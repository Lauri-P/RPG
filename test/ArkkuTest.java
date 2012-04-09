
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArkkuTest {

    Arkku arkku;
    Esine potion;
    Esine miekka;
    ArrayList<Esine> esineet;

    public ArkkuTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        arkku = new Arkku();
        potion = new Esine("Potion", "HP:20", "Palauttaa 20HP", false, true);
        miekka = new Esine("Miekka", "STR:3", "Voima +3", true, false);
        esineet = new ArrayList<>();
        esineet.add(miekka);
        esineet.add(potion);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testLuonti() {
        assertTrue(arkku.getEsineet().isEmpty());
    }

    @Test
    public void testAddEsine() {
        arkku.addEsine(potion);
        assertTrue(arkku.getEsineet().contains(potion));
    }

    @Test
    public void testSetEsineet() {
        arkku.setEsineet(esineet);
        assertTrue(arkku.getEsineet().containsAll(esineet));
    }

    @Test
    public void testRemoveEsine() {
        arkku.setEsineet(esineet);
        arkku.removeEsine(miekka);
        assertTrue(arkku.getEsineet().contains(potion));
        assertTrue(!arkku.getEsineet().contains(miekka));
    }

    @Test
    public void testRemoveAll() {
        arkku.setEsineet(esineet);
        arkku.removeAll();
        assertTrue(arkku.getEsineet().isEmpty());
    }
}
