package com.epam.rd.autotasks.godutch;

import java.util.Scanner;

public class GoDutch {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int bill = scan.nextInt();
        int numbOfFriends = scan.nextInt();
        if(bill < 0){
            System.out.println("Bill total amount cannot be negative");
        }else if(numbOfFriends <= 0){
            System.out.println("Number of friends cannot be negative or zero");
        }else{
            System.out.println((int)(bill * 1.1 / numbOfFriends));
        }


    }
}
