package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null) {
            return false;
        }
        return (telNumber.matches("^\\+(\\d[\\-\\(\\)]?){11}\\d$") ||
                telNumber.matches("^[\\(\\d]-?(\\d[\\-\\)]?){8}\\d$"))
                && telNumber.matches("^(\\+)?(\\d)*(\\(\\d{3}\\))?(\\d+-?\\d+-?)?\\d+$");
    }

    public static void main(String[] args) {

    }
}

/*
package com.javarush.task.task22.task2212;

*/
/*
Проверка номера телефона
*//*


import java.util.regex.Pattern;

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null) return false;

        // 1) если номер начинается с '+', то он содержит 12 цифр
        if (telNumber.matches("^\\+") && telNumber.replaceAll("\\D", "").length() != 12) return false;

        // 2) если номер начинается с цифры или открывающей скобки
        if (telNumber.matches("^[\\d(].*")) {
            // то он содержит 10 цифр
            if (telNumber.replaceAll("\\D", "").length() != 10) return false;
        }

        // 3) может содержать 0-2 знаков '-', которые не могут идти подряд
        if (!telNumber.replaceAll("[^-]", "").matches("-{0,2}") || telNumber.matches("--")) return false;

        // 4) может содержать 1 пару скобок '(' и ')'
        if (telNumber.matches(".*[()].*")) {
            // причем если она есть, то она расположена левее знаков '-'
            String tmp = telNumber.replaceAll("[^()-]", "");
            if (!tmp.matches("\\(\\)-{0,2}")) return false;

            // 5) скобки внутри содержат четко 3 цифры
            if (!telNumber.matches(".*\\(\\d{3}\\).*")) return false;
        }

        // 6) номер не содержит букв
        if (telNumber.matches(".*[\\p{IsAlphabetic}].*")) return false;

        // 7) номер заканчивается на цифру
        return telNumber.matches(".+\\d$");
    }

    public static void main(String[] args) {
//        System.out.println(checkTelNumber("+380501234567"));
//        System.out.println(checkTelNumber("+38(050)1234567"));
//        System.out.println(checkTelNumber("+38050123-45-67"));
//        System.out.println(checkTelNumber("050123-4567"));
//        System.out.println(checkTelNumber("+38)050(1234567"));
//        System.out.println(checkTelNumber("+38(050)1-23-45-6-7"));
//        System.out.println(checkTelNumber("050ххх4567"));
//        System.out.println(checkTelNumber("050123456"));
//        System.out.println(checkTelNumber("(0)501234567"));
    }
}
*/

