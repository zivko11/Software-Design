package tabele;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import tabele.model.TabelaModel;

/**
 * Klasa <code>SekundarnaTabelaPanel</code> predstavlja graficki user interfejs, izgled.
 * 
 * @author Stefan Pandzic
 */
@SuppressWarnings("serial")
public class SekundarnaTabelaPanel extends JPanel implements TabelaInterface {

	private TabelaModel tabelaModel = null;

	public SekundarnaTabelaPanel(TabelaModel tabelaModel) {
		this.tabelaModel = tabelaModel;
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(200, 200));
		SekundarnaAlatnaTraka tb = new SekundarnaAlatnaTraka(tabelaModel);

		add(tb, BorderLayout.NORTH);

		JScrollPane sp = new JScrollPane(new TabelaView(tabelaModel));
		add(sp, BorderLayout.CENTER);

	}

	/**
	 * Ažurira prikaz donje tabele kada se promeni model stanja.
	 * 
	 * @author Stefan Pandzic
	 */
	public void update() {

	}

	public TabelaModel getTabelaModel() {
		return tabelaModel;
	}

}