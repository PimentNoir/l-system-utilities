/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lsystem;

/**
 * Pen class extends Turtle to include width, length and color parameters
 * includes a drawLine funtion that calls on PApplet line(x, y, x1, y2);
 * @author tux
 */

import processing.core.PApplet;

public class Pen extends Turtle implements Cloneable, PenInterface {

    float len, width;
    int col;
    PApplet parent;
    /**
     * Copy Constructor for pen
     * @param pen
     */
    public Pen(Pen pen) {
        super(pen.getX(), pen.getY(), pen.getTheta());
        this.parent = pen.getParent();
        this.len = pen.getLength();
        this.col = pen.getColor();
        this.width = pen.getWidth();
    }

    /**
     * Constructor
     * @param xpos
     * @param ypos
     * @param direction
     * @param len
     * @param col
     * @param width
     */
    public Pen(PApplet parent, float xpos, float ypos, float direction, float len, int col, float width) {
        super(xpos, ypos, direction);
        this.parent = parent;
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
    public Pen(PApplet parent, float xpos, float ypos, float direction, float len, int col) {
        super(xpos, ypos, direction);
        this.parent = parent;
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
    public Pen(PApplet parent, float xpos, float ypos, float direction, float len) {
        super(xpos, ypos, direction);
        this.parent = parent;
        this.len = len;
        this.col = 0;  // default color black (white -1)
        this.width = 1.0f;
    }

    private PApplet getParent(){
        return this.parent;
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

    public void resizeLength(float factor){
        this.len *= factor;
    }

    public void incrementGreen(int increment){
        int green = this.col  >> 8 & 0xFF;
        green += increment;
        this.col |= green << 8;
    }

    public void turnLeft(int repeats){
        setTheta(getTheta() + (float)Math.PI/180 * 34.9f * repeats);
    }
    public void turnRight(int repeats){
        setTheta(getTheta() - (float)Math.PI/180 * 34.9f * repeats);

    }


    public void drawLine(){
       // parent.strokeWeight(getWidth());
        parent.stroke(this.col);
        float x0 = getX();
        float y0 = getY();
        float x1 = (float)(x0 - getLength()*Math.cos(getTheta()));
        float y1 = (float)(y0 - getLength()*Math.sin(getTheta()));
        parent.line(x0, y0, x1, y1);
        this.setX(x1);
        this.setY(y1);
    }
}
