package Metier;

import java.io.Serializable;

public class Plan implements Serializable, Objets {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Vecteur normal;
	public Point3D point;
	public Float transparence, refraction;
	public Integer specularite;
	public Couleur ambiante, transparente;
	public Float3 diffuse, speculaire;

	public Plan(Vecteur normal, Point3D point, Float transparence,
			Float refraction, Integer specularite, Couleur ambiante,
			Float3 diffuse, Float3 speculaire, Couleur transparente) {
		super();
		normal.normer();
		if(normal.equals(new Point3D(0.F,0.F,0.F))){
			throw new IllegalArgumentException("Erreur vecteur normal");
		} else
			this.normal = normal;
		this.point = point;
		this.transparence = transparence;
		this.refraction = refraction;
		this.specularite = specularite;
		this.ambiante = ambiante;
		this.diffuse = diffuse;
		this.speculaire = speculaire;
		this.transparente = transparente;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Plan [position=" + normal + "]";
	}
	
	@Override
	public Double intersection(Point3D observateur,Vecteur rayon, Float seuil) {
		
		if(observateur == null || rayon == null || seuil == null)
			return -1.0;
		double vd = (rayon.x*normal.x + rayon.y*normal.y + rayon.z*normal.z);
		if(vd == 0.0){
			return -1.0;
		}
		else{
			double vn = -(normal.x*observateur.x + normal.y*observateur.y + normal.z*observateur.z -(normal.x*point.x + normal.y*point.y + normal.z*point.z ));
			double t0 = vn/vd;
			if(t0 < seuil){
				return -1.0;
			}
			else {
				return t0;
			}
		}
	}

	@Override
	public Vecteur getNormal(Point3D inter, Vecteur rayon) {
		// TODO Stub de la méthode généré automatiquement
		if(normal.scalaire(rayon)<0)
			return normal;
		else
			return normal.getInverse();
	}
	/**
	 * @return le centre
	 */
	public Point3D getCentre() {
		return null;
	}



	/**
	 * @return le transparence
	 */
	public Float getTransparence() {
		return transparence;
	}

	/**
	 * @return le refraction
	 */
	public Float getRefraction() {
		return refraction;
	}

	/**
	 * @return le specularite
	 */
	public Integer getSpecularite() {
		return specularite;
	}

	/**
	 * @return le ambiante
	 */
	public Couleur getAmbiante() {
		return ambiante;
	}

	/**
	 * @return le transparente
	 */
	public Couleur getTransparente() {
		return transparente;
	}

	/**
	 * @return le diffuse
	 */
	public Float3 getDiffuse() {
		return diffuse;
	}

	/**
	 * @return le speculaire
	 */
	public Float3 getSpeculaire() {
		return speculaire;
	}

	@Override
	public Float getR() {
		// TODO Stub de la méthode généré automatiquement
		return null;
	}

	@Override
	public Vecteur getNormal() {
		// TODO Stub de la méthode généré automatiquement
		return normal;
	}

	@Override
	public Point3D getPoint() {
		// TODO Stub de la méthode généré automatiquement
		return point;
	}

	@Override
	public void setR(Float parseFloat) {
		// TODO Stub de la méthode généré automatiquement
		
	}

	@Override
	public void setSpecularite(int parseInt) {
		// TODO Stub de la méthode généré automatiquement
		specularite = parseInt;
	}

	@Override
	public void setTransparence(float parseFloat) {
		// TODO Stub de la méthode généré automatiquement
		transparence = parseFloat;
	}

	@Override
	public void setRefraction(float parseFloat) {
		// TODO Stub de la méthode généré automatiquement
		refraction = parseFloat;
	}
	
}
