import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class EsineTest {
    
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
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testTyhjäLuonti() {
        Esine esine=new Esine();
        assertTrue(!(esine.getConsumable()||esine.getConsumed()||esine.getEquipable()||esine.getEquiped()));
        assertEquals(esine.getNimi(), "EI NIMEÄ");
        assertEquals(esine.getOminaisuudet(), "");
        assertEquals(esine.getKuvaus(), "EI KUVAUSTA");
    }
    
    @Test
    public void testLuonti() {
        Esine esine=new Esine("Potion", "HP:20", false, true);
        assertTrue(!(!esine.getConsumable()||esine.getConsumed()||esine.getEquipable()||esine.getEquiped()));
        assertEquals(esine.getNimi(), "Potion");
        assertEquals(esine.getOminaisuudet(), "HP:20");
        assertEquals(esine.getKuvaus(), "EI KUVAUSTA");
    }
    
    @Test
    public void testLuontiKuvauksella() {
        Esine esine = new Esine("Potion", "HP:20", "Palauttaa 20HP", false, true);
        assertTrue(!(!esine.getConsumable()||esine.getConsumed()||esine.getEquipable()||esine.getEquiped()));
        assertEquals(esine.getNimi(), "Potion");
        assertEquals(esine.getOminaisuudet(), "HP:20");
        assertEquals(esine.getKuvaus(), "Palauttaa 20HP");
    }

    @Test
    public void testSetterit() {
        Esine esine=new Esine();
        assertTrue(!(esine.getConsumable()||esine.getConsumed()||esine.getEquipable()||esine.getEquiped()));
        assertEquals(esine.getNimi(), "EI NIMEÄ");
        assertEquals(esine.getOminaisuudet(), "");
        assertEquals(esine.getKuvaus(), "EI KUVAUSTA");
        
        esine.setConsumable(true);
        esine.setConsumed(true);
        esine.setEquipable(true);
        esine.setEquiped(true);
        esine.setNimi("Potion");
        esine.setOminaisuudet("HP:20");
        esine.setKuvaus("Palauttaa 20HP");
        
        assertTrue(esine.getConsumable()&&esine.getConsumed()&&esine.getEquipable()&&esine.getEquiped());
        assertEquals(esine.getNimi(), "Potion");
        assertEquals(esine.getOminaisuudet(), "HP:20");
        assertEquals(esine.getKuvaus(), "Palauttaa 20HP");
    }
    
}
