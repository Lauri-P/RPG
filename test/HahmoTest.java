/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lauri
 */
public class HahmoTest {
    
    public HahmoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testHahmo0(){
    Hahmo hahmo=new Hahmo();
    assertEquals(hahmo.getStr(),0);
    assertEquals(hahmo.getVit(),0);
    assertEquals(hahmo.getLck(),0);
    assertEquals(hahmo.getIntl(),0);
    assertEquals(hahmo.getHP(),0);
    assertEquals(hahmo.getMP(),0);
    assertEquals(hahmo.getMaxHP(),0);
    assertEquals(hahmo.getMaxMP(),0);

}
}
    
