package com.javarush.task.task27.task2701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Избавляемся от меток
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        String substring = reader.readLine();

//        String string = "абраабраабракадабра";
//        String substring = "абрб";

        if (isSubstringPresent(substring, string)) {
            System.out.println("String: \n" + substring + "\nis present in the string: \n" + string);
        } else {
            System.out.println("String: \n" + substring + "\nis not present in the string: \n" + string);
        }
    }

    static boolean isSubstringPresent(String substring, String string) {
        boolean found = false;
        int max = string.length() - substring.length();
        for (int i = 0; i <= max && !found; i++) {

            boolean allCharEquals = true;
            for (int j = i, k = 0; k < substring.length() && allCharEquals; j++, k++) {
                allCharEquals = string.charAt(j) == substring.charAt(k);
            }

            if (allCharEquals) {
                found = true;
            }
        }
        return found;
    }
}

