package com.epam.rd.autotasks.figures;

import static java.lang.Math.*;
import static java.lang.Math.max;
import static java.lang.StrictMath.pow;
import static java.lang.String.format;
class Triangle extends Figure{
    private final Point a, b, c;
    public Triangle(Point a, Point b, Point c) {
        if( a == null || b == null || c == null){
            throw new IllegalArgumentException();
        }
        double ab = length(a,b);
        double bc = length(b,c);
        double ca = length(c,a);
        double max = max( max(ab , bc) , ca);
        if( max / 2 > (ab + bc + ca - max)){
            throw new IllegalArgumentException();
        }
        if(a.equals(b) || a.equals(c) || b.equals(c)) {
            throw new IllegalArgumentException();
        }
        if(!intersection(a,b,b,c) || !intersection(b,c,c,a) || !intersection(c,a,a,b)){
            throw new IllegalArgumentException();
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private double length(Point start , Point end) {
        double x1 = start.getX();
        double x2 = end.getX();
        double y1 = start.getY();
        double y2 = end.getY();

        return sqrt((pow(abs(x1 - x2), 2) + pow(abs(y1 - y2), 2)));
    }

    public Point centroid(){
        double xc= (((a.getX()+b.getX()+c.getX())/3));
        double yc= (((a.getY()+b.getY()+c.getY())/3));
        return new Point(xc, yc);
    }
    private Boolean intersection(Point firstStart , Point firstEnd, Point secondStart , Point secondEnd) {
        double x1 = firstStart.getX();
        double x2 = firstEnd.getX();
        double y1 = firstStart.getY();
        double y2 = firstEnd.getY();
        double x3 = secondStart.getX();
        double x4 = secondEnd.getX();
        double y3 = secondStart.getY();
        double y4 = secondEnd.getY();

        double v = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
        if (v == 0) {
            return false;
        }
        double x = ((x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3 * x4)) / v;
        double y = ((x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3 * x4)) / v;

        if (x > x1 && x > x2 || x >x3 && x > x4 || x < x1 && x<x2 || x < x3 && x < x4 ||
                y > y1 && y > y2 || y >y3 && y > y4 || y < y1 && y<y2 || y < y3 && y < y4 ) {
            return false;
        }
        return true;
    }

    public boolean isTheSame(Figure figure){
        if(this.getClass() == figure.getClass() &&
                a.equals(((Triangle) figure).a) && b.equals(((Triangle) figure).b) && c.equals(((Triangle) figure).c)){
            return true;
        }
        return false;
    }

    public double area(){
        double AB = countSide(a, b);
        double BC = countSide(b, c);
        double CA = countSide(c, a);
        double p = (AB + BC + CA) / 2;
        return sqrt(p * (p - AB) * (p - BC) * (p - CA));
    }
    private double countSide(Point a, Point b){
        return sqrt(pow(b.getX() - a.getX(), 2) + pow(b.getY() - a.getY(), 2));
    }
}
