package com.epam.rd.autotasks.max;

public class MaxMethod {
    public static int max(int[] values ) {
        int max = values[0];
        for(int elem : values){
            if(elem > max){
                max = elem;
            }
        }
        return max;

    }
}
