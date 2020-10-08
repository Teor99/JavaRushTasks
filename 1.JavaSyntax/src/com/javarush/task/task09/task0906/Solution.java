package com.javarush.task.task09.task0906;

/* 
Логирование стек-трейса
*/

public class Solution {
    public static void main(String[] args) {
        log("In main method");
    }

    public static void log(String text) {
        //напишите тут ваш код
        StackTraceElement ste = Thread.currentThread().getStackTrace()[2];
        System.out.println(ste.getClassName() + ": " + ste.getMethodName() + ": " + text);
    }
}
