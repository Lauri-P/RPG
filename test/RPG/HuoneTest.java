package RPG;


import RPG.Huone;
import RPG.Arkku;
import RPG.Vihollinen;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HuoneTest {

    Huone huone;

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
        huone = new Huone();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testLuontiBossi() {
        assertTrue(!huone.getBossi());
    }

    @Test
    public void testLuontiKauppa() {
        assertTrue(!huone.getKauppa());
    }

    @Test
    public void testLuontiArkku() {
        assertEquals(huone.getArkku(), null);
    }

    @Test
    public void testLuontiVihollinen() {
        assertEquals(huone.getVihollinen(), null);
    }

    @Test
    public void testLuontiPohjoinen() {
        assertEquals(huone.getPohjoinen(), null);
    }

    @Test
    public void testLuontiLansi() {
        assertEquals(huone.getLansi(), null);
    }

    @Test
    public void testLuontiEtela() {
        assertEquals(huone.getEtela(), null);
    }

    @Test
    public void testLuontiIta() {
        assertEquals(huone.getIta(), null);
    }

    @Test
    public void testSetBossi() {
        huone.setBossi(true);
        assertTrue(huone.getBossi());
    }

    @Test
    public void testSetKauppa() {
        huone.setKauppa(true);
        assertTrue(huone.getKauppa());
    }

    @Test
    public void testSetArkku() {
        Arkku arkku = new Arkku();
        huone.setArkku(arkku);
        assertEquals(huone.getArkku(), arkku);
    }

    @Test
    public void testSetVihollinen() {
        Vihollinen vihollinen = new Vihollinen();
        huone.setVihollinen(vihollinen);
        assertEquals(huone.getVihollinen(), vihollinen);
    }

    @Test
    public void testSetPohjoinen() {
        Huone yla = new Huone();
        huone.setPohjoinen(yla);
        assertEquals(huone.getPohjoinen(), yla);
    }

    @Test
    public void testSetLansi() {
        Huone vasen = new Huone();
        huone.setLansi(vasen);
        assertEquals(huone.getLansi(), vasen);
    }

    @Test
    public void testSetEtela() {
        Huone ala = new Huone();
        huone.setEtela(ala);
        assertEquals(huone.getEtela(), ala);
    }

    @Test
    public void testSetIta() {
        Huone oikea = new Huone();
        huone.setIta(oikea);
        assertEquals(huone.getIta(), oikea);
    }

    @Test // Tässä testataan huoneidenmuodostusta hieman laajemmin
    public void testHuoneita() {
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
}
