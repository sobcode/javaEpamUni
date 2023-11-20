package com.epam.rd.autotasks.sequence;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindMaxInSeq {
    public static int max() {

        Scanner scan = new Scanner(System.in);
        int a;
        List<Integer> elements = new ArrayList<Integer>();
        do{
            a = scan.nextInt();
            elements.add(a);
        }while(a != 0);

        int max = elements.get(0);
        for(int i = 0; i < (elements.size() - 1); i++){
            if(elements.get(i) > max){
                max = elements.get(i);
            }
        }

        return max;
    }

    public static void main(String[] args) {

        //System.out.println("Test your code here!\n");

        // Get a result of your code

        System.out.println(max());
    }
}
