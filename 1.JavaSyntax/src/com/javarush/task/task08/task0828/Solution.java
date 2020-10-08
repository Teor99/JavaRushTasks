package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Номер месяца

map.put(1, "JANUARY");
map.put(1, "FEBRUARY");
map.put(1, "MARCH");
map.put(1, "APRIL");
map.put(1, "MAY");
map.put(1, "JUNE");
map.put(1, "JULY");
map.put(1, "AUGUST");
map.put(1, "SEPTEMBER");
map.put(1, "OCTOBER");
map.put(1, "NOVEMBER");
map.put(1, "DECEMBER");
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        Map<String, Integer> map = new HashMap<>();
        map.put("JANUARY", 1);
        map.put("FEBRUARY", 2);
        map.put("MARCH", 3);
        map.put("APRIL", 4);
        map.put("MAY", 5);
        map.put("JUNE", 6);
        map.put("JULY", 7);
        map.put("AUGUST", 8);
        map.put("SEPTEMBER", 9);
        map.put("OCTOBER", 10);
        map.put("NOVEMBER", 11);
        map.put("DECEMBER", 12);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String month = reader.readLine();

        if (map.containsKey(month.toUpperCase())) {
            System.out.println(month + " is the " + map.get(month.toUpperCase()) + " month");
        }
    }
}
