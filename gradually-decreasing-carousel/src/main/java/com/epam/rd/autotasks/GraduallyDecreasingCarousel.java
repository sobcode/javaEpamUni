package com.epam.rd.autotasks;

public class GraduallyDecreasingCarousel extends DecrementingCarousel{
    public GraduallyDecreasingCarousel(final int capacity) {
        super(capacity);
    }

    public CarouselRun run(){
        if(!active){
            active = true;
            return new CarouselRun2(elements, filledCapacity);
        }
        return null;
    }
}
