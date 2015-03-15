package Metier;

import java.io.Serializable;

public class Lumiere implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public Lumiere() {
		// TODO Auto-generated constructor stub
	}
	public Point3D position;
	public Float intensite_r,intensite_g,intensite_b;
	public Lumiere(Point3D position, Float intensite_r, Float intensite_g,
			Float intensite_b) {
		super();
		this.position = position;
		this.intensite_r = intensite_r;
		this.intensite_g = intensite_g;
		this.intensite_b = intensite_b;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Lumiere [position=" + position + "]";
	}
	
}
