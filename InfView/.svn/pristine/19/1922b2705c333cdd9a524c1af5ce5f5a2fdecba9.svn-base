package tabele;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import tabele.model.TabelaModel;
/**
 * Prikaz tabele.
 * @author Milan Vujakovic
 *
 */
@SuppressWarnings("serial")
public class TabelaView extends JTable {
	public static int selectedRow = -1;
	
	public TabelaView(TabelaModel tabelaModel) {
		setModel(tabelaModel);
		
		ListSelectionModel cellSelectionModel = getSelectionModel();
	    cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				selectedRow = getSelectedRow();
			}
		});
	}
}
