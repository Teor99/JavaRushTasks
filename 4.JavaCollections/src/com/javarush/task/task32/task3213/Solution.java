package com.javarush.task.task32.task3213;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        String resultString = "";
        try (StringWriter stringWriter = new StringWriter()) {
            if (reader != null) {
                int symbol = 0;
                while ((symbol = reader.read()) != -1) {
                    stringWriter.write(symbol + key);
                }
            }
            resultString = stringWriter.toString();
        }

        return resultString;
    }
}
