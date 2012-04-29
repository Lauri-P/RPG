package RPG;

import RPG.Vihollinen;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VihollinenTest {

    Vihollinen vihu;

    public VihollinenTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        vihu = new Vihollinen(1, 2, 3, 4);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testVihunLuontiStr() {
        assertEquals(vihu.getStr(), 1);
    }

    @Test
    public void testVihunLuontiVit() {
        assertEquals(vihu.getVit(), 2);
    }

    @Test
    public void testVihunLuontiLck() {
        assertEquals(vihu.getLck(), 3);
    }

    @Test
    public void testVihunLuontiIntl() {
        assertEquals(vihu.getIntl(), 4);
    }

    @Test
    public void testVihunLuontiHP() {
        assertEquals(vihu.getHP(), 5);
    }

    @Test
    public void testVihunLuontiMP() {
        assertEquals(vihu.getMP(), 8);
    }

    @Test
    public void testVihunLuontiMaxHP() {
        assertEquals(vihu.getMaxHP(), 5);
    }

    @Test
    public void testVihunLuontiMaxMP() {
        assertEquals(vihu.getMaxMP(), 8);
    }

    @Test
    public void testVihunLuontiWeakness() {
        assertTrue(vihu.getWeak().isEmpty());
    }

    @Test
    public void testVihunLuontiNimi() {
        assertEquals(vihu.getNimi(), "Anonymous");
    }

    @Test
    public void testVihunLuontiPolku() {
        assertEquals(vihu.getPolku(), "Kuvat\\F.O.E..png");
    }

    @Test
    public void testSetWeak() {
        ArrayList<String> heikkoudet = new ArrayList<>();
        heikkoudet.add("Tuli");
        heikkoudet.add("Vesi");
        vihu.setWeak(heikkoudet);
        assertTrue(vihu.getWeak().containsAll(heikkoudet));
    }

    @Test
    public void testAddWeak() {
        vihu.addWeak("Tuli");
        assertTrue(vihu.getWeak().contains("Tuli"));
    }

    @Test
    public void testSetNimi() {
        vihu.setNimi("Pahis");
        assertEquals(vihu.getNimi(), "Pahis");
    }

    @Test
    public void testSetPolku() {
        vihu.setPolku("Kuvat\\F.O.E.blue.png");
        assertEquals(vihu.getPolku(), "Kuvat\\F.O.E.blue.png");
    }
}
