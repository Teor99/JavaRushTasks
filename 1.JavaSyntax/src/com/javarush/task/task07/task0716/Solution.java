package com.javarush.task.task07.task0716;

import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        /*strings.add("роза");
        strings.add("лоза");
        strings.add("лира");*/
        strings.add("роза");
        strings.add("лира");
        strings.add("лоза");
        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> strings) {
        //напишите тут ваш код
        ArrayList<String> result = new ArrayList<>();
        for (String s : strings) {
            if (s.indexOf('р') != -1 && s.indexOf('л') != -1) {
                result.add(s);
            } else if (s.indexOf('л') != -1) {
                result.add(s);
                result.add(s);
            } else if (s.indexOf('р') == -1) {
                result.add(s);
            }
        }
        return result;
    }
}