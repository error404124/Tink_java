package edu.project4.Transformations;

import edu.project4.Point;

public class Heart implements Transformation {
    @Override
    public Point apply(Point point) {
        double theta = Transformation.theta(point);
        double r = Transformation.r(point);
        return new Point(r * Math.sin(theta * r), -r * Math.cos(theta * r));
    }
}
