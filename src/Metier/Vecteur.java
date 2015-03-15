package Metier;

public class Vecteur extends Point3D {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Vecteur() {
		// TODO Auto-generated constructor stub
	}

	public Vecteur(Float x, Float y, Float z) {
		super(x, y, z);
		// TODO Auto-generated constructor stub
	}
	
	public Point3D getPoint3D(Point3D observateur, Double plus_proche_t){
		Point3D inter = new Point3D();
		inter.x = (float) (observateur.x + this.x * plus_proche_t);
		inter.y = (float) (observateur.y + this.y * plus_proche_t);
		inter.z = (float) (observateur.z + this.z * plus_proche_t);
		return inter;
	}
	

	public Vecteur plus(Point3D v) {
		return (new Vecteur(x + v.x, y + v.y, z + v.z));
	}

	public Vecteur multiplication(float c) {
		return (new Vecteur(x * c, y * c, z * c));
	}

	public Vecteur getInverse() {
		// TODO Stub de la méthode généré automatiquement
		return new Vecteur(-x,-y,-z);
	}


}
