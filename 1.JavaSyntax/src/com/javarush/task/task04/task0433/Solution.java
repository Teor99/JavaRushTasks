package com.javarush.task.task04.task0433;

/* 
Гадание на долларовый счет
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        String s = "";
        int counter = 10;
        while (counter-- > 0) {
            while (s.length() < 10) {
                s += "S";
            }
            System.out.println(s);
        }
    }
}