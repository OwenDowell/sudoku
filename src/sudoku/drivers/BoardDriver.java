/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package sudoku.drivers;

import sudoku.components.Board;

/**
 * Use this file to print a generated board
 */
public class BoardDriver {
    public static void main(String[] args) {
        Board board = new Board();
        board.generate();
        int i,j;
        System.out.println("*-----------*");
        for (i = 0; i < board.getBoardArray().length; i++) {
            if (i % 3 == 0 && i != 0) System.out.println("|---|---|---|");
            for (j = 0; j < board.getBoardArray()[i].length; j++) {
                if (j % 3 == 0) System.out.print("|");
                System.out.print(board.getBoardArray()[i][j].getValue());
            }
            System.out.println("|");
        }
        System.out.println("*-----------*");
    }
}
