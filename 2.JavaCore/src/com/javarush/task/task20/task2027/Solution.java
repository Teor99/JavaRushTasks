package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/* 
Кроссворд
*/

public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");

        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> resultList = new ArrayList<>();

        for (String word : words) {
            for (int y = 0; y < crossword.length; y++) {
                for (int x = 0; x < crossword[y].length; x++) {
                    if (word.startsWith(String.valueOf((char) crossword[y][x]))) {
                        resultList.addAll(findAllWordsFromPoint(crossword, word, x, y));
                    }
                }
            }
        }

        return resultList;
    }

    private static List<Word> findAllWordsFromPoint(int[][] crossword, String word, int x, int y) {
        List<Word> resultList = new ArrayList<>();
        for (int xDirection = -1; xDirection <= 1; xDirection++) {
            for (int yDirection = -1; yDirection <= 1; yDirection++) {
                findWord(crossword, word, x, y, xDirection, yDirection).ifPresent(resultList::add);
            }
        }
        return resultList;
    }

    private static Optional<Word> findWord(int[][] crossword, String word, int startX, int startY, int xDirection, int yDirection) {
        if (xDirection == 0 && yDirection == 0) return Optional.empty();

        int x = startX;
        int y = startY;
        int charIndex = 0;

        while (charIndex < word.length()) {
            // check crossword borders
            // compare chars
            if (crosswordHasCell(crossword, x, y) && (char) crossword[y][x] == word.charAt(charIndex)) {
                if (charIndex == word.length() - 1) {
                    // last char
                    Word newWord = new Word(word);
                    newWord.setStartPoint(startX, startY);
                    newWord.setEndPoint(x, y);
                    return Optional.of(newWord);
                } else {
                    charIndex++;
                    x += xDirection;
                    y += yDirection;
                }
            } else {
                break;
            }
        }

        return Optional.empty();
    }

    private static boolean crosswordHasCell(int[][] crossword, int x, int y) {
        return (crossword.length > 0 && crossword[0].length > 0)
                && (y >= 0 && y < crossword.length && x >= 0 && x < crossword[0].length);
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
