package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) {
        //напиште тут ваш код
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String line = console.readLine();
                if (line.equals("exit")) {
                    break;
                }

                // try parse double
                try {
                    if (line.indexOf('.') != -1) {
                        print(Double.parseDouble(line));
                        continue;
                    }
                } catch (NumberFormatException ignored) {
                }

                // try parse int
                try {
                    int value = Integer.parseInt(line);
                    if (value > 0 && value < 128) {
                        print((short)value);
                    } else {
                        print(value);
                    }
                    continue;
                } catch (NumberFormatException ignored) {
                }

                print(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
