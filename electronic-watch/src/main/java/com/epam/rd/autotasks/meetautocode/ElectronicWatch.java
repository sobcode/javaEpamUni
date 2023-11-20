package com.epam.rd.autotasks.meetautocode;

import java.util.Scanner;

public class ElectronicWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();

        int withoutDays = seconds % 86400;
        int NeededHours = withoutDays / 3600;
        int withoutHours = withoutDays % 3600;
        int NeededMinutes = withoutHours / 60;
        int NeededSeconds = withoutHours % 60;

        System.out.print(NeededHours + ":");

        if(NeededMinutes / 10 == 0){
            System.out.print("0" + NeededMinutes + ":");
        }else{
            System.out.print(NeededMinutes + ":");
        }

        if(NeededSeconds / 10 == 0){
            System.out.print("0" + NeededSeconds);
        }else{
            System.out.print(NeededSeconds);
        }
    }
}
