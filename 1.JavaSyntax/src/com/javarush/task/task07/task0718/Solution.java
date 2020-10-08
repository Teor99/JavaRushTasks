package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
1
11
11
111
11
1111
1111
11111
1111
11111
*/


public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<>();
        int index = -1;
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            if (i != 0 && index == -1) {
                if (s.length() < strings.get(strings.size()-1).length()) {
                    index = i;
                }
            }
            strings.add(s);
        }

        if (index != -1) {
            System.out.println(index);
        }
    }
}

