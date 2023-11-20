package com.epam.rd.autotasks;


public class DecrementingCarousel {
    private int filledCapacity;
    private final int[] elements;
    private boolean active = false;

    public DecrementingCarousel(int capacity) {
        elements = new int[capacity];
    }

    public boolean addElement(int element){
        if(element > 0 && !active) {
            for (int i : elements) {
                if (i == 0) {
                    elements[filledCapacity++] = element;
                    return true;
                }
            }
        }
        return false;
    }

    public CarouselRun run(){
        if(!active){
            active = true;
            return new CarouselRun(elements);
        }
        return null;
    }
}
