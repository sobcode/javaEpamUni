package com.epam.rd.autotasks.figures;
import static java.lang.Math.*;

class Circle extends Figure{
    private final Point centre;
    private final double radius;

    public Circle(Point centre, double radius){
        this.centre = centre;
        this.radius = radius;
    }

    public double area(){
        return PI * pow(radius, 2);
    }

    public String pointsToString(){
        return "(" + centre.getX() + "," + centre.getY() + ")";
    }

    public String toString(){
        return "Circle[" + pointsToString() + radius + "]";
    }

    public Point leftmostPoint(){
        return new Point(centre.getX() - radius, centre.getY());
    }
}
