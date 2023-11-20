package com.epam.rd.autotasks;

public class CarouselRun2 extends CarouselRun{
    public CarouselRun2(int[] elements, int actionLimit){
        super(elements);
        this.actionLimit = actionLimit;
    }
    private int actionLimit;

    public int next() {
        if(actionLimit == 0){
            return -1;
        }
        while(!isFinished()){
            if(position == elements.length){
                position = 0;
            }
            if(elements[position] > 0){
                actionLimit--;
                return elements[position++]--;
            }
            position++;
        }
        return -1;
    }

    public boolean isFinished() {
        if(actionLimit == 0){
            return true;
        }
        for(int i : elements){
            if(i > 0){
                return false;
            }
        }
        return true;
    }
}
