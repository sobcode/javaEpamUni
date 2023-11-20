package com.epam.rd.autotasks.figures;
import static java.lang.Math.*;
class Triangle extends Figure{
    Point a, b, c;
    public Triangle(Point a, Point b, Point c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area(){
        double AB = countSide(a, b);
        double BC = countSide(b, c);
        double CA = countSide(c, a);
        double p = (AB + BC + CA) / 2;
        return sqrt(p * (p - AB) * (p - BC) * (p - CA));
    }

    public String pointsToString(){
        return "(" + a.getX() + "," + a.getY() + ")(" + b.getX() + "," + b.getY() + ")(" + c.getX() + "," + c.getY() + ")";
    }


    public Point leftmostPoint(){
        Point leftmost = a;
        if(b.getX() < leftmost.getX()){
            leftmost = b;
        }
        if(c.getX() < leftmost.getX()){
            leftmost = c;
        }
        return leftmost;
    }

    private double countSide(Point a, Point b){
        return sqrt(pow(b.getX() - a.getX(), 2) + pow(b.getY() - a.getY(), 2));
    }

}
