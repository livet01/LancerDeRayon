package Metier;

import java.io.Serializable;

public class Float3 implements Serializable {
	/**
	 * @param x
	 * @param y
	 * @param z
	 */
	public Float3(Float x, Float y, Float z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Float x;
	public Float y;
	public Float z;
	
	public Float3() {
		// TODO Stub du constructeur généré automatiquement
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Float3 [x=" + x + ", y=" + y + ", z=" + z + "]";
	}

}
