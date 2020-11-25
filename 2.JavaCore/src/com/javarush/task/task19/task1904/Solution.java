package com.javarush.task.task19.task1904;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {
/*
        try {
            PersonScannerAdapter personScannerAdapter = new PersonScannerAdapter(new Scanner(new FileInputStream("f:\\1.txt")));
            Person person;
            while ((person = personScannerAdapter.read()) != null) {
                System.out.println(person);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner scanner) {
            this.fileScanner = scanner;
        }

        @Override
        public Person read() throws IOException {
            if (!fileScanner.hasNext()) return null;

            String lastName = fileScanner.next();
            String firstName = fileScanner.next();
            String middleName = fileScanner.next();

            int day = fileScanner.nextInt();
            int month = fileScanner.nextInt();
            int year = fileScanner.nextInt();
            Calendar calendar = new GregorianCalendar(year, month - 1, day);


            return new Person(firstName, middleName, lastName, calendar.getTime());
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
