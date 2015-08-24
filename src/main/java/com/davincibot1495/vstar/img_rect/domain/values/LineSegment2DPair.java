package com.davincibot1495.vstar.img_rect.domain.values;

/**
 * A value class that represents a pair of line segments in two dimensional
 * space.
 */
public final class LineSegment2DPair {
	private final LineSegment2D lineSegment1;
	private final LineSegment2D lineSegment2;

	public LineSegment2DPair(LineSegment2D lineSegment1, LineSegment2D lineSegment2) {
		this.lineSegment1 = lineSegment1;
		this.lineSegment2 = lineSegment2;
	}

	public LineSegment2D getLineSegment1() {
		return lineSegment1;
	}

	public LineSegment2D getLineSegment2() {
		return lineSegment2;
	}

	@Override
	public String toString() {
		return "LineSegment2DPair [lineSegment1=" + lineSegment1 + ", lineSegment2=" + lineSegment2 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lineSegment1 == null) ? 0 : lineSegment1.hashCode());
		result = prime * result + ((lineSegment2 == null) ? 0 : lineSegment2.hashCode());
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
		LineSegment2DPair other = (LineSegment2DPair) obj;
		if (lineSegment1 == null) {
			if (other.lineSegment1 != null)
				return false;
		} else if (!lineSegment1.equals(other.lineSegment1))
			return false;
		if (lineSegment2 == null) {
			if (other.lineSegment2 != null)
				return false;
		} else if (!lineSegment2.equals(other.lineSegment2))
			return false;
		return true;
	}
}
