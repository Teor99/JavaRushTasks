package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код
        ArrayList<String>[] arrayOfStringList = new ArrayList[(int)(Math.random() * 4) + 2];
        for (int i = 0; i < arrayOfStringList.length; i++) {
            arrayOfStringList[i] = new ArrayList<>();
            for (int j = 0; j < (int)(Math.random() * 4) + 2; j++) {
                arrayOfStringList[i].add(Integer.valueOf((int)(Math.random() * 10)).toString());
            }
        }

        return arrayOfStringList;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String string : list) {
                System.out.println(string);
            }
        }
    }
}