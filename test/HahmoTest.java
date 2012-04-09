
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HahmoTest {

    Hahmo h0;
    Hahmo h1;
    Hahmo h2;
    Hahmo h3;
    Hahmo h4;

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
        h0 = new Hahmo();
        h1 = new Hahmo(1);
        h2 = new Hahmo(1, 2);
        h3 = new Hahmo(1, 2, 3);
        h4 = new Hahmo(1, 2, 3, 4);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testH0Str() {
        assertEquals(h0.getStr(), 0);
    }

    @Test
    public void testH0Vit() {
        assertEquals(h0.getVit(), 0);
    }

    @Test
    public void testH0Lck() {
        assertEquals(h0.getLck(), 0);
    }

    @Test
    public void testH0Intl() {
        assertEquals(h0.getIntl(), 0);
    }

    @Test
    public void testH0HP() {
        assertEquals(h0.getHP(), 0);
    }

    @Test
    public void testH0MP() {
        assertEquals(h0.getMP(), 0);
    }

    @Test
    public void testH0MaxHP() {
        assertEquals(h0.getMaxHP(), 0);
    }

    @Test
    public void testH0MaxMP() {
        assertEquals(h0.getMaxMP(), 0);
    }

    @Test
    public void testH1Str() {
        assertEquals(h1.getStr(), 1);
    }

    @Test
    public void testH1Vit() {
        assertEquals(h1.getVit(), 0);
    }

    @Test
    public void testH1Lck() {
        assertEquals(h1.getLck(), 0);
    }

    @Test
    public void testH1Intl() {
        assertEquals(h1.getIntl(), 0);
    }

    @Test
    public void testH1HP() {
        assertEquals(h1.getHP(), 0);
    }

    @Test
    public void testH1MP() {
        assertEquals(h1.getMP(), 0);
    }

    @Test
    public void testH1MaxHP() {
        assertEquals(h1.getMaxHP(), 0);
    }

    @Test
    public void testH1MaxMP() {
        assertEquals(h1.getMaxMP(), 0);
    }

    @Test
    public void testH2Str() {
        assertEquals(h2.getStr(), 1);
    }

    @Test
    public void testH2Vit() {
        assertEquals(h2.getVit(), 2);
    }

    @Test
    public void testH2Lck() {
        assertEquals(h2.getLck(), 0);
    }

    @Test
    public void testH2Intl() {
        assertEquals(h2.getIntl(), 0);
    }

    @Test
    public void testH2HP() {
        assertEquals(h2.getHP(), 0);
    }

    @Test
    public void testH2MP() {
        assertEquals(h2.getMP(), 0);
    }

    @Test
    public void testH2MaxHP() {
        assertEquals(h2.getMaxHP(), 0);
    }

    @Test
    public void testH2MaxMP() {
        assertEquals(h2.getMaxMP(), 0);
    }

    @Test
    public void testH3Str() {
        assertEquals(h3.getStr(), 1);
    }

    @Test
    public void testH3Vit() {
        assertEquals(h3.getVit(), 2);
    }

    @Test
    public void testH3Lck() {
        assertEquals(h3.getLck(), 3);
    }

    @Test
    public void testH3Intl() {
        assertEquals(h3.getIntl(), 0);
    }

    @Test
    public void testH3HP() {
        assertEquals(h3.getHP(), 0);
    }

    @Test
    public void testH3MP() {
        assertEquals(h3.getMP(), 0);
    }

    @Test
    public void testH3MaxHP() {
        assertEquals(h3.getMaxHP(), 0);
    }

    @Test
    public void testH3MaxMP() {
        assertEquals(h3.getMaxMP(), 0);
    }

    @Test
    public void testH4Str() {
        assertEquals(h4.getStr(), 1);
    }

    @Test
    public void testH4Vit() {
        assertEquals(h4.getVit(), 2);
    }

    @Test
    public void testH4Lck() {
        assertEquals(h4.getLck(), 3);
    }

    @Test
    public void testH4Intl() {
        assertEquals(h4.getIntl(), 4);
    }

    @Test
    public void testH4HP() {
        assertEquals(h4.getHP(), 0);
    }

    @Test
    public void testH4MP() {
        assertEquals(h4.getMP(), 0);
    }

    @Test
    public void testH4MaxHP() {
        assertEquals(h4.getMaxHP(), 0);
    }

    @Test
    public void testH4MaxMP() {
        assertEquals(h4.getMaxMP(), 0);
    }

    @Test
    public void testSetStr() {
        h0.setStr(1);
        assertEquals(h0.getStr(), 1);
    }

    @Test
    public void testSetVit() {
        h0.setVit(2);
        assertEquals(h0.getVit(), 2);
    }

    @Test
    public void testSetLck() {
        h0.setLck(3);
        assertEquals(h0.getLck(), 3);
    }

    @Test
    public void testSetIntl() {
        h0.setIntl(4);
        assertEquals(h0.getIntl(), 4);
    }

    @Test
    public void testSetHP() {
        h0.setMaxHP(7);
        h0.setHP(5);
        assertEquals(h0.getHP(), 5);
    }

    @Test
    public void testSetHPLiikaa() {
        h0.setMaxHP(7);
        h0.setHP(10);
        assertEquals(h0.getHP(), 7);
    }

    @Test
    public void testSetHPAlleNolla() {
        h0.setMaxHP(7);
        h0.setHP(-5);
        assertEquals(h0.getHP(), 0);
    }

    @Test
    public void testSetHPTasan() {
        h0.setMaxHP(7);
        h0.setHP(7);
        assertEquals(h0.getHP(), 7);
    }

    @Test
    public void testSetMP() {
        h0.setMaxMP(8);
        h0.setMP(6);
        assertEquals(h0.getMP(), 6);
    }

    @Test
    public void testSetMPLiikaa() {
        h0.setMaxMP(8);
        h0.setMP(12);
        assertEquals(h0.getMP(), 8);
    }

    @Test
    public void testSetMPAlleNolla() {
        h0.setMaxMP(8);
        h0.setMP(-6);
        assertEquals(h0.getMP(), 0);
    }

    @Test
    public void testSetMPTasan() {
        h0.setMaxMP(8);
        h0.setMP(8);
        assertEquals(h0.getMP(), 8);
    }

    @Test
    public void testSetMaxHP() {
        h0.setMaxHP(7);
        assertEquals(h0.getMaxHP(), 7);
    }

    @Test
    public void testSetMaxMP() {
        h0.setMaxMP(8);
        assertEquals(h0.getMaxMP(), 8);
    }

    @Test
    public void tesAddtStr() {
        h0.addStr(1);
        assertEquals(h0.getStr(), 1);
    }

    @Test
    public void testAddVit() {
        h0.addVit(2);
        assertEquals(h0.getVit(), 2);
    }

    @Test
    public void testAddLck() {
        h0.addLck(3);
        assertEquals(h0.getLck(), 3);
    }

    @Test
    public void testAddIntl() {
        h0.addIntl(4);
        assertEquals(h0.getIntl(), 4);
    }

    @Test
    public void testAddHP() {
        h0.setMaxHP(7);
        h0.addHP(5);
        assertEquals(h0.getHP(), 5);
    }

    @Test
    public void testAddHPLiikaa() {
        h0.setMaxHP(7);
        h0.addHP(10);
        assertEquals(h0.getHP(), 7);
    }

    @Test
    public void testAddHPAlleNolla() {
        h0.setMaxHP(7);
        h0.addHP(-5);
        assertEquals(h0.getHP(), 0);
    }

    @Test
    public void testAddHPTasan() {
        h0.setMaxHP(7);
        h0.addHP(7);
        assertEquals(h0.getHP(), 7);
    }

    @Test
    public void testAddMP() {
        h0.setMaxMP(8);
        h0.addMP(6);
        assertEquals(h0.getMP(), 6);
    }

    @Test
    public void testAddMPLiikaa() {
        h0.setMaxMP(8);
        h0.addMP(12);
        assertEquals(h0.getMP(), 8);
    }

    @Test
    public void testAddMPAlleNolla() {
        h0.setMaxMP(8);
        h0.addMP(-6);
        assertEquals(h0.getMP(), 0);
    }

    @Test
    public void testAddMPTasan() {
        h0.setMaxMP(8);
        h0.addMP(8);
        assertEquals(h0.getMP(), 8);
    }

    @Test
    public void testAddMaxHP() {
        h0.addMaxHP(7);
        assertEquals(h0.getMaxHP(), 7);
    }

    @Test
    public void testAddMaxMP() {
        h0.addMaxMP(8);
        assertEquals(h0.getMaxMP(), 8);
    }
}
