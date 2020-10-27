package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            String url = console.readLine();
            url = url.trim();

            // отрезаем подстроку с параметрами и делим на массив строк (отдельные параметры)
            String paramsLine = url.substring(url.indexOf('?') + 1);
            String[] params = paramsLine.split("&");

            // обрабатываем каждый параметр
            StringBuffer outputParamNames = new StringBuffer();
            List<String> objValues = new ArrayList<>();
            for (String param : params) {
                if (param.indexOf('=') != -1) {
                    String[] nameAndValue = param.split("=");
                    outputParamNames.append(nameAndValue[0]);
                    outputParamNames.append(" ");
                    if (nameAndValue[0].equals("obj")) {
                        objValues.add(nameAndValue[1]);
                    }
                } else {
                    outputParamNames.append(param);
                    outputParamNames.append(" ");
                }
            }

            // вывод
            System.out.println(outputParamNames.toString().trim());

            for (String value : objValues) {
                try {
                    alert(Double.parseDouble(value));
                } catch (NumberFormatException e) {
                    alert(value);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
