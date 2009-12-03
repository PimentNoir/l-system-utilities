package lsystem;

/**
 * A turtle to store position and direction
 * @author Martin Prout
 */
public class Turtle {
    private float x, y, angle;
    /**
     * Constructor
     * @param x
     * @param y
     * @param angle
     */
    public Turtle(float x, float y, float angle) {
        this.x = x;
        this.y = y;
        this.angle = angle;
    }
    /**
     * X position getter
     * @return x position float
     */

    public float getX() {
        return x;
    }
    /**
     * Y position getter
     * @return y position float
     */

    public float getY() {
        return y;
    }
    /**
     * Angle getter
     * @return angle float
     */

    public float getTheta() {
        return angle;
    }
}