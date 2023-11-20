package com.epam.rd.autotasks.figures;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;

class Quadrilateral extends Figure {

    private final Point point1;
    private final Point point2;
    private final Point point3;
    private final Point point4;


    public Quadrilateral(Point point1, Point point2, Point point3, Point point4) {
        if (point1 == null || point2 == null || point3 == null || point4 == null) {
            throw new IllegalArgumentException();
        }

        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.point4 = point4;

        checkIsConvex(point1, point2, point3, point4);
        checkIsDegenerative(point1, point2, point3, point4);
        checkIsPlain(point1, point2, point3, point4);
    }

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public Point getPoint3() {
        return point3;
    }

    public Point getPoint4() {
        return point4;
    }

    private void checkIsConvex(Point point1, Point point2, Point point3, Point point4) {
        Triangle t1 = new Triangle(point1, point2, point3);
        Triangle t2 = new Triangle(point2, point3, point4);
        Triangle t3 = new Triangle(point3, point4, point1);
        Triangle t4 = new Triangle(point4, point1, point2);

        if (t1.area() > area() || t2.area() > area() || t3.area() > area() || t4.area() > area()) {
            throw new IllegalArgumentException();
        }
    }

    public double area() {
        return Math.abs((point1.getX() - point3.getX()) * (point2.getY() - point4.getY())
                - (point1.getY() - point3.getY()) * (point2.getX() - point4.getX())) / 2;
    }

    private void checkIsDegenerative(Point a, Point b, Point c, Point d) {
        double ab = sqrt(pow(b.getX() - a.getX(), 2) + pow(b.getY() - a.getY(), 2));
        double ac = sqrt(pow(c.getX() - a.getX(), 2) + pow(c.getY() - a.getY(), 2));
        double bc = sqrt(pow(c.getX() - b.getX(), 2) + pow(c.getY() - b.getY(), 2));
        double bd = sqrt(pow(d.getX() - b.getX(), 2) + pow(d.getY() - b.getY(), 2));
        double cd = sqrt(pow(c.getX() - d.getX(), 2) + pow(c.getY() - d.getY(), 2));
        double da = sqrt(pow(d.getX() - a.getX(), 2) + pow(d.getY() - a.getY(), 2));

        if (ab + bc == ac || bc + cd == bd || cd + da == ac || da + ab == bd) {
            throw new IllegalArgumentException();
        }
    }

    private void checkIsPlain(Point point1, Point point2, Point point3, Point point4) {
        if (intersection(point1, point2, point3, point4) == null) {
            throw new IllegalArgumentException();
        }
    }

    Point intersection(Point point1, Point point2, Point point3, Point point4) {
        double x1 = point1.getX();
        double y1 = point1.getY();
        double x2 = point3.getX();
        double y2 = point3.getY();

        double x3 = point2.getX();
        double y3 = point2.getY();
        double x4 = point4.getX();
        double y4 = point4.getY();

        if (x1 >= x2) {
            double a = x1;
            x1 = x2;
            x2 = a;

            double b = y1;
            y1 = y2;
            y2 = b;
        }

        if (x3 >= x4) {
            double a = x3;
            x3 = x4;
            x4 = a;

            double b = y3;
            y3 = y4;
            y4 = b;
        }

        double k1, k2;

        if (y1 == y2) {
            k1 = 0;
        } else {
            k1 = (y2 - y1) / (x2 - x1);
        }

        if (y3 == y4) {
            k2 = 0;
        } else {
            k2 = (y4 - y3) / (x4 - x3);
        }

        if (k1 == k2) {
            return null;
        }

        double b1 = y1 - k1 * x1;
        double b2 = y3 - k2 * x3;

        double x = (b2 - b1) / (k1 - k2);
        double y = k1 * x + b1;

        return new Point(x, y);
    }

    @Override
    public Point centroid() {
        Point center = intersection(point1, point2, point3, point4);

        Triangle t1 = new Triangle(point1, point3, point2);
        Triangle t2 = new Triangle(point2, point4, point3);
        Triangle t3 = new Triangle(point3, point1, point4);
        Triangle t4 = new Triangle(point4, point2, point1);

        Point centerT1 = t1.centroid();
        Point centerT2 = t2.centroid();
        Point centerT3 = t3.centroid();
        Point centerT4 = t4.centroid();

        return intersection(centerT1, centerT2, centerT3, centerT4);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (figure.getClass() != Quadrilateral.class) {
            return false;
        }

        List<Point> l1 = new ArrayList<>();
        l1.add(point1);
        l1.add(point2);
        l1.add(point3);
        l1.add(point4);

        Quadrilateral another = (Quadrilateral) figure;

        List<Point> l2 = new ArrayList<>();
        l2.add(another.getPoint1());
        l2.add(another.getPoint2());
        l2.add(another.getPoint3());
        l2.add(another.getPoint4());

        boolean isTheSame = false;

        for (Point p1 : l1) {
            for (Point p2 : l2) {
                if (abs(p1.getX() - p2.getX()) < 0.001 && abs(p1.getY() - p2.getY()) < 0.001) {
                    l2.remove(p2);
                    isTheSame = true;
                    break;
                }
                isTheSame = false;
            }
            if (!isTheSame) {
                break;
            }
        }

        return isTheSame;
    }
}
