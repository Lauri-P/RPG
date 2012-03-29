/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lauri
 */
public class ArkkuTest {

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
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addEsine method, of class Arkku.
     */
    @Test
    public void testLuonti() {

        Arkku arkku = new Arkku();
        assertTrue(arkku.getEsineet().isEmpty());

    }

    @Test
    public void testLisays() {

        Arkku arkku = new Arkku();
        Esine potion = new Esine("Potion", "HP:20", "Palauttaa 20HP", false, true);
        arkku.addEsine(potion);
        assertTrue(arkku.getEsineet().contains(potion));
    }

    @Test
    public void testMoniLisays() {

        Arkku arkku = new Arkku();
        Esine potion = new Esine("Potion", "HP:20", "Palauttaa 20HP", false, true);
        Esine miekka = new Esine("Miekka", "STR:3", "Voima +3", true, false);
        ArrayList<Esine> esineet = new ArrayList<Esine>();
        esineet.add(miekka);
        esineet.add(potion);
        arkku.setEsineet(esineet);
        assertTrue(arkku.getEsineet().contains(potion));
        assertTrue(arkku.getEsineet().contains(miekka));
    }

    @Test
    public void testPoisto() {

        Arkku arkku = new Arkku();
        Esine potion = new Esine("Potion", "HP:20", "Palauttaa 20HP", false, true);
        Esine miekka = new Esine("Miekka", "STR:3", "Voima +3", true, false);
        ArrayList<Esine> esineet = new ArrayList<Esine>();
        esineet.add(miekka);
        esineet.add(potion);
        arkku.setEsineet(esineet);
        arkku.removeEsine(miekka);
        assertTrue(arkku.getEsineet().contains(potion));
        assertTrue(!arkku.getEsineet().contains(miekka));
    }

    @Test
    public void testPoistaKaikki() {

        Arkku arkku = new Arkku();
        Esine potion = new Esine("Potion", "HP:20", "Palauttaa 20HP", false, true);
        Esine miekka = new Esine("Miekka", "STR:3", "Voima +3", true, false);
        ArrayList<Esine> esineet = new ArrayList<Esine>();
        esineet.add(miekka);
        esineet.add(potion);
        arkku.setEsineet(esineet);
        arkku.removeAll();
        assertTrue(arkku.getEsineet().isEmpty());
    }
}
