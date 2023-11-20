package com.epam.rd.autotasks.figures;

abstract class Figure{
    final double THRESHOLD = .0001;
    public abstract Point centroid();
    public abstract boolean isTheSame(Figure figure);
}
