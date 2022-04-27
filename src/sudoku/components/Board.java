/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package sudoku.components;

import java.util.Random;

public class Board {
    private Number[][] boardArray = new Number[9][9];

    public Board() {
        int i, j;
        for (i = 0; i < boardArray.length; i++) {
            for (j = 0; j < boardArray[i].length; j++) {
                boardArray[i][j] = new Number();
            }
        }

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
    private boolean checkRow(int row, int number) {
        int i;
        for (i = 0; i < boardArray[row].length; i++) {
            if (boardArray[row][i].getValue() == number) return false;
        }
        return true;
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
    private boolean checkColumn(int column, int number) {
        int i;
        for (i = 0; i < boardArray.length; i++) {
            if (boardArray[i][column].getValue() == number) return false;
        }
        return true;
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
    private boolean check3x3(int block, int number) {
        int[] coordinates = get3x3Coordinates(block);

        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                if (boardArray[coordinates[0]+k][coordinates[1]+l].getValue() == number) return false;
            }
        }
        return true;
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
        int block;
        int[] bc = new int[2];
        int row, column;
        int currentNum;
        Random rand = new Random();

        for (currentNum = 1; currentNum <=9; currentNum++) {
            for (block = 0; block < 9; block++) {
                bc = get3x3Coordinates(block);

                do {
                    row = bc[0] + rand.nextInt(3);
                    column = bc[1] + rand.nextInt(3);

                } while (!boardArray[row][column].isBlank() //NOT BLANK
                      || !checkRow(row, currentNum)         //INVALID ROW
                      && !checkColumn(column, currentNum)); //INVALID COLUMN

                boardArray[row][column].setValue(currentNum);
                //if (boardArray[i+k][j+l].isBlank()) {
                //    if (checkRow(i+k,currentNum) && checkColumn(j+l,currentNum)) {
                //        boardArray[i+k][j+l].setValue(currentNum);
                //    }
                //}
            }
        }
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

    /**
     * inputNumber:
     *
     * Inputs a number at a coordinate on the board.
     *
     * @param i selects the row
     * @param j selects the column
     * @param value sets the value of the location
     */
    public void inputNumber(int i, int j, int value) {
        if ((i < 0 || i > boardArray.length) && (j < 0 || j > boardArray[0].length)) {
            boardArray[i][j].setValue(value);
        } else return;
    }

    /**
     * get3x3Coordinates:
     *
     * This method will calculate the coordinates of a specific
     * 3x3 grid on the board and return the upper left corner.
     *
     * @param block is the block you want to select
     *
     * @return an array containing 2 ints, [0] is for i and [1]
     *         is for j. Invalid block number will return 0,0.
     */
    private int[] get3x3Coordinates(int block) {
        int i,j;
        int[] coordinates = new int[2];
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
            default: return coordinates;
        }
        coordinates[0] = i;
        coordinates[1] = j;
        return coordinates;
    }

    public Number[][] getBoardArray() { return boardArray; }
}
