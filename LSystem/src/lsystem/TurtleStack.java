package lsystem;

import java.util.Deque;
import java.util.ArrayDeque;

/**
 * A turtle tuned stack with minimal interface
 * @author Martin Prout
 */
public class TurtleStack {

    private Deque<Turtle> stack;

    /**
     * Stack constructor
     */
    public TurtleStack() {
        stack = new ArrayDeque<Turtle>();
    }

    /**
     * Turtle push
     * @param turtle Turtle
     */
    public void push(Turtle turtle) {
        stack.push(turtle);
    }

    /**
     * Turtle pop
     * @return turtle Turtle
     */
    public Turtle pop() {
        return stack.pop();
    }

    public void destroy(){
        stack.clear();
        stack = null;
    }
}
