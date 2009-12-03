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
public class ParserTest {

    Parser instance;

    public ParserTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        instance = new Parser();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testConstructor() {
        System.out.println("constructor");
        assertNotNull(instance);
    }

    /**
     * Test of parseRule method, of class Parser.
     */
    @Test
    public void testSingleParseRule() {
        System.out.println("Parse a Single Rule");
        String prod_ = "FFFF";
        Rule[] rule_ = new Rule[2];
        rule_[0] = new Rule('F', "2F+F-"); // NB: rule_[1] = null
        String expResult = "2F+F-2F+F-2F+F-2F+F-";
        String result = instance.parseRule(prod_, rule_);
        assertEquals(expResult, result);
    }

    /**
     * Test of parseRule method, of class Parser.
     */
    @Test
    public void testTwoParseRule() {
        System.out.println("Parse a Two Rules");
        String prod_ = "X";
        Rule[] ruleT = new Rule[2];
        ruleT[0] = new Rule('X', "XFFX");
        ruleT[1] = new Rule('F', "FF");        
        String result = instance.parseRule(prod_, ruleT);
        String expResult = "XFFFFX";
        assertEquals(expResult, result);
    }
}
