package com.javarush.task.task08.task0827;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) throws ParseException {
//        System.out.println(isDateOdd("jan 1 2013"));
//        System.out.println(isDateOdd("jan 31 2013"));
//        System.out.println(isDateOdd("FEBRUARY 1 2013"));
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        DateFormat sdf = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        calendar.setTime(sdf.parse(date));
        if (calendar.get(Calendar.DAY_OF_YEAR) % 2 == 1) {
            return true;
        }
        return false;
    }
}
