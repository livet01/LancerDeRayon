package Presentation;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class RayonMainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PanelPrincipale concevoir = new PanelPrincipale(); 
	private FileTreePanel parcourir = new FileTreePanel();
	private Container contenu = getContentPane();
	private CardLayout cards = new CardLayout();
	private JMenuItem mntmNouveau;
	private JMenuItem mntmOuvrir;
	private JMenuItem mntmEnregistrer;
	private JMenuItem mntmEnregistrerSous; 
	
	public RayonMainFrame() {
		this("");
	}

	/**
	 * @param title
	 * @throws HeadlessException
	 */
	public RayonMainFrame(String title) throws HeadlessException {
		super(title);
		// TODO Stub du constructeur généré automatiquement
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnScene = new JMenu("Scene");
		menuBar.add(mnScene);
		
		 mntmNouveau = new JMenuItem("Nouveau");
		mnScene.add(mntmNouveau);
		
		 mntmOuvrir = new JMenuItem("Ouvrir");
		 mntmOuvrir.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		concevoir.ouvrir();
		 	}
		 });
		mnScene.add(mntmOuvrir);
		
		 mntmEnregistrer = new JMenuItem("Enregistrer");
		 mntmEnregistrer.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		concevoir.enregistrer();
		 	}
		 });
		mnScene.add(mntmEnregistrer);
		
		 mntmEnregistrerSous = new JMenuItem("Enregistrer sous ...");
		 mntmEnregistrerSous.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		concevoir.enregistrerSous();
		 	}
		 });
		mnScene.add(mntmEnregistrerSous);
		
		JMenuItem mntmQuitter = new JMenuItem("Quitter");
		mntmQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnScene.add(mntmQuitter);
		
		JMenu mnAffichage = new JMenu("Affichage");
		menuBar.add(mnAffichage);
		
		ButtonGroup group = new ButtonGroup();
		JRadioButtonMenuItem rdbtnmntmConception = new JRadioButtonMenuItem("Conception");
		rdbtnmntmConception.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmOuvrir.setEnabled(true);
				mntmNouveau.setEnabled(true);
				mntmEnregistrer.setEnabled(true);
				mntmEnregistrerSous.setEnabled(true);
				cards.show(contenu, "concevoir");
			}
		});
		rdbtnmntmConception.setSelected(true);
		group.add(rdbtnmntmConception);
		mnAffichage.add(rdbtnmntmConception);
		
		JRadioButtonMenuItem rdbtnmntmParcourir = new JRadioButtonMenuItem("Parcourir");
		rdbtnmntmParcourir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmOuvrir.setEnabled(false);
				mntmNouveau.setEnabled(false);
				mntmEnregistrer.setEnabled(false);
				mntmEnregistrerSous.setEnabled(false);
				cards.show(contenu, "parcourir");
			}
		});
		group.add(rdbtnmntmParcourir);
		mnAffichage.add(rdbtnmntmParcourir);
		// TODO Stub du constructeur généré automatiquement
		contenu.setLayout(cards);
		contenu.add(concevoir,"concevoir");
		contenu.add(parcourir,"parcourir");
	}

	
}
