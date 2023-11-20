package com.epam.rd.autotasks.arrays;

import java.util.Arrays;

public class SumOfPrevious {

    public static void main(String[] args) {
        int[] array = new int[]{1, -1, 0, 4, 6, 10, 15, 25};

        System.out.println(Arrays.toString(getSumCheckArray(array)));
    }

    public static boolean[] getSumCheckArray(int[] array){

        boolean[] checkArray = new boolean[array.length];
        checkArray[0] = false;
        checkArray[1] = false;

        for(int i = 2; i < checkArray.length; i++){
            if(array[i - 1] + array[i - 2] == array[i]){
                checkArray[i] = true;
            }else{
                checkArray[i] = false;
            }
        }

        return checkArray;
    }
}
