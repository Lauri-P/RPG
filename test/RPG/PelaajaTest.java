package RPG;


import RPG.Pelaaja;
import org.junit.*;
import static org.junit.Assert.*;

public class PelaajaTest {

    Pelaaja soturi;
    Pelaaja maagi;

    public PelaajaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        soturi = new Pelaaja(12, 12, 8);
        maagi = new Pelaaja(8, 8, 8, 8);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSoturinLuontiStr() {
        assertEquals(soturi.getStr(), 12);
    }

    @Test
    public void testSoturinLuontiVit() {
        assertEquals(soturi.getVit(), 12);
    }

    @Test
    public void testSoturinLuontiLck() {
        assertEquals(soturi.getLck(), 8);
    }

    @Test
    public void testSoturinLuontiIntl() {
        assertEquals(soturi.getIntl(), 0);
    }

    @Test
    public void testSoturinLuontiHP() {
        assertEquals(soturi.getHP(), 36);
    }

    @Test
    public void testSoturinLuontiMP() {
        assertEquals(soturi.getMP(), 0);
    }

    @Test
    public void testSoturinLuontiMaxHP() {
        assertEquals(soturi.getMaxHP(), 36);
    }

    @Test
    public void testSoturinLuontiMaxMP() {
        assertEquals(soturi.getMaxMP(), 0);
    }

    @Test
    public void testSoturinLuontiInventory() {
        assertTrue(soturi.getInventory().getEsineet().isEmpty());
    }

    @Test
    public void testSoturinLuontiTaiat() {
        assertTrue(soturi.getTaiat().isEmpty());
    }

    @Test
    public void testSoturinLuontiExp() {
        assertEquals(soturi.getExp(), 0);
    }

    @Test
    public void testSoturinLuontiLvl() {
        assertEquals(soturi.getLvl(), 1);
    }

    @Test
    public void testMaaginLuontiStr() {
        assertEquals(maagi.getStr(), 8);
    }

    @Test
    public void testMaaginLuontiVit() {
        assertEquals(maagi.getVit(), 8);
    }

    @Test
    public void testMaaginLuontiLck() {
        assertEquals(maagi.getLck(), 8);
    }

    @Test
    public void testMaaginLuontiIntl() {
        assertEquals(maagi.getIntl(), 8);
    }

    @Test
    public void testMaaginLuontiHP() {
        assertEquals(maagi.getHP(), 24);
    }

    @Test
    public void testMaaginLuontiMP() {
        assertEquals(maagi.getMP(), 16);
    }

    @Test
    public void testMaaginLuontiMaxHP() {
        assertEquals(maagi.getMaxHP(), 24);
    }

    @Test
    public void testMaaginLuontiMaxMP() {
        assertEquals(maagi.getMaxMP(), 16);
    }

    @Test
    public void testMaaginLuontiInventory() {
        assertTrue(maagi.getInventory().getEsineet().isEmpty());
    }

    @Test
    public void testMaaginLuontiTaiat() {
        assertTrue(maagi.getTaiat().isEmpty());
    }

    @Test
    public void testMaaginLuontiExp() {
        assertEquals(maagi.getExp(), 0);
    }

    @Test
    public void testMaaginLuontiLvl() {
        assertEquals(maagi.getLvl(), 1);
    }

    @Test
    public void testPaivitaMaximitStrHP() {
        maagi.addStr(1);
        maagi.paivitaMaximit();
        assertEquals(maagi.getMaxHP(), 25);
    }

    @Test
    public void testPaivitaMaximitVitHP() {
        maagi.addVit(1);
        maagi.paivitaMaximit();
        assertEquals(maagi.getMaxHP(), 26);
    }

    @Test
    public void testPaivitaMaximitIntlMP() {
        maagi.addIntl(1);
        maagi.paivitaMaximit();
        assertEquals(maagi.getMaxMP(), 18);
    }

    @Test
    public void testSetExp() {
        maagi.setExp(1000);
        assertEquals(maagi.getExp(), 1000);
    }

    @Test
    public void testSetExpNeg() {
        maagi.setExp(-1000);
        assertEquals(maagi.getExp(), -1000);
    }

    @Test
    public void testSetLvl() {
        maagi.setLvl(8);
        assertEquals(maagi.getLvl(), 8);
    }

    @Test
    public void testSetLvlNeg() {
        maagi.setLvl(-8);
        assertEquals(maagi.getLvl(), -8);
    }

    @Test
    public void testAddLvl() {
        maagi.addLvl(1);
        assertEquals(maagi.getLvl(), 2);
    }

    @Test
    public void testAddLvlNeg() {
        maagi.addLvl(-2);
        assertEquals(maagi.getLvl(), -1);
    }

    @Test
    public void testLevelUpLiaanVahanLvl() {
        maagi.setExp(50);
        maagi.levelUp();
        assertEquals(maagi.getLvl(), 1);
    }

    @Test
    public void testLevelUpTasanLvl() {
        maagi.setExp(100);
        maagi.levelUp();
        assertEquals(maagi.getLvl(), 2);
    }

    @Test
    public void testLevelUpYliLvl() {
        maagi.setExp(150);
        maagi.levelUp();
        assertEquals(maagi.getLvl(), 2);
    }

    @Test
    public void testLevelUpMonenVerranLvl() {
        maagi.setExp(1000);
        maagi.levelUp();
        assertEquals(maagi.getLvl(), 5);
    }

    @Test
    public void testLevelUpLiaanVahanExp() {
        maagi.setExp(50);
        maagi.levelUp();
        assertEquals(maagi.getExp(), 50);
    }

    @Test
    public void testLevelUpTasanExp() {
        maagi.setExp(100);
        maagi.levelUp();
        assertEquals(maagi.getExp(), 0);
    }

    @Test
    public void testLevelUpYliExp() {
        maagi.setExp(150);
        maagi.levelUp();
        assertEquals(maagi.getExp(), 50);
    }

    @Test
    public void testLevelUpMonenVerranExp() {
        maagi.setExp(1050);
        maagi.levelUp();
        assertEquals(maagi.getExp(), 50);
    }

    @Test
    public void testAddExpAlle() {
        maagi.addExp(50);
        assertEquals(maagi.getExp(), 50);
    }

    @Test
    public void testAddExpTasan() {
        maagi.addExp(100);
        assertEquals(maagi.getExp(), 0);
    }

    @Test
    public void testAddExpYli() {
        maagi.addExp(150);
        assertEquals(maagi.getExp(), 50);
    }
}
