package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list20 = new ArrayList<>();
        ArrayList<Integer> listDivBy3 = new ArrayList<>();
        ArrayList<Integer> listDivBy2 = new ArrayList<>();
        ArrayList<Integer> listDivOther = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            list20.add(Integer.parseInt(reader.readLine()));
        }

        for (Integer val : list20) {
            boolean isDivBy3or2 = false;
            if (val % 3 == 0) {
                listDivBy3.add(val);
                isDivBy3or2 = true;
            }
            if (val % 2 == 0) {
                listDivBy2.add(val);
                isDivBy3or2 = true;
            }
            if (!isDivBy3or2) {
                listDivOther.add(val);
            }
        }

        printList(list20);
        printList(listDivBy3);
        printList(listDivBy2);
        printList(listDivOther);
    }

    public static void printList(ArrayList<Integer> list) {
        //напишите тут ваш код
        for (Integer val : list) {
            System.out.println(val);
        }
    }
}
