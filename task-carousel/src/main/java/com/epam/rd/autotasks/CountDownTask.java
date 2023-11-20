package com.epam.rd.autotasks;

public class CountDownTask implements Task{
    private int value;
    private boolean finished = false;

    public CountDownTask(int value) {
        if(value < 0){
            this.value = 0;
        }else{
            this.value = value;
        }
        if(this.value == 0){
            finished = true;
        }
    }

    public int getValue() {
        return value;
    }


    @Override
    public void execute() {
        if(value == 0){
            finished = true;
        }else{
            value--;
            if(value == 0){
                finished = true;
            }
        }
    }

    @Override
    public boolean isFinished() {
        return finished;
    }
}
