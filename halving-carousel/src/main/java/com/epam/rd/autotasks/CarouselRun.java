package com.epam.rd.autotasks;

public class CarouselRun {

    protected final int[] elements;
    protected int position = 0;

    public CarouselRun(int[] elements){
        this.elements = elements;
    }

    public int next() {
        while(!isFinished()){
            if(position == elements.length){
                position = 0;
            }
            if(elements[position] > 0){
                return elements[position++]--;
            }
            position++;
        }
        return -1;
    }


    public boolean isFinished() {
        for(int i : elements){
            if(i > 0){
                return false;
            }
        }
        return true;
    }
}
