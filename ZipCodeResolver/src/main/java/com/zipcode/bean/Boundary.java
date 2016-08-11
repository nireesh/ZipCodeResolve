package com.zipcode.bean;

/**
 * @author Nireesh Thiruveedula
 * @version 1.0
 *
 */
public class Boundary {
	public int lowerIndex;
	public int upperIndex;

	/**
	 * @param start
	 * @param end
	 */
	public Boundary(int start, int end) {
		this.lowerIndex = start;
		this.upperIndex = end;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[" + lowerIndex + "," + upperIndex + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Boundary)) {
			return false;
		}
		Boundary suspect = (Boundary) obj;
		return lowerIndex == suspect.lowerIndex && upperIndex == suspect.upperIndex;
	}

}