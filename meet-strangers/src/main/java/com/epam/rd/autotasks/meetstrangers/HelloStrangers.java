package com.epam.rd.autotasks.meetstrangers;

import java.io.IOException;
import java.util.Scanner;

public class HelloStrangers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfStrangers = scan.nextInt();

        if(numberOfStrangers == 0){
            System.out.println("Oh, it looks like there is no one here");
        } else if(numberOfStrangers < 0){
            System.out.println("Seriously? Why so negative?");
        } else{
            String[] names = new String[numberOfStrangers];
            for (int i = 0; i < numberOfStrangers; i++){
                names[i] = scan.nextLine();
                if(names[i].isEmpty()){
                    i--;
                }
            }
            for(int i = 0; i < numberOfStrangers; i++){
                System.out.println("Hello, " + names[i]);
            }
        }
    }
}
