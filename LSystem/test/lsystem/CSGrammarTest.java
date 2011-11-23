/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lsystem;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import static org.junit.Assert.assertEquals;
import org.junit.*;

/**
 *
 * @author tux
 */
public class CSGrammarTest {
    CSGrammar instance;
    /**
     * 
     */
    public CSGrammarTest() {
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
        instance = new CSGrammar("F");
    }

    /**
     * 
     */
    @After
    public void tearDown() {
    }

    /**
     * Test of addRule method, of class CSGrammar.
     */
    @Test
    public void testAddRule_char_String() {
        System.out.println("addRule");
        char premise = 'F';
        String rule = "F[-EF[3&A]]E[+F[3^A]]";
        instance.addRule(premise, rule);
    }

    /**
     * Test of addRule method, of class CSGrammar.
     */
    @Test
    public void testAddRule_String_String() {
        System.out.println("addRule");
        instance = new CSGrammar("baaaaa");
        String premise = "b<a";
        String rule = "b";
        instance.addRule(premise, rule);
        assert(instance.hasKey('a'));
//        String expResult = "b";
//        StringBuilder result = instance.getRule('a', "baaaaa", 1);
//        assertEquals(expResult, result.toString());
    }


    /**
     * Test of getRule method, of class CSGrammar.
     */
    @Test
    public void testGetRule() {
        System.out.println("getRule");
        char premise = 'F';
        String rule = "F[-EF[3&A]]E[+F[3^A]]";
        instance.addRule(premise, rule);
        int count = 0;
        String production = "F";
        String expResult = "F[-EF[3&A]]E[+F[3^A]]";
        StringBuilder result = instance.getRule(premise, production, count);
        assertEquals(expResult, result.toString());
    }

    /**
     * Test of hasKey method, of class CSGrammar.
     */
    @Test
    public void testHasKey() {
        System.out.println("hasKey");
        char premise = 'F';
        String rule = "F[-EF[3&A]]E[+F[3^A]]";
        instance.addRule(premise, rule);
        boolean expResult = true;
        boolean result = instance.hasKey(premise);
        assertEquals(expResult, result);
    }

    /**
     * Test of setIgnoreList method, of class CSGrammar.
     */
    @Test
    public void testSetIgnoreList_String() {
        System.out.println("setIgnoreList");
        String str = "[]+-^&3";
        instance.setIgnoreList(str);
    }

    /**
     * Test of setIgnoreList method, of class CSGrammar.
     */
    @Test
    public void testSetIgnoreList_charArr() {
        System.out.println("setIgnoreList");
        char[] str = {'[',']','+','-','^','&','3'};
        instance.setIgnoreList(str);
    }

    /**
     * Test of createGrammar method, of class CSGrammar.
     */
    @Test
    public void testCreateGrammar_int() {
        System.out.println("createGrammar");
        int repeats = 1 ;
        char premise = 'F';
        String rule = "F[-EF[3&A]]E[+F[3^A]]";
        instance.addRule(premise, rule);
        String premise2 = "F<E";
        String rule2 = "F[&F[3+A]][^F[3-A]]";
        instance.addRule(premise2, rule2);
        String expResult = "F[-EF[3&A]]E[+F[3^A]]";
        String result = instance.createGrammar(repeats);
        assertEquals(expResult, result);
    }

    /**
     * Test of createGrammar method, of class CSGrammar.
     */
    @Test
    public void testCreateGrammar_0args() {
        System.out.println("createGrammar");
        String expResult = "F";
        String result = instance.createGrammar();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIterator method, of class CSGrammar.
     */
    @Test
    public void testGetIterator() {
        System.out.println("getIterator");
        String production = "FFF";
        CharacterIterator expResult = new StringCharacterIterator("FFF") ;
        CharacterIterator result = instance.getIterator(production);
        assertEquals(expResult, result);
    }

    /**
     * Test of dispose method, of class CSGrammar.
     */
    @Test
    public void testDispose() {
        System.out.println("dispose");
        instance.dispose();
    }

  
    /**
     * Test of dispose method, of class CSGrammar.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        char[] str = {'[',']','+','-','^','&','3'};
        instance.setIgnoreList(str);
        String rule = "F[-EF[3&A]]E[+F[3^A]]";
        instance.addRule('F', rule);
        String premise2 = "F<E";
        String rule2 = "F[&F[3+A]][^F[3-A]]";
        instance.addRule(premise2, rule2);
        System.out.print(instance.toString());
    }
    /**
     * Test of version method, of class CSGrammar.
     */
    @Test
    public void testVersion() {
        System.out.println("version");
        String expResult = "0.7.4";
        String result = instance.version();
        assertEquals(expResult, result);
    }

}