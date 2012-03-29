
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HuoneTest {

    public HuoneTest() {
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
    public void testLuoHuone() {
        Huone huone = new Huone();
        assertTrue(!huone.getBossi());
        assertTrue(!huone.getKauppa());
        assertEquals(huone.getArkku(), null);
        assertEquals(huone.getVihollinen(), null);
        assertEquals(huone.getPohjoinen(), null);
        assertEquals(huone.getLansi(), null);
        assertEquals(huone.getEtela(), null);
        assertEquals(huone.getIta(), null);
    }

    @Test
    public void testHuoneet() {
        Huone huone = new Huone();
        Huone vasen = new Huone();
        Huone yla = new Huone();
        Huone ala = new Huone();
        Huone oikea = new Huone();

        huone.setEtela(ala);
        huone.setIta(oikea);
        huone.setLansi(vasen);
        huone.setPohjoinen(yla);

        yla.setEtela(huone);
        vasen.setIta(huone);
        oikea.setLansi(huone);
        ala.setPohjoinen(huone);


        assertEquals(huone.getPohjoinen(), yla);
        assertEquals(huone.getLansi(), vasen);
        assertEquals(huone.getEtela(), ala);
        assertEquals(huone.getIta(), oikea);

        assertEquals(ala.getPohjoinen(), huone);
        assertEquals(oikea.getLansi(), huone);
        assertEquals(yla.getEtela(), huone);
        assertEquals(vasen.getIta(), huone);
    }

    @Test
    public void testMuutSetterit() {
        Huone huone = new Huone();
        huone.setBossi(true);
        huone.setKauppa(true);
        Arkku arkku = new Arkku();
        Vihollinen vihollinen = new Vihollinen();
        huone.setArkku(arkku);
        huone.setVihollinen(vihollinen);

        assertTrue(huone.getBossi());
        assertTrue(huone.getKauppa());
        assertEquals(huone.getArkku(), arkku);
        assertEquals(huone.getVihollinen(), vihollinen);
    }
}
