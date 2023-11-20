package com.epam.rd.autotasks;

public class CompleteByRequestTask implements Task {
    private boolean finished = false;
    private boolean completeWasCalled = false;

    @Override
    public void execute() {
        finished = completeWasCalled;
    }

    @Override
    public boolean isFinished() {
        return finished;
    }

    public void complete() {
        completeWasCalled = true;
    }
}
