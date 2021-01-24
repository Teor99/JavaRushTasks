package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.*;

/* 
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
        String path;
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            path = console.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        StringBuilder lines = new StringBuilder();
        try (BufferedReader file = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = file.readLine()) != null) {
                if (lines.length() != 0) lines.append(" ");
                lines.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        String[] words = lines.toString().split(" ");
        List<Integer> ignoreList = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (ignoreList.contains(i)) continue;
            for (int j = i+1; j < words.length; j++) {
                if (ignoreList.contains(j)) continue;

                if (words[i].equals(new StringBuilder(words[j]).reverse().toString())) {
                    ignoreList.add(i);
                    ignoreList.add(j);
                    Pair pair = new Pair();
                    pair.first = words[i];
                    pair.second = words[j];
                    result.add(pair);
                    break;
                }
            }
        }

        result.forEach(System.out::println);
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
