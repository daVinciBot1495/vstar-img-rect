package com.davincibot1495.vstar.img_rect.domain.values;

/**
 * A value class the represents a point in two dimensional space.
 */
public final class Point2D {
	private final double x1;
	private final double x2;

	public Point2D(double x1, double x2) {
		this.x1 = x1;
		this.x2 = x2;
	}

	public double getX1() {
		return x1;
	}

	public double getX2() {
		return x2;
	}

	@Override
	public String toString() {
		return "Point2D [x1=" + x1 + ", x2=" + x2 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x1);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(x2);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point2D other = (Point2D) obj;
		if (Double.doubleToLongBits(x1) != Double.doubleToLongBits(other.x1))
			return false;
		if (Double.doubleToLongBits(x2) != Double.doubleToLongBits(other.x2))
			return false;
		return true;
	}
}
