package com.javarush.task.task20.task2025;

import java.util.Date;

/*
Алгоритмы-числа
*/
public class Solution {

    private static class Seto{
        private long[] array = new long[]{1};
        public void add(long numb){
            if (contains(numb))
                return;

            long[] newArray = new long[array.length+1];

            System.arraycopy(array,0,newArray,0,array.length);
            newArray[newArray.length-1] = numb;

            array = newArray;
        }
        public long[] getArray(){
            sort();
            return array;
        }
        private boolean contains(long numb){
            for(int i = 0; i < array.length; i++)
                if (array[i] == numb)
                    return true;
            return false;
        }
        private void sort(){
            for(int i = array.length-1; i > 0; i--){
                for(int j = 0; j < i; j++){
                    if(array[j] > array[j+1]) {
                        long mid = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = mid;
                    }
                }
            }
        }
    }
    private static long[][] pows = new long[10][20];

    public static long[] getNumbers(long N) {
        long[] result = null;

        for(int i = 0; i <= 9; i++){
            for(int j = 1; j <= 19; j++){
                pows[i][j] = pow(i,j);
            }
        }

        if(N < 0)
            return new long[0];

        int[] arr = new int[1];
        Seto set = new Seto();
        long numb;

        while ((numb = arrToNumber2(arr)) < N && numb >= 0){

            try {
                long armstrong = countPower(arr);

                if(armstrong >0 && isArmstrong(armstrong) && armstrong <= N ) {
                    set.add(armstrong);
                }
                increment2(arr);

            } catch (ArrayIndexOutOfBoundsException e){
                arr = new int[arr.length+1];
            }
        }

        result = set.getArray();
        return result;
    }

    private static long pow(int x, int a){
        long numb = 1;
        for(int i = 0; i < a; i++)
            numb *= x;
        return numb;
    }
    //Получение суммы степеней
    private static long countPower(int[] arr){
        long number = 0;
        for(int i = 0; i < arr.length; i++){
            number += pows[arr[i]][arr.length];
        }
        return number;
    }

    private static int[] numbToArray2(long number){
        int length = String.valueOf(number).length();
        int[] array = new int[length];
        final int J = 10;
        for ( int i = 0; i < array.length; i++) {
            array[i] = ((int) (number % J));
            number /= J;
        }
        return array;
    }

    //Определение числа Армстронга
    private static boolean isArmstrong(long numb){
        int[] array = numbToArray2(numb);
        long armstrong = countPower(array);
        return numb == armstrong;
    }

    private static long arrToNumber2(int[] arr){
        long number = 0, j = 1;
        for (int i = 0; i < arr.length; i++, j*=10){
            number += arr[i]*j;
        }
        return number;
    }

    private static int[] increment2(int[] arr){
        arr[0]++;
        boolean flag = false;
        int flagNumb = 0;
        for(int i = 0; i < arr.length ; i++){
            if(arr[i] == 10){
                arr[i+1]++;
                flag = true;
                flagNumb = i+1;
            }
        }
        if(flag) {
            for (int i = flagNumb - 1; i >= 0; i--) {
                arr[i] = arr[i + 1];
            }
        }
        return arr;
    }

    public static void main(String[] args) {

        long[] array;

        Date start = new Date();

        array = getNumbers(Long.MAX_VALUE);

        Date stop = new Date();
        System.out.println((stop.getTime() - start.getTime())/1000.0);
        long usedBytes = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("Memory: " + usedBytes/1048576);
        for (int i = 0; i < array.length; i++)
            System.out.println(array[i]);
        //System.out.println(array.length);
    }
}
