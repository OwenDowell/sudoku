/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package sudoku.components;

public class Board {
    private Number[][] boardArray = new Number[9][9];

    public Board() {

    }

    /**
     * checkRow:
     *
     * This checks a specific row to see if there is already an
     * occurance of a specific number in a specific row
     *
     * @param row is the row to check
     * @param number is the number to check for
     *
     * @return whether or not the number was found
     */
    public boolean checkRow(int row, int number) {
        int i;
        for (i = 0; i < boardArray[row].length; i++) {
            if (boardArray[row][i].getValue() == number) return true;
        }
        return false;
    }

    /**
     * checkColumn:
     *
     * This checks a specific column to see if there is already an
     * occurance of a specific number in a specific column
     *
     * @param column is the column to check
     * @param number is the number to check for
     *
     * @return whether or not the number was found
     */
    public boolean checkColumn(int column, int number) {
        int i;
        for (i = 0; i < boardArray.length; i++) {
            if (boardArray[i][column].getValue() == number) return true;
        }
        return false;
    }

    /**
     * check3x3:
     *
     * This checks a 3x3 block to see if a specific number occurs in a
     * specific block of 9 numbers.
     *
     * The way this is denoted is at follows:
     * <br>
     * *-----------*<br>
     * |000|111|222|<br>
     * |000|111|222|<br>
     * |000|111|222|<br>
     * |-----------|<br>
     * |333|444|555|<br>
     * |333|444|555|<br>
     * |333|444|555|<br>
     * |-----------|<br>
     * |666|777|888|<br>
     * |666|777|888|<br>
     * |666|777|888|<br>
     * *-----------*<br>
     *
     * @param block is the row to check
     * @param number is the number to check for
     *
     * @return whether or not the number was found
     */
    public boolean check3x3(int block, int number) {
        int i, j, k, l;
        switch (block) {
            case 0: i = 0; j = 0; break;
            case 1: i = 0; j = 3; break;
            case 2: i = 0; j = 6; break;
            case 3: i = 3; j = 0; break;
            case 4: i = 3; j = 3; break;
            case 5: i = 3; j = 6; break;
            case 6: i = 6; j = 0; break;
            case 7: i = 6; j = 3; break;
            case 8: i = 6; j = 6; break;
            default: return false;
        }

        for (k = 0; k < 3; k++) {
            for (l = 0; l < 3; l++) {
                if (boardArray[i+k][j+l].getValue() == number) return true;
            }
        }
        return false;
    }

    /**
     * generate:
     *
     * This method generates the board, under the rules of Sudoku:
     *
     * A row can have one occurance of numbers 1-9
     * A column can have one occurance of numbers 1-9
     * Each 3x3 square can have one occurance of numbers 1-9
     */
    public void generate() {

    }

    /**
     * generate (overloaded):
     *
     * This generates a board with all numbers being set to the same
     * value, which is specified by the value parameter.
     *
     * @param value is the value to set whole board to
     */
    public void generate(int value) {
        //for initial coding purposes, generate each number to
        //hold the number 5
        int i, j;
        for (i = 0; i < boardArray.length; i++) {
            for (j = 0; j < boardArray[i].length; j++)
                boardArray[i][j] = new Number(value);
        }
    }

    public Number[][] getBoardArray() { return boardArray; }
}
