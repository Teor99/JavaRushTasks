package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж',
                'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о',
                'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц',
                'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я');

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String line = reader.readLine();
            list.add(line.toLowerCase());
        }

        // напишите тут ваш код
        int[] arrayOfCounters = new int[alphabet.size()];
        for (String line : list) {
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                if (alphabet.contains(ch)) {
                    int index = alphabet.indexOf(ch);
                    arrayOfCounters[index]++;
                }
            }
        }
/*
            for (char character : line.toCharArray()) {
                int index = alphabet.indexOf(character);
                if (index < 0) {
                    continue;
                }
            }
*/

        for (int i = 0; i < alphabet.size(); i++) {
            System.out.println(alphabet.get(i) + " " + arrayOfCounters[i]);
        }
    }
}
