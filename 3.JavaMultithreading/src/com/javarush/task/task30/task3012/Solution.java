package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    private static final int[] arr = new int[]{1, 3, 9, 27, 81, 243, 729, 2187};

    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.createExpression(74);
        solution.createExpression(1234);
    }

    public void createExpression(int number) {
        for (int i = 0; i < 1/*arr.length*/; i++) {
            ExpressionTree expressionTree = new ExpressionTree(new ExpressionTree.Cell(i));
            expressionTree.buildTree();
            String expressionLineForNumber = expressionTree.getExpressionLineForNumber(number);
            if (expressionLineForNumber != null) {
                System.out.println(expressionLineForNumber);
                return;
            }
        }
    }

    // TODO implement expression tree
    public static class ExpressionTree {
        private final Cell rootCell;
        private Stack<Cell> cellChain = null;

        public ExpressionTree(Cell rootCell) {
            this.rootCell = rootCell;
        }

        public void buildTree() {
            rootCell.findNext();
        }

        public String getExpressionLineForNumber(int number) {
            Stack<Cell> cellChain;
            while ((cellChain = getNextCellChain()) != null) {
                List<Cell> cells = new ArrayList<>(cellChain);
//                Collections.reverse(cells);
//                log.log(Level.INFO, "TRACE - " + cells);
                System.out.println("TRACE - " + cells);

                // start from +
                int result = getCellChainResultStartSign(cells, true);
                if (result == number) {
                    return getExpressionLineForNumberFromCellChain(number, cells, true);
                }

                // start from -
                result = getCellChainResultStartSign(cells, false);
                if (result == number) {
                    return getExpressionLineForNumberFromCellChain(number, cells, false);
                }
            }

            return null;
        }

        private String getExpressionLineForNumberFromCellChain(int number, List<Cell> cells, boolean isAdditionSign) {
            StringBuilder sb = new StringBuilder();
            sb.append(number).append(" =");
            for (Cell cell : cells) {
                sb.append(" ").append(isAdditionSign ? " + " : " - ").append(arr[cell.getIndex()]);
                isAdditionSign = !isAdditionSign;
            }

            return sb.toString();
        }

        private int getCellChainResultStartSign(List<Cell> cells, boolean isAdditionSign) {
            int result = 0;

            for (Cell cell : cells) {
                result += isAdditionSign ? arr[cell.getIndex()] : -arr[cell.getIndex()];
                isAdditionSign = !isAdditionSign;
            }

            return result;
        }

        private Stack<Cell> getNextCellChain() {
            if (cellChain == null) {
                System.out.println("create new cell chain");
                // new cell chain with first child
                cellChain = new Stack<>();
                cellChain.add(rootCell);
                Cell cell;
                while ((cell = rootCell.getNextChild()) != null) {
                    cellChain.add(cell);
                }

                /*boolean hasChildCells = true;
                while (hasChildCells) {
                    Cell cell = cellChain.peek();
                    List<Cell> childCells = cell.getChildCells();

                    if (!childCells.isEmpty()) {
                        cellChain.add(childCells.get(0));
                    } else {
                        hasChildCells = false;
                    }
                }*/
            } else {
                Cell oldChildCell = cellChain.pop();
                if (cellChain.isEmpty()) {
                    System.out.println("quit from empty chain");
                    return null;
                }

                Cell nextChild = cellChain.peek().getNextChild();
                if (nextChild != null) {
                    cellChain.add(nextChild);
                    System.out.println("next child");
                } else {
                    System.out.println("last child - level up");
                    cellChain.pop();
                }
                return cellChain;
            }

            return cellChain;
        }

        public static class Cell {
            private final int index;
            private int childIndex = 0;
            private final List<Cell> childCells = new ArrayList<>();

            public Cell(int index) {
                this.index = index;
            }

            public void findNext() {
                for (int i = index + 1; i < arr.length; i++) {
                    Cell cell = new Cell(i);
                    cell.findNext();
                    childCells.add(cell);
                }
            }

            public Cell getNextChild() {
                if (childCells.isEmpty() || childIndex >= childCells.size()) return null;

                return childCells.get(childIndex++);
            }

            public int getIndex() {
                return index;
            }

            public List<Cell> getChildCells() {
                return childCells;
            }

            @Override
            public String toString() {
                return String.valueOf(arr[index]);
            }
        }
    }
}