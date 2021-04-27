package com.javarush.task.task25.task2512;

import java.util.LinkedList;
import java.util.List;

/* 
Живем своим умом
*/

public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
//        Thread.currentThread().interrupt();
        t.interrupt();
        printThrowable(e);
    }

    private void printThrowable(Throwable e) {
        if (e == null) return;
        Throwable cause = e.getCause();
        if (cause != null) {
            printThrowable(cause);
        }
        System.out.println(e);
    }

    public static void main(String[] args) {

/*
        try {
            throw new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
        } catch (Throwable e) {
            printThrowable(e);
        }
*/
    }
}
