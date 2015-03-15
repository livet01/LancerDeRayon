package Presentation;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Metier.Couleur;
import Metier.Float3;
import Metier.Lumiere;
import Metier.Objets;
import Metier.Plan;
import Metier.Point3D;
import Metier.RayonException;
import Metier.Scene;
import Metier.SceneDAOFichier;
import Metier.Sphere;
import Metier.Vecteur;

public class PanelScene extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelPrincipale parent = null;
	public String nomScene;
	public Scene maScene = null;
	private JTextField grille_l;
	private JTextField grille_h;
	private JTextField grille_y;
	private JTextField grille_x;
	private JTextField grille_z;
	private JLabel lblObservateur;
	private JLabel lblPosition_1;
	private JPanel panel_1;
	private JTextField o_x;
	private JTextField o_y;
	private JTextField o_z;
	private JLabel lblScene;
	private JLabel lblCouleurFond;
	private JPanel panel_2;
	private JTextField fond_r;
	private JTextField fond_g;
	private JTextField fond_b;
	private JPanel panel_3;
	private JButton btnValider;
	private JButton btnAnnuler;
	private JLabel lblSphres;
	private JPanel panel_4;
	private JComboBox<Objets> comboBox;
	private JPanel panel_5;
	private JButton btnAjouter;
	private JButton btnModifier;
	private JButton btnSupprimer;
	private JPanel panel_6;
	private JLabel lblCentre;
	private JPanel panel_7;
	private JTextField txtCentrex;
	private JTextField txtCentrey;
	private JTextField txtCentrez;
	private JLabel lblRayon;
	private JTextField txtRayon;
	private JLabel lblCouleur;
	private JPanel panel_8;
	private JTextField txtCouleurr;
	private JTextField txtCouleurg;
	private JTextField txtCouleurb;
	private JLabel lblLumires;
	private JPanel panel_9;
	private JPanel panel_10;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JComboBox<Lumiere> comboBox_1;
	private JPanel panel_11;
	private JLabel lblPosition_2;
	private JPanel panel_12;
	private JTextField txtLx;
	private JTextField txtLy;
	private JTextField txtLz;
	private JButton btnSauvegarderLimage;
	private JPanel panel_13;
	private JTextField txtDiffuser;
	private JTextField txtDiffuseg;
	private JTextField txtDiffuseb;
	private JLabel lblDiffuse;
	private JLabel lblIntensite;
	private JPanel panel_14;
	private JTextField txtIntensiter;
	private JTextField txtIntensiteg;
	private JTextField txtIntensiteb;
	private JLabel lblSpe;
	private JTextField txtSpe;
	private JLabel lblspec;
	private JPanel panel_15;
	private JTextField txtSpecr;
	private JTextField txtSpecg;
	private JTextField txtSpecb;
	private JLabel lblIntensiteAmbiante;
	private JPanel panel_16;
	private JTextField txtIr;
	private JTextField txtIg;
	private JTextField txtIb;
	private JLabel lblAntialiassage;
	private JTextField txtPixel;
	private JLabel lblProfondeurRpercution;
	private JTextField txtRep;
	private JLabel lblRe;
	private JTextField txtRe;
	private JLabel lblTr;
	private JTextField txtTr;
	private JPanel panel18;
	private JComboBox<String> comboxObjet;
	private CardLayout panel_19;
	private JPanel panelObjets;
	private JPanel panel_6p;
	private JLabel lblCentrep;
	private JPanel panel_7p;
	private JLabel lblRayonp;
	private JPanel panel_8p;
	private JTextField txtPointx;
	private JTextField txtPointy;
	private JTextField txtPointz;
	private JTextField txtCentrexp;
	private JTextField txtCentreyp;
	private JTextField txtCentrezp;
	private JPanel panelBox;

	public void getScene() {
		try {
			maScene = SceneDAOFichier.findScene(new File(nomScene));
		} catch (RayonException e) {
			// TODO Auto-generated catch block
			maScene = new Scene();
		}
	}

	public void setScene() {
		try {
			SceneDAOFichier.storeScene(maScene, new File(nomScene));

		} catch (RayonException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void affectation() {
		try {
			grille_l.setText(maScene.dx.toString());
		} catch (NullPointerException e) {

		}
		try {
			grille_h.setText(maScene.dy.toString());
		} catch (NullPointerException e) {

		}
		try {
			grille_x.setText(maScene.centre_grille.x.toString());

		} catch (NullPointerException e) {

		}
		try {
			grille_y.setText(maScene.centre_grille.y.toString());

		} catch (NullPointerException e) {

		}
		try {
			grille_z.setText(maScene.centre_grille.z.toString());

		} catch (NullPointerException e) {

		}
		try {
			o_x.setText(maScene.observateur.x.toString());

		} catch (NullPointerException e) {

		}
		try {
			o_y.setText(maScene.observateur.y.toString());

		} catch (NullPointerException e) {

		}
		try {
			o_z.setText(maScene.observateur.z.toString());

		} catch (NullPointerException e) {

		}
		try {
			fond_r.setText(maScene.fond.r.toString());

		} catch (NullPointerException e) {

		}
		try {
			fond_g.setText(maScene.fond.g.toString());

		} catch (NullPointerException e) {

		}
		try {
			fond_b.setText(maScene.fond.b.toString());

		} catch (NullPointerException e) {

		}
		comboBox.removeAllItems();
		for (Objets uneSphere : maScene.liste_de_spheres) {
			comboBox.addItem(uneSphere);
		}
		comboBox_1.removeAllItems();
		for (Lumiere l : maScene.liste_de_lumieres) {
			comboBox_1.addItem(l);
		}
		try {
			txtIr.setText(maScene.intensite_a_r.toString());

		} catch (NullPointerException e) {

		}
		try {

			txtIg.setText(maScene.intensite_a_g.toString());

		} catch (NullPointerException e) {

		}
		try {

			txtIb.setText(maScene.intensite_a_b.toString());

		} catch (NullPointerException e) {

		}
		try {

			txtPixel.setText(maScene.taille_pixel.toString());

		} catch (NullPointerException e) {

		}
		try {

			txtRep.setText(maScene.p.toString());

		} catch (NullPointerException e) {

		}
	}

	public void persiste() {
		try {
			maScene.dx = Integer.parseInt(grille_l.getText());
		} catch (NullPointerException e) {

		}
		try {
			maScene.dy = Integer.parseInt(grille_h.getText());
		} catch (NullPointerException e) {

		}
		try {
			maScene.centre_grille.x = Float.parseFloat(grille_x.getText());

		} catch (NullPointerException e) {

		}
		try {
			maScene.centre_grille.y = Float.parseFloat(grille_y.getText());

		} catch (NullPointerException e) {

		}
		try {
			maScene.centre_grille.z = Float.parseFloat(grille_z.getText());

		} catch (NullPointerException e) {

		}
		try {
			maScene.observateur.x = Float.parseFloat(o_x.getText());

		} catch (NullPointerException e) {

		}
		try {
			maScene.observateur.y = Float.parseFloat(o_y.getText());

		} catch (NullPointerException e) {

		}
		try {
			maScene.observateur.z = Float.parseFloat(o_z.getText());

		} catch (NullPointerException e) {

		}
		try {
			maScene.fond.r = Integer.parseInt(fond_r.getText());

		} catch (NullPointerException e) {

		}
		try {
			maScene.fond.g = Integer.parseInt(fond_g.getText());

		} catch (NullPointerException e) {

		}
		try {
			maScene.fond.b = Integer.parseInt(fond_b.getText());

		} catch (NullPointerException e) {

		}
		maScene.liste_de_spheres = new ArrayList<Objets>();
		for (int i = 0; i < comboBox.getItemCount(); i++) {
			maScene.liste_de_spheres.add(comboBox.getItemAt(i));
		}
		maScene.liste_de_lumieres = new ArrayList<Lumiere>();
		for (int i = 0; i < comboBox_1.getItemCount(); i++) {
			maScene.liste_de_lumieres.add(comboBox_1.getItemAt(i));
		}
		maScene.intensite_a_r = Float.parseFloat(txtIr.getText());
		maScene.intensite_a_g = Float.parseFloat(txtIg.getText());
		maScene.intensite_a_b = Float.parseFloat(txtIb.getText());
		maScene.taille_pixel = Float.parseFloat(txtPixel.getText());
		maScene.p = Integer.parseInt(txtRep.getText());
	}

	private void ajoutObjet(){
		try {
			if(comboxObjet.getSelectedItem().equals("Sphère")){
			Sphere nouvelle = new Sphere(
					new Point3D(Float.parseFloat(txtCentrex
							.getText()), Float
							.parseFloat(txtCentrey.getText()),
							Float.parseFloat(txtCentrez.getText())),
					Float.parseFloat(txtRayon.getText()),
					Float.parseFloat(txtTr.getText()),
					Float.parseFloat(txtRe.getText()),
					Integer.parseInt(txtSpe.getText()),
					new Couleur(Integer.parseInt(txtCouleurr
							.getText()), Integer
							.parseInt(txtCouleurg.getText()),
							Integer.parseInt(txtCouleurb.getText())),
					new Float3(Float.parseFloat(txtDiffuser
							.getText()), Float
							.parseFloat(txtDiffuseg.getText()),
							Float.parseFloat(txtDiffuseb.getText())),
					new Float3(
							Float.parseFloat(txtSpecr.getText()),
							Float.parseFloat(txtSpecg.getText()),
							Float.parseFloat(txtSpecb.getText())),
					new Couleur());
			comboBox.addItem(nouvelle);
			}
			if(comboxObjet.getSelectedItem().equals("Plan")){
			Plan nouvelle = new Plan(
					new Vecteur(Float.parseFloat(txtCentrexp
							.getText()), Float
							.parseFloat(txtCentreyp.getText()),
							Float.parseFloat(txtCentrezp.getText())),
					new Point3D(Float.parseFloat(txtPointx
							.getText()), Float
							.parseFloat(txtPointy.getText()),
							Float.parseFloat(txtPointz.getText())),
					Float.parseFloat(txtTr.getText()),
					Float.parseFloat(txtRe.getText()),
					Integer.parseInt(txtSpe.getText()),
					new Couleur(Integer.parseInt(txtCouleurr
							.getText()), Integer
							.parseInt(txtCouleurg.getText()),
							Integer.parseInt(txtCouleurb.getText())),
					new Float3(Float.parseFloat(txtDiffuser
							.getText()), Float
							.parseFloat(txtDiffuseg.getText()),
							Float.parseFloat(txtDiffuseb.getText())),
					new Float3(
							Float.parseFloat(txtSpecr.getText()),
							Float.parseFloat(txtSpecg.getText()),
							Float.parseFloat(txtSpecb.getText())),
					new Couleur());
			comboBox.addItem(nouvelle);
			}
			txtCentrex.setText("");
			txtCentrey.setText("");
			txtCentrez.setText("");
			txtPointx.setText("");
			txtPointy.setText("");
			txtPointz.setText("");
			txtRayon.setText("");
			txtCouleurr.setText("");
			txtCouleurg.setText("");
			txtCouleurb.setText("");
			txtDiffuser.setText("");
			txtDiffuseg.setText("");
			txtDiffuseb.setText("");
			txtSpe.setText("");
			txtSpecr.setText("");
			txtSpecg.setText("");
			txtSpecb.setText("");
			txtRe.setText("");
			txtTr.setText("");

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null,
					"Erreur dans l'ajout de la sphère", "Erreur",
					JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		}
	}
	public PanelScene(PanelPrincipale parent, String nomScene) {
		this.setParent(parent);
		this.nomScene = nomScene;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblGrille = new JLabel("Grille");
		GridBagConstraints gbc_lblGrille = new GridBagConstraints();
		gbc_lblGrille.gridwidth = 2;
		gbc_lblGrille.insets = new Insets(0, 0, 5, 0);
		gbc_lblGrille.gridx = 0;
		gbc_lblGrille.gridy = 0;
		add(lblGrille, gbc_lblGrille);

		JLabel lblLargeur = new JLabel("Largeur");
		GridBagConstraints gbc_lblLargeur = new GridBagConstraints();
		gbc_lblLargeur.insets = new Insets(0, 0, 5, 5);
		gbc_lblLargeur.gridx = 0;
		gbc_lblLargeur.gridy = 1;
		add(lblLargeur, gbc_lblLargeur);

		grille_l = new JTextField();
		GridBagConstraints gbc_grille_l = new GridBagConstraints();
		gbc_grille_l.insets = new Insets(0, 0, 5, 0);
		gbc_grille_l.fill = GridBagConstraints.HORIZONTAL;
		gbc_grille_l.gridx = 1;
		gbc_grille_l.gridy = 1;
		add(grille_l, gbc_grille_l);
		grille_l.setColumns(10);

		JLabel lblHauteur = new JLabel("Hauteur");
		GridBagConstraints gbc_lblHauteur = new GridBagConstraints();
		gbc_lblHauteur.insets = new Insets(0, 0, 5, 5);
		gbc_lblHauteur.gridx = 0;
		gbc_lblHauteur.gridy = 2;
		add(lblHauteur, gbc_lblHauteur);

		grille_h = new JTextField();
		GridBagConstraints gbc_grille_h = new GridBagConstraints();
		gbc_grille_h.insets = new Insets(0, 0, 5, 0);
		gbc_grille_h.fill = GridBagConstraints.HORIZONTAL;
		gbc_grille_h.gridx = 1;
		gbc_grille_h.gridy = 2;
		add(grille_h, gbc_grille_h);
		grille_h.setColumns(10);

		JLabel lblPosition = new JLabel("Position centre");
		GridBagConstraints gbc_lblPosition = new GridBagConstraints();
		gbc_lblPosition.insets = new Insets(0, 0, 5, 5);
		gbc_lblPosition.gridx = 0;
		gbc_lblPosition.gridy = 3;
		add(lblPosition, gbc_lblPosition);

		JPanel panel = new JPanel();
		panel.setSize(new Dimension(10, 10));
		panel.setMaximumSize(new Dimension(10, 10));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.BASELINE;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 3;
		add(panel, gbc_panel);
		panel.setLayout(new GridLayout(1, 3, 0, 0));
		grille_x = new JTextField();
		grille_x.setMinimumSize(new Dimension(30, 28));
		panel.add(grille_x);
		grille_x.setColumns(10);

		grille_y = new JTextField();
		panel.add(grille_y);
		grille_y.setColumns(10);

		grille_z = new JTextField();
		panel.add(grille_z);
		grille_z.setColumns(10);

		lblAntialiassage = new JLabel("Anti-Aliassage");
		GridBagConstraints gbc_lblAntialiassage = new GridBagConstraints();
		gbc_lblAntialiassage.insets = new Insets(0, 0, 5, 5);
		gbc_lblAntialiassage.gridx = 0;
		gbc_lblAntialiassage.gridy = 4;
		add(lblAntialiassage, gbc_lblAntialiassage);

		txtPixel = new JTextField();
		GridBagConstraints gbc_txtPixel = new GridBagConstraints();
		gbc_txtPixel.insets = new Insets(0, 0, 5, 0);
		gbc_txtPixel.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPixel.gridx = 1;
		gbc_txtPixel.gridy = 4;
		add(txtPixel, gbc_txtPixel);
		txtPixel.setColumns(10);

		lblObservateur = new JLabel("Observateur\n");
		GridBagConstraints gbc_lblObservateur = new GridBagConstraints();
		gbc_lblObservateur.insets = new Insets(0, 0, 5, 0);
		gbc_lblObservateur.gridwidth = 2;
		gbc_lblObservateur.gridx = 0;
		gbc_lblObservateur.gridy = 5;
		add(lblObservateur, gbc_lblObservateur);

		lblPosition_1 = new JLabel("Position");
		GridBagConstraints gbc_lblPosition_1 = new GridBagConstraints();
		gbc_lblPosition_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblPosition_1.gridx = 0;
		gbc_lblPosition_1.gridy = 6;
		add(lblPosition_1, gbc_lblPosition_1);

		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 6;
		add(panel_1, gbc_panel_1);
		panel_1.setLayout(new GridLayout(1, 3, 0, 0));

		o_x = new JTextField();
		o_x.setColumns(10);
		panel_1.add(o_x);

		o_y = new JTextField();
		o_y.setColumns(10);
		panel_1.add(o_y);

		o_z = new JTextField();
		o_z.setColumns(10);
		panel_1.add(o_z);

		lblScene = new JLabel("Scene");
		GridBagConstraints gbc_lblScene = new GridBagConstraints();
		gbc_lblScene.insets = new Insets(0, 0, 5, 0);
		gbc_lblScene.gridwidth = 2;
		gbc_lblScene.gridx = 0;
		gbc_lblScene.gridy = 7;
		add(lblScene, gbc_lblScene);

		lblCouleurFond = new JLabel("Couleur fond");
		GridBagConstraints gbc_lblCouleurFond = new GridBagConstraints();
		gbc_lblCouleurFond.insets = new Insets(0, 0, 5, 5);
		gbc_lblCouleurFond.gridx = 0;
		gbc_lblCouleurFond.gridy = 8;
		add(lblCouleurFond, gbc_lblCouleurFond);

		panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 8;
		add(panel_2, gbc_panel_2);
		panel_2.setLayout(new GridLayout(1, 3, 0, 0));

		fond_r = new JTextField();
		fond_r.setColumns(10);
		panel_2.add(fond_r);

		fond_g = new JTextField();
		fond_g.setColumns(10);
		panel_2.add(fond_g);

		fond_b = new JTextField();
		fond_b.setColumns(10);
		panel_2.add(fond_b);

		lblIntensiteAmbiante = new JLabel("Intensite ambiante");
		GridBagConstraints gbc_lblIntensiteAmbiante = new GridBagConstraints();
		gbc_lblIntensiteAmbiante.insets = new Insets(0, 0, 5, 5);
		gbc_lblIntensiteAmbiante.gridx = 0;
		gbc_lblIntensiteAmbiante.gridy = 9;
		add(lblIntensiteAmbiante, gbc_lblIntensiteAmbiante);

		panel_16 = new JPanel();
		GridBagConstraints gbc_panel_16 = new GridBagConstraints();
		gbc_panel_16.insets = new Insets(0, 0, 5, 0);
		gbc_panel_16.fill = GridBagConstraints.BOTH;
		gbc_panel_16.gridx = 1;
		gbc_panel_16.gridy = 9;
		add(panel_16, gbc_panel_16);
		panel_16.setLayout(new BoxLayout(panel_16, BoxLayout.X_AXIS));

		txtIr = new JTextField();
		panel_16.add(txtIr);
		txtIr.setColumns(10);

		txtIg = new JTextField();
		panel_16.add(txtIg);
		txtIg.setColumns(10);

		txtIb = new JTextField();
		panel_16.add(txtIb);
		txtIb.setColumns(10);

		lblProfondeurRpercution = new JLabel("Profondeur r\u00E9percution");
		GridBagConstraints gbc_lblProfondeurRpercution = new GridBagConstraints();
		gbc_lblProfondeurRpercution.anchor = GridBagConstraints.EAST;
		gbc_lblProfondeurRpercution.insets = new Insets(0, 0, 5, 5);
		gbc_lblProfondeurRpercution.gridx = 0;
		gbc_lblProfondeurRpercution.gridy = 10;
		add(lblProfondeurRpercution, gbc_lblProfondeurRpercution);

		txtRep = new JTextField();
		GridBagConstraints gbc_txtRep = new GridBagConstraints();
		gbc_txtRep.insets = new Insets(0, 0, 5, 0);
		gbc_txtRep.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRep.gridx = 1;
		gbc_txtRep.gridy = 10;
		add(txtRep, gbc_txtRep);
		txtRep.setColumns(10);

		lblSphres = new JLabel("Objets");
		GridBagConstraints gbc_lblSphres = new GridBagConstraints();
		gbc_lblSphres.insets = new Insets(0, 0, 5, 5);
		gbc_lblSphres.gridx = 0;
		gbc_lblSphres.gridy = 11;
		add(lblSphres, gbc_lblSphres);

		panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.anchor = GridBagConstraints.NORTH;
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 11;
		add(panel_4, gbc_panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));

		comboBox = new JComboBox<Objets>();
		panel_4.add(comboBox);

		panel_5 = new JPanel();
		panel_4.add(panel_5);

		btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int result = JOptionPane.showConfirmDialog(null, panelBox,
						"Nouvelle sphère", JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					ajoutObjet();
				}

			}
		});
		panel_5.add(btnAjouter);

		btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Objets o = (Objets) comboBox.getSelectedItem();
				if(o instanceof Sphere){
					Sphere nouvelle = (Sphere) o;
					comboxObjet.setSelectedItem("Sphère");
					txtCentrex.setText(nouvelle.centre.x.toString());
					txtCentrey.setText(nouvelle.centre.y.toString());
					txtCentrez.setText(nouvelle.centre.z.toString());
					txtRayon.setText(nouvelle.r.toString());
					txtCouleurr.setText(nouvelle.ambiante.r.toString());
					txtCouleurg.setText(nouvelle.ambiante.g.toString());
					txtCouleurb.setText(nouvelle.ambiante.b.toString());
					txtDiffuser.setText(nouvelle.diffuse.x.toString());
					txtDiffuseg.setText(nouvelle.diffuse.y.toString());
					txtDiffuseb.setText(nouvelle.diffuse.z.toString());
					txtSpe.setText(nouvelle.specularite.toString());
					txtSpecr.setText(nouvelle.speculaire.x.toString());
					txtSpecg.setText(nouvelle.speculaire.y.toString());
					txtSpecb.setText(nouvelle.speculaire.z.toString());
					txtRe.setText(nouvelle.refraction.toString());
					txtTr.setText(nouvelle.transparence.toString());
				}
				else{
					Plan nouvelle = (Plan) o;
					comboxObjet.setSelectedItem("Plan");
					nouvelle = (Plan) comboBox.getSelectedItem();
					txtCentrexp.setText(nouvelle.normal.x.toString());
					txtCentreyp.setText(nouvelle.normal.y.toString());
					txtCentrezp.setText(nouvelle.normal.z.toString());
					txtPointx.setText(nouvelle.point.x.toString());
					txtPointy.setText(nouvelle.point.y.toString());
					txtPointz.setText(nouvelle.point.z.toString());
					txtCouleurr.setText(nouvelle.ambiante.r.toString());
					txtCouleurg.setText(nouvelle.ambiante.g.toString());
					txtCouleurb.setText(nouvelle.ambiante.b.toString());
					txtDiffuser.setText(nouvelle.diffuse.x.toString());
					txtDiffuseg.setText(nouvelle.diffuse.y.toString());
					txtDiffuseb.setText(nouvelle.diffuse.z.toString());
					txtSpe.setText(nouvelle.specularite.toString());
					txtSpecr.setText(nouvelle.speculaire.x.toString());
					txtSpecg.setText(nouvelle.speculaire.y.toString());
					txtSpecb.setText(nouvelle.speculaire.z.toString());
					txtRe.setText(nouvelle.refraction.toString());
					txtTr.setText(nouvelle.transparence.toString());
				}
				
				int result = JOptionPane.showConfirmDialog(null, panelBox,
						"Modifier sphère", JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					comboBox.removeItem(o);
					ajoutObjet();
				}

			}
		});
		panel_5.add(btnModifier);

		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.removeItem(comboBox.getSelectedItem());
			}
		});
		panel_5.add(btnSupprimer);

		//
		// Sphère
		//
		
		panel_6 = new JPanel();
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[] { 175, 175, 0 };
		gbl_panel_6.rowHeights = new int[] { 35, 0, 0 };
		gbl_panel_6.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_6.rowWeights = new double[] { 0.0, 0.0, 0.0 };
		panel_6.setLayout(gbl_panel_6);

	
		
		lblCentre = new JLabel("Centre");
		GridBagConstraints gbc_lblCentre = new GridBagConstraints();
		gbc_lblCentre.anchor = GridBagConstraints.WEST;
		gbc_lblCentre.insets = new Insets(0, 0, 5, 5);
		gbc_lblCentre.gridx = 0;
		gbc_lblCentre.gridy = 1;
		panel_6.add(lblCentre, gbc_lblCentre);

		panel_7 = new JPanel();
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.insets = new Insets(0, 0, 5, 0);
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 1;
		gbc_panel_7.gridy = 1;
		panel_6.add(panel_7, gbc_panel_7);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.X_AXIS));

		txtCentrex = new JTextField();
		panel_7.add(txtCentrex);
		txtCentrex.setColumns(10);

		txtCentrey = new JTextField();
		panel_7.add(txtCentrey);
		txtCentrey.setColumns(10);

		txtCentrez = new JTextField();
		panel_7.add(txtCentrez);
		txtCentrez.setColumns(10);

		lblRayon = new JLabel("Rayon");
		GridBagConstraints gbc_lblRayon = new GridBagConstraints();
		gbc_lblRayon.anchor = GridBagConstraints.WEST;
		gbc_lblRayon.insets = new Insets(0, 0, 5, 5);
		gbc_lblRayon.gridx = 0;
		gbc_lblRayon.gridy = 2;
		panel_6.add(lblRayon, gbc_lblRayon);

		txtRayon = new JTextField();
		GridBagConstraints gbc_txtRayon = new GridBagConstraints();
		gbc_txtRayon.insets = new Insets(0, 0, 5, 0);
		gbc_txtRayon.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRayon.gridx = 1;
		gbc_txtRayon.gridy = 2;
		panel_6.add(txtRayon, gbc_txtRayon);
		txtRayon.setColumns(10);

		
		//
		// Plan 
		//
		
		panel_6p = new JPanel();
		GridBagLayout gbl_panel_6p = new GridBagLayout();
		gbl_panel_6p.columnWidths = new int[] { 175, 175, 0 };
		gbl_panel_6p.rowHeights = new int[] { 35, 0, 0 };
		gbl_panel_6p.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_6p.rowWeights = new double[] { 0.0, 0.0, 0.0 };
		panel_6p.setLayout(gbl_panel_6p);

		
		lblCentrep = new JLabel("Normal");
		GridBagConstraints gbc_lblCentrep = new GridBagConstraints();
		gbc_lblCentrep.anchor = GridBagConstraints.WEST;
		gbc_lblCentrep.insets = new Insets(0, 0, 5, 5);
		gbc_lblCentrep.gridx = 0;
		gbc_lblCentrep.gridy = 1;
		panel_6p.add(lblCentrep, gbc_lblCentrep);

		panel_7p = new JPanel();
		GridBagConstraints gbc_panel_7p = new GridBagConstraints();
		gbc_panel_7p.insets = new Insets(0, 0, 5, 0);
		gbc_panel_7p.fill = GridBagConstraints.BOTH;
		gbc_panel_7p.gridx = 1;
		gbc_panel_7p.gridy = 1;
		panel_6p.add(panel_7p, gbc_panel_7p);
		panel_7p.setLayout(new BoxLayout(panel_7p, BoxLayout.X_AXIS));


		txtCentrexp = new JTextField();
		panel_7p.add(txtCentrexp);
		txtCentrexp.setColumns(10);

		txtCentreyp = new JTextField();
		panel_7p.add(txtCentreyp);
		txtCentreyp.setColumns(10);

		txtCentrezp = new JTextField();
		panel_7p.add(txtCentrezp);
		txtCentrezp.setColumns(10);
		

		lblRayonp = new JLabel("Point");
		GridBagConstraints gbc_lblRayonp = new GridBagConstraints();
		gbc_lblRayonp.anchor = GridBagConstraints.WEST;
		gbc_lblRayonp.insets = new Insets(0, 0, 5, 5);
		gbc_lblRayonp.gridx = 0;
		gbc_lblRayonp.gridy = 2;
		panel_6p.add(lblRayonp, gbc_lblRayon);

		panel_8p = new JPanel();
		GridBagConstraints gbc_panel_8p = new GridBagConstraints();
		gbc_panel_8p.insets = new Insets(0, 0, 5, 0);
		gbc_panel_8p.fill = GridBagConstraints.BOTH;
		gbc_panel_8p.gridx = 1;
		gbc_panel_8p.gridy = 2;
		panel_6p.add(panel_8p, gbc_panel_8p);
		panel_8p.setLayout(new BoxLayout(panel_8p, BoxLayout.X_AXIS));

		txtPointx = new JTextField();
		panel_8p.add(txtPointx);
		txtPointx.setColumns(10);

		txtPointy = new JTextField();
		panel_8p.add(txtPointy);
		txtPointy.setColumns(10);

		txtPointz = new JTextField();
		panel_8p.add(txtPointz);
		txtPointz.setColumns(10);
		
		// ------
		
		panelBox = new JPanel(new BorderLayout());
		panelObjets = new JPanel();
		panel_19 = new CardLayout();
		panelObjets.setLayout(panel_19);
		panelObjets.add(panel_6,"Sphère");
		panelObjets.add(panel_6p,"Plan");

		panelBox.add(panelObjets,BorderLayout.CENTER);
		
		comboxObjet = new JComboBox<String>();
		comboxObjet.addItem("Sphère");
		comboxObjet.addItem("Plan");
		comboxObjet.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Stub de la méthode généré automatiquement
				
				panel_19.show(panelObjets, comboxObjet.getSelectedItem().toString());
			}
			
		});
		panelBox.add(comboxObjet,BorderLayout.NORTH);
		
		
		panel18 = new JPanel();

		panelBox.add(panel18,BorderLayout.SOUTH);
		// ajout sphère
		//panel_6.add(panel18, gbc_panel18);
		//panel_6p.add(panel18, gbc_panel18);
		GridBagLayout gbl_panel18 = new GridBagLayout();
		gbl_panel18.columnWidths = new int[] { 175, 175, 0 };
		gbl_panel18.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel18.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel18.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		panel18.setLayout(gbl_panel18);

		lblCouleur = new JLabel("Couleur");
		GridBagConstraints gbc_lblCouleur = new GridBagConstraints();
		gbc_lblCouleur.anchor = GridBagConstraints.WEST;
		gbc_lblCouleur.insets = new Insets(0, 0, 5, 5);
		gbc_lblCouleur.gridx = 0;
		gbc_lblCouleur.gridy = 0;
		panel18.add(lblCouleur, gbc_lblCouleur);

		panel_8 = new JPanel();
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.insets = new Insets(0, 0, 5, 0);
		gbc_panel_8.gridx = 1;
		gbc_panel_8.gridy = 0;
		panel18.add(panel_8, gbc_panel_8);
		panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.X_AXIS));

		txtCouleurr = new JTextField();
		panel_8.add(txtCouleurr);
		txtCouleurr.setColumns(10);

		txtCouleurg = new JTextField();
		panel_8.add(txtCouleurg);
		txtCouleurg.setColumns(10);

		txtCouleurb = new JTextField();
		panel_8.add(txtCouleurb);
		txtCouleurb.setColumns(10);

		lblDiffuse = new JLabel("Diffuse (entre 0 et 1)");
		GridBagConstraints gbc_lblDiffuse = new GridBagConstraints();
		gbc_lblDiffuse.anchor = GridBagConstraints.WEST;
		gbc_lblDiffuse.insets = new Insets(0, 0, 5, 5);
		gbc_lblDiffuse.gridx = 0;
		gbc_lblDiffuse.gridy = 1;
		panel18.add(lblDiffuse, gbc_lblDiffuse);

		panel_13 = new JPanel();
		GridBagConstraints gbc_panel_13 = new GridBagConstraints();
		gbc_panel_13.fill = GridBagConstraints.BOTH;
		gbc_panel_13.insets = new Insets(0, 0, 5, 0);
		gbc_panel_13.gridx = 1;
		gbc_panel_13.gridy = 1;
		panel18.add(panel_13, gbc_panel_13);
		panel_13.setLayout(new BoxLayout(panel_13, BoxLayout.X_AXIS));

		txtDiffuser = new JTextField();
		panel_13.add(txtDiffuser);
		txtDiffuser.setColumns(10);

		txtDiffuseg = new JTextField();
		panel_13.add(txtDiffuseg);
		txtDiffuseg.setColumns(10);

		txtDiffuseb = new JTextField();
		panel_13.add(txtDiffuseb);
		txtDiffuseb.setColumns(10);

		lblSpe = new JLabel("Specularité");
		GridBagConstraints gbc_lblSpe = new GridBagConstraints();
		gbc_lblSpe.anchor = GridBagConstraints.WEST;
		gbc_lblSpe.insets = new Insets(0, 0, 5, 5);
		gbc_lblSpe.gridx = 0;
		gbc_lblSpe.gridy = 2;
		panel18.add(lblSpe, gbc_lblSpe);

		txtSpe = new JTextField();
		GridBagConstraints gbc_txtSpe = new GridBagConstraints();
		gbc_txtSpe.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSpe.insets = new Insets(0, 0, 5, 0);
		gbc_txtSpe.gridx = 1;
		gbc_txtSpe.gridy = 2;
		panel18.add(txtSpe, gbc_txtSpe);
		txtSpe.setColumns(10);

		lblspec = new JLabel("Spéculaire");
		GridBagConstraints gbc_lblspec = new GridBagConstraints();
		gbc_lblspec.anchor = GridBagConstraints.WEST;
		gbc_lblspec.insets = new Insets(0, 0, 5, 5);
		gbc_lblspec.gridx = 0;
		gbc_lblspec.gridy = 3;
		panel18.add(lblspec, gbc_lblspec);

		panel_15 = new JPanel();
		GridBagConstraints gbc_panel_15 = new GridBagConstraints();
		gbc_panel_15.fill = GridBagConstraints.BOTH;
		gbc_panel_15.insets = new Insets(0, 0, 5, 0);
		gbc_panel_15.gridx = 1;
		gbc_panel_15.gridy = 3;
		panel18.add(panel_15, gbc_panel_15);
		panel_15.setLayout(new BoxLayout(panel_15, BoxLayout.X_AXIS));

		txtSpecr = new JTextField();
		panel_15.add(txtSpecr);
		txtSpecr.setColumns(10);

		txtSpecg = new JTextField();
		panel_15.add(txtSpecg);
		txtSpecg.setColumns(10);

		txtSpecb = new JTextField();
		panel_15.add(txtSpecb);
		txtSpecb.setColumns(10);

		lblRe = new JLabel("Réflexion");
		GridBagConstraints gbc_lblRe = new GridBagConstraints();
		gbc_lblRe.anchor = GridBagConstraints.WEST;
		gbc_lblRe.insets = new Insets(0, 0, 5, 5);
		gbc_lblRe.gridx = 0;
		gbc_lblRe.gridy = 4;
		panel18.add(lblRe, gbc_lblRe);

		txtRe = new JTextField();
		GridBagConstraints gbc_txtRe = new GridBagConstraints();
		gbc_txtRe.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRe.insets = new Insets(0, 0, 5, 0);
		gbc_txtRe.gridx = 1;
		gbc_txtRe.gridy = 4;
		panel18.add(txtRe, gbc_txtRe);
		txtRe.setColumns(10);

		lblTr = new JLabel("Transparence");
		GridBagConstraints gbc_lblTr = new GridBagConstraints();
		gbc_lblTr.anchor = GridBagConstraints.WEST;
		gbc_lblTr.insets = new Insets(0, 0, 5, 5);
		gbc_lblTr.gridx = 0;
		gbc_lblTr.gridy = 5;
		panel18.add(lblTr, gbc_lblTr);

		txtTr = new JTextField();
		GridBagConstraints gbc_txtTr = new GridBagConstraints();
		gbc_txtTr.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTr.insets = new Insets(0, 0, 5, 0);
		gbc_txtTr.gridx = 1;
		gbc_txtTr.gridy = 5;
		panel18.add(txtTr, gbc_txtTr);
		txtTr.setColumns(10);


		lblLumires = new JLabel("Lumi\u00E8res");
		GridBagConstraints gbc_lblLumires = new GridBagConstraints();
		gbc_lblLumires.insets = new Insets(0, 0, 5, 5);
		gbc_lblLumires.gridx = 0;
		gbc_lblLumires.gridy = 12;
		add(lblLumires, gbc_lblLumires);

		panel_9 = new JPanel();
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.insets = new Insets(0, 0, 5, 0);
		gbc_panel_9.fill = GridBagConstraints.BOTH;
		gbc_panel_9.gridx = 1;
		gbc_panel_9.gridy = 12;
		add(panel_9, gbc_panel_9);
		panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.Y_AXIS));

		comboBox_1 = new JComboBox<Lumiere>();
		panel_9.add(comboBox_1);

		panel_10 = new JPanel();
		panel_9.add(panel_10);

		button = new JButton("Ajouter");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int result = JOptionPane.showConfirmDialog(null, panel_11,
						"Nouvelle lumière", JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					try {
						Lumiere nouvelle = new Lumiere(new Point3D(Float
								.parseFloat(txtLx.getText()), Float
								.parseFloat(txtLy.getText()), Float
								.parseFloat(txtLz.getText())), Float
								.parseFloat(txtIntensiter.getText()), Float
								.parseFloat(txtIntensiteg.getText()), Float
								.parseFloat(txtIntensiteb.getText()));
						comboBox_1.addItem(nouvelle);
						txtLx.setText("");
						txtLy.setText("");
						txtLz.setText("");
						txtIntensiter.setText("");
						txtIntensiteg.setText("");
						txtIntensiteb.setText("");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null,
								"Erreur dans l'ajout de la lumiere", "Erreur",
								JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		});
		panel_10.add(button);

		button_1 = new JButton("Modifier");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Lumiere nouvelle = (Lumiere) comboBox_1.getSelectedItem();
				txtLx.setText(nouvelle.position.x.toString());
				txtLy.setText(nouvelle.position.y.toString());
				txtLz.setText(nouvelle.position.z.toString());
				txtIntensiter.setText(nouvelle.intensite_r.toString());
				txtIntensiteg.setText(nouvelle.intensite_g.toString());
				txtIntensiteb.setText(nouvelle.intensite_b.toString());
				int result = JOptionPane.showConfirmDialog(null, panel_11,
						"Modifier lumière", JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					try {
						nouvelle.position = new Point3D(Float.parseFloat(txtLx
								.getText()), Float.parseFloat(txtLy.getText()),
								Float.parseFloat(txtLz.getText()));
						nouvelle.intensite_r = Float.parseFloat(txtIntensiter
								.getText());
						nouvelle.intensite_g = Float.parseFloat(txtIntensiteg
								.getText());
						nouvelle.intensite_b = Float.parseFloat(txtIntensiteb
								.getText());
						txtLx.setText("");
						txtLy.setText("");
						txtLz.setText("");
						txtIntensiter.setText("");
						txtIntensiteg.setText("");
						txtIntensiteb.setText("");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null,
								"Erreur dans la modification de la lumiere",
								"Erreur", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		panel_10.add(button_1);

		button_2 = new JButton("Supprimer");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_1.removeItem(comboBox_1.getSelectedItem());
			}
		});
		panel_10.add(button_2);

		panel_11 = new JPanel();
		GridBagLayout gbl_panel_11 = new GridBagLayout();
		gbl_panel_11.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_11.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_11.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_11.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panel_11.setLayout(gbl_panel_11);

		lblPosition_2 = new JLabel("Position");
		GridBagConstraints gbc_lblPosition_2 = new GridBagConstraints();
		gbc_lblPosition_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblPosition_2.gridx = 0;
		gbc_lblPosition_2.gridy = 0;
		panel_11.add(lblPosition_2, gbc_lblPosition_2);

		panel_12 = new JPanel();
		GridBagConstraints gbc_panel_12 = new GridBagConstraints();
		gbc_panel_12.insets = new Insets(0, 0, 5, 0);
		gbc_panel_12.fill = GridBagConstraints.BOTH;
		gbc_panel_12.gridx = 1;
		gbc_panel_12.gridy = 0;
		panel_11.add(panel_12, gbc_panel_12);

		txtLx = new JTextField();
		panel_12.add(txtLx);
		txtLx.setColumns(10);

		txtLy = new JTextField();
		panel_12.add(txtLy);
		txtLy.setColumns(10);

		txtLz = new JTextField();
		panel_12.add(txtLz);
		txtLz.setColumns(10);

		lblIntensite = new JLabel("Intensite");
		GridBagConstraints gbc_lblIntensite = new GridBagConstraints();
		gbc_lblIntensite.insets = new Insets(0, 0, 5, 5);
		gbc_lblIntensite.gridx = 0;
		gbc_lblIntensite.gridy = 1;
		panel_11.add(lblIntensite, gbc_lblIntensite);

		panel_14 = new JPanel();
		GridBagConstraints gbc_panel_14 = new GridBagConstraints();
		gbc_panel_14.insets = new Insets(0, 0, 5, 0);
		gbc_panel_14.fill = GridBagConstraints.BOTH;
		gbc_panel_14.gridx = 1;
		gbc_panel_14.gridy = 1;
		panel_11.add(panel_14, gbc_panel_14);

		txtIntensiter = new JTextField();
		panel_14.add(txtIntensiter);
		txtIntensiter.setColumns(10);

		txtIntensiteg = new JTextField();
		panel_14.add(txtIntensiteg);
		txtIntensiteg.setColumns(10);

		txtIntensiteb = new JTextField();
		panel_14.add(txtIntensiteb);
		txtIntensiteb.setColumns(10);

		panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridwidth = 2;
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 14;
		add(panel_3, gbc_panel_3);

		btnValider = new JButton("Rendu");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				persiste();
				setScene();
				getParent().rendu(true);
			}
		});
		panel_3.add(btnValider);

		btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getScene();
				affectation();
			}
		});

		btnSauvegarderLimage = new JButton("Sauvegarder l'image");
		btnSauvegarderLimage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				persiste();
				setScene();
				getParent().rendu(true);
			}
		});
		panel_3.add(btnSauvegarderLimage);
		panel_3.add(btnAnnuler);
		// TODO Stub du constructeur généré automatiquement

		getScene();
		affectation();
	}

	public PanelPrincipale getParent() {
		return parent;
	}

	public void setParent(PanelPrincipale parent) {
		this.parent = parent;
	}

}
