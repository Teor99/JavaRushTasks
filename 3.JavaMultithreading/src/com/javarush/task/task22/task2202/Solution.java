package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string == null) throw new TooShortStringException();

        int[] indexArray = new int[5];

        for (int i = 0; i < indexArray.length; i++) {
            indexArray[i] = i == 0 ? string.indexOf(' ') : string.indexOf(' ', indexArray[i - 1] + 1);
        }

        for (int i = 0; i < 4; i++) {
            if (indexArray[i] == -1) {
                throw new TooShortStringException();
            }
        }

        return indexArray[4] == -1 ? string.substring(indexArray[0] + 1) : string.substring(indexArray[0] + 1, indexArray[4]);
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
