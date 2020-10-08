package com.javarush.task.task08.task0830;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Задача по алгоритмам Ӏ Java Syntax: 8 уровень, 11 лекция

РАСКРАСЧИК
АРХИВ
АВТОПОКРЫШКА
ОРИГИНАЛЬНИЧАТЬ
КОЛОНИЗАТОРСКИЙ
БРОНЕБОЙНЫЙ
ГРЕЧИШНЫЙ
ФОТОАЛЬБОМ
УТЕРЯТЬСЯ
ФОРТЕПЬЯНИСТ
ШИРМА
ЗАКОВАТЬ
БЕСПЛОДНОСТЬ
ТРЕСНУТЬ
КВАРТАЛЬНЫЙ
БЕНЗОФИЛЬТР
ДЕВАЛЬВИРОВАТЬ
ЖАЖДАТЬ
ТЕНЗОМЕТР
САХАРОМИЦЕТ

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = new String[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = reader.readLine();
        }

        sort(array);

        for (String word : array) {
            System.out.println(word);
        }
    }

    public static void sort(String[] array) {
        //напишите тут ваш код
        for (int endIndex = array.length - 1; endIndex >= 0; endIndex--) {
            for (int i = 0; i < endIndex; i++) {
                if (isGreaterThan(array[i], array[i+1])) {
                    String tmp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = tmp;
                }
            }
        }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }
}
