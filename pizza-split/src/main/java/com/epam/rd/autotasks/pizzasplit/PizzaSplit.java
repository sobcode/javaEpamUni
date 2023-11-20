package com.epam.rd.autotasks.pizzasplit;

import java.util.Scanner;

public class PizzaSplit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numbOfPeople = scan.nextInt();
        int numbOfPieces = scan.nextInt();

        for(int i = 1; i <= numbOfPeople; i++){
            if((numbOfPieces * i) % numbOfPeople == 0){
                System.out.println(i);
                break;
            }
        }
    }
}


