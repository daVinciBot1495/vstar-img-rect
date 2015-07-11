package com.davincibot1495.vstar.domain.services;

import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.davincibot1495.vstar.domain.values.LineSegment2D;
import com.davincibot1495.vstar.domain.values.LineSegment2DPair;
import com.davincibot1495.vstar.domain.values.Point2D;
import com.davincibot1495.vstar.infra.services.Projective2DService;

@RunWith(MockitoJUnitRunner.class)
public class ImageRectificationTransformationServiceTest {
	@Mock
	private Projective2DService p2Service;

	private ImageRectificationTransformationService irtService;

	@Before
	public void setUp() {
		irtService = new ImageRectificationTransformationService(p2Service);
	}

	@Test
	public void getTransformToRectifiyWithinAffinity_shouldReturnProjectiveTransformationWithLineAtInfinityAsThirdRow() {
		// Mock calls to Projective2DService
		final Vector3D lineAtInfinity = new Vector3D(1.0, 2.0, 3.0);
		Mockito.when(p2Service.getIntersectionOf((Vector3D) Mockito.anyObject(), (Vector3D) Mockito.anyObject()))
				.thenReturn(null).thenReturn(null);
		Mockito.when(p2Service.getLineThrough((Vector3D) Mockito.anyObject(), (Vector3D) Mockito.anyObject()))
				.thenReturn(null).thenReturn(null).thenReturn(null).thenReturn(lineAtInfinity);
		Mockito.when(p2Service.newPointTransformation(Mockito.anyDouble(), Mockito.anyDouble(), Mockito.anyDouble(),
				Mockito.anyDouble(), Mockito.anyDouble(), Mockito.anyDouble(), Mockito.anyDouble(), Mockito.anyDouble(),
				Mockito.anyDouble())).thenReturn(null);

		// Mock input to getTransformToRectifiyWithinAffinity() call
		final Point2D point = new Point2D(0.0, 0.0);
		final LineSegment2D lineSegment = new LineSegment2D(point, point);
		final LineSegment2DPair lineSegmentPair = new LineSegment2DPair(lineSegment, lineSegment);

		// Make getTransformToRectifiyWithinAffinity() call
		irtService.getTransformToRectifiyWithinAffinity(lineSegmentPair, lineSegmentPair);

		/*
		 * Assert that the third row of the returned projective 2D
		 * transformation is the line at infinity.
		 */
		Mockito.verify(p2Service).newPointTransformation(
				1.0, 0.0, 0.0,
				0.0, 1.0, 0.0,
				lineAtInfinity.getX(), lineAtInfinity.getY(), lineAtInfinity.getZ());
	}
}
