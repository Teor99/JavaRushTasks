package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {

//        args = new String[]{"-c", "vasya", "м", "15/04/1990", "oleg", "м", "18/03/1980"};
//        args = new String[]{"-u", "0", "vasya", "м", "15/04/1990", "1", "oleg", "м", "18/03/1980"};
//        args = new String[]{"-d", "0", "1", "2"};
//        args = new String[]{"-i", "0", "1", "2"};
//        args = new String[]{"-s", "0", "1", "2"};

        //start here - начни тут
        if (args.length < 1) return;

        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    parseCreate(args);
                }
                break;

            case "-u":
                synchronized (allPeople) {
                    parseUpdate(args);
                }
                break;

            case "-d":
                synchronized (allPeople) {
                    parseDelete(args);
                }
                break;

            case "-i":
                synchronized (allPeople) {
                    parseInfo(args);
                }
                break;

/*
            default:
                System.err.println("Неизвестный параметр: \"" + args[0] + "\"");
                break;
*/
        }
    }

    private static void parseInfo(String[] args) {
        for (int index = 1; index < args.length; index++) {
            info(args[index]);
        }
    }

    private static void info(String idString) {
        try {
            int id = parseId(idString);
            if (id < 0 || id >= allPeople.size()) {
                System.err.printf("Can't find id \"%s\"", idString);
                return;
            }

            Person person = allPeople.get(id);
            String sexString = null;
            if (person.getSex() == Sex.MALE) sexString = "м";
            else if (person.getSex() == Sex.FEMALE) sexString = "ж";

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            String dateString = dateFormat.format(person.getBirthDate());

            System.out.printf("%s %s %s\n", person.getName(), sexString, dateString);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void parseDelete(String[] args) {
        for (int index = 1; index < args.length; index++) {
            delete(args[index]);
        }
    }

    private static void delete(String idString) {
        try {
            int id = parseId(idString);
            if (id < 0 || id >= allPeople.size()) {
                System.err.printf("Can't find id \"%s\"", idString);
                return;
            }

            Person person = allPeople.get(id);
            person.setName(null);
            person.setSex(null);
            person.setBirthDate(null);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void parseUpdate(String[] args) {
        final int COUNT_OF_PARAMS_UPDATE = 4;
        if ((args.length - 1) % COUNT_OF_PARAMS_UPDATE != 0) {
            System.err.printf("Неверное количество параметров при вызове комманды \"%s\"", args[0]);
            return;
        }

        for (int index = 1; index < args.length; index += COUNT_OF_PARAMS_UPDATE) {
            update(args[index], args[index + 1], args[index + 2], args[index + 3]);
        }
    }

    private static void update(String idString, String name, String sexString, String dateString) {
        try {
            int id = parseId(idString);
            if (id < 0 || id >= allPeople.size()) {
                System.err.printf("Can't find id \"%s\"", idString);
                return;
            }

            Sex sex = parseSex(sexString);
            Date date = parseDate(dateString);

            Person person = allPeople.get(id);
            person.setName(name);
            person.setSex(sex);
            person.setBirthDate(date);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void parseCreate(String[] args) {
        final int COUNT_OF_PARAMS_CREATE = 3;

        if ((args.length - 1) % COUNT_OF_PARAMS_CREATE != 0) {
            System.err.printf("Неверное количество параметров при вызове комманды \"%s\"", args[0]);
            return;
        }

        for (int index = 1; index < args.length; index += COUNT_OF_PARAMS_CREATE) {
            create(args[index], args[index + 1], args[index + 2]);
        }
    }

    private static void create(String name, String sexString, String dateString) {
        try {
            Sex sex = parseSex(sexString);
            Date date = parseDate(dateString);

            if (sex == Sex.MALE) {
                allPeople.add(Person.createMale(name, date));
            } else {
                allPeople.add(Person.createFemale(name, date));
            }

            System.out.println(allPeople.size() - 1);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }



    private static int parseId(String idString) throws IllegalArgumentException {
        int id;
        try {
            id = Integer.parseInt(idString);
            return id;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("Can't parse id \"%s\"", idString));
        }
    }

    private static Date parseDate(String dateString) throws IllegalArgumentException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            throw new IllegalArgumentException(String.format("Can't parse date \"%s\"", dateString));
        }
    }

    private static Sex parseSex(String sex) throws IllegalArgumentException {
        if (sex.equals("м")) {
            return Sex.MALE;
        } else if (sex.equals("ж")) {
            return Sex.FEMALE;
        }

        throw new IllegalArgumentException(String.format("Unknown sex: \"%s\"", sex));
    }
}
