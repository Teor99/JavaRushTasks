package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        List<Character> listVowel = new ArrayList<>();
        List<Character> listConsonant = new ArrayList<>();

        for (int i = 0; i < line.length(); i++) {
            char symbol = line.charAt(i);
            if (symbol == ' ') continue;

            if (isVowel(symbol)) {
                listVowel.add(symbol);
            } else {
                listConsonant.add(symbol);
            }
        }

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < listVowel.size(); i++) {
            output.append(listVowel.get(i));
//            if (i != listVowel.size() - 1)
                output.append(' ');
        }
        System.out.println(output);

        output = new StringBuilder();
        for (int i = 0; i < listConsonant.size(); i++) {
            output.append(listConsonant.get(i));
//            if (i != listConsonant.size() - 1)
                output.append(' ');
        }
        System.out.println(output);
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char character) {
        character = Character.toLowerCase(character);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char vowel : vowels) {  // ищем среди массива гласных
            if (character == vowel) {
                return true;
            }
        }
        return false;
    }
}