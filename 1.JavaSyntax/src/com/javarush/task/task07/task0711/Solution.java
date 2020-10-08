package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удалить и вставить

Стих каждый в повести твоей
Звучит и блещет, как червонец.
Твоя чухоночка, ей-ей,
Гречанок Байрона милей,
А твой зоил прямой чухонец.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            strings.add(reader.readLine());
        }

        for (int i = 0; i < 13; i++) {
            String s = strings.remove(strings.size()-1);
            strings.add(0, s);
        }

        for (String elem :
                strings) {
            System.out.println(elem);
        }
    }
}
