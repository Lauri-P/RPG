
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class EsineTulkkiTest {

    public EsineTulkkiTest() {
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
    public void testLuontiJaVaihto() {
        Vihollinen vihu = new Vihollinen(1, 2, 3, 4);
        Pelaaja pelaaja = new Pelaaja(8, 8, 8, 8);
        EsineTulkki tulkki = new EsineTulkki(vihu);
        assertEquals(tulkki.getHahmo(), vihu);
        tulkki.setHahmo(pelaaja);
        assertEquals(tulkki.getHahmo(), pelaaja);
    }

    @Test
    public void testConsume() {
        Esine potion = new Esine("Potion", "HP:20", "Palauttaa 20HP", false, true);
        Pelaaja pelaaja = new Pelaaja(8, 8, 8, 8);
        EsineTulkki tulkki = new EsineTulkki(pelaaja);
        pelaaja.addHP(-8);
        assertEquals(pelaaja.getHP(), 16);
        tulkki.consume(potion);
        assertEquals(pelaaja.getHP(), 24);
        assertTrue(potion.getConsumed());
    }

    @Test
    public void testEquip() {
        Esine miekka = new Esine("Miekka", "STR:3", "Voima +3", true, false);
        Pelaaja pelaaja = new Pelaaja(8, 8, 8, 8);
        EsineTulkki tulkki = new EsineTulkki(pelaaja);
        tulkki.equip(miekka);
        pelaaja.paivitaMaximit();
        assertEquals(pelaaja.getStr(), 11);
        assertEquals(pelaaja.getMaxHP(), 27);
        tulkki.unEquip(miekka);
        pelaaja.paivitaMaximit();
        assertEquals(pelaaja.getStr(), 8);
        assertEquals(pelaaja.getMaxHP(), 24);
    }
}
