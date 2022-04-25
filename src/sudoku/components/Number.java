/*
 * Copyright (c) 2022. Owen Dowell
 */

package sudoku.components;

/**
 * Enumerated type containing numbers for Sudoku
 *
 * @author Owen Dowell
 * @version 1.0
 */
public class Number {
    private int value = 0;
    private int solution;
    private boolean isEditable = false;

    /**
     * default constructor.  When used, sets to
     * a blank square and turns on editability.
     *
     * Sets the solution field to 0, solution field
     * is the field of the number that is supposed
     * to be entered in the solution. This constructor
     * will likely be most useful for testing etc.
     */
    public Number() {
        this.value = 0;
        this.solution = 0;
        this.isEditable = true;
    }

    /**
     * Constroctor that will set the number to
     * a certain value and then keeps editability
     * off. In essence, these will be the pre-
     * populated numbers when you generate the
     * board.
     *
     * @param value is the value to be set intially
     */
    public Number(int value) {
        //assert that the parameter value is a valid value
        if (value > 0 && value <= 9 )
            this.value = value;
            this.solution = value;
    }

    /**
     * setBlank:
     *
     * Changes the number to a blank number (0),
     * and enables editability
     */
    public void setBlank() {
        this.value = 0;
        this.isEditable = true;
    }

    public int getValue() { return value; }
    public int getSolution() { return solution; }

    public boolean isEditable() { return isEditable; }

    public void setValue(int value) { this.value = value; }
    public void setSolution(int solution) { this.solution = solution; }
}