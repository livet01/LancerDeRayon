package Metier;

import java.io.Serializable;

public class Sphere implements Serializable, Objets {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public Sphere() {
		// TODO Auto-generated constructor stub
	}

	public Point3D centre;
	public Float r, transparence, refraction;
	public Integer specularite;
	public Couleur ambiante, transparente;
	public Float3 diffuse, speculaire;

	public Sphere(Point3D centre, Float r, Float transparence,
			Float refraction, Integer specularite, Couleur ambiante,
			Float3 diffuse, Float3 speculaire, Couleur transparente) {
		super();
		this.centre = centre;
		this.r = r;
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
		return "Sphere [position=" + centre + ", r=" + r + "]";
	}

	/* (non-Javadoc)
	 * @see Metier.Objets#intersection(Metier.Point3D, Metier.Vecteur, java.lang.Float)
	 */
	@Override
	public Double intersection(Point3D observateur,Vecteur rayon, Float seuil) {
		
		if(observateur == null || rayon == null || seuil == null)
			return -1.0;
		
		float oh = rayon.scalaire(centre.moins(observateur));
		if(oh<0){
			return -1.0;
		}
		else {
			float ch2 = centre.distanceCarrer(observateur) - oh*oh;
			if(ch2>r*r) {
				return -1.0;
			}
			else{
				float d2 = r*r - ch2;
				double t1 = Math.max(0, oh + Math.sqrt(d2));
				double t2 = Math.max(0, oh - Math.sqrt(d2));
				
				if( t1 < t2){
					if(t1<seuil && t2>seuil)
						return t2;
					else if(t1>seuil){
						return t1;
					}
					else{
						return -1.0;
					}
				}
				else {
					if(t2<seuil && t1>seuil)
						return t1;
					else if(t2>seuil){
						return t2;
					}
					else{
						return -1.0;
					}
				}
			}
		}
	}
	public Boolean appartient(Point3D p){
		return Math.pow(p.x - centre.x,2) + Math.pow(p.y - centre.y,2) + Math.pow(p.z - centre.z,2) == r*r;
	}
	@Override
	public Vecteur getNormal(Point3D inter, Vecteur rayon) {
		return inter.moins(this.centre);
	}

	/**
	 * @return le serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return le centre
	 */
	public Point3D getCentre() {
		return centre;
	}

	/**
	 * @return le r
	 */
	public Float getR() {
		return r;
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
	public Vecteur getNormal() {
		// TODO Stub de la méthode généré automatiquement
		return null;
	}

	@Override
	public Point3D getPoint() {
		// TODO Stub de la méthode généré automatiquement
		return null;
	}
	@Override
	public void setR(Float parseFloat) {
		// TODO Stub de la méthode généré automatiquement
		r = parseFloat;
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
