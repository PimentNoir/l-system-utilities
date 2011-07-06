package lsystem.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Martin Prout <martin_p@lineone.net>
 */
public class LUT2Test {
    
    /**
     * 
     */
    public LUT2Test() {
    }

    /**
     * 
     * @throws Exception
     */
    @BeforeClass
    public static void setUpClass() throws Exception {
        LUT2.initialize();
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
     * Test of sin method, of class LUT2.
     */
    @Test
    public void testMinusSin() {
        System.out.println("minus sin");
        float thet = -37.5F;
        float expResult = (float)Math.sin(Math.toRadians(thet));
        float result = LUT2.sin(thet);
        assertEquals(expResult, result, 0.01F);
    }

    /**
     * Test of cos method, of class LUT2.
     */
    @Test
    public void testMinusCos() {
        System.out.println("minus cos");
        float thet = -37.5F;
        float expResult = (float)Math.cos(Math.toRadians(thet));
        float result = LUT2.cos(thet);
        assertEquals(expResult, result, 0.01F);
    }
    
        /**
     * Test of sin method, of class LUT2.
     */
    @Test
    public void testSin() {
        System.out.println("sin");
        float thet = 90.5F;
        float expResult = (float)Math.sin(Math.toRadians(thet));
        float result = LUT2.sin(thet);
        assertEquals(expResult, result, 0.01F);
    }

    /**
     * Test of cos method, of class LUT2.
     */
    @Test
    public void testCos() {
        System.out.println("cos");
        float thet = 90.5F;
        float expResult = (float)Math.cos(Math.toRadians(thet));
        float result = LUT2.cos(thet);
        assertEquals(expResult, result, 0.01F);
    }
    
            /**
     * Test of sin method, of class LUT2.
     */
    @Test
    public void testLargeSin() {
        System.out.println("large sin");
        float thet = 2000.5F;
        float expResult = (float)Math.sin(Math.toRadians(thet));
        float result = LUT2.sin(thet);
        assertEquals(expResult, result, 0.01F);
    }

    /**
     * Test of cos method, of class LUT2.
     */
    @Test
    public void testLargeCos() {
        System.out.println("large cos");
        float thet = 2000.5F;
        float expResult = (float)Math.cos(Math.toRadians(thet));
        float result = LUT2.cos(thet);
        assertEquals(expResult, result, 0.01F);
    }
}
