package view;

/**
 * <code>ProstorZaTabele</code> je prostor gde se tabele prikazuju.
 * @author Milan Vujakovic
 */
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import tabele.TabelaInterface;

@SuppressWarnings("serial")
public class ProstorZaTabele extends JTabbedPane {
	
	/**
	 * Tab dobija mogucnost da bude zatvoren direktno.
	 */
	public static final int TAB_SA_ZATVARANJEM = 0;
	
	/**
	 * Tab ne dobija mogucnost da bude zatvoren direktno.
	 */
	public static final int TAB_BEZ_ZATVARANJA = 1;
	
	/**
	 * Odabrana tab opcija
	 */
	private int tabOpcija = TAB_BEZ_ZATVARANJA;
	
	private ArrayList<JPanel> paneli;
	private Component c = null;

	public ProstorZaTabele(int tabOpcija) {
		setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		setSize(600, 600);
		setPaneli(new ArrayList<JPanel>());
		setTabOpcija(tabOpcija);
	}

	/**
	 * Dodavanje vise panela za tabele, prikazano u vidu tabova.
	 */
	public void DodajTab(String nazivTabele, JPanel panel) {
		int index = getTabCount();
			
		JPanel tabPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		tabPanel.setBackground(new Color(0, 255, 0, 0));

		ImageIcon icon = new ImageIcon("src/stablo/slike/tabela.png");
		JLabel label = new JLabel(nazivTabele);
		label.setIcon(icon);

		tabPanel.add(label);
		
		addTab(nazivTabele, panel);
		setTabComponentAt(index, tabPanel);
		
		c = getComponentAt(index);
		
		if(tabOpcija == TAB_SA_ZATVARANJEM) {
			TabDugme zatvoriBtn = new TabDugme(this);
			tabPanel.add(zatvoriBtn);
			zatvoriBtn.setC(c);
		}
		
		setToolTipText(nazivTabele);
		setSelectedIndex(index);
	}
	
	public boolean proveraDalVecPostoji(String id) {
		for(int i = 0; i < getTabCount(); i++) {
			TabelaInterface ti = (TabelaInterface) getComponentAt(i);
			String tabId = ti.getTabelaModel().getCvorTabela().getTabela().getId();
			if(tabId.equals(id)) {
				setSelectedIndex(i);
				return true;
			}
		}
		return false;
	}
	
	
	public void UkloniSelektovaniTab() {
		remove(getSelectedIndex());
	}
	

	public int getTabOpcija() {
		return tabOpcija;
	}

	public void setTabOpcija(int tabOpcija) {
		if(tabOpcija != TAB_BEZ_ZATVARANJA && tabOpcija != TAB_SA_ZATVARANJEM) {
			throw new IllegalArgumentException("tabOpcija mora biti: TAB_BEZ_ZATVARANJA ili TAB_SA_ZATVARANJEM");
		}
		this.tabOpcija = tabOpcija;
	}

	public ArrayList<JPanel> getPaneli() {
		return paneli;
	}

	public void setPaneli(ArrayList<JPanel> paneli) {
		this.paneli = paneli;
	}

	public Component getC() {
		return c;
	}

	public void setC(Component c) {
		this.c = c;
	}

	/**
	 * <code>TabDugme</code> je dugme na tabu za zatvaranje aktivne tabele.
	 * 
	 * @author Zivko Stanisic
	 *
	 */
	private class TabDugme extends JButton implements MouseListener {
		private JTabbedPane pane;
		private Component c;

		public void setC(final Component c) {
			this.c = c;
		}

		public TabDugme(JTabbedPane pane) {
			this.pane = pane;

			setToolTipText("Close tab!");
			setIcon(new ImageIcon("src/stablo/slike/delete.png"));
			setPreferredSize(new Dimension(5, 5));
			setContentAreaFilled(false);
			setFocusable(false);
			addMouseListener(this);
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			int i = pane.indexOfComponent(c);
			if (i != -1)
				pane.remove(i);
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		@Override
		public void mouseExited(MouseEvent arg0) {

		}

		@Override
		public void mousePressed(MouseEvent arg0) {

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {

		}
	}
}