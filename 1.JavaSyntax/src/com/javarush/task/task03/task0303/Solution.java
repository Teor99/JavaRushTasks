package com.javarush.task.task03.task0303;

/* 
Обмен валют
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        System.out.println(convertEurToUsd(10, 1.4));
        System.out.println(convertEurToUsd(12, 1.3));
    }

    public static double convertEurToUsd(int eur, double exchangeRate) {
        //напишите тут ваш код
        return eur * exchangeRate;
    }
}
