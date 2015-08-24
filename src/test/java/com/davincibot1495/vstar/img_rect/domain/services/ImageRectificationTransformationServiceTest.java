package com.davincibot1495.vstar.img_rect.domain.services;

import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.davincibot1495.vstar.img_rect.domain.services.ImageRectificationTransformationService;
import com.davincibot1495.vstar.img_rect.domain.values.LineSegment2D;
import com.davincibot1495.vstar.img_rect.domain.values.LineSegment2DPair;
import com.davincibot1495.vstar.img_rect.domain.values.Point2D;
import com.davincibot1495.vstar.img_rect.infra.services.Projective2DService;

@RunWith(MockitoJUnitRunner.class)
public class ImageRectificationTransformationServiceTest {
	@Mock
	private Projective2DService p2Service;

	private Point2D point1;
	private Point2D point2;
	private Point2D point3;
	private Point2D point4;
	private Point2D point5;
	private Point2D point6;
	private Point2D point7;
	private Point2D point8;

	private LineSegment2D lineSegment1;
	private LineSegment2D lineSegment2;
	private LineSegment2D lineSegment3;
	private LineSegment2D lineSegment4;

	private LineSegment2DPair lineSegmentPair1;
	private LineSegment2DPair lineSegmentPair2;

	private Vector3D vector1;
	private Vector3D vector2;
	private Vector3D vector3;
	private Vector3D vector4;
	private Vector3D vector5;
	private Vector3D vector6;
	private Vector3D vector7;
	private Vector3D vector8;

	private Vector3D lineThroughPoint1Point2;
	private Vector3D lineThroughPoint3Point4;
	private Vector3D lineThroughPoint5Point6;
	private Vector3D lineThroughPoint7Point8;

	private Vector3D intersection1;
	private Vector3D intersection2;

	private Vector3D lineAtInfinity;

	private ImageRectificationTransformationService irtService;

	@Before
	public void setUp() {
		point1 = new Point2D(1.0, 1.0);
		point2 = new Point2D(2.0, 2.0);
		point3 = new Point2D(3.0, 3.0);
		point4 = new Point2D(4.0, 4.0);
		point5 = new Point2D(5.0, 5.0);
		point6 = new Point2D(6.0, 6.0);
		point7 = new Point2D(7.0, 7.0);
		point8 = new Point2D(8.0, 8.0);

		lineSegment1 = new LineSegment2D(point1, point2);
		lineSegment2 = new LineSegment2D(point3, point4);
		lineSegment3 = new LineSegment2D(point5, point6);
		lineSegment4 = new LineSegment2D(point7, point8);

		lineSegmentPair1 = new LineSegment2DPair(lineSegment1, lineSegment2);
		lineSegmentPair2 = new LineSegment2DPair(lineSegment3, lineSegment4);

		vector1 = newHomogeneousPoint(point1);
		vector2 = newHomogeneousPoint(point2);
		vector3 = newHomogeneousPoint(point3);
		vector4 = newHomogeneousPoint(point4);
		vector5 = newHomogeneousPoint(point5);
		vector6 = newHomogeneousPoint(point6);
		vector7 = newHomogeneousPoint(point7);
		vector8 = newHomogeneousPoint(point8);

		lineThroughPoint1Point2 = new Vector3D(1.0, 2.0, 0.0);
		lineThroughPoint3Point4 = new Vector3D(3.0, 4.0, 0.0);
		lineThroughPoint5Point6 = new Vector3D(5.0, 6.0, 0.0);
		lineThroughPoint7Point8 = new Vector3D(7.0, 8.0, 0.0);

		intersection1 = new Vector3D(0.0, 0.0, 1.0);
		intersection2 = new Vector3D(0.0, 0.0, 2.0);

		lineAtInfinity = new Vector3D(1.0, 2.0, 3.0);

		// Mock calls to getLineThrough()
		Mockito.when(p2Service.getLineThrough(vector1, vector2)).thenReturn(lineThroughPoint1Point2);
		Mockito.when(p2Service.getLineThrough(vector3, vector4)).thenReturn(lineThroughPoint3Point4);
		Mockito.when(p2Service.getLineThrough(vector5, vector6)).thenReturn(lineThroughPoint5Point6);
		Mockito.when(p2Service.getLineThrough(vector7, vector8)).thenReturn(lineThroughPoint7Point8);
		Mockito.when(p2Service.getLineThrough(intersection1, intersection2)).thenReturn(lineAtInfinity);

		// Mock calls to getIntersectionOf()
		Mockito.when(p2Service.getIntersectionOf(lineThroughPoint1Point2, lineThroughPoint3Point4))
				.thenReturn(intersection1);
		Mockito.when(p2Service.getIntersectionOf(lineThroughPoint5Point6, lineThroughPoint7Point8))
				.thenReturn(intersection2);

		// Mock call to newPointTransformation()
		Mockito.when(p2Service.newPointTransformation(Mockito.anyDouble(), Mockito.anyDouble(), Mockito.anyDouble(),
				Mockito.anyDouble(), Mockito.anyDouble(), Mockito.anyDouble(), Mockito.anyDouble(), Mockito.anyDouble(),
				Mockito.anyDouble())).thenReturn(null);

		irtService = new ImageRectificationTransformationService(p2Service);

		// Make the getTransformToRectifiyWithinAffinity() call
		irtService.getTransformToRectifiyWithinAffinity(lineSegmentPair1, lineSegmentPair2);
	}

	@Test
	public void getTransformToRectifiyWithinAffinity_shouldComputeLineThroughLineSegments() {
		Mockito.verify(p2Service).getLineThrough(vector1, vector2);
		Mockito.verify(p2Service).getLineThrough(vector3, vector4);
		Mockito.verify(p2Service).getLineThrough(vector5, vector6);
		Mockito.verify(p2Service).getLineThrough(vector7, vector8);
	}

	@Test
	public void getTransformToRectifiyWithinAffinity_shouldComputeIntersectionOfLineSegmentPairs() {
		Mockito.verify(p2Service).getIntersectionOf(lineThroughPoint1Point2, lineThroughPoint3Point4);
		Mockito.verify(p2Service).getIntersectionOf(lineThroughPoint5Point6, lineThroughPoint7Point8);
	}

	@Test
	public void getTransformToRectifiyWithinAffinity_shouldComputeLineAtInfinity() {
		Mockito.verify(p2Service).getLineThrough(intersection1, intersection2);
	}

	@Test
	public void getTransformToRectifiyWithinAffinity_shouldComputeTransformWithLineAtInfinityAsThirdRow() {
		Mockito.verify(p2Service).newPointTransformation(
				1.0, 0.0, 0.0,
				0.0, 1.0, 0.0,
				lineAtInfinity.getX(), lineAtInfinity.getY(), lineAtInfinity.getZ());
	}

	private static Vector3D newHomogeneousPoint(final Point2D point2D) {
		return new Vector3D(point2D.getX1(), point2D.getX2(), 1.0);
	}
}
