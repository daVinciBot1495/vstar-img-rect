package com.davincibot1495.vstar.img_rect.domain.services;

import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import com.davincibot1495.vstar.img_rect.domain.values.LineSegment2D;
import com.davincibot1495.vstar.img_rect.domain.values.LineSegment2DPair;
import com.davincibot1495.vstar.img_rect.domain.values.Point2DTransform;
import com.davincibot1495.vstar.img_rect.domain.values.ProjectivePoint2DTransform;
import com.davincibot1495.vstar.img_rect.infra.services.Projective2DService;

/**
 * A service class that computes transformations for affine and metric
 * rectification.
 */
public class ImageRectificationTransformationService {
	private final Projective2DService p2Service;
	
	public ImageRectificationTransformationService(final Projective2DService p2Service) {
		this.p2Service = p2Service;
	}
	
	/**
	 * Returns a transformation (based on the provided pairs of parallel lines)
	 * that rectifies and image within an affinity.
	 * 
	 * @param parallelLines1
	 *            The first pair of parallel lines.
	 * @param parallelLines2
	 *            The second pair of parallel lines.
	 * @return A transformation that rectifies and image within an affinity.
	 */
	public Point2DTransform getTransformToRectifiyWithinAffinity(final LineSegment2DPair parallelLines1,
			final LineSegment2DPair parallelLines2) {
		final Vector3D intersection1 = getIntersectionOf(parallelLines1);
		final Vector3D intersection2 = getIntersectionOf(parallelLines2);
		final Vector3D lineAtInfinity = p2Service.getLineThrough(intersection1, intersection2);
		return new ProjectivePoint2DTransform(p2Service.newPointTransformation(
			1.0, 0.0, 0.0,
			0.0, 1.0, 0.0,
			lineAtInfinity.getX(), lineAtInfinity.getY(), lineAtInfinity.getZ()));
	}

	private Vector3D getIntersectionOf(final LineSegment2DPair parallelLines) {
		final Vector3D line1 = convertToHomogeneousLine(parallelLines.getLineSegment1());
		final Vector3D line2 = convertToHomogeneousLine(parallelLines.getLineSegment2());
		return p2Service.getIntersectionOf(line1, line2);
	}

	private Vector3D convertToHomogeneousLine(final LineSegment2D lineSegment) {
		final Vector3D point1 = new Vector3D(lineSegment.getPoint1().getX1(), lineSegment.getPoint1().getX2(), 1.0);
		final Vector3D point2 = new Vector3D(lineSegment.getPoint2().getX1(), lineSegment.getPoint2().getX2(), 1.0);
		return p2Service.getLineThrough(point1, point2);
	}
}
