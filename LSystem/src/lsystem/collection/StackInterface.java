/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lsystem.collection;

/**
 *
 * @param <E>
 * @author tux
 */
public interface StackInterface <E>{

    /**
     *
     */
    public final String VERSION = "0.6.7";

    /**
     *
     */
    void dispose();

    /**
     * SimpleTurtle pop
     * @return turtle SimpleTurtle
     */
    E pop();

    /**
     * SimpleTurtle push
     * @param turtle SimpleTurtle
     */
    void push(E turtle);

}
