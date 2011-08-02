/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lsystem;
import lsystem.collection.TurtleStack;
import lsystem.turtle.Turtle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tux
 */
public class TurtleStackTest {
    Turtle turtle;
    TurtleStack instance;
    /**
     *
     */
    public TurtleStackTest() {
    }

    /**
     *
     * @throws Exception
     */
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    /**
     *
     * @throws Exception
     */
    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     *
     */
    @Before
    public void setUp() {
      turtle = new Turtle(0.0f,0.0f,0.0f);
      instance = new TurtleStack();
    }

    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     *
     */
    @Test
    public void testTurtleConstructor() {
        System.out.println("turtle constructor");
        assertNotNull(turtle);
    }

    /**
     *
     */
    @Test
    public void testStackConstructor() {
        System.out.println("stack constructor");
        assertNotNull(instance);
    }

     /**
     * Test of push method, of class TurtleStack.
     */
    @Test
    public void testPush() {
        System.out.println("push");      
        instance.push(null);
        instance.push(turtle);
        assertEquals(turtle, instance.pop());
    }

    /**
     * Test of version method
     */
    @Test
    public void testVersion(){
        System.out.println("version");
        String expectedResult = "0.7.3";
        assertEquals(expectedResult, instance.version());
    }

}