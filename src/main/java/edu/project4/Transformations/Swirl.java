package edu.project4.Transformations;

import edu.project4.Point;

public class Swirl implements Transformation {
    @Override
    public Point apply(Point point) {
        double r = Transformation.r(point);
        return new Point(
            point.x() * Math.sin(r * r) - point.y() * Math.cos(r * r),
            point.x() * Math.cos(r * r) + point.y() * Math.sin(r * r)
        );
    }
}
