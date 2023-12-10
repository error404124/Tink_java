package edu.project4.Transformations;

import edu.project4.Point;
import java.util.function.Function;

@SuppressWarnings("MagicNumber")
public interface Transformation extends Function<Point, Point> {

    static double r(Point point) {
        return Math.pow(point.x() * point.x() + point.y() * point.y(), 0.5);
    }

    static double theta(Point point) {
        return Math.atan(point.x() / point.y());
    }

    static double phi(Point point) {
        return Math.atan(point.y() / point.x());
    }

}
