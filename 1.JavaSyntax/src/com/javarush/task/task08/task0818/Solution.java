package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей

map.put("Аскольд", 500);
map.put("Никон", 500);
map.put("Макар", 500);
map.put("Аким", 500);
map.put("Геннадий", 500);
map.put("Дмитрий", 500);
map.put("Артем", 500);
map.put("Савелий", 500);
map.put("Артемий", 500);
map.put("Валерий", 500);

*/

public class Solution {
    public static Map<String, Integer> createMap() {
        //напишите тут ваш код
        Map<String, Integer> map = new HashMap<>();
        map.put("Аскольд", 1500);
        map.put("Никон", 2500);
        map.put("Макар", 3500);
        map.put("Аким", 4500);
        map.put("Геннадий", 1500);
        map.put("Дмитрий", 500);
        map.put("Артем", 400);
        map.put("Савелий", 100);
        map.put("Артемий", 200);
        map.put("Валерий", 300);

        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        //напишите тут ваш код
        map.entrySet().removeIf(entry -> entry.getValue() < 500);
/*
        //напишите тут ваш код
        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            if (entry.getValue() < 500) {
                it.remove();
            }
        }
*/
    }

    public static void main(String[] args) {
/*
        Map<String, Integer> map = createMap();
//        System.out.println(map);
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }

        System.out.println();
        removeItemFromMap(map);
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
*/

    }
}