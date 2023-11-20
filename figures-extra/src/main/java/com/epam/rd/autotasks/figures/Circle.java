package com.epam.rd.autotasks.figures;

import static java.lang.Math.abs;
import static java.lang.String.format;

class Circle extends Figure {
    private final Point center;
    public final double radius;
    public Circle(Point center , double radius) {
        if(center == null || radius <= 0){
            throw new IllegalArgumentException();
        }
        this.center = center;
        this.radius = radius;
    }
    public String toString(){
        return format("Circle[(%s,%s)%s]", center.getX() , center.getY() , radius );
    }
    @Override
    public Point centroid() {
        return center;
    }
    private Point getCenter(){
        return this.center;
    }

    public double area(){
        return radius * radius * Math.PI;
    }
    @Override
    public boolean isTheSame(Figure figure) {
        if( this.getClass() == figure.getClass()
                && abs(((Circle) figure).radius - radius) < THRESHOLD
                && abs(abs(figure.centroid().getX()) - abs(center.getX())) < THRESHOLD
                && abs(figure.centroid().getY() - center.getY()) < THRESHOLD) {
            return true;
        }
        return false;
    }
}
