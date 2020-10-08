package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* 
Нам повторы не нужны
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

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        //напишите тут ваш код
        Map<String, Integer> firstNameMap = new HashMap<>();
        for (Map.Entry<String, String> pair : map.entrySet()) {
            String name = pair.getValue();
            if (firstNameMap.containsKey(name)) {
                Integer counter = firstNameMap.get(name);
                counter++;
                firstNameMap.put(name, counter);
            } else {
                firstNameMap.put(name, 1);
            }
        }

        for (Map.Entry<String, Integer> pair : firstNameMap.entrySet()) {
            if (pair.getValue() > 1) {
                removeItemFromMapByValue(map, pair.getKey());
            }
        }
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
/*
        Map<String, String> map = createMap();
        System.out.println(map);
        removeTheFirstNameDuplicates(map);
        System.out.println(map);
*/
    }
}
