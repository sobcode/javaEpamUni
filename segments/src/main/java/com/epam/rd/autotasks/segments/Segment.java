package com.epam.rd.autotasks.segments;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {
    private final Point start, end;

    public Segment(Point start, Point end) {
        if(start.getX() == end.getX() && start.getY() == end.getY()){
            throw new IllegalArgumentException();
        }
        this.start = start;
        this.end = end;
    }

    double length() {
        double x1 = start.getX(),
                y1 = start.getY(),
                x2 = end.getX(),
                y2 = end.getY();

        return sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));
    }

    Point middle() {
        return new Point((end.getX() + start.getX()) / 2,  (end.getY() + start.getY()) / 2);
    }

    Point intersection(Segment another) {
        double x1 = start.getX();
        double x2 = end.getX();
        double x3 = another.start.getX();
        double x4 = another.end.getX();
        double y1 = start.getY();
        double y2 = end.getY();
        double y3 = another.start.getY();
        double y4 = another.end.getY();
        double u = ((x1 - x3) * (y1 - y2) - (y1 - y3) * (x1 - x2)) / ((x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4));
        double t = ((x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4)) / ((x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4));
        double den = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
        if (
                ((x1 > x4 && x4 > x2) && (x1 > x3 && x3 > x2)) || ((y4 - y3) / (x4 - x3) == (y2 - y1) / (x2 - x1)) || t > 1 || t < 0 || u > 1 || u < 0
                        || den == 0) {
            return null;
        } else {

            double x = ((x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3 * x4)) / ((x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4));
            double y = ((x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3 * x4)) / ((x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4));
            x = x1 + t * (x2 - x1);
            y = y1 + t * (y2 - y1);
            return new Point(x, y);
        }
    }
}
