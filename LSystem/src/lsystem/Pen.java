/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lsystem;

/**
 *
 * @author tux
 */
public class Pen extends Turtle implements Cloneable, PenInterface {

    float x, y, angle, len, delta, width;
    int col;

    /**
     *
     * @param xpos
     * @param ypos
     * @param direction
     * @param len
     * @param col
     * @param width
     */
    public Pen(float xpos, float ypos, float direction, float len, int col, float width) {
        super(xpos, ypos, direction);
        this.len = len;
        this.col = col;
        this.width = width;
    }

    /**
     *
     * @param xpos
     * @param ypos
     * @param direction
     * @param len
     * @param col
     */
    public Pen(float xpos, float ypos, float direction, float len, int col) {
        super(xpos, ypos, direction);
        this.len = len;
        this.col = col;
        this.width = 1.0f;
    }

    /**
     *
     * @param xpos
     * @param ypos
     * @param direction
     * @param len
     */
    public Pen(float xpos, float ypos, float direction, float len) {
        super(xpos, ypos, direction);
        this.len = len;
        this.col = 0;  // default color black (white -1)
        this.width = 1.0f;
    }

    /**
     * Line color getter
     * @return length float
     */
    public float getLength() {
        return len;
    }

     /**
     * line color getter
     * @return length int
     */
    public int getColor() {
        return col;
    }

    /**
     * Line width getter
     * @return width float
     */
    public float getWidth() {
        return width;
    }

    /**
     * Line width setter
     * @param width float
     */
    public void setWidth(float width) {
        this.width = width;
    }

    /**
     * line color setter
     * @param col int
     */
    public void setColor(int col) {
        this.col = col;
    }

    /**
     * Length setter
     * @param len
     */
    public void setLength(float len) {
        this.len = len;
    }

}
