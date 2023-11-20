package com.epam.rd.autotasks.sprintplanning.tickets;
import java.util.Arrays;

public class UserStory extends Ticket {
    private final UserStory[] dependencies;

    public UserStory(int id, String name, int estimate, UserStory... dependsOn) {
        super(id, name, estimate);
        dependencies = dependsOn;
    }

    @Override
    public void complete() {
        for(UserStory i : dependencies){
            if(!i.isCompleted()){
                completed = false;
                return;
            }
        }
        completed = true;
    }

    public UserStory[] getDependencies() {

        return Arrays.copyOf(dependencies, dependencies.length);
    }

    @Override
    public String toString() {
        return "[US " + id + "] " + name;
    }

}
