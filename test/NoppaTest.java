/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Koti
 */
public class NoppaTest {

    public NoppaTest() {
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

    /**
     * Test of heitto method, of class Noppa.
     */
    @Test
    public void testHeittoD6() {
        boolean toimii = true;
        Noppa d6 = new Noppa();
        for (int i = 0; i < 1000; i++) {
            int tulos = d6.heitto();
            if (tulos < 1 || tulos > 6) {
                toimii = false;
            }
        }
        assertTrue(toimii);
    }

    @Test
    public void testHeittoD10() {
        boolean toimii = true;
        Noppa d10 = new Noppa(10);
        for (int i = 0; i < 1000; i++) {
            int tulos = d10.heitto();
            if (tulos < 1 || tulos > 10) {
                toimii = false;
            }
        }
        assertTrue(toimii);
    }

    @Test
    public void testHeittoD6TuhatKertaa() {
        boolean toimii = true;
        Noppa d6 = new Noppa();
        for (int i = 0; i < 1000; i++) {
            int tulos = d6.heitto(1000);
            if (tulos < 1000 || tulos > 6000) {
                toimii = false;
            }
        }
        assertTrue(toimii);
    }

    @Test
    public void testHeittoD10TuhatKertaa() {
        boolean toimii = true;
        Noppa d10 = new Noppa(10);
        for (int i = 0; i < 1000; i++) {
            int tulos = d10.heitto(1000);
            if (tulos < 1000 || tulos > 10000) {
                toimii = false;
            }
        }
        assertTrue(toimii);
    }
    
    @Test
    public void testHeittoD6Neg() {
        boolean toimii = true;
        Noppa d6 = new Noppa();
        for (int i = 0; i < 1000; i++) {
            int tulos = d6.heitto(-1);
            if (tulos < -6 || tulos > -1) {
                toimii = false;
            }
        }
        assertTrue(toimii);
    }

    @Test
    public void testHeittoD10Neg() {
        boolean toimii = true;
        Noppa d10 = new Noppa(10);
        for (int i = 0; i < 1000; i++) {
            int tulos = d10.heitto(-1);
            if (tulos < -10 || tulos > -1) {
                toimii = false;
            }
        }
        assertTrue(toimii);
    }

    @Test
    public void testHeittoD6TuhatKertaaNeg() {
        boolean toimii = true;
        Noppa d6 = new Noppa();
        for (int i = 0; i < 1000; i++) {
            int tulos = d6.heitto(-1000);
            if (tulos < -6000 || tulos > -1000) {
                toimii = false;
            }
        }
        assertTrue(toimii);
    }

    @Test
    public void testHeittoD10TuhatKertaaNeg() {
        boolean toimii = true;
        Noppa d10 = new Noppa(10);
        for (int i = 0; i < 1000; i++) {
            int tulos = d10.heitto(-1000);
            if (tulos < -10000 || tulos > -1000) {
                toimii = false;
            }
        }
        assertTrue(toimii);
    }
}
