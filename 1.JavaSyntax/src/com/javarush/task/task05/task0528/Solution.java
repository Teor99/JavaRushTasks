package com.javarush.task.task05.task0528;

/* 
Вывести на экран сегодняшнюю дату
*/

import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        // http://proglang.su/java/date-and-time
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
        System.out.println(sdf.format(date));
    }
}
