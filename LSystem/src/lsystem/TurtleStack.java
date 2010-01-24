package lsystem;

import java.util.ArrayDeque;
import java.util.Deque;
import processing.core.PApplet;


/**
 * A turtle tuned stack with minimal interface
 * @author Martin Prout
 */
public class TurtleStack implements StackInterface {

    private Deque<Turtle> stack;
    private PApplet parent;

    /**
     * Stack constructor
     * allows stack instance to be registered with PApplet
     */
    public TurtleStack(PApplet parent) {
        this.parent = parent;
        parent.registerDispose(this);
        stack = new ArrayDeque<Turtle>();
    }
    // default constructor for testing

    public TurtleStack() {
        stack = new ArrayDeque<Turtle>();
    }

    /**
     * Turtle push
     * @param turtle Turtle
     */
    public void push(Turtle turtle) {
        if (turtle != null) {
            stack.push(turtle);
        }
    }

    /**
     * Turtle push
     * @param turtle Object
     */
    public void push(Object turtle) {
        if (turtle != null) {
            stack.push((Turtle)turtle);
        }
    }


    /**
     * Turtle pop
     * @return turtle Turtle
     */
    public Turtle pop() {
        return stack.pop();
    }

    public void dispose() {
        stack.clear();
        stack = null;
    }
}
