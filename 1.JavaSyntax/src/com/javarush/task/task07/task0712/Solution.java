package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые

Уж небо осенью дышало,
Уж реже солнышко бли
Короче становился
Лесов таинственн
С печальным шумо
Тянулся к югу: приближалась
Ложился на
Гусей крикливы
Довольно скучная пора;
Стоял ноябрь уж у двора.

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<>();
        int minLength = 0, minIndex = -1, maxLength = 0, maxIndex = -1;
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            strings.add(s);
            if (i == 0) {
                // first iteration
                minLength = s.length();
                maxLength = minLength;
                minIndex = i;
                maxIndex = i;
            } else {
                // other iterations
                if (s.length() < minLength) {
                    minLength = s.length();
                    minIndex = i;
                }
                if (s.length() > maxLength) {
                    maxLength = s.length();
                    maxIndex = i;
                }
            }
        }

        if (minIndex <= maxIndex) {
            System.out.println(strings.get(minIndex));
        } else {
            System.out.println(strings.get(maxIndex));
        }
    }
}
