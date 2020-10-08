package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Map;

/* 
Перепись населения

map.put("Болотников", "Серафим");
map.put("Щербатых", "Арсений");
map.put("Кузубов", "Анвар");
map.put("Кабинов", "Анвар");
map.put("Бабатьев", "Гордон");
map.put("Зюганов", "Марк");
map.put("Кравчук", "Назарий");
map.put("Пономарев", "Ксанф");
map.put("Ивакин", "Аскольд");
map.put("Чекудаев", "Елизар");

*/

public class Solution {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<>();
        map.put("Болотников", "Серафим");
        map.put("Щербатых", "Арсений");
        map.put("Кузубов", "Анвар");
        map.put("Кабинов", "Анвар");
        map.put("Бабатьев", "Гордон");
        map.put("Зюганов", "Марк");
        map.put("Кравчук", "Назарий");
        map.put("Пономарев", "Ксанф");
        map.put("Ивакин", "Аскольд");
        map.put("Чекудаев", "Елизар");

        return map;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        //напишите тут ваш код
        int count = 0;
        for (Map.Entry<String, String> pair : map.entrySet()) {
            if (pair.getValue().equals(name)) count++;
        }
        return count;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        //напишите тут ваш код
        int count = 0;
        for (Map.Entry<String, String> pair : map.entrySet()) {
            if (pair.getKey().equals(lastName)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
/*
        Map<String, String> map = createMap();
        System.out.println(getCountTheSameFirstName(map, "Кравчук"));
        System.out.println(getCountTheSameLastName(map, "Анвар"));
*/
    }
}
