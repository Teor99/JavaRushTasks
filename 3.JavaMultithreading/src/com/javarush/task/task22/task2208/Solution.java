package com.javarush.task.task22.task2208;

import java.util.LinkedHashMap;
import java.util.Map;

/*
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder resultString = new StringBuilder();
        for (Map.Entry<String, String> param : params.entrySet()) {
            if (param.getValue() == null) continue;
            if (resultString.length() != 0) resultString.append(" and ");

            resultString.append(param.getKey()).append(" = '").append(param.getValue()).append("'");
        }
        return resultString.toString();
    }
}
