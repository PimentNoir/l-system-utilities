package lsystem;

/**
 * A turtle to store position and direction
 * @author Martin Prout
 */
public class Turtle implements Cloneable, TurtleInterface {

    private float x, y, angle;

    /**
     * Copy Constructor
     * @param turtle
     */
    public Turtle(Turtle turtle) {
        this.x = turtle.getX();
        this.y = turtle.getY();
        this.angle = turtle.getTheta();
    }


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

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
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

    /**
     * X position setter
     * @param x position float
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * Y position setter
     * @param y position float
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * Angle setter
     * @param theta
     */
    public void setTheta(float theta) {
        this.angle = theta;
    }
}
