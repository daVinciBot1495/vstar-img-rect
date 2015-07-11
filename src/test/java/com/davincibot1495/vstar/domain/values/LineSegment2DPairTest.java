package com.davincibot1495.vstar.domain.values;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class LineSegment2DPairTest {
	private LineSegment2D lineSegment1;
	private LineSegment2D lineSegment2;
	private LineSegment2DPair lineSegmentPair;

	@Before
	public void setUp() {
		final Point2D point1 = new Point2D(0, 0);
		final Point2D point2 = new Point2D(1, 1);
		lineSegment1 = new LineSegment2D(point1, point2);
		lineSegment2 = new LineSegment2D(point2, point1);
		lineSegmentPair = new LineSegment2DPair(lineSegment1, lineSegment2);
	}

	@Test
	public void shouldProvideFirstLineSegment() {
		Assert.assertThat(lineSegmentPair.getLineSegment1(), equalTo(lineSegment1));
	}

	@Test
	public void shouldProvideSecondLineSegment() {
		Assert.assertThat(lineSegmentPair.getLineSegment1(), equalTo(lineSegment1));
	}

	@Test
	public void whenTwoLineSegmentPairsAreEqualEqualsShouldReturnTrue() {
		final LineSegment2DPair otherLineSegmentPair = new LineSegment2DPair(lineSegment1, lineSegment2);
		Assert.assertTrue(lineSegmentPair.equals(otherLineSegmentPair));
	}

	@Test
	public void whenTwoLineSegmentPairsAreNotEqualEqualsShouldReturnFalse() {
		final LineSegment2DPair otherLineSegmentPair = new LineSegment2DPair(lineSegment2, lineSegment1);
		Assert.assertFalse(lineSegmentPair.equals(otherLineSegmentPair));
	}

	@Test
	public void whenTwoLineSegmentsPairsAreEqualShouldHaveSameHashCode() {
		final LineSegment2DPair otherLineSegmentPair = new LineSegment2DPair(lineSegment1, lineSegment2);
		Assert.assertThat(otherLineSegmentPair.hashCode(), equalTo(lineSegmentPair.hashCode()));
	}

	@Test
	public void whenTwoLineSegmentsPairsAreNotEqualShouldHaveDifferentHashCodes() {
		final LineSegment2DPair otherLineSegmentPair = new LineSegment2DPair(lineSegment2, lineSegment1);
		Assert.assertThat(otherLineSegmentPair.hashCode(), not(equalTo(lineSegmentPair.hashCode())));
	}
}
