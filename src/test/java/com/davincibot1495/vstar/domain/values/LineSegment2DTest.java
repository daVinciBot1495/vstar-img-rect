package com.davincibot1495.vstar.domain.values;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class LineSegment2DTest {
	private Point2D point1;
	private Point2D point2;
	private LineSegment2D lineSegment;
	
	@Before
	public void setUp() {
		point1 = new Point2D(0, 0);
		point2 = new Point2D(1, 1);
		lineSegment = new LineSegment2D(point1, point2);
	}
	
	@Test
	public void shouldProvideFirstPoint() {
		Assert.assertThat(lineSegment.getPoint1(), equalTo(point1));
	}
	
	@Test
	public void shouldProvideSecondPoint() {
		Assert.assertThat(lineSegment.getPoint2(), equalTo(point2));
	}
	
	@Test
	public void whenTwoLineSegmentsAreEqualEqualsShouldReturnTrue() {
		final LineSegment2D otherLineSegment = new LineSegment2D(point1, point2);
		Assert.assertTrue(lineSegment.equals(otherLineSegment));
	}
	
	@Test
	public void whenTwoLineSegmentsAreNotEqualEqualsShouldReturnFalse() {
		final LineSegment2D otherLineSegment = new LineSegment2D(point2, point1);
		Assert.assertFalse(lineSegment.equals(otherLineSegment));
	}
	
	@Test
	public void whenTwoLineSegmentsAreEqualShouldHaveSameHashCode() {
		final LineSegment2D otherLineSegment = new LineSegment2D(point1, point2);
		Assert.assertThat(otherLineSegment.hashCode(), equalTo(lineSegment.hashCode()));
	}
	
	@Test
	public void whenTwoLineSegmentsAreNotEqualShouldHaveDifferentHashCodes() {
		final LineSegment2D otherLineSegment = new LineSegment2D(point2, point1);
		Assert.assertThat(otherLineSegment.hashCode(), not(equalTo(lineSegment.hashCode())));
	}
}
