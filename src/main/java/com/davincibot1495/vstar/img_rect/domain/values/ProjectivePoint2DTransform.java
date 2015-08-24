package com.davincibot1495.vstar.img_rect.domain.values;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

/**
 * A value class that represents a projective transformation for points in a two
 * dimensional space.
 */
public final class ProjectivePoint2DTransform implements Point2DTransform {
	private final RealMatrix transform;

	public ProjectivePoint2DTransform(final RealMatrix transform) {
		this.transform = transform;
	}

	public Point2D apply(Point2D point2D) {
		// Convert point2D to a homogeneous point
		final RealMatrix x = new Array2DRowRealMatrix(new double[] {point2D.getX1(), point2D.getX2(), 1.0});
		
		// Apply the projective transformation to x
		final double[] xPrime = transform.multiply(x).getColumn(0);
		
		// Convert xPrime back into an in-homogeneous point
		return new Point2D(xPrime[0] / xPrime[2], xPrime[1] / xPrime[2]);
	}
}
