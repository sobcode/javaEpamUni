package com.epam.rd.autotasks.intersection;

public class Line {
    private final int k, b;
    public Line(int k, int b) {
        this.k = k;
        this.b = b;
    }

    public Point intersection(Line l2) {
        int x1 = 0, x2 = 0;
        if(k == l2.getK() || k == -l2.getK()){
            return null;
        } else{
            while(k * x1 + b != l2.k * x1 + l2.b && k * x2 + b != l2.k * x2 + l2.b){
                x1++;
                x2--;
            }
        }
        if(k * x1 + b == l2.k * x1 + l2.b){
            return new Point(x1, k * x1 + b);
        }else{
            return new Point(x2, k * x2 + b);
        }
    }

    public int getK() {
        return k;
    }

    public int getB() {
        return b;
    }
}
