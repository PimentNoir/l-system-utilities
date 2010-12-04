package lsystem;

import lsystem.collection.StackInterface;
import lsystem.turtle.Pen;
import java.util.ArrayDeque;
import java.util.Deque;
import processing.core.PApplet;

/**
 * A Pen tuned stack with minimal interface
 * @author Martin Prout
 */
public class PenStack implements StackInterface{

    private Deque<Pen> stack;
    private PApplet parent;

    /**
     * Stack constructor
     * allows stack instance to be registered with PApplet
     * @param parent
     */
    public PenStack(PApplet parent) {
        this.parent = parent;
        parent.registerDispose(this);
        stack = new ArrayDeque<Pen>();
    }
    // default constructor for testing

    /**
     *
     */
    public PenStack() {
        stack = new ArrayDeque<Pen>();
    }

    /**
     * Pen push
     * @param pen
     */
    public void push(Pen pen) {
        if (pen != null) {
            stack.push(pen);
        }
    }

    public void push(Object pen) {
        if (pen != null) {
            stack.push((Pen) pen);
        }
    }

    /**
     * Pen pop
     * @return Pen Pen
     */
    public Pen pop() {
        return stack.pop();
    }

    /**
     *
     */
    public void dispose() {
        stack.clear();
        stack = null;
    }
}

