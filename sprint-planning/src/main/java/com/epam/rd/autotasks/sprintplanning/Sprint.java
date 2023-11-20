package com.epam.rd.autotasks.sprintplanning;

import com.epam.rd.autotasks.sprintplanning.tickets.Bug;
import com.epam.rd.autotasks.sprintplanning.tickets.Ticket;
import com.epam.rd.autotasks.sprintplanning.tickets.UserStory;
import java.util.Arrays;

public class Sprint {
    private int capacity, ticketsLimit;
    Ticket[] tickets;
    private int numberOfLoadedTickets = 0;

    public Sprint(int capacity, int ticketsLimit) {
        this.capacity = capacity;
        this.ticketsLimit = ticketsLimit;
        tickets = new Ticket[ticketsLimit];
    }

    public boolean addUserStory(UserStory userStory) {
        if(userStory == null || userStory.getEstimate() + getTotalEstimate() > capacity ||
        userStory.isCompleted() || ticketsLimit <= numberOfLoadedTickets || checkDependencies(userStory)){
            return false;
        }
        tickets[numberOfLoadedTickets++] = userStory;
        return true;
    }

    public boolean addBug(Bug bugReport) {
        if(bugReport == null || bugReport.getEstimate() + getTotalEstimate() > capacity ||
        bugReport.isCompleted() || ticketsLimit <= numberOfLoadedTickets){
            return false;
        }
        tickets[numberOfLoadedTickets++] = bugReport;
        return true;
    }

    public Ticket[] getTickets() {
        return Arrays.copyOf(tickets, numberOfLoadedTickets);
    }

    public int getTotalEstimate() {
        int totalEstimate = 0;
        for(Ticket i : tickets){
            if(i != null){
                totalEstimate += i.getEstimate();
            }
        }
        return totalEstimate;
    }

    private boolean checkDependencies(UserStory userStory){
        UserStory[] deps = userStory.getDependencies();
        int count = deps.length;
        for(UserStory i : deps){
            if(contains(i)){
                count--;
            }
        }
        return count != 0;
    }
    private boolean contains(UserStory temp){
        for(Ticket i : getTickets()){
            if(temp == i){
                return true;
            }
        }
        return false;
    }
}
