package edu.project4.Transformations;

import edu.project4.Point;

public class Spherical implements Transformation {
    @Override
    public Point apply(Point point) {
        double r = Transformation.r(point);
        return new Point(
            point.x() / (r * r),
            point.y() / (r * r)
        );
    }
}
