package com.javarush.task.task07.task0707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            strings.add("line " + i);
        }

        System.out.println(strings.size());

        for (String s :
                strings) {
            System.out.println(s);
        }
    }
}
