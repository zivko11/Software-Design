package tabele;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import tabele.model.TabelaModel;
import view.ProstorZaTabele;

/**
 * Klasa <code>PrioritetnaTabelaPanel</code> predstavlja graficki user interfejs, izgled.
 * 
 * @author Stefan Pandzic
 */
@SuppressWarnings("serial")
public class PrioritetnatabelaPanel extends JPanel implements TabelaInterface {

	private ProstorZaTabele prostorZaTabele = null;
	private TabelaModel tabelaModel = null;
	
	public PrioritetnatabelaPanel(TabelaModel tabelaModel) {
		this.tabelaModel = tabelaModel;
		
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(800, 400));
		
		PrimarnaAlatnaTraka tb = new PrimarnaAlatnaTraka(tabelaModel);
		add(tb, BorderLayout.NORTH);
		
		JScrollPane sp=new JScrollPane(new TabelaView(tabelaModel));
		
		prostorZaTabele = new ProstorZaTabele(ProstorZaTabele.TAB_BEZ_ZATVARANJA);
		
		JSplitPane jsp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, sp, prostorZaTabele);
		add(jsp, BorderLayout.CENTER);
	}
	
	
	
	public ProstorZaTabele getProstorZaTabele() {
		return prostorZaTabele;
	}



	public void setProstorZaTabele(ProstorZaTabele prostorZaTabele) {
		this.prostorZaTabele = prostorZaTabele;
	}



	public TabelaModel getTabelaModel() {
		return tabelaModel;
	}



	public void setTabelaModel(TabelaModel tabelaModel) {
		this.tabelaModel = tabelaModel;
	}



	/**
	    * Ažurira prikaz gornje tabele kada se promeni model stanja.
	    * 
	    * @author Stefan Pandzic
	    */
	public void update() {

	}
}