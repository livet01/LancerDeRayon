package Presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.media.jai.JAI;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileFilter;

import Metier.Scene;
import Metier.SceneDAOFichier;

import com.sun.media.jai.widget.DisplayJAI;

public class PanelPrincipale extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private PanelScene panel;
	public DisplayJAI peinture;
	private String nomScene = null;
	private JLabel chargement;
	private Scene maScene;

	public PanelPrincipale() {
		setMinimumSize(new Dimension(500, 500));
		setLayout(new BorderLayout(0, 0));
		setSize(400, 400);
		peinture = new DisplayJAI();
		peinture.set(JAI.create("fileload", "white.ppm"));
		peinture.setMinimumSize(new Dimension(500, 500));
		scrollPane = new JScrollPane(peinture);
		scrollPane.setMinimumSize(new Dimension(500, 500));
		add(scrollPane, BorderLayout.CENTER);
		nomScene = "nouveau.scene";
		panel = new PanelScene(this, nomScene);
		add(panel, BorderLayout.WEST);
		chargement = new JLabel("Lancement");
		chargement.setHorizontalAlignment(SwingConstants.RIGHT);
		add(chargement, BorderLayout.SOUTH);
		try {
			rendu(false);
		} catch (Exception e1) {
			System.out.println(e1);
			JOptionPane.showMessageDialog(null,
					"File2: not found! Please check your path and try again",
					"Error!", JOptionPane.ERROR_MESSAGE);
			chargement.setText("Erreur");
			System.exit(0);
		}
	}

	public void enregistrerSous() {
		JFileChooser choix = new JFileChooser();
		choix.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int retour = choix.showOpenDialog(this);
		if (retour == JFileChooser.APPROVE_OPTION) {
			if (choix.getSelectedFile().exists()) {
				String backup = new String(nomScene);
				nomScene = choix.getSelectedFile().getName()+File.pathSeparatorChar+backup;
				try {
					panel.nomScene = nomScene;
					enregistrer();

				} catch (Exception e1) {
					System.out.println(e1);
					JOptionPane
							.showMessageDialog(
									null,
									"File2: not found! Please check your path and try again",
									"Error!", JOptionPane.ERROR_MESSAGE);
					nomScene = backup;
					chargement.setText("Erreur");
				}
			}
		}
	}

	public void ouvrir() {
		JFileChooser choix = new JFileChooser();
		choix.setFileSelectionMode(JFileChooser.FILES_ONLY);
		FileFilter fil_scene = new FiltreSimple("Fichier scene", ".scene");
		choix.addChoosableFileFilter(fil_scene);
		choix.setAcceptAllFileFilterUsed(false);
		int retour = choix.showOpenDialog(this);
		if (retour == JFileChooser.APPROVE_OPTION) {
			if (choix.getSelectedFile().exists()) {
				String backup = new String(nomScene);
				nomScene = choix.getSelectedFile().getName();
				try {
					chargement.setText("Ouverture de la scene ...");
					panel.nomScene = nomScene;
					panel.getScene();
					panel.affectation();
					rendu(false);
				} catch (Exception e1) {
					System.out.println(e1);
					JOptionPane
							.showMessageDialog(
									null,
									"File2: not found! Please check your path and try again",
									"Error!", JOptionPane.ERROR_MESSAGE);
					nomScene = backup;
					chargement.setText("Erreur");
				}
			} else {
				JOptionPane
						.showMessageDialog(
								null,
								"File: not found! Please check your path and try again",
								"Error!", JOptionPane.ERROR_MESSAGE);
				nomScene = null;
				chargement.setText("Erreur");
			}
		}
	}

	public void enregistrer() {
		if (nomScene != null) {
			panel.persiste();
			panel.setScene();
			chargement.setText("Scene enregistré : " + nomScene);
		}
	}

	public void rendu(Boolean save_as) {
		chargement.setText("Initialisation de la scene ...");
		try {
			maScene = panel.maScene;
			if (maScene.image == null) {
				save_as = true;
			}
			if (save_as) {
				chargement.setText("Création du nouveau fichier ...");
				Date d = new Date();
				DateFormat formatage = new SimpleDateFormat("d MM yyyy");
				File dir = new File("rendu" + File.separatorChar
						+ formatage.format(d) + " - " + nomScene);
				if (!dir.exists())
					dir.mkdirs();
				formatage = new SimpleDateFormat("d MM yyyy - HH 'h' mm");
				maScene.image = new File("rendu" + File.separatorChar
						+ dir.getName() + File.separatorChar
						+ formatage.format(d) + " - " + nomScene + ".ppm");
				SceneDAOFichier.storeScene(maScene, new File(nomScene));
			}
			Thread t = new Thread() {
				public void run() {
					try {
						chargement.setText("Chargement de la scene ...");
						long a_sec = (System.currentTimeMillis());
						maScene.rendu(500, 500);
						// peinture.remove(chargement);
						peinture.set(JAI.create("fileload",
								maScene.image.toString()));
						long b_sec = (System.currentTimeMillis());
						chargement.setText("Rendu générer en "
								+ (b_sec - a_sec) + " ms. Temps par rayon : "
								+ (b_sec - a_sec)
								/ (500 * 500 * maScene.taille_pixel));
					} catch (Exception e) {
						// TODO Bloc catch généré automatiquement
						e.printStackTrace();
						chargement.setText("Erreur");
					}
				}
			};
			t.start();

		} catch (Exception e1) {
			// TODO Bloc catch généré automatiquement
			e1.printStackTrace();
			chargement.setText("Erreur");
		}
	}
}
