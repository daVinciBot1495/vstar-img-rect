package com.davincibot1495.vstar.img_rect.domain.values;

/**
 * A value class that represents a line segment in two dimensional space.
 */
public final class LineSegment2D {
	private final Point2D point1;
	private final Point2D point2;

	public LineSegment2D(Point2D point1, Point2D point2) {
		this.point1 = point1;
		this.point2 = point2;
	}

	public Point2D getPoint1() {
		return point1;
	}

	public Point2D getPoint2() {
		return point2;
	}

	@Override
	public String toString() {
		return "LineSegment2D [point1=" + point1 + ", point2=" + point2 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((point1 == null) ? 0 : point1.hashCode());
		result = prime * result + ((point2 == null) ? 0 : point2.hashCode());
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
		LineSegment2D other = (LineSegment2D) obj;
		if (point1 == null) {
			if (other.point1 != null)
				return false;
		} else if (!point1.equals(other.point1))
			return false;
		if (point2 == null) {
			if (other.point2 != null)
				return false;
		} else if (!point2.equals(other.point2))
			return false;
		return true;
	}
}
