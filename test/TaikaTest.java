
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TaikaTest {

    Taika tuli;
    Taika hoyry;
    ArrayList<String> tyyppi;

    public TaikaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        tuli = new Taika("Tulipallo", "Tuli", 2, 8);
        tyyppi = new ArrayList<>();
        tyyppi.add("Tuli");
        tyyppi.add("Vesi");
        hoyry = new Taika("Höyryä", tyyppi, 2, 5);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testTuliLuontiNimi() {
        assertEquals(tuli.getNimi(), "Tulipallo");
    }

    @Test
    public void testTuliLuontiTyyppi() {
        assertTrue(tuli.getTyyppi().contains("Tuli"));
    }

    @Test
    public void testTuliLuontiHinta() {
        assertEquals(tuli.getHinta(), 2);
    }

    @Test
    public void testTuliLuontiTeho() {
        assertEquals(tuli.getTeho(), 8);
    }

    @Test
    public void testHoyryLuontiNimi() {
        assertEquals(hoyry.getNimi(), "Höyryä");
    }

    @Test
    public void testHoyryLuontiTyyppi() {
        assertTrue(hoyry.getTyyppi().containsAll(tyyppi));
    }

    @Test
    public void testHoyryLuontiHinta() {
        assertEquals(hoyry.getHinta(), 2);
    }

    @Test
    public void testHoyryLuontiTeho() {
        assertEquals(hoyry.getTeho(), 5);
    }

    @Test
    public void testSetNimi() {
        tuli.setNimi("Vesi");
        assertEquals(tuli.getNimi(), "Vesi");
    }

    @Test
    public void testSetTyyppi() {
        tuli.setTyyppi(tyyppi);
        assertTrue(hoyry.getTyyppi().containsAll(tyyppi));
    }

    @Test
    public void testSetHinta() {
        tuli.setHinta(3);
        assertEquals(tuli.getHinta(), 3);
    }

    @Test
    public void testSetTeho() {
        tuli.setTeho(3);
        assertEquals(tuli.getTeho(), 3);
    }

    @Test
    public void testAddTyyppi() {
        tuli.addTyyppi("Vesi");
        assertTrue(hoyry.getTyyppi().containsAll(tyyppi));
    }
}
