/**
 * Paket u kome su implementrirane CRUD operacije.
 */
package crud;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import crud.fabrike.FabrikaDatoteka;
import crud.fabrike.FabrikaSelekcija;
import crud.fabrike.FabrikaTekst;
import model.Kolona;
import model.Tabela;
import net.miginfocom.swing.MigLayout;
import parsiranje.OdustaniAkcija;
import podaci.MapaSaPodacima;
import stablo.model.CvorTabela;
import tabele.TabelaView;
import tabele.model.TabelaModel;
import view.GlavniProzor;

/**
 * /**
 * <code>DijalogSaPodacima</code> je dijalog u kome se unose podaci za aktivnu tabelu.
 * Dijalog moze biti pozvan pri dodavanju novih podataka ili izmeni vec postojecih.
 * @author Zivko Stanisic
 *
 */

@SuppressWarnings("serial")
public class DijalogSaPodacima extends JDialog {
	private boolean isEdited = false;

	public DijalogSaPodacima(TabelaModel tabelaModel, boolean isEdited) {
		setResizable(false);
		setLocationRelativeTo(null);
		this.isEdited = isEdited;

		setTitle(GlavniProzor.getInstance().getResourceBundle()
				.getString("podatak"));

		ImageIcon icon = new ImageIcon("images/new.png");
		setIconImage(icon.getImage());
		setSize(400, 600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setModal(true);
		setLayout(new MigLayout());

		CvorTabela cvorTabela = tabelaModel.getCvorTabela();
		Tabela tabela = cvorTabela.getTabela();

		JPanel btnPane = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		JButton saveBtn = new JButton();
		saveBtn.setText(GlavniProzor.getInstance().getResourceBundle()
				.getString("save"));

		JButton cancelBtn = new JButton();
		cancelBtn.setText(GlavniProzor.getInstance().getResourceBundle()
				.getString("odustani"));

		cancelBtn.addActionListener(new OdustaniAkcija(this));
		for (Kolona kolona : tabela.getKolone()) {
			MapaSaPodacima mapaTabele = (MapaSaPodacima) GlavniProzor
					.getInstance().getPodaciTabela().element(tabela.getId());
			if (mapaTabele != null) {
				if (kolona.getTip().contains("char")
						|| kolona.getTip().contains("int")) {
					FabrikaTekst fabrika = new FabrikaTekst();

					add((Component) fabrika.kreirajElement(kolona), "wrap");
					if (isEdited) {
						JTextField polje = fabrika.getText();
						@SuppressWarnings("unchecked")
						ArrayList<Object> list = (ArrayList<Object>) mapaTabele
								.element(kolona.getId());
						if (mapaTabele.element(kolona.getId()) != null) {
							polje.setText((String) list
									.get(TabelaView.selectedRow));
						}
					}
					saveBtn.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							JTextField polje = fabrika.getText();

							@SuppressWarnings("unchecked")
							ArrayList<Object> list = (ArrayList<Object>) mapaTabele
									.element(kolona.getId());
							if (isEdited) {
								list.set(TabelaView.selectedRow,
										polje.getText());
							} else {
								list.add(polje.getText());
							}
							GlavniProzor.getInstance().getProstorZaTabele()
									.removeAll();
							dispose();
						}
					});

				} else if (kolona.getTip().equals("image")
						|| kolona.getTip().equals("byte")) {
					FabrikaDatoteka fabrika = new FabrikaDatoteka();
					add((Component) fabrika.kreirajElement(kolona), "wrap");
					JFileChooser chooser = new JFileChooser();
					JButton dugme = fabrika.getDugme();
					JTextField polje = fabrika.getText();

					dugme.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							int retVal = chooser.showOpenDialog(fabrika
									.getPanel());
							if (retVal == JFileChooser.APPROVE_OPTION)
								polje.setText(chooser.getSelectedFile()
										.getAbsolutePath());
							saveBtn.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent arg0) {
									try {
										@SuppressWarnings("unchecked")
										ArrayList<Object> list = (ArrayList<Object>) mapaTabele
												.element(kolona.getId());
										Path path = Paths.get(chooser
												.getSelectedFile()
												.getAbsolutePath());
										byte[] data = Files.readAllBytes(path);
										list.add(data);

										GlavniProzor.getInstance()
												.getProstorZaTabele()
												.removeAll();
										dispose();
									} catch (Exception e) {

									}
								}
							});
						}
					});

				} else if (kolona.getTip().equals("datetime")) {
					FabrikaSelekcija fabrika = new FabrikaSelekcija();
					add((Component) fabrika.kreirajElement(kolona), "wrap");
					if (isEdited) {
						@SuppressWarnings("unchecked")
						ArrayList<Object> list = (ArrayList<Object>) mapaTabele
								.element(kolona.getId());
						if (mapaTabele.element(kolona.getId()) != null) {
							String timeDate = (String) list
									.get(TabelaView.selectedRow);
							String[] parts = timeDate.split(" ");
							try {
								fabrika.getTime().setValue(
										new SimpleDateFormat("HH:mm:ss")
												.parse(parts[1]));
							} catch (ParseException e) {
								e.printStackTrace();
							}
							try {
								fabrika.getDate().setValue(
										new SimpleDateFormat("yyyy/MM/dd")
												.parseObject(parts[0]));
							} catch (ParseException e) {
								e.printStackTrace();
							}
						}
					}
					saveBtn.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							@SuppressWarnings("unchecked")
							ArrayList<Object> list = (ArrayList<Object>) mapaTabele
									.element(kolona.getId());
							JSpinner time = fabrika.getTime();
							JSpinner date = fabrika.getDate();

							String dateTime = new SimpleDateFormat("yyyy/MM/dd")
									.format(date.getValue())
									+ " "
									+ new SimpleDateFormat("HH:mm:ss")
											.format(time.getValue());
							if (isEdited) {
								list.set(TabelaView.selectedRow,
										dateTime);
							} else {
								list.add(dateTime);
							}

							
							GlavniProzor.getInstance().getProstorZaTabele()
									.removeAll();
							dispose();
						}
					});
				}

			}
		}

		btnPane.add(saveBtn);
		btnPane.add(cancelBtn);
		add(btnPane, BorderLayout.SOUTH);
		pack();

	}

	public boolean isEdited() {
		return isEdited;
	}

	public void setEdited(boolean isEdited) {
		this.isEdited = isEdited;
	}

}
