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
     * generate:
     *
     * This method generates the board, under the rules of Sudoku:
     *
     * A row can have one occurance of numbers 1-9
     * A column can have one occurance of numbers 1-9
     * Each 3x3 square can have one occurance of numbers 1-9
     */
    public void generate() {
        //for initial coding purposes, generate each number to
        //hold the number 5
        int i, j;
        for (i = 0; i < boardArray.length; i++) {
            for (j = 0; j < boardArray[i].length; j++)
                boardArray[i][j] = new Number(5);
        }
    }

    public Number[][] getBoardArray() { return boardArray; }
}
