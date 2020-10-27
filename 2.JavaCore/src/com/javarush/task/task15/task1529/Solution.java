package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }

    static {
        //add your code here - добавьте код тут
        reset();
    }

    public static CanFly result;

    public static void reset() {
        //add your code here - добавьте код тут
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line = console.readLine();

            if (line.equals("helicopter")) {
                result = new Helicopter();
            } else if (line.equals("plane")) {
                String passCount = console.readLine();
                try {
                    result = new Plane(Integer.parseInt(passCount));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            console.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
