package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки

map.put("Алексеева", "Алена");
map.put("Колесникова", "Василиса");
map.put("Кузнецова", "Ульяна");
map.put("Медведев", "Вадим");
map.put("Николаев", "Алексей");
map.put("Осипов", "Арсений");
map.put("Панкратова", "Анна");
map.put("Полякова", "Варвара");
map.put("Попов", "Матвей");
map.put("Сергеев", "Владимир");

*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleMap();
        printPeopleMap(map);
    }

    public static Map<String, String> createPeopleMap() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<>();
        map.put("Алексеева", "Алена");
        map.put("Колесникова", "Василиса");
        map.put("Кузнецова", "Ульяна");
        map.put("Медведев", "Вадим");
        map.put("Николаев", "Алексей");
        map.put("Осипов", "Арсений");
        map.put("Панкратова", "Анна");
        map.put("Панкратова", "Анна");
        map.put("Полякова", "Варвара");
        map.put("Сергеев", "Владимир");
        return map;
    }

    public static void printPeopleMap(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
