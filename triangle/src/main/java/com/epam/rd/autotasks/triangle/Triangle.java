package com.epam.rd.autotasks.triangle;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;
class Triangle {
    private final Point a, b, c;

    public Triangle(Point a, Point b, Point c) {
        if((a.getX() == b.getX() && a.getY() == b.getY()) ||
            (a.getX() == c.getX() && a.getY() == c.getY()) ||
            (c.getX() == b.getX() && c.getY() == b.getY()) ||
            (((a.getX() - c.getX()) * (b.getY() - c.getY()) - (b.getX() - c.getX()) * (a.getY() - c.getY()))/2 == 0)){
            throw new IllegalArgumentException();
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() {
        double AB = sqrt(pow(b.getX() - a.getX(), 2) + pow(b.getY() - a.getY(), 2)),
                BC = sqrt(pow(c.getX() - b.getX(), 2) + pow(c.getY() - b.getY(), 2)),
                CA = sqrt(pow(a.getX() - c.getX(), 2) + pow(a.getY() - c.getY(), 2)),
                p = (AB + BC + CA) / 2;


        return sqrt(p * (p - AB) * (p - BC) * (p - CA));
    }

    public Point centroid(){
        double x1 = a.getX(), y1 = a.getY(),
                x2 = (b.getX() + c.getX()) / 2, y2 = (b.getY() + c.getY()) / 2,
                x3 = b.getX(), y3 = b.getY(),
                x4 = (a.getX() + c.getX()) / 2, y4 = (a.getY() + c.getY()) / 2;

        double denominator = ((x1-x2)*(y3-y4)-(y1-y2)*(x3-x4));
        double Px = ((x1*y2-y1*x2)*(x3-x4)-(x1-x2)*(x3*y4-y3*x4))/denominator;
        double Py = ((x1*y2-y1*x2)*(y3-y4)-(y1-y2)*(x3*y4-y3*x4))/denominator;

        return new Point(Px, Py);
    }

}
