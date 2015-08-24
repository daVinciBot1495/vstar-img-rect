package com.davincibot1495.vstar.img_rect.infra.services;

import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.davincibot1495.vstar.img_rect.infra.services.Projective2DService;

import static org.hamcrest.Matchers.equalTo;

public class Projective2DServiceTest {
	private Projective2DService p2Service;

	@Before
	public void setUp() {
		p2Service = new Projective2DService();
	}

	@Test
	public void getLineThrough_whenPointsAreEqualShouldReturnZeroVector() {
		final Vector3D point1 = new Vector3D(1.0, 2.0, 3.0);
		final Vector3D point2 = new Vector3D(1.0, 2.0, 3.0);
		final Vector3D actual = p2Service.getLineThrough(point1, point2);
		final Vector3D expected = new Vector3D(0.0, 0.0, 0.0);
		Assert.assertThat(actual, equalTo(expected));
	}
	
	@Test
	public void getLineThrough_whenPointsAreDifferentShouldReturnLineThroughThem() {
		final Vector3D point1 = new Vector3D(0.0, 0.0, 1.0);
		final Vector3D point2 = new Vector3D(1.0, 1.0, 1.0);
		final Vector3D actual = p2Service.getLineThrough(point1, point2);
		final Vector3D expected = new Vector3D(-1.0, 1.0, 0.0);
		Assert.assertThat(actual, equalTo(expected));
	}
	
	@Test
	public void getIntersectionOf_whenLinesAreParallelShouldReturnIdealPoint() {
		final Vector3D line1 = new Vector3D(-1.0, 1.0, 1.0);
		final Vector3D line2 = new Vector3D(-1.0, 1.0, 2.0);
		final Vector3D actual = p2Service.getIntersectionOf(line1, line2);
		final Vector3D expected = new Vector3D(1.0, 1.0, 0.0);
		Assert.assertThat(actual, equalTo(expected));
	}
	
	@Test
	public void getIntersectionOf_whenLinesAreNotParallelShouldReturnIntersection() {
		final Vector3D line1 = new Vector3D(-1.0, 0.0, 1.0);
		final Vector3D line2 = new Vector3D(0.0, -1.0, 1.0);
		final Vector3D actual = p2Service.getIntersectionOf(line1, line2);
		final Vector3D expected = new Vector3D(1.0, 1.0, 1.0);
		Assert.assertThat(actual, equalTo(expected));
	}
	
	@Test
	public void newPointTransformation_shouldProvideNewPointTransformations() {
		final double a = 1.0; final double b = 2.0; final double c = 3.0;
		final double d = 4.0; final double e = 5.0; final double f = 6.0;
		final double g = 7.0; final double h = 8.0; final double i = 9.0;
		final RealMatrix actual = p2Service.newPointTransformation(
				a, b, c,
				d, e, f,
				g, h, i);
		final RealMatrix expected = new Array2DRowRealMatrix(new double[][] {
			{a, b, c},
			{d, e, f},
			{g, h, i}
		});
		Assert.assertThat(actual, equalTo(expected));
	}
}
