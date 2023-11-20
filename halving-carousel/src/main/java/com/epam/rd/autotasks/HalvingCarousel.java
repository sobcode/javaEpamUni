package com.epam.rd.autotasks;

public class HalvingCarousel extends DecrementingCarousel {
    public HalvingCarousel(final int capacity) {
        super(capacity);
    }

    public CarouselRun run(){
        if(!active){
            active = true;
            return new CarouselRun2(elements);
        }
        return null;
    }

}
