/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lsystem;

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
public class SimpleGrammarTest {

    /**
     *
     */
    public SimpleGrammarTest() {
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
    }

    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     * Test of addRule method, of class SimpleGrammar.
     */
    @Test
    public void testAddRule_char_String() {
        System.out.println("addRule");
        char premise = 'F';
        String rule = "F-F-F-F";
        Grammar instance = new SimpleGrammar("F");
        instance.addRule(premise, rule);
    }

    /**
     * Test of addRule method, of class SimpleGrammar.
     */
    @Test (expected=RuntimeException.class)
    public void testAddRule_3args() {
        System.out.println("addRule");
        char premise = ' ';
        String rule = "";
        float weight = 0.0F;
        Grammar instance = new SimpleGrammar("F");
        instance.addRule(premise, rule, weight);
    }

    /**
     * Test of getRule method, of class SimpleGrammar.
     */
    @Test
    public void testGetRule() {
        System.out.println("getRule");
        char premise = 'F';
        Grammar instance = new SimpleGrammar("F");
        String rule = "F-F-F-F";
        instance.addRule(premise, rule);
        String expResult = "F-F-F-F";
        String result = instance.getRule(premise);
        assertEquals(expResult, result);
    }


    /**
     * Test of createGrammar method, of class SimpleGrammar.
     */
    @Test
    public void testCreateGrammar() {
        System.out.println("createGrammar no args");
        Grammar instance = new SimpleGrammar("F");
        String rule = "F-F-F-F";
        instance.addRule('F', rule);
        String expResult = "F";
         String result = instance.createGrammar();
        assertEquals(expResult, result);
    }

    /**
     * Test of createGrammar method, of class SimpleGrammar.
     */
    @Test
    public void testCreateGrammar_args() {
        System.out.println("createGrammar 2 repeats");
        int repeats = 2;
        Grammar instance = new SimpleGrammar("F");
        String rule = "F-F-F-F";
        instance.addRule('F', rule);
        String expResult = "F-F-F-F-F-F-F-F-F-F-F-F-F-F-F-F";
         String result = instance.createGrammar(repeats);
        assertEquals(expResult, result);
    }



    /**
     * Test of version method, of class SimpleGrammar.
     */
    @Test
    public void testVersion() {
        System.out.println("version");
        Grammar instance = new SimpleGrammar("FF");
        String expResult = "0.6.0";
        String result = instance.version();
        assertEquals(expResult, result);
    }

}
