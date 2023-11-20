package com.epam.rd.autotasks;

public class CarouselRun2 extends CarouselRun{
    public CarouselRun2(int[] elements){
        super(elements);
    }

    public int next() {
        while(!isFinished()){
            if(position == elements.length){
                position = 0;
            }
            if(elements[position] > 0){
                int temp = elements[position];
                elements[position] = elements[position++] / 2;
                return temp;
            }
            position++;
        }
        return -1;
    }
}
