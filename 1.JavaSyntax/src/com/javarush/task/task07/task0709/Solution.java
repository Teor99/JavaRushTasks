package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<>();
        int min = 0;
        for (int i = 0; i < 5; i++) {
            String tmp = reader.readLine();
            if (i == 0) {
                min = tmp.length();
            } else if (tmp.length() < min) {
                min = tmp.length();
            }
            strings.add(tmp);
        }

        for (String s : strings) {
            if (s.length() == min) {
                System.out.println(s);
            }
        }
    }
}
