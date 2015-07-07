package com.davincibot1495.vstar.domain.values;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.number.IsCloseTo.closeTo;

public class Point2DTest {
	private static final double EPSILON = 0.0001;
	
	private double x1;
	private double x2;
	private Point2D point;

	@Before
	public void setUp() {
		x1 = 0.123;
		x2 = 5.678;
		point = new Point2D(x1, x2);
	}

	@Test
	public void shouldProvideFirstCoordinate() {
		Assert.assertThat(point.getX1(), closeTo(x1, EPSILON));
	}
	
	@Test
	public void shouldProvideSecondCoordinate() {
		Assert.assertThat(point.getX2(), closeTo(x2, EPSILON));
	}
	
	@Test
	public void whenTwoPointsAreEqualEqualsShouldReturnTrue() {
		final Point2D otherPoint = new Point2D(x1, x2);
		Assert.assertTrue(point.equals(otherPoint));
	}
	
	@Test
	public void whenTwoPointsAreNotEqualEqualsShouldReturnFalse() {
		final Point2D otherPoint = new Point2D(x2, x1);
		Assert.assertFalse(point.equals(otherPoint));
	}
	
	@Test
	public void whenTwoPointsAreEqualShouldHaveSameHashCode() {
		final Point2D otherPoint = new Point2D(x1, x2);
		Assert.assertThat(otherPoint.hashCode(), equalTo(point.hashCode()));
	}
	
	@Test
	public void whenTwoPointsAreNotEqualShouldHaveDifferentHashCodes() {
		final Point2D otherPoint = new Point2D(x2, x1);
		Assert.assertThat(otherPoint.hashCode(), not(equalTo(point.hashCode())));
	}
}
