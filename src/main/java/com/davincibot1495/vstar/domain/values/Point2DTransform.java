package com.davincibot1495.vstar.domain.values;

/**
 * An interface that represents a transformation for points in two dimensional
 * space.
 */
public interface Point2DTransform {
	/**
	 * Applies the transformation to the provided two dimensional point and
	 * returns a new two dimensional point.
	 * 
	 * @param point2D
	 *            A two dimensional point.
	 * @return A new two dimensional point.
	 */
	public Point2D apply(final Point2D point2D);
}
