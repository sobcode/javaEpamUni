package com.epam.rd.autotasks;

public class TaskCarousel {
    private final int capacity;
    Task[] tasks;
    private int filledTasks = 0;
    private int numberOfExecution = 0;

    public TaskCarousel(int capacity) {
        this.capacity = capacity;
        tasks = new Task[capacity];
    }

    public boolean addTask(Task task) {
        if(task == null || task.isFinished() || isFull()){
            return false;
        }
        tasks[filledTasks++] = task;
        return true;
    }

    public boolean execute() {
        if(isEmpty()){
            return false;
        }
        if(numberOfExecution == filledTasks){
            numberOfExecution = 0;
        }
        tasks[numberOfExecution].execute();

        if(tasks[numberOfExecution].isFinished()){
            remove();
            filledTasks--;
            numberOfExecution--;
        }
        numberOfExecution++;
        return true;
    }

    public boolean isFull() {
        return filledTasks == capacity;
    }

    public boolean isEmpty() {
        return filledTasks == 0;
    }

    private void remove(){
        for(int i = numberOfExecution; i < filledTasks; i++){
            if(i == tasks.length - 1){
                tasks[i] = null;
            }else{
                tasks[i] = tasks[i + 1];
            }
        }
    }
}
