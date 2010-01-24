/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lsystem;

public class Pen extends Turtle implements Cloneable, PenInterface {

    float x, y, angle, len, delta, width;
    int col;

    public Pen(float xpos, float ypos, float direction, float len, int col, float width) {
        super(xpos, ypos, direction);
        this.len = len;
        this.col = col;
        this.width = width;
    }

    public Pen(float xpos, float ypos, float direction, float len, int col) {
        super(xpos, ypos, direction);
        this.len = len;
        this.col = col;
        this.width = 1.0f;
    }

        public Pen(float xpos, float ypos, float direction, float len) {
        super(xpos, ypos, direction);
        this.len = len;
        this.col = 0;  // default color black (white -1)
        this.width = 1.0f;
    }

//    @Override
//    public Object clone() {
//        try {
//            return super.clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

//    /**
//     * X position getter
//     * @return x position float
//     */
//    public float getX() {
//        return x;
//    }
//
//    /**
//     * Y position getter
//     * @return y position float
//     */
//    public float getY() {
//        return y;
//    }
//
//    /**
//     * Angle getter
//     * @return angle float
//     */
//    public float getTheta() {
//        return angle;
//    }

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
     * @param length float
     */
    public void setLength(float len) {
        this.len = len;
    }

//    /**
//     * X position setter
//     * @param x position float
//     */
//    public void setX(float x) {
//        this.x = x;
//    }
//
//    /**
//     * Y position setter
//     * @param y position float
//     */
//    public void setY(float y) {
//        this.y = y;
//    }
//
//    /**
//     * Angle setter
//     * @param angle float
//     */
//    public void setTheta(float theta) {
//        this.angle = theta;
//    }
}
