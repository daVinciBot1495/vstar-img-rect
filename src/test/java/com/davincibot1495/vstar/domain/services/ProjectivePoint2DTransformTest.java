package com.davincibot1495.vstar.domain.services;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.junit.Assert;
import org.junit.Test;

import com.davincibot1495.vstar.domain.values.Point2D;
import com.davincibot1495.vstar.domain.values.Point2DTransform;

import static org.hamcrest.Matchers.equalTo;

public class ProjectivePoint2DTransformTest {
	@Test
	public void whenGivenPointShouldApplyTransformation() {
		final Point2DTransform H = new ProjectivePoint2DTransform(new Array2DRowRealMatrix(new double[][] {
			{2.0, 3.0, 2.0},
			{4.0, 5.0, 1.0},
			{2.0, 1.0, 1.0}
		}));
		final Point2D x = new Point2D(1.0, 2.0);
		final Point2D actual = H.apply(x);
		final Point2D expected = new Point2D(2.0, 3.0);
		Assert.assertThat(actual, equalTo(expected));
	}
}
