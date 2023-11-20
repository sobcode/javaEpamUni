package com.epam.rd.autotasks.arrays;

import java.util.Arrays;

public class LocalMaximaRemove {

    public static void main(String[] args) {
        int[] array = new int[]{18, 1, 3, 6, 7, -5};

        System.out.println(Arrays.toString(removeLocalMaxima(array)));
    }

    public static int[] removeLocalMaxima(int[] array){
        int[] semiCompletedArr = new int[array.length];
        int count = 0;

        if(array[0] <= array[1]){
            semiCompletedArr[count++] = array[0];
        }
        for(int i = 1; i < array.length - 1; i++){
            if(array[i] <= array[i - 1] || array[i] <= array[i + 1]){
                semiCompletedArr[count++] = array[i];
            }
        }
        if(array[array.length - 1] <= array[array.length - 2]){
            semiCompletedArr[count++] = array[array.length - 1];
        }

        int[] completedArr = new int[count];
        completedArr = Arrays.copyOf(semiCompletedArr, count);


        return completedArr;
    }
}
