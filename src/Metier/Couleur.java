package Metier;

import java.io.Serializable;
import java.util.ArrayList;

public class Couleur implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public Couleur() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return  r +" " + g + " " + b + " ";
	}

	public Integer r,g,b;

	public Couleur(Integer r, Integer g, Integer b) {
		super();
		this.r = r;
		this.g = g;
		this.b = b;
	}
	public Couleur(ArrayList<Couleur> t){
		this.r = 0;
		this.g = 0;
		this.b = 0;
		for(Couleur c : t) {
			add(c);
		}
		div(t.size());
	}
	public void add(Couleur c){
		this.r += c.r;
		this.g += c.g;
		this.b += c.b;
	}
	public void div(Integer n){
		this.r /= n;
		this.g /= n;
		this.b /= n;
	}
	public Couleur fois(Float3 f){
		Couleur coul = new Couleur((int) (r * f.x),(int) (g * f.y),(int) (b * f.z));
		coul.r = (coul.r>255) ? 255 : ((coul.r<0) ? 0 : coul.r);
		coul.g = (coul.g>255) ? 255 : ((coul.g<0) ? 0 : coul.g);
		coul.b = (coul.b>255) ? 255 : ((coul.b<0) ? 0 : coul.b);
		return coul;
	}
}
