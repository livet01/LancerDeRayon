package Metier;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Scene implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public File image;
	public Integer p, dx, dy;
	public Point3D observateur, centre_grille;
	public Float intensite_a_r, intensite_a_g, intensite_a_b, taille_pixel;
	public Couleur fond;
	public ArrayList<Lumiere> liste_de_lumieres;
	public ArrayList<Objets> liste_de_spheres;
	public Integer nbLumiere;

	public Scene() {
		// TODO Auto-generated constructor stub
		nbLumiere = 1;
	}

	public ArrayList<Lumiere> getLumiere() {
		ArrayList<Lumiere> nouveau = new ArrayList<Lumiere>();
		nbLumiere = 1;
		Random rand = new Random();
		for (Lumiere l : liste_de_lumieres) {
			for (int i = 0; i < nbLumiere; i++) {
				nouveau.add(new Lumiere(new Point3D(l.position.x
						+ (float) (rand.nextDouble() * rand.nextInt(3) - rand
								.nextDouble() * rand.nextInt(3)), l.position.y
						+ (float) (rand.nextDouble() * rand.nextInt(3) - rand
								.nextDouble() * rand.nextInt(3)), l.position.z
						+ (float) (rand.nextDouble() * rand.nextInt(3) - rand
								.nextDouble() * rand.nextInt(3))),
						l.intensite_r / nbLumiere, l.intensite_g / nbLumiere,
						l.intensite_b / nbLumiere));
			}
		}
		return liste_de_lumieres;
		// return nouveau;

	}

	// @SuppressWarnings("unused")
	public Couleur lancerRayon(Point3D O, Vecteur rayon, int profondeur) {
		// déclarations
		rayon.normer();
		Iterator<Objets> iter_sphere;
		Objets sphere_proche = null;
		Iterator<Lumiere> iter_lumiere;

		// intersections
		Double plus_proche_t = -1.0;
		Double t = -1.0;

		// coordonnees de l'intersection
		Point3D inter = new Point3D(0.F, 0.F, 0.F);

		// ombre sur l'intersection?
		boolean ombre = false;

		// vecteur normale a l'intersection
		Vecteur v_n = new Vecteur(0.F, 0.F, 0.F);

		// vecteur directeur (intersection,lumiere)
		Vecteur v_l = new Vecteur(0.F, 0.F, 0.F);

		// vecteur directeur bisecteur (lumiere,rayon)
		Vecteur v_h = new Vecteur(0.F, 0.F, 0.F);

		// rayon reflechi
		Vecteur v_r = new Vecteur(0.F, 0.F, 0.F);

		// vecteur inverse du rayon
		Vecteur v_i = rayon.getInverse();
		v_i.normer();
		// rayon refracté
		Vecteur v_refracte = new Vecteur(0.F, 0.F, 0.F);

		// point de sortie du rayon refracté dans la sphere
		Point3D sortie = new Point3D(0.F, 0.F, 0.F);

		// cosinus de l'angle entre la normale v_n et v_l
		float cos_theta = 0;

		// cosinus de l'angle entre la normale v_n et v_h
		float cos_phi = 0;

		// declaration des couleurs
		Couleur coul = fond;
		Couleur coul_reflexion = new Couleur(0, 0, 0);
		Couleur coul_refraction = new Couleur(0, 0, 0);

		// A COMPLETER !

		// pour chaque objet
		// intersection de l'objet i et du rayon
		iter_sphere = this.liste_de_spheres.iterator();

		while (iter_sphere.hasNext()) {
			Object o = iter_sphere.next();
			if (o instanceof Objets) {
				Objets maSphere = (Objets) o;
				t = maSphere.intersection(O, rayon, 0.01F);

				// si il y a eu intersection avec l'objet
				if (t != -1) {
					// et qu'elle est meilleur qu'avec le precedent objet (ou
					// que
					// c'est le
					// premier objet rencontré par le rayon)
					if (t < plus_proche_t || plus_proche_t == -1) {
						// on prend l'intersection comme etant la plus proche et
						// on
						// sauvegarde
						// l'objet
						plus_proche_t = t;
						sphere_proche = maSphere;
					}
				}
			}

		}
		// si il y a eu intersection avec un objet on calcul la couleur
		if (sphere_proche != null && plus_proche_t != -1) {
			inter = rayon.getPoint3D(O, plus_proche_t);
			// Définition de la couleur
			coul = sphere_proche.getAmbiante();
			// Vecteur normal
			v_n = sphere_proche.getNormal(inter, rayon);
			v_n.normer();

			ArrayList<Lumiere> tabList = getLumiere();
			// pour chaque lumière on calcul
			iter_lumiere = tabList.iterator();

			// anti ombre dur

			Float3 intensite = new Float3(intensite_a_r, intensite_a_g,
					intensite_a_b);
			int conteur = 0;
			while (iter_lumiere.hasNext()) {
				ombre = false;
				Object o1 = iter_lumiere.next();
				if (o1 instanceof Lumiere) {
					Lumiere l = (Lumiere) o1;
					v_l = l.position.moins(inter);
					v_l.normer();
					iter_sphere = this.liste_de_spheres.iterator();

					plus_proche_t = -1.0;

					while (iter_sphere.hasNext()) {
						Object o = iter_sphere.next();
						if (o instanceof Objets) {
							Objets maSphere = (Objets) o;
							t = maSphere.intersection(inter, v_l, 0.01F);

							// si il y a eu intersection avec l'objet
							if (t != -1) {
								// et qu'elle est meilleur qu'avec le
								// precedent objet (ou que
								// c'est le
								// premier objet rencontré par le rayon)
								if (t < plus_proche_t || plus_proche_t == -1) {
									// on prend l'intersection comme etant
									// la plus proche et on
									// sauvegarde
									// l'objet
									plus_proche_t = t;
									ombre = true;
								}
							}
						}

					}

					if (ombre == false) {

						// Diffuse
						cos_theta = (float) v_l.scalaire(v_n);
						intensite.x += (cos_theta) * sphere_proche.getDiffuse().x
								* l.intensite_r;
						intensite.y += (cos_theta) * sphere_proche.getDiffuse().y
								* l.intensite_g;
						intensite.z += (cos_theta) * sphere_proche.getDiffuse().z
								* l.intensite_b;
						// Spéculaire
						if (conteur % nbLumiere == 0) {
							v_h = (v_n.multiplication(2 * (v_n.scalaire(v_l))))
									.moins(v_l);
							v_h.normer();
							cos_phi = (float) Math.pow(v_i.scalaire(v_h),
									sphere_proche.getSpecularite());
							intensite.x += (cos_phi * sphere_proche.getSpeculaire().x);
							intensite.y += (cos_phi * sphere_proche.getSpeculaire().y);
							intensite.z += (cos_phi * sphere_proche.getSpeculaire().z);
						}
						conteur++;
					}
				}

			}
			coul = coul.fois(intensite);
			if (profondeur > 0) {
				float cos_theta1, cos_theta2, n;
				n = sphere_proche.getRefraction();
				cos_theta1 = v_n.scalaire(v_i);

				// Réflexion
				v_r = rayon.plus(v_n.multiplication(2 * cos_theta1));
				v_r.normer();
				coul_reflexion = lancerRayon(inter, v_r, profondeur - 1);
				coul_reflexion = coul_reflexion.fois(sphere_proche.getSpeculaire());
				coul = coul.fois(new Float3(1 - sphere_proche.getSpeculaire().x,
						1 - sphere_proche.getSpeculaire().y,
						1 - sphere_proche.getSpeculaire().z));
				coul.add(coul_reflexion);
				if (sphere_proche instanceof Sphere) {
					// Réfraction
					cos_theta2 = 1 - n * n * (1 - cos_theta1 * cos_theta1);
					if (cos_theta2 >= 0) {
						cos_theta2 = (float) Math.sqrt(cos_theta2);
						if (cos_theta1 > 0) {
							v_refracte = (rayon.multiplication(n))
									.plus(v_n.multiplication(n * cos_theta1
											- cos_theta2));
						} else {
							v_refracte = (rayon.multiplication(n))
									.plus(v_n.multiplication(n * cos_theta1
											+ cos_theta2));
						}
						v_refracte.normer();

						plus_proche_t = -1.0;
						t = -1.0;
						Sphere sphere_proche2 = null;
						iter_sphere = this.liste_de_spheres.iterator();
						while (iter_sphere.hasNext()) {
							Object o = iter_sphere.next();
							if (o instanceof Sphere) {
								Sphere maSphere = (Sphere) o;
								t = maSphere.intersection(inter, v_refracte,
										0.01F);

								// si il y a eu intersection avec l'objet
								if (t != -1) {
									// et qu'elle est meilleur qu'avec le
									// precedent objet (ou
									// que
									// c'est le
									// premier objet rencontré par le rayon)
									if (t < plus_proche_t
											|| plus_proche_t == -1) {
										// on prend l'intersection comme etant
										// la plus proche et
										// on
										// sauvegarde
										// l'objet
										plus_proche_t = t;
										sphere_proche2 = maSphere;
									}
								}
							}

						}

						if (sphere_proche.equals(sphere_proche2)) {
							sortie = v_refracte
									.getPoint3D(inter, plus_proche_t);
							Vecteur v_n2 = sphere_proche.getNormal(inter,
									v_refracte);
							Vecteur v_i2 = v_refracte.getInverse();
							n = 1 / n;
							cos_theta1 = v_n2.scalaire(v_i2);
							cos_theta2 = 1 - n * n
									* (1 - cos_theta1 * cos_theta1);
							if (cos_theta2 >= 0) {
								cos_theta2 = (float) Math.sqrt(cos_theta2);
								if (cos_theta1 > 0) {
									v_refracte = (v_refracte.multiplication(n))
											.plus(v_n2.multiplication(n
													* cos_theta1 - cos_theta2));
								} else {
									v_refracte = (v_refracte.multiplication(n))
											.plus(v_n2.multiplication(n
													* cos_theta1 + cos_theta2));
								}
							}
							v_refracte.normer();

							coul_refraction = lancerRayon(sortie, v_refracte,
									profondeur - 1);
						} else {
							coul_refraction = lancerRayon(inter, v_refracte,
									profondeur - 1);
						}

						coul_refraction = coul_refraction.fois(new Float3(
								sphere_proche.getTransparence(),
								sphere_proche.getTransparence(),
								sphere_proche.getTransparence()));
						coul = coul.fois(new Float3(
								1 - sphere_proche.getTransparence(),
								1 - sphere_proche.getTransparence(),
								1 - sphere_proche.getTransparence()));
						coul.add(coul_refraction);
					}
				}
			}

		} else {
			coul = fond;
		}

		// terme diffus (avec ombre)

		// terme spéculaire

		// calcul du terme de reflexion
		// on lance un rayon suivant la normale a la sphere (si on a pas atteint
		// la profondeur de recursion
		// et que l'angle entre la normale et l'opposé du rayon lancé
		// calcul du rayon relechi loi de Snell-Descartes
		// lancement du rayon reflechi

		// transparence de l'objet

		// terme de refraction

		// on retourne la couleur calculée ou la couleur du fond
		coul.r = (coul.r > 255) ? 255 : ((coul.r < 0) ? 0 : coul.r);
		coul.g = (coul.g > 255) ? 255 : ((coul.g < 0) ? 0 : coul.g);
		coul.b = (coul.b > 255) ? 255 : ((coul.b < 0) ? 0 : coul.b);
		return coul;

	}

	public void writeLine(BufferedWriter out, String line) throws Exception {
		out.write(line, 0, line.length());
		out.newLine();
	}

	public void rendu(int largeur, int hauteur) throws Exception {
		float taille_x = dx / ((float) largeur);
		float taille_y = dy / ((float) hauteur);

		BufferedWriter out = new BufferedWriter(new FileWriter(image));

		writeLine(out, "P3");
		writeLine(out, "" + largeur + " " + hauteur);
		writeLine(out, "255");
		writeLine(out, "");
		// Lancer de rayon
		Point3D origine = new Point3D(centre_grille.x - dx / 2 + taille_x / 2
				- taille_x / taille_pixel, centre_grille.y + dy / 2 - taille_y
				/ 2 + taille_y / taille_pixel, centre_grille.z);

		for (int j = 0; j < hauteur; j++) {
			String line = "";
			for (int i = 0; i < largeur; i++) {
				ArrayList<Couleur> tabCoul = new ArrayList<Couleur>();
				for (float k = 0; k < taille_pixel; k++) {
					Vecteur monRayon = new Vecteur(
							origine.x + (i) * taille_x + k
									* (taille_x / taille_pixel) - observateur.x,
							origine.y - (j) * taille_y - k
									* (taille_x / taille_pixel) - observateur.y,
							origine.z - observateur.z);

					tabCoul.add(lancerRayon(observateur, monRayon, p));
				}
				Couleur coul = new Couleur(tabCoul);

				line += coul.toString();
			}

			writeLine(out, line);
		}
		out.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Scene [image=" + image + ", p=" + p + ", dx=" + dx + ", dy="
				+ dy + ", observateur=" + observateur + ", centre_grille="
				+ centre_grille + ", intensite_a_r=" + intensite_a_r
				+ ", intensite_a_g=" + intensite_a_g + ", intensite_a_b="
				+ intensite_a_b + ", taille_pixel=" + taille_pixel + ", fond="
				+ fond + ", liste_de_lumieres=" + liste_de_lumieres
				+ ", liste_de_spheres=" + liste_de_spheres + "]";
	}
}
