package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Задача по алгоритмам Ӏ Java Syntax: 9 уровень, 11 лекция
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) {
                break;
            }
            list.add(s);
        }

        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        // напишите тут ваш код
        // раскидываем на 2 листа
        List<Integer> listNumbers = new ArrayList<>();
        List<String> listWords = new ArrayList<>();
        for (String line : array) {
            if (isNumber(line)) {
                listNumbers.add(Integer.parseInt(line));
            } else {
                listWords.add(line);
            }
        }

        // Numbers
        // сортировка в возрастающем порядке
        if (listNumbers.size() > 1) {
            for (int i = listNumbers.size() - 1; i >= 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (listNumbers.get(j) > listNumbers.get(j + 1)) {
                        Integer tmp = listNumbers.get(j);
                        listNumbers.set(j, listNumbers.get(j + 1));
                        listNumbers.set(j + 1, tmp);
                    }
                }
            }
        }

        // Words
        // сортировка в возрастающем порядке
        if (listWords.size() > 1) {
            for (int i = listWords.size() - 1; i >= 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (isGreaterThan(listWords.get(j), listWords.get(j + 1))) {
                        String tmp = listWords.get(j);
                        listWords.set(j, listWords.get(j + 1));
                        listWords.set(j + 1, tmp);
                    }
                }
            }
        }

        // копирование в выходной массив
        // вывод слов должен быть по алфавиту
        // чисел в убывающем порядке
        int indexListNumbers = listNumbers.size() - 1;
        int indexListWords = 0;
        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) {
                array[i] = listNumbers.get(indexListNumbers--).toString();
            } else {
                array[i] = listWords.get(indexListWords++);
            }
        }
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String text) {
        if (text.length() == 0) {
            return false;
        }

        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char character = chars[i];

            // есть '-' внутри строки
            if (i != 0 && character == '-') {
                return false;
            }

            // не цифра и не начинается с '-'
            if (!Character.isDigit(character) && character != '-') {
                return false;
            }

            // одиночный '-'
            if (chars.length == 1 && character == '-') {
                return false;
            }
        }

        return true;
    }
}
