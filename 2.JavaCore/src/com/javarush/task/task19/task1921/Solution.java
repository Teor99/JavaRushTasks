package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
//        args = new String[]{"f:\\5.txt"};

        if (args.length < 1) return;

        try (BufferedReader file = new BufferedReader(new FileReader(args[0]))) {
            String line;
            while ((line = file.readLine()) != null) {
                Pattern pattern = Pattern.compile("^\\w+\\s\\w*\\-?\\w+\\s\\w+\\s\\d+\\s\\d+\\s\\d+$", Pattern.UNICODE_CHARACTER_CLASS);
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {   // Иванов Иван Иванович 31 12 1987
                    String[] splitLine = line.split(" ");
                    int day = Integer.parseInt(splitLine[3]);
                    int month = Integer.parseInt(splitLine[4]);
                    int year = Integer.parseInt(splitLine[5]);
                    Calendar calendar = new GregorianCalendar();
                    calendar.set(year, month - 1, day);
                    Person person = new Person(splitLine[0] + " " + splitLine[1] + " " + splitLine[2], calendar.getTime());
                    PEOPLE.add(person);
                } else {
                    pattern = Pattern.compile("^\\w*\\-?\\w+\\s\\d+\\s\\d+\\s\\d+$", Pattern.UNICODE_CHARACTER_CLASS);
                    matcher = pattern.matcher(line);
                    if (matcher.find()) {   // Вася 15 5 2013
                        String[] splitLine = line.split(" ");
                        int day = Integer.parseInt(splitLine[1]);
                        int month = Integer.parseInt(splitLine[2]);
                        int year = Integer.parseInt(splitLine[3]);
                        Calendar calendar = new GregorianCalendar();
                        calendar.set(year, month - 1, day);
                        Person person = new Person(splitLine[0], calendar.getTime());
                        PEOPLE.add(person);
                    } else {
                        System.err.println("cant't parse line: \"" + line + "\"");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
