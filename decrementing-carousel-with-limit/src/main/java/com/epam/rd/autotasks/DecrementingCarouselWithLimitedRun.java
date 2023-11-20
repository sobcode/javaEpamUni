package com.epam.rd.autotasks;

public class DecrementingCarouselWithLimitedRun extends DecrementingCarousel{
    public DecrementingCarouselWithLimitedRun(final int capacity, final int actionLimit) {
        super(capacity);
        this.actionLimit = actionLimit;
    }
    private final int actionLimit;

    public CarouselRun run(){
        if(!active){
            active = true;
            return new CarouselRun2(elements, actionLimit);
        }
        return null;
    }
}
