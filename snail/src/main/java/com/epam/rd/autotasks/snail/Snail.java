package com.epam.rd.autotasks.snail;

import java.util.Scanner;

public class Snail
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        int b = scan.nextInt();
        int h = scan.nextInt();

        if(h <= a){
            System.out.println("1");
        }else if(b >= a){
            System.out.println("Impossible");
        } else{
            System.out.println((h - a) / (a - b) + 1);
        }


    }
}
