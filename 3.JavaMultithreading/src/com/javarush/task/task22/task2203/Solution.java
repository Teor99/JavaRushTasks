package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/

public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) throw new TooShortStringException();

        int firstIndex = string.indexOf('\t');
        int secondIndex = string.indexOf('\t', firstIndex + 1);
        if (firstIndex == -1 || secondIndex == -1) {
            throw new TooShortStringException();
        }
        return string.substring(firstIndex + 1, secondIndex);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
