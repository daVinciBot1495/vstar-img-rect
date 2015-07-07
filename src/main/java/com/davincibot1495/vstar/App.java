package com.davincibot1495.vstar;

import com.davincibot1495.vstar.domain.values.LineSegment2D;
import com.davincibot1495.vstar.domain.values.Point2D;

public class App {
	public static void main(String[] args) {
		final Point2D point2D = new Point2D(0.123, 5.678);
		System.out.println(point2D);

		final LineSegment2D lineSegment2D = new LineSegment2D(new Point2D(0, 0), new Point2D(1.0, 1.0));
		System.out.println(lineSegment2D);
	}
}
