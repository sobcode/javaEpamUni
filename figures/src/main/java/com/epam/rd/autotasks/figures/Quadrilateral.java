package com.epam.rd.autotasks.figures;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

class Quadrilateral extends Figure{
    Point a, b, c, d;

    public Quadrilateral(Point a, Point b, Point c, Point d){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public double area(){
        double AB = countSide(a, b);
        double BC = countSide(b, c);
        double CA = countSide(c, a);
        double p = (AB + BC + CA) / 2;
        double ABC = sqrt(p * (p - AB) * (p - BC) * (p - CA));

        double AD = countSide(a, d);
        double DC = countSide(d, c);
        p = (AD + DC + CA) / 2;
        double ACD = sqrt(p * (p - AD) * (p - DC) * (p - CA));

        return ABC + ACD;
    }

    public String pointsToString(){
        return "(" + a.getX() + "," + a.getY() + ")(" + b.getX() + "," + b.getY() + ")("
                + c.getX() + "," + c.getY() + ")(" + d.getX() + "," + d.getY() + ")";
    }

    public Point leftmostPoint(){
        Point leftmost = a;
        if(b.getX() < leftmost.getX()){
            leftmost = b;
        }
        if(c.getX() < leftmost.getX()){
            leftmost = c;
        }
        if(d.getX() < leftmost.getX()){
            leftmost = d;
        }
        return leftmost;
    }

    private double countSide(Point a, Point b){
        return sqrt(pow(b.getX() - a.getX(), 2) + pow(b.getY() - a.getY(), 2));
    }

}
