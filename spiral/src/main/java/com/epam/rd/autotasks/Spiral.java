package com.epam.rd.autotasks;

class Spiral {
    static int[][] spiral(int rows, int columns) {
        int[][] arr = new int[rows][columns];
        int sr = 0;
        int sc = 0;
        int number = 1;
        int i;

        while(sr < rows && sc < columns){
            for(i = sc; i < columns; i++){
                arr[sr][i] = number++;
            }
            sr++;

            for(i = sr; i < rows; i++){
                arr[i][columns - 1] = number++;
            }
            columns--;

            if(sr < rows){
                for(i = columns - 1; i >= sc; i--){
                    arr[rows - 1][i] = number++;
                }
                rows--;
            }

            if(sc < columns){
                for(i = rows - 1; i >= sr; i--){
                    arr[i][sc] = number++;
                }
                sc++;
            }
        }

        return arr;
    }

}
