package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();

        //напишите тут ваш код
        String[] words = string.split("\\s");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() > 0) {
                String firstChar = word.substring(0, 1);
                String other = word.substring(1);
                result.append(firstChar.toUpperCase());
                result.append(other);

                if (i != words.length - 1) {
                    result.append(" ");
                }
            }
        }

        System.out.println(result);
    }
}
