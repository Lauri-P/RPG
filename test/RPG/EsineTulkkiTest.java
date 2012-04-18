package RPG;


import RPG.Hahmo;
import RPG.Pelaaja;
import RPG.Esine;
import RPG.Vihollinen;
import RPG.EsineTulkki;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class EsineTulkkiTest {

    EsineTulkki tulkki;
    Hahmo hahmo;

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
        hahmo = new Pelaaja(8, 8, 8, 8);
        tulkki = new EsineTulkki(hahmo);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testLuontiHahmo() {
        assertEquals(tulkki.getHahmo(), hahmo);
    }

    @Test
    public void testSetHahmo() {
        Vihollinen vihu = new Vihollinen(1, 2, 3, 4);
        tulkki.setHahmo(vihu);
        assertEquals(tulkki.getHahmo(), vihu);
    }

    @Test
    public void testConsumeOminaisuus() {
        Esine potion = new Esine("Potion", "HP:20", "Palauttaa 20HP", false, true);
        hahmo.addHP(-22);
        tulkki.consume(potion);
        assertEquals(hahmo.getHP(), 22);
    }

    @Test
    public void testConsumeConsumed() {
        Esine potion = new Esine("Potion", "HP:20", "Palauttaa 20HP", false, true);
        tulkki.consume(potion);
        assertTrue(potion.getConsumed());
    }

    @Test
    public void testConsumeOminaisuusNotConsumable() {
        Esine potion = new Esine("Potion", "HP:20", "Palauttaa 20HP", false, false);
        hahmo.addHP(-22);
        tulkki.consume(potion);
        assertEquals(hahmo.getHP(), 2);
    }

    @Test
    public void testConsumeConsumedNotConsumable() {
        Esine potion = new Esine("Potion", "HP:20", "Palauttaa 20HP", false, false);
        tulkki.consume(potion);
        assertFalse(potion.getConsumed());
    }

    @Test
    public void testConsumeOminaisuusAlreadyConsumed() {
        Esine potion = new Esine("Potion", "HP:20", "Palauttaa 20HP", false, true);
        hahmo.addHP(-22);
        tulkki.consume(potion);
        tulkki.consume(potion);
        assertEquals(hahmo.getHP(), 22);
    }

    @Test
    public void testEquipOminaisuus() {
        Esine miekka = new Esine("Miekka", "STR:3", "Voima +3", true, false);
        tulkki.equip(miekka);
        assertEquals(hahmo.getStr(), 11);
    }

    @Test
    public void testEquipEquiped() {
        Esine miekka = new Esine("Miekka", "STR:3", "Voima +3", true, false);
        tulkki.equip(miekka);
        assertTrue(miekka.getEquiped());
    }

    @Test
    public void testEquipOminaisuusNotEquipable() {
        Esine miekka = new Esine("Miekka", "STR:3", "Voima +3", false, false);
        tulkki.equip(miekka);
        assertEquals(hahmo.getStr(), 8);
    }

    @Test
    public void testEquipEquipedNotEquipable() {
        Esine miekka = new Esine("Miekka", "STR:3", "Voima +3", false, false);
        tulkki.equip(miekka);
        assertFalse(miekka.getEquiped());
    }

    @Test
    public void testEquipOminaisuusAlreadyEquiped() {
        Esine miekka = new Esine("Miekka", "STR:3", "Voima +3", true, false);
        tulkki.equip(miekka);
        tulkki.equip(miekka);
        assertEquals(hahmo.getStr(), 11);
    }

    @Test
    public void testUnEquipOminaisuus() {
        Esine miekka = new Esine("Miekka", "STR:3", "Voima +3", true, false);
        tulkki.equip(miekka);
        tulkki.unEquip(miekka);
        assertEquals(hahmo.getStr(), 8);
    }

    @Test
    public void testUnEquipEquiped() {
        Esine miekka = new Esine("Miekka", "STR:3", "Voima +3", true, false);
        tulkki.equip(miekka);
        tulkki.unEquip(miekka);
        assertFalse(miekka.getEquiped());
    }

    @Test
    public void testUnEquipOminaisuusNotEquiped() {
        Esine miekka = new Esine("Miekka", "STR:3", "Voima +3", true, false);
        tulkki.unEquip(miekka);
        assertEquals(hahmo.getStr(), 8);
    }
}
