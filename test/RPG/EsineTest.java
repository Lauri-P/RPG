package RPG;


import RPG.Esine;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class EsineTest {

    Esine tyhja;
    Esine potion;
    Esine miekka;

    public EsineTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        tyhja = new Esine();
        potion = new Esine("Potion", "HP:20", false, true);
        miekka = new Esine("Miekka", "STR:4", "Voima +4", true, false);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testTyhjäLuontiConsumableFalse() {
        assertFalse(tyhja.getConsumable());
    }

    @Test
    public void testTyhjäLuontiConsumedFalse() {
        assertFalse(tyhja.getConsumed());
    }

    @Test
    public void testTyhjäLuontiEquipableFalse() {
        assertFalse(tyhja.getEquipable());
    }

    @Test
    public void testTyhjäLuontiEquipedFalse() {
        assertFalse(tyhja.getEquiped());
    }

    @Test
    public void testTyhjäLuontiEiNimea() {
        assertEquals(tyhja.getNimi(), "EI NIMEÄ");
    }

    @Test
    public void testTyhjäLuontiEiOminaisuuksia() {
        assertEquals(tyhja.getOminaisuudet(), "");
    }

    @Test
    public void testTyhjäLuontiEiKuvausta() {
        assertEquals(tyhja.getKuvaus(), "EI KUVAUSTA");
    }

    @Test
    public void testPotionLuontiConsumableTrue() {
        assertTrue(potion.getConsumable());
    }

    @Test
    public void testPotionLuontiConsumedFalse() {
        assertFalse(potion.getConsumed());
    }

    @Test
    public void testPotionLuontiEquipableFalse() {
        assertFalse(potion.getEquipable());
    }

    @Test
    public void testPotionLuontiEquipedFalse() {
        assertFalse(potion.getEquiped());
    }

    @Test
    public void testPotionLuontiNimiOikein() {
        assertEquals(potion.getNimi(), "Potion");
    }

    @Test
    public void testPotionLuontiOminaisuudetOikein() {
        assertEquals(potion.getOminaisuudet(), "HP:20");
    }

    @Test
    public void testPotionLuontiEiKuvausta() {
        assertEquals(potion.getKuvaus(), "EI KUVAUSTA");
    }

    @Test
    public void testMiekkaLuontiConsumableFalse() {
        assertFalse(miekka.getConsumable());
    }

    @Test
    public void testMiekkaLuontiConsumedFalse() {
        assertFalse(miekka.getConsumed());
    }

    @Test
    public void testMiekkaLuontiEquipableTrue() {
        assertTrue(miekka.getEquipable());
    }

    @Test
    public void testMiekkaLuontiEquipedFalse() {
        assertFalse(miekka.getEquiped());
    }

    @Test
    public void testMiekkaLuontiNimiOikein() {
        assertEquals(miekka.getNimi(), "Miekka");
    }

    @Test
    public void testMiekkaLuontiOminaisuudetOikein() {
        assertEquals(miekka.getOminaisuudet(), "STR:4");
    }

    @Test
    public void testMiekkaLuontiEiKuvausta() {
        assertEquals(miekka.getKuvaus(), "Voima +4");
    }

    @Test
    public void testSetConsumableTrue() {
        tyhja.setConsumable(true);
        assertTrue(tyhja.getConsumable());
    }

    @Test
    public void testSetConsumedTrue() {
        tyhja.setConsumed(true);
        assertTrue(tyhja.getConsumed());
    }

    @Test
    public void testSetEquipableTrue() {
        tyhja.setEquipable(true);
        assertTrue(tyhja.getEquipable());
    }

    @Test
    public void testSetEquipedTrue() {
        tyhja.setEquiped(true);
        assertTrue(tyhja.getEquiped());
    }

    @Test
    public void testSetNimi() {
        tyhja.setNimi("Potion");
        assertEquals(tyhja.getNimi(), "Potion");
    }

    @Test
    public void testSetOminaisuudet() {
        tyhja.setOminaisuudet("HP:30,MP:10");
        assertEquals(tyhja.getOminaisuudet(), "HP:30,MP:10");
    }

    @Test
    public void testSetKuvaus() {
        tyhja.setKuvaus("Palauttaa 30HP ja 10MP");
        assertEquals(tyhja.getKuvaus(), "Palauttaa 30HP ja 10MP");
    }
}
