/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lsystem;



/**
 *
 * @author tux
 */
public interface PenInterface extends TurtleInterface{


    /**
     * line color getter
     * @return length int
     */
    int getColor();

    /**
     * Line color getter
     * @return length float
     */
    float getLength();

    /**
     * Line width getter
     * @return width float
     */
    float getWidth();

    /**
     * line color setter
     * @param col int
     */
    void setColor(int col);

    /**
     * Length setter
     * @param len
     */
    void setLength(float len);

    /**
     * Line width setter
     * @param width float
     */
    void setWidth(float width);

    void drawLine();

    void incrementGreen(int increment);
    void turnLeft(int repeats);
    void turnRight(int repeats);
    void resizeLength(float adj);

}
