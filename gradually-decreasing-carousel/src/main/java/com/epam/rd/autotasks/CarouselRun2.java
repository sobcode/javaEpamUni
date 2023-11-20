package com.epam.rd.autotasks;

public class CarouselRun2 extends CarouselRun{
    public CarouselRun2(int[] elements, int filledCapacity){
        super(elements);
        this.filledCapacity = filledCapacity;
    }
    private int decrement = 1;
    private int filledCapacity;
    private int nextIterator = 0;


    public int next() {

        if(nextIterator == filledCapacity){
            decrement++;
            nextIterator = 0;
            filledCapacity = countExistElements();
        }

        nextIterator++;
        while(!isFinished()){
            if(position == elements.length){
                position = 0;
            }
            if(elements[position] > 0){
                int temp = elements[position];
                elements[position] = elements[position++] - decrement;
                return temp;
            }
            position++;
        }
        return -1;
    }

   private int countExistElements(){
        int counter = 0;
        for(int i : elements){
            if(i > 0){
                counter++;
            }
        }
        return counter;
   }
}
