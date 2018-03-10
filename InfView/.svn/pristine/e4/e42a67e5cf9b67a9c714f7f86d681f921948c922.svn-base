/**
 * Paket koji sadrzi parser baze podataka.
 */
package baza.parsiranje;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.tree.TreeNode;

import model.Kolona;
import model.Paket;
import model.Podsistem;
import model.PrimarniKljuc;
import model.Sistem;
import model.StraniKljuc;
import model.Tabela;
import parsiranje.ParserInterface;
import parsiranje.fabrike.KonkretnaFabrikaCvorSistem;
import podaci.MapaSaPodacima;
import stablo.model.CvorSistem;
import stablo.model.MojModelStabla;
import view.GlavniProzor;

/**
 * Implementacija parsera za MSSQL bazu podataka.
 * 
 * @author Nikola Stojanovic
 *
 */
public class SQLParser implements ParserInterface {

	public static String ADMIN = "ADMIN";
	public static String NORMAL = "NORMAL";

	private Sistem s;
	private ArrayList<Podsistem> ps = new ArrayList<>();
	private Podsistem psTmp;
	Map<String, Podsistem> psMapa = new TreeMap<String, Podsistem>(String.CASE_INSENSITIVE_ORDER);
	Map<String, Paket> paketMapa = new TreeMap<String, Paket>(String.CASE_INSENSITIVE_ORDER);
	Map<String, Tabela> tabelaMapa = new TreeMap<String, Tabela>(String.CASE_INSENSITIVE_ORDER);
	public static ArrayList<Tabela> zavisneTabele = new ArrayList<Tabela>();

	/**
	 * Parsira bazu podataka
	 * 
	 * @return true ako je operacija parsiranja bila uspesna, false ukoliko nije
	 * @param tekst
	 *            indikator koji ukazuje da li se parsira baza za privilegovanog ili
	 *            neprivilegovanog korisnika
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean parsiraj(String tekst) {
		try {
			Connection konekcija = GlavniProzor.getInstance().getKonekcijaNaServer();

			if (tekst.equals(NORMAL)) {

				Statement stmt = konekcija.createStatement();
				// Preuzima sve pakete i svrstava ih u odgovarajucu mapu
				ResultSet rs = stmt.executeQuery("SELECT * FROM PODSISTEM");

				while (rs.next()) {
					if (rs.getString(3).equalsIgnoreCase("S")) {
						s = new Sistem();
						s.setId(rs.getString(1));
						s.dodajIme(rs.getString(2));
					} else if (rs.getString(3).equalsIgnoreCase("P")) {
						psTmp = new Podsistem();
						psTmp.setId(rs.getString(1));
						psTmp.dodajIme(rs.getString(2));
						ps.add(psTmp);
						psMapa.put(psTmp.getId(), psTmp);
					} else if (rs.getString(3).equalsIgnoreCase("K")) {
						Paket pk = new Paket();
						pk.setId(rs.getString(1));
						pk.dodajIme(rs.getString(2));
						paketMapa.put(pk.getId(), pk);
					}
				}

				HashMap<String, Tabela> imaLiDuplikata = new HashMap<String, Tabela>();
				// Vrsenje upita nad tabelom TABELE i ubacivanje tabela
				// u odgovarajuce podsisteme
				if (!psMapa.isEmpty()) {
					for (String key : psMapa.keySet()) {
						rs = stmt.executeQuery("SELECT * FROM TABELE WHERE PO_OZNAKA = '" + key + "'");
						while (rs.next()) {
							if (!rs.getString("TAB_KOD").equals("KORISNICI")) {
								Tabela t = new Tabela();
								t.setId(rs.getString("TAB_KOD"));
								t.dodajIme(rs.getString("TAB_NAZIV"));
								psMapa.get(key).dodajTabelu(t);
								imaLiDuplikata.put(t.getId(), t);
							}
						}
					}
				}

				// u odgovarajuce pakete
				if (!paketMapa.isEmpty()) {
					for (String key : paketMapa.keySet()) {
						rs = stmt.executeQuery("SELECT * FROM TABELE WHERE PO_OZNAKA = '" + key + "'");
						while (rs.next()) {
							Tabela t = new Tabela();
							t.setId(rs.getString(2));
							t.dodajIme(rs.getString(3));
							paketMapa.get(key).dodajTabelu(t);
							imaLiDuplikata.put(t.getId(), t);
						}
					}
				}

				// Vrsenje upita nad tabelom ATRIBUTI i ubacivanje atributa u tabele
				// prvo tabele u podsistemima
				if (!psMapa.isEmpty()) {
					for (String psKey : psMapa.keySet()) {
						ArrayList<Tabela> tabele = psMapa.get(psKey).getTabele();
						for (int i = 0; i < tabele.size(); i++) {
							rs = stmt.executeQuery("SELECT * FROM ATRIBUTI WHERE PO_OZNAKA='" + psKey
									+ "' AND TAB_KOD='" + tabele.get(i).getId() + "'");
							ArrayList<PrimarniKljuc> pkLista = new ArrayList<>();
							while (rs.next()) {
								Kolona k = new Kolona();
								k.setId(rs.getString(3));
								k.dodajIme(rs.getString(4));
								k.setTip(rs.getString(5));
								if (rs.getString(9).equals("1")) {
									PrimarniKljuc pk = new PrimarniKljuc();
									pk.dodajImeKolone(rs.getString(4));
									pk.setImeTabele(tabele.get(i).getIme());
									pkLista.add(pk);
								}
								tabele.get(i).dodajKolonu(k);
							}
							tabele.get(i).setPrimarniKljuc(pkLista);
						}
					}
				}

				// pa tabele u paketima
				if (!paketMapa.isEmpty()) {
					for (String pkKey : paketMapa.keySet()) {
						ArrayList<Tabela> tabele = paketMapa.get(pkKey).getTabele();
						for (int i = 0; i < tabele.size(); i++) {
							rs = stmt.executeQuery("SELECT * FROM ATRIBUTI WHERE PO_OZNAKA='" + pkKey
									+ "' AND TAB_KOD='" + tabele.get(i).getId() + "'");
							ArrayList<PrimarniKljuc> pkLista = new ArrayList<>();
							while (rs.next()) {
								Kolona k = new Kolona();
								k.setId(rs.getString(3));
								k.dodajIme(rs.getString(4));
								k.setTip(rs.getString(5));
								if (rs.getString(9).equals("1")) {
									PrimarniKljuc pk = new PrimarniKljuc();
									pk.dodajImeKolone(rs.getString(4));
									pk.setImeTabele(tabele.get(i).getIme());
									pkLista.add(pk);
								}
								tabele.get(i).dodajKolonu(k);
							}
							tabele.get(i).setPrimarniKljuc(pkLista);
						}
					}
				}

				// Vrsenje upita nad tabelom STRANI_KLJUC i kreiranje stranih kljuceva
				rs = stmt.executeQuery("SELECT * FROM STRANI_KLJUC");
				while (rs.next()) {
					StraniKljuc sk = new StraniKljuc();
					sk.setId(rs.getString("SK_KOD"));
					sk.setIdOsnovneTabele(rs.getString("TAB_TAB_KOD"));
					sk.setIdReferenciraneTabele(rs.getString("TAB_KOD"));
					if (rs.getString("SK_JAKA_VEZA").equals("1")) {
						sk.setJakaVeza(true);
					} else {
						sk.setJakaVeza(false);
					}

					for (Tabela t : psMapa.get(rs.getString("PO_OZNAKA")).getTabele()) {
						if (t.getId().equals(rs.getString("TAB_TAB_KOD"))) {
							t.dodajStraniKljuc(sk);
							break;
						}
					}
				}

				// Vrsenje upita nad tabelom STRUKTURA_PODSISTEMA i ubacivanje odgovarajucih
				// paketa u podsisteme,
				if (!paketMapa.isEmpty()) {
					for (String paketKey : paketMapa.keySet()) {
						rs = stmt.executeQuery(
								"SELECT * FROM STRUKTURA_PODSISTEMA WHERE PO_OZNAKA = '" + paketKey + "'");
						while (rs.next()) {
							psMapa.get(rs.getString(1)).dodajPaket(paketMapa.get(paketKey));
						}
					}
				}

				// podsistema u odgovarajuce podsisteme
				if (!psMapa.isEmpty()) {
					for (String psKey : psMapa.keySet()) {
						rs = stmt.executeQuery("SELECT * FROM STRUKTURA_PODSISTEMA WHERE PO_OZNAKA = '" + psKey + "'");
						while (rs.next()) {
							psMapa.get(psKey).dodajPodistem(psMapa.get(rs.getString(2)));
						}
					}
				}
				// i podsistema u sistem
				if (!s.equals(null)) {
					rs = stmt.executeQuery("SELECT * FROM STRUKTURA_PODSISTEMA WHERE PO_OZNAKA = '" + s.getId() + "'");
					while (rs.next()) {
						if (rs.getString(1).equalsIgnoreCase(s.getId())) {
							if (psMapa.containsKey(rs.getString(2))) {
								s.dodajPodistsem(psMapa.get(rs.getString(2)));
							}
						}
					}
				}

				// Dodavanje modela u stablo
				zavisneTabele.removeAll(zavisneTabele);
				KonkretnaFabrikaCvorSistem fabrika = new KonkretnaFabrikaCvorSistem();
				CvorSistem sistemCvor = (CvorSistem) fabrika.kreirajCvor(s);

				MojModelStabla mms = new MojModelStabla((TreeNode) sistemCvor);
				GlavniProzor.getInstance().getStabloKontroler().setModel(mms);
				GlavniProzor.getInstance().getStablo().dodajZavisneTabele();

				for (String tabelaKey : imaLiDuplikata.keySet()) {
					Tabela t = imaLiDuplikata.get(tabelaKey);
					MapaSaPodacima mapaTabele = (MapaSaPodacima) GlavniProzor.getInstance().getPodaciTabela()
							.element(t.getId());
					
					rs = stmt.executeQuery("SELECT * FROM " + t.getId());

					HashMap<String, ArrayList<Object>> kolone_liste = new HashMap<>();
					for (Kolona k : t.getKolone()) {
						ArrayList<Object> lista_tmp = (ArrayList<Object>) mapaTabele.element(k.getId());
						kolone_liste.put(k.getId(), lista_tmp);
					}
					while (rs.next()) {
						for (String s : kolone_liste.keySet()) {
							kolone_liste.get(s).add(rs.getString(s));
						}
					}
				}

				return true;
			} else if (tekst.equals(ADMIN)) {

				Tabela korisnici = new Tabela();
				Podsistem ps = new Podsistem();
				Sistem s = new Sistem();
				Statement stmt = konekcija.createStatement();

				ResultSet rs = stmt.executeQuery("SELECT * FROM TABELE WHERE TAB_KOD='KORISNICI'");
				if (rs.next()) {
					korisnici.setId("KORISNICI");
					korisnici.dodajIme(rs.getString("TAB_NAZIV"));
					ps.dodajTabelu(korisnici);
					ps.setId(rs.getString("PO_OZNAKA"));
				} else {
					return false;
				}

				rs = stmt.executeQuery("SELECT * FROM ATRIBUTI WHERE TAB_KOD='KORISNICI'");
				while (rs.next()) {
					Kolona k = new Kolona();
					k.setId(rs.getString("ATR_KOD"));
					k.setTip(rs.getString("ATR_TIP"));
					k.dodajIme(rs.getString("ATR_LABELA"));
					if (rs.getString("ATR_DEO_PK").equals("1")) {
						PrimarniKljuc pk = new PrimarniKljuc();
						pk.setId("KORISNICI_PK");
						pk.dodajImeKolone(rs.getString("ATR_LABELA"));
						pk.dodajImeTabele("Korisnici");
					}
					ps.getTabele().get(0).dodajKolonu(k);
				}

				rs = stmt.executeQuery("SELECT * FROM PODSISTEM WHERE PO_OZNAKA='" + ps.getId() + "'");
				if (rs.next()) {
					ps.dodajIme(rs.getString("PO_NAZIV"));
				} else {
					return false;
				}

				rs = stmt.executeQuery("SELECT * FROM PODSISTEM WHERE PO_TIP='S'");
				if (rs.next()) {
					s.setId(rs.getString("PO_OZNAKA"));
					s.dodajIme(rs.getString("PO_NAZIV"));
					s.dodajPodistsem(ps);
				} else {
					return false;
				}

				zavisneTabele.removeAll(zavisneTabele);
				KonkretnaFabrikaCvorSistem fabrika = new KonkretnaFabrikaCvorSistem();
				CvorSistem sistemCvor = (CvorSistem) fabrika.kreirajCvor(s);

				MojModelStabla mms = new MojModelStabla((TreeNode) sistemCvor);
				GlavniProzor.getInstance().getStabloKontroler().setModel(mms);
				GlavniProzor.getInstance().getStablo().dodajZavisneTabele();

				MapaSaPodacima mapaTabele = (MapaSaPodacima) GlavniProzor.getInstance().getPodaciTabela()
						.element(korisnici.getId());

				rs = stmt.executeQuery("SELECT * FROM " + korisnici.getId());

				ArrayList<Object> kr_oznaka = (ArrayList<Object>) mapaTabele.element("KR_OZNAKA");
				ArrayList<Object> kr_korisnicko_ime = (ArrayList<Object>) mapaTabele.element("KR_KORISNICKO_IME");
				ArrayList<Object> kr_lozinka = (ArrayList<Object>) mapaTabele.element("KR_LOZINKA");
				ArrayList<Object> kr_pravo_pristupa = (ArrayList<Object>) mapaTabele.element("KR_PRAVO_PRISTUPA");

				while (rs.next()) {
					kr_oznaka.add(rs.getString("KR_OZNAKA"));
					kr_korisnicko_ime.add(rs.getString("KR_KORISNICKO_IME"));
					kr_lozinka.add(rs.getString("KR_LOZINKA"));
					kr_pravo_pristupa.add(rs.getString("KR_PRAVO_PRISTUPA"));
				}

				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
