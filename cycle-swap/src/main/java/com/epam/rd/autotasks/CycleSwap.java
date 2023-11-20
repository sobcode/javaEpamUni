package com.epam.rd.autotasks;
import java.util.Arrays;

class CycleSwap {
    static void cycleSwap(int[] array) {
        int[] tempArray = Arrays.copyOf(array, array.length);

        for(int i = 0; i < array.length; i++){
            if(i == 0){
                array[i] = tempArray[array.length - 1];
            }else{
                array[i] = tempArray[i - 1];
            }
        }
    }

    static void cycleSwap(int[] array, int shift) {
        do{
            cycleSwap(array);
            shift--;
        }while(shift > 0);
    }
}
