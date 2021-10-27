package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int lowerCaseCount, upperCaseCount, digitCount;

        do {
            lowerCaseCount = 0;
            upperCaseCount = 0;
            digitCount = 0;

            baos.reset();

            for (int i = 0; i < 8; i++) {
                char symbol = getRandomSymbol();
                digitCount += Character.isDigit(symbol) ? 1 : 0;
                lowerCaseCount += Character.isLowerCase(symbol) ? 1 : 0;
                upperCaseCount += Character.isUpperCase(symbol) ? 1 : 0;
                baos.write(symbol);
            }

        } while (digitCount == 0 || lowerCaseCount == 0 || upperCaseCount == 0);

        return baos;
    }

    private static char getRandomSymbol() {
        switch (((int) (Math.random() * 100) % 3)) {
            case 0:
                return (char) ('0' + (Math.random() * 10) % 9);
            case 1:
                return (char) ('a' + (Math.random() * 100) % 25);
            default:
                return (char) ('A' + (Math.random() * 100) % 25);
        }
    }
}