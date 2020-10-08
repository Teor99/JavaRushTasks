package com.javarush.task.task08.task0802;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* 
Map из 10 пар

^([а-я]+)\s-\s([а-я]+)[,.]
map.put("$1", "$2");

арбуз - ягода,
банан - трава,
вишня - ягода,
груша - фрукт,
дыня - овощ,
ежевика - куст,
жень-шень - корень,
земляника - ягода,
ирис - цветок,
картофель - клубень.

*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Map<String,String> map = new HashMap<>();
        map.put("арбуз", "ягода");
        map.put("банан", "трава");
        map.put("вишня", "ягода");
        map.put("груша", "фрукт");
        map.put("дыня", "овощ");
        map.put("ежевика", "куст");
        map.put("жень-шень", "корень");
        map.put("земляника", "ягода");
        map.put("ирис", "цветок");
        map.put("картофель", "клубень");

        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
