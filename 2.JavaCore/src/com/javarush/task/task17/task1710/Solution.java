package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
//        args = new String[]{"-c", "vasya", "м", "15/04/1990"};
//        args = new String[]{"-c", "vasya", "м", "15/041990"};
//        args = new String[]{"-u", "1", "vasya", "м", "15/04/1990"};
//        args = new String[]{"-d", "1"};
//        args = new String[]{"-i", "1"};

        if (args.length < 1) return;

        try {
            parseAndExecute(args);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

    }

    private static void parseAndExecute(String[] args) {
        if (args[0].equals("-c") && args.length == 4) {
            create(args);
        } else if (args[0].equals("-u") && args.length == 5) {
            update(args);
        } else if (args[0].equals("-d") && args.length == 2) {
            delete(args);
        } else if (args[0].equals("-i") && args.length == 2) {
            info(args);
        } else {
            System.err.println(String.format("Unknown parameter \"%s\"", args[0]));
        }
    }

    private static void create(String[] args) {
        // -c name sex bd
        // -c - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
        String name = args[1];
        Sex sex = parseSex(args[2]);
        Date date = parseDate(args[3]);

        if (sex == Sex.MALE) {
            allPeople.add(Person.createMale(name, date));
        } else {
            allPeople.add(Person.createFemale(name, date));
        }

        System.out.println(allPeople.size() - 1);
    }

    private static void update(String[] args) {
        // -u id name sex bd
        // -u - обновляет данные человека с данным id
        int id = parseId(args[1]);
        String name = args[2];
        Sex sex = parseSex(args[3]);
        Date date = parseDate(args[4]);

        allPeople.get(id).setName(name);
        allPeople.get(id).setSex(sex);
        allPeople.get(id).setBirthDate(date);
    }

    private static void delete(String[] args) {
        // -d id
        // -d - производит логическое удаление человека с id, заменяет все его данные на null
        int id = parseId(args[1]);

        allPeople.get(id).setName(null);
        allPeople.get(id).setSex(null);
        allPeople.get(id).setBirthDate(null);
    }

    private static void info(String[] args) {
        // -i id
        // -i - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)
        int id = parseId(args[1]);
        Person person = allPeople.get(id);

        String sexString = null;
        if (person.getSex() == Sex.MALE) sexString = "м";
        else if (person.getSex() == Sex.FEMALE) sexString = "ж";

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        String dateString = dateFormat.format(person.getBirthDate());

        System.out.printf("%s %s %s%n", person.getName(), sexString, dateString);
    }

    private static int parseId(String idString) throws IllegalArgumentException {
        int id;
        try {
            id = Integer.parseInt(idString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("Can't parse id \"%s\"", idString));
        }

        if (id >= 0 && id < allPeople.size()) {
            return id;
        } else {
            throw new IllegalArgumentException(String.format("Can't find id \"%s\"", idString));
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