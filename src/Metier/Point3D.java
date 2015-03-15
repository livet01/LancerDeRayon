package Metier;

import java.io.Serializable;

public class Point3D extends Float3 implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Point3D() {
		this.x = this.y = this.z = 0.F;
	}

	public boolean egalité(Point3D v) {
		return (x == v.x && y == v.y && z == v.z);
	}

	public Point3D plus(Point3D v) {
		return (new Point3D(x + v.x, y + v.y, z + v.z));
	}

	public Point3D increment(Point3D v) {
		this.x += v.x;
		this.y += v.y;
		this.z += v.z;
		return this;
	}

	/**
	 * @param x
	 * @param y
	 * @param z
	 */
	public Point3D(Float x, Float y, Float z) {
		super(x, y, z);
		// TODO Stub du constructeur généré automatiquement
	}

	public Point3D decrement(Point3D v) {
		this.x -= v.x;
		this.y -= v.y;
		this.z -= v.z;
		return this;
	}

	public Vecteur moins(Point3D v) {
		return (new Vecteur(x - v.x, y - v.y, z - v.z));
	}

	public Point3D vectoriel(Point3D v) {
		return (new Point3D(x * v.y + y * v.x, y * v.z + z * v.y, z * v.x + x
				* v.z));
	}

	public Float scalaire(Point3D v) {
		return (x * v.x + y * v.y + z * v.z);
	}

	public Point3D multiplication(float c) {
		return (new Point3D(x * c, y * c, z * c));
	}

	public float distance(Point3D v) {
		float dx, dy, dz;
		dx = v.x - x;
		dy = v.y - y;
		dz = v.z - z;
		return (float) Math.sqrt(dx * dx + dy * dy + dz * dz);
	}

	public float distanceCarrer(Point3D v) {
		float dx, dy, dz;
		dx = v.x - x;
		dy = v.y - y;
		dz = v.z - z;
		return (float)(dx * dx + dy * dy + dz * dz);
	}

	public void normer() {
		float norme = (float) Math.sqrt(x * x + y * y + z * z);
		x = (float) x / (float) norme;
		y = (float) y / (float) norme;
		z = (float) z / (float) norme;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "(" + x + "," + y + "," + z + ")";
	}

}
