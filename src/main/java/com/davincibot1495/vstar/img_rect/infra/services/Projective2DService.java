package com.davincibot1495.vstar.img_rect.infra.services;

import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

/**
 * A service class that performs calculations in the two dimensional projective
 * (P2) space.
 */
public class Projective2DService {
	/**
	 * Computes the line through two points in P2.
	 * 
	 * @param point1
	 *            A point in P2.
	 * @param point2
	 *            A point in P2.
	 * @return A line in P2.
	 */
	public Vector3D getLineThrough(final Vector3D point1, final Vector3D point2) {
		return point1.crossProduct(point2);
	}
	
	/**
	 * Computes the intersection of two lines in P2.
	 * 
	 * @param line1
	 *            A line in P2.
	 * @param line2
	 *            A line in P2.
	 * @return A point in P2.
	 */
	public Vector3D getIntersectionOf(final Vector3D line1, final Vector3D line2) {
		return line1.crossProduct(line2);
	}
	
	/**
	 * Creates a new matrix that transforms points in P2.
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @param e
	 * @param f
	 * @param g
	 * @param h
	 * @param i
	 * @return A new matrix that transforms points in P2
	 */
	public RealMatrix newPointTransformation(
			final double a, final double b, final double c,
			final double d, final double e, final double f,
			final double g, final double h, final double i) {
		return new Array2DRowRealMatrix(new double[][] {
			{a, b, c},
			{d, e, f},
			{g, h, i}
		});
	}
}
