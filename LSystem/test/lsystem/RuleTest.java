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
public class RuleTest {
    Rule instance;
    public RuleTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        instance = new Rule('Z', "RRR");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of key method, of class Rule.
     */
    @Test
    public void testKey() {
        System.out.println("key");
        char expResult = 'Z';
        char result = instance.key();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRule method, of class Rule.
     */
    @Test
    public void testGetRule() {
        System.out.println("getRule");
        String expResult = "RRR";
        String result = instance.getRule();
        assertEquals(expResult, result);
    }
        /**
     * Test of getRule method, of class Rule.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Z=>RRR";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}