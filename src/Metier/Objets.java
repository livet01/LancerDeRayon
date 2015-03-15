package Metier;

public interface Objets {

	public abstract Double intersection(Point3D observateur, Vecteur rayon,
			Float seuil);
	public abstract Vecteur getNormal(Point3D inter, Vecteur rayon);
	
	public abstract Couleur getAmbiante();
	public abstract Float3 getDiffuse();
	public abstract Integer getSpecularite();
	public abstract Float3 getSpeculaire();
	public abstract Float getRefraction();
	public abstract Float getTransparence();
	public abstract Point3D getCentre();
	public abstract Float getR();
	public abstract Vecteur getNormal();
	public abstract Point3D getPoint();
	public abstract void setR(Float parseFloat);
	public abstract void setSpecularite(int parseInt);
	public abstract void setTransparence(float parseFloat);
	public abstract void setRefraction(float parseFloat);
}