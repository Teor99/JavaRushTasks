package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
Не жалею, не зову, не плачу,
Все пройдет, как с белых яблонь дым.
Увяданья золотом охваченный,
Я не буду больше молодым.
Ты теперь не так уж будешь биться,
Сердце, тронутое холодком,
И страна березового ситца
Не заманит шляться босиком.
Дух бродяжий! ты все реже, реже
Расшевеливаешь пламень уст
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = new String[10];
        int[] numbers = new int[10];

        for (int i = 0; i < 10; i++) {
            strings[i] = reader.readLine();
            numbers[i] = strings[i].length();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(numbers[i]);
        }
    }
}
