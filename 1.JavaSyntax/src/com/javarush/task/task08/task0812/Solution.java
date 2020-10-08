package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Integer value = Integer.parseInt(reader.readLine());
            list.add(value);
            if (i == 0) {
                pairs.add(new Pair(value, 1));
            } else {
                Pair lastPair = pairs.get(pairs.size() - 1);
                if (value.equals(lastPair.value)) {
                    lastPair.repeats++;
                } else {
                    pairs.add(new Pair(value, 1));
                }
            }
        }

        int maxRepeats = 0;
        for (Pair pair : pairs) {
            maxRepeats = Math.max(maxRepeats, pair.repeats);
        }

        System.out.println(maxRepeats);
    }

    public static class Pair {
        public Integer value;
        public Integer repeats;

        public Pair(Integer value, Integer repeats) {
            this.value = value;
            this.repeats = repeats;
        }
    }
}