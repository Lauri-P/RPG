
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
    public void testHahmo0() {
        Hahmo hahmo = new Hahmo();
        assertEquals(hahmo.getStr(), 0);
        assertEquals(hahmo.getVit(), 0);
        assertEquals(hahmo.getLck(), 0);
        assertEquals(hahmo.getIntl(), 0);
        assertEquals(hahmo.getHP(), 0);
        assertEquals(hahmo.getMP(), 0);
        assertEquals(hahmo.getMaxHP(), 0);
        assertEquals(hahmo.getMaxMP(), 0);

    }

    @Test
    public void testHahmo1() {
        Hahmo hahmo = new Hahmo(1);
        assertEquals(hahmo.getStr(), 1);
        assertEquals(hahmo.getVit(), 0);
        assertEquals(hahmo.getLck(), 0);
        assertEquals(hahmo.getIntl(), 0);
        assertEquals(hahmo.getHP(), 0);
        assertEquals(hahmo.getMP(), 0);
        assertEquals(hahmo.getMaxHP(), 0);
        assertEquals(hahmo.getMaxMP(), 0);

    }

    @Test
    public void testHahmo2() {
        Hahmo hahmo = new Hahmo(1, 2);
        assertEquals(hahmo.getStr(), 1);
        assertEquals(hahmo.getVit(), 2);
        assertEquals(hahmo.getLck(), 0);
        assertEquals(hahmo.getIntl(), 0);
        assertEquals(hahmo.getHP(), 0);
        assertEquals(hahmo.getMP(), 0);
        assertEquals(hahmo.getMaxHP(), 0);
        assertEquals(hahmo.getMaxMP(), 0);

    }

    @Test
    public void testHahmo3() {
        Hahmo hahmo = new Hahmo(1, 2, 3);
        assertEquals(hahmo.getStr(), 1);
        assertEquals(hahmo.getVit(), 2);
        assertEquals(hahmo.getLck(), 3);
        assertEquals(hahmo.getIntl(), 0);
        assertEquals(hahmo.getHP(), 0);
        assertEquals(hahmo.getMP(), 0);
        assertEquals(hahmo.getMaxHP(), 0);
        assertEquals(hahmo.getMaxMP(), 0);

    }

    @Test
    public void testHahmo4() {
        Hahmo hahmo = new Hahmo(1, 2, 3, 4);
        assertEquals(hahmo.getStr(), 1);
        assertEquals(hahmo.getVit(), 2);
        assertEquals(hahmo.getLck(), 3);
        assertEquals(hahmo.getIntl(), 4);
        assertEquals(hahmo.getHP(), 0);
        assertEquals(hahmo.getMP(), 0);
        assertEquals(hahmo.getMaxHP(), 0);
        assertEquals(hahmo.getMaxMP(), 0);

    }

    @Test
    public void testSetterit() {
        Hahmo hahmo = new Hahmo();
        hahmo.setStr(1);
        hahmo.setVit(2);
        hahmo.setLck(3);
        hahmo.setIntl(4);
        hahmo.setMaxHP(7);
        hahmo.setMaxMP(8);
        hahmo.setHP(5);
        hahmo.setMP(6);

        assertEquals(hahmo.getStr(), 1);
        assertEquals(hahmo.getVit(), 2);
        assertEquals(hahmo.getLck(), 3);
        assertEquals(hahmo.getIntl(), 4);
        assertEquals(hahmo.getHP(), 5);
        assertEquals(hahmo.getMP(), 6);
        assertEquals(hahmo.getMaxHP(), 7);
        assertEquals(hahmo.getMaxMP(), 8);

    }

    @Test
    public void testAdderit() {
        Hahmo hahmo = new Hahmo(1, 2, 3, 4);
        hahmo.setMaxHP(7);
        hahmo.setMaxMP(8);
        hahmo.setHP(5);
        hahmo.setMP(6);

        hahmo.addStr(1);
        hahmo.addVit(2);
        hahmo.addLck(3);
        hahmo.addIntl(4);
        hahmo.addMaxHP(7);
        hahmo.addMaxMP(8);
        hahmo.addHP(5);
        hahmo.addMP(6);

        assertEquals(hahmo.getStr(), 2);
        assertEquals(hahmo.getVit(), 4);
        assertEquals(hahmo.getLck(), 6);
        assertEquals(hahmo.getIntl(), 8);
        assertEquals(hahmo.getHP(), 10);
        assertEquals(hahmo.getMP(), 12);
        assertEquals(hahmo.getMaxHP(), 14);
        assertEquals(hahmo.getMaxMP(), 16);

    }

    @Test
    public void testRajojenUlkopuolella() {
        Hahmo hahmo = new Hahmo();
        hahmo.setMaxHP(1);
        hahmo.setMaxMP(2);
        hahmo.setHP(3);
        hahmo.setMP(4);

        assertEquals(hahmo.getHP(), 1);
        assertEquals(hahmo.getMP(), 2);

        hahmo.addHP(3);
        hahmo.addMP(4);

        assertEquals(hahmo.getHP(), 1);
        assertEquals(hahmo.getMP(), 2);

        hahmo.setHP(-3);
        hahmo.setMP(-4);

        assertEquals(hahmo.getHP(), 0);
        assertEquals(hahmo.getMP(), 0);

        hahmo.addHP(-3);
        hahmo.addMP(-4);

        assertEquals(hahmo.getHP(), 0);
        assertEquals(hahmo.getMP(), 0);


    }
}
