package model;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * <code>StraniKljuc</code> moze da bude deo kolone.
 * Sluzi da se identifikuje slog iz tabele.
 * Cine ga <code>imeOsnovneKolone</code> sto predstavlja u kojoj koloni
 * i <code>imeOsnovneTabele</code> i kojoj tabeli je primaran kljuc.
 * <code>imeReferenciraneKolone</code> predstavlja u kojoj koloni
 * i <code>imeReferenciraneTabele</code> kojoj tabeli predstavlja strani kljuc.
 * <code>jakaVeza</code> oznacava da li je veza izmedju tabela jaka ili slaba.
 * <code>ime</code> moze biti na vise jezika.
 * @author Zivko Stanisic
 *
 */
public class StraniKljuc {
	@JsonProperty("id")
	private String id;
	@JsonProperty("Base_column_id")
	private String idOsnovneKolone;
	@JsonProperty("Base_table_id")
	private String idOsnovneTabele;
	@JsonProperty("Referenced_column_id")
	private String idReferenciraneKolone;
	@JsonProperty("Referenced_table_id")
	private String idReferenciraneTabele;
	@JsonProperty("strong_ties")
	private boolean jakaVeza;

	public StraniKljuc() {
		idOsnovneKolone = new String();
		idOsnovneTabele = new String();
		idReferenciraneKolone = new String();
		idReferenciraneTabele = new String();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdOsnovneKolone() {
		return idOsnovneKolone;
	}

	public void setIdOsnovneKolone(String idOsnovneKolone) {
		this.idOsnovneKolone = idOsnovneKolone;
	}

	public String getIdOsnovneTabele() {
		return idOsnovneTabele;
	}

	public void setIdOsnovneTabele(String idOsnovneTabele) {
		this.idOsnovneTabele = idOsnovneTabele;
	}

	public String getIdReferenciraneKolone() {
		return idReferenciraneKolone;
	}

	public void setIdReferenciraneKolone(String idReferenciraneKolone) {
		this.idReferenciraneKolone = idReferenciraneKolone;
	}

	public String getIdReferenciraneTabele() {
		return idReferenciraneTabele;
	}

	public void setIdReferenciraneTabele(String idReferenciraneTabele) {
		this.idReferenciraneTabele = idReferenciraneTabele;
	}

	public boolean isJakaVeza() {
		return jakaVeza;
	}

	public void setJakaVeza(boolean jakaVeza) {
		this.jakaVeza = jakaVeza;
	}

}