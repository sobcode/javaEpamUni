package com.epam.rd.autotasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a;
        List<Integer> elements = new ArrayList<>();
        do{
            a = scanner.nextInt();
            elements.add(a);
        }while(a != 0);

        int total = 0;
        for(int i = 0; i < (elements.size() - 1); i++){
            total += elements.get(i);
        }
        System.out.println(total / (elements.size() - 1));


    }

}