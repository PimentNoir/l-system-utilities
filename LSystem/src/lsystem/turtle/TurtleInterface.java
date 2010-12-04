/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lsystem.turtle;

/**
 *
 * @author tux
 */
public interface TurtleInterface {

    /**
     *
     */
    public final String VERSION = "0.6.7";

    /**
     *
     * @return copy
     */
    Object clone();

    /**
     * Angle getter
     * @return angle float
     */
    float getTheta();

    /**
     * X position getter
     * @return x position float
     */
    float getX();

    /**
     * Y position getter
     * @return y position float
     */
    float getY();

    /**
     * Angle setter
     * @param theta
     */
    void setTheta(float theta);

    /**
     * X position setter
     * @param x position float
     */
    void setX(float x);

    /**
     * Y position setter
     * @param y position float
     */
    void setY(float y);

}
