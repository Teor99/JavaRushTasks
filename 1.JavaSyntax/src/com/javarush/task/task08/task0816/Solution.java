package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы

https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html#JANUARY

*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));

        //напишите тут ваш код
        map.put("Шварц", dateFormat.parse("JAN 1 2012"));
        map.put("Юлий", dateFormat.parse("FEB 1 2012"));
        map.put("Марк", dateFormat.parse("MAR 1 2012"));
        map.put("Василий", dateFormat.parse("APR 1 2012"));

        map.put("Дмитрий", dateFormat.parse("JUN 1 2012"));
        map.put("Олег", dateFormat.parse("JUL 1 2012"));
        map.put("Александр", dateFormat.parse("AUG 1 2012"));
        map.put("Павел", dateFormat.parse("SEP 1 2012"));
        map.put("Евгений", dateFormat.parse("OCT 1 2012"));
        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        //напишите тут ваш код
        map.entrySet().removeIf(pair -> pair.getValue().getMonth() == Calendar.JUNE ||
                pair.getValue().getMonth() == Calendar.JULY ||
                pair.getValue().getMonth() == Calendar.AUGUST);
    }

    public static void main(String[] args) throws ParseException {
/*
        Map<String, Date> map = createMap();
        System.out.println(map);
        removeAllSummerPeople(map);
        System.out.println(map);
*/
    }
}
