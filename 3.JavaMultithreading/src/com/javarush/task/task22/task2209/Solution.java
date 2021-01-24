package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Составить цепочку слов
*/

public class Solution {
    public static void main(String[] args) {
        String path;
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            path = console.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        String[] words = null;
        try (BufferedReader file = new BufferedReader(new FileReader(path))) {
            words = file.readLine().split(" ");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            nodes.add(new Node(i, words));
        }
        nodes.forEach(Node::findChilds);

        List<String> validLines = new ArrayList<>();
        List<String> invalidLines = new ArrayList<>();

        for (Node node : nodes) {
            List<String> wordSequences = node.getAllNodeSequences();
            for (String line : wordSequences) {
                if (line.split(" ").length == words.length) {
                    validLines.add(line);
                    System.out.println(line);
                } else {
                    invalidLines.add(line);
                    System.err.println(line);
                }
            }
        }

        if (validLines.isEmpty()) return new StringBuilder();

        return new StringBuilder();
//        return new StringBuilder(validLines.get(0));
    }

    public static class Node {
        private int wordIndex;
        private String[] words;
        private Node parentNode;
        private List<Node> childNodes = new ArrayList<>();

        public Node(int wordIndex, String[] words) {
            this(null, wordIndex, words);
        }

        public Node(Node parentNode, int wordIndex, String[] words) {
            this.wordIndex = wordIndex;
            this.words = words;
            this.parentNode = parentNode;
        }

        public void findChilds() {
            List<Integer> childIndexes = getChildIndexes();
            if (childIndexes.isEmpty()) return;

            childIndexes.forEach(index -> childNodes.add(new Node(this, index, words)));
            childNodes.forEach(Node::findChilds);
        }

        private List<Integer> getChildIndexes() {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                if (i == wordIndex) continue;
                if (parentNode != null && parentNode.isBranchContain(i)) continue;

                char lastChar = words[wordIndex].charAt(words[wordIndex].length() - 1);
                char firstChar = words[i].charAt(0);
                if (Character.toString(lastChar).equalsIgnoreCase(Character.toString(firstChar))) {
                    list.add(i);
                }
            }

            return list;
        }

        private boolean isBranchContain(int index) {
            if (this.wordIndex == index) return true;
            if (this.parentNode == null) return false;

            return parentNode.isBranchContain(index);
        }

        @Override
        public String toString() {
            return words[wordIndex];
        }

        public List<String> getAllNodeSequences() {
            List<String> nodeSequences = new ArrayList<>();
            for (Node childNode : childNodes) {
                childNode.getAllNodeSequences(toString(), nodeSequences);
            }
            return nodeSequences;
        }

        private void getAllNodeSequences(String prefix, List<String> nodeSequences) {
            if (childNodes.isEmpty()) {
                nodeSequences.add(prefix + " " + toString());
                return;
            }

            for (Node childNode : childNodes) {
                childNode.getAllNodeSequences(prefix + " " + toString(), nodeSequences);
            }
        }
    }
}
