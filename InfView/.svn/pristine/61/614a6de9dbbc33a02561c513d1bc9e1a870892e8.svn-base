package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Locale;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.tree.TreeNode;

import stablo.model.SlozenCvor;

/**
 * Klasa <code>Meni</code> predstavlja osnovni izgled meni bara.
 * 
 * @author Stefan Pandzic
 */
@SuppressWarnings("serial")
public class Meni extends JMenuBar {
	public static int JEZIK = 0;

	JRadioButtonMenuItem Srpski;
	JRadioButtonMenuItem Engleski;
	JMenu miJezik;
	JMenu miOnama;

	JMenuItem miHelp;

	public Meni() {



		miJezik = new JMenu(GlavniProzor.getInstance().getResourceBundle().getString("miJezik"));

		ButtonGroup group = new ButtonGroup();
		Srpski = new JRadioButtonMenuItem(GlavniProzor.getInstance().getResourceBundle().getString("Srpski"));

		Srpski.setSelected(true);

		Srpski.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Locale.setDefault(new Locale("sr", "RS"));
				GlavniProzor.getInstance().changeLanguage();
				JEZIK = 0;

				TreeNode root = (TreeNode) GlavniProzor.getInstance().getStablo().getModel().getRoot();
				promeniJezik(0, root);

				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					SwingUtilities.updateComponentTreeUI(GlavniProzor.getInstance().getStablo());
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		group.add(Srpski);
		miJezik.add(Srpski);

		Engleski = new JRadioButtonMenuItem(GlavniProzor.getInstance().getResourceBundle().getString("Engleski"));
		Engleski.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Locale.setDefault(new Locale("en", "US"));
				GlavniProzor.getInstance().changeLanguage();
				JEZIK = 1;

				TreeNode root = (TreeNode) GlavniProzor.getInstance().getStablo().getModel().getRoot();
				promeniJezik(1, root);

				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					SwingUtilities.updateComponentTreeUI(GlavniProzor.getInstance().getStablo());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		group.add(Engleski);
		miJezik.add(Engleski);

		miOnama = new JMenu(GlavniProzor.getInstance().getResourceBundle().getString("miOnama"));
		miHelp = new JMenuItem(GlavniProzor.getInstance().getResourceBundle().getString("miHelp"));

		miHelp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				GlavniProzor.getInstance().helpWin();
			}
		});

		miOnama.add(miHelp);

		add(miJezik);
		add(miOnama);
	}

	public void initComponents() {

		Engleski.setText(GlavniProzor.getInstance().getResourceBundle().getString("Engleski"));
		Srpski.setText(GlavniProzor.getInstance().getResourceBundle().getString("Srpski"));
		miJezik.setText(GlavniProzor.getInstance().getResourceBundle().getString("miJezik"));
		miOnama.setText(GlavniProzor.getInstance().getResourceBundle().getString("miOnama"));
		miHelp.setText(GlavniProzor.getInstance().getResourceBundle().getString("miHelp"));
	}

	@SuppressWarnings("rawtypes")
	private void promeniJezik(int oznaka, TreeNode cvor) {
		TreeNode node = null;
		Enumeration iterator = cvor.children();
		while (iterator.hasMoreElements()) {
			node = (TreeNode) iterator.nextElement();
			if (node instanceof SlozenCvor) {
				((SlozenCvor) node).setIme(oznaka);
				if (node.getChildCount() > 0) {
					promeniJezik(oznaka, node);
				}
			}
		}
	}

}