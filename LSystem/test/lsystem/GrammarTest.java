/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lsystem;

import static org.junit.Assert.assertEquals;
import org.junit.*;

/**
 *
 * @author tux
 */
public class GrammarTest {

    Grammar instance;

    /**
     *
     */
    public GrammarTest() {
        instance = new SimpleGrammar("F-F-F-F");
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
     * Test of addRule method, of class Grammar.
     */
    @Test
    public void testAddRule() {
        System.out.println("addRule");
        char premise = 'F';
        String rule = "FFFF";
        instance.addRule(premise, rule);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getRule method, of class Grammar.
     */
    @Test
    public void testGetRule() {
        System.out.println("getRule");
        char premise = 'F';
        String rule = "FFFF";
        instance.addRule(premise, rule);
        String expResult = "FFFF";
        String result = instance.getRule(premise);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //  fail("The test case is a prototype.");
    }

    /**
     * Test of hasKey method, of class Grammar.
     */
    @Test
    public void testHasKey() {
        System.out.println("hasKey");
        char premise = 'F';
        String rule = "FFFF";
        instance.addRule(premise, rule);
        boolean expResult = true;
        boolean result = instance.hasKey(premise);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //  fail("The test case is a prototype.");
    }



    /**
     * Test of 1 rule 1 repeat createGrammar method, of class Grammar.
     */
    @Test
    public void testCreateGrammar() {
        System.out.println("createGrammar 1 rule 1repeat");
        char premise = 'F';
        String rule = "FFXX";
        instance.addRule(premise, rule);
        String expResult = "FFXX-FFXX-FFXX-FFXX";
        String result = instance.createGrammar(1);
        assertEquals(expResult, result);
    }

     /**
     * Test 2 rule 2 repeat createGrammar method, of class Grammar.
     */
    @Test
    public void testCreateGrammar2() {
        System.out.println("createGrammar 2 rule 2 repeat");
        char premise = 'F';
        String rule = "FFXX";
        instance.addRule(premise, rule);
        char premise1 = 'X';
        String rule1 = "ZZ";
        instance.addRule(premise1, rule1);
        String expResult = "FFXXFFXXZZZZ-FFXXFFXXZZZZ-FFXXFFXXZZZZ-FFXXFFXXZZZZ";
        String result = instance.createGrammar(2);
        assertEquals(expResult, result);
    }


    /**
     * Test of version method, of class Grammar.
     */
    @Test
    public void testVersion() {
        System.out.println("version");
        String expResult = "0.8.0";
        String result = instance.version();
        assertEquals(expResult, result);
    }
}
