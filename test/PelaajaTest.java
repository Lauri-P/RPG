/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Koti
 */
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
        soturi=new Pelaaja(12,12,8);
        maagi=new Pelaaja(8,8,8,8);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSoturinLuonti() {
        
        assertEquals(soturi.getStr(), 12);
        assertEquals(soturi.getVit(), 12);
        assertEquals(soturi.getLck(), 8);
        assertEquals(soturi.getIntl(), 0);
    }
    
    @Test
    public void testSoturinHPMP() {
        
        assertEquals(soturi.getMaxHP(), 36);
        assertEquals(soturi.getMaxMP(), 0);
        assertEquals(soturi.getHP(), 36);
        assertEquals(soturi.getMP(), 0);
    }
    
    @Test
    public void testMaaginLuonti() {
        
        assertEquals(maagi.getStr(), 8);
        assertEquals(maagi.getVit(), 8);
        assertEquals(maagi.getLck(), 8);
        assertEquals(maagi.getIntl(), 8);
    }
    
    @Test
    public void testMaaginHPMP() {
        
        assertEquals(maagi.getMaxHP(), 24);
        assertEquals(maagi.getMaxMP(), 16);
        assertEquals(maagi.getHP(), 24);
        assertEquals(maagi.getMP(), 16);
    }
    
    @Test
    public void testMaaginVahingoitus() {
        
        assertEquals(maagi.getMaxHP(), 24);
        assertEquals(maagi.getMaxMP(), 16);
        assertEquals(maagi.getHP(), 24);
        assertEquals(maagi.getMP(), 16);
        
        maagi.addHP(-8);
        
        assertEquals(maagi.getMaxHP(), 24);
        assertEquals(maagi.getMaxMP(), 16);
        assertEquals(maagi.getHP(), 16);
        assertEquals(maagi.getMP(), 16);
        
        maagi.addHP(10);
        
        assertEquals(maagi.getMaxHP(), 24);
        assertEquals(maagi.getMaxMP(), 16);
        assertEquals(maagi.getHP(), 24);
        assertEquals(maagi.getMP(), 16);
        
        maagi.addHP(-18);
        
        assertEquals(maagi.getMaxHP(), 24);
        assertEquals(maagi.getMaxMP(), 16);
        assertEquals(maagi.getHP(), 6);
        assertEquals(maagi.getMP(), 16);
        
        maagi.addHP(-18);
        
        assertEquals(maagi.getMaxHP(), 24);
        assertEquals(maagi.getMaxMP(), 16);
        assertEquals(maagi.getHP(), 0);
        assertEquals(maagi.getMP(), 16);
        
    }
    
    @Test
    public void testMaaginTaiat() {
        
        assertEquals(maagi.getMaxHP(), 24);
        assertEquals(maagi.getMaxMP(), 16);
        assertEquals(maagi.getHP(), 24);
        assertEquals(maagi.getMP(), 16);
        
        maagi.addMP(-8);
        
        assertEquals(maagi.getMaxHP(), 24);
        assertEquals(maagi.getMaxMP(), 16);
        assertEquals(maagi.getHP(), 24);
        assertEquals(maagi.getMP(), 8);
        
        maagi.addMP(10);
        
        assertEquals(maagi.getMaxHP(), 24);
        assertEquals(maagi.getMaxMP(), 16);
        assertEquals(maagi.getHP(), 24);
        assertEquals(maagi.getMP(), 16);
        
        maagi.addMP(-12);
        
        assertEquals(maagi.getMaxHP(), 24);
        assertEquals(maagi.getMaxMP(), 16);
        assertEquals(maagi.getHP(), 24);
        assertEquals(maagi.getMP(), 4);
        
        maagi.addMP(-18);
        
        assertEquals(maagi.getMaxHP(), 24);
        assertEquals(maagi.getMaxMP(), 16);
        assertEquals(maagi.getHP(), 24);
        assertEquals(maagi.getMP(), 0);
        
    }
    
    @Test
    public void testSoturinLevelit() {
        assertEquals(soturi.getExp(),0);
        assertEquals(soturi.getLvl(),1);
        soturi.addExp(50);
        assertEquals(soturi.getExp(),50);
        assertEquals(soturi.getLvl(),1);
        
        soturi.addHP(-20);
        assertEquals(soturi.getHP(), 16);
        soturi.addExp(150);
        assertEquals(soturi.getExp(),100);
        assertEquals(soturi.getLvl(),2);
        
        assertEquals(soturi.getStr(), 14);
        assertEquals(soturi.getVit(), 14);
        assertEquals(soturi.getIntl(), 0);
        
        assertEquals(soturi.getMaxHP(), 42);
        assertEquals(soturi.getMaxMP(), 0);
        assertEquals(soturi.getHP(), 42);
        assertEquals(soturi.getMP(), 0);
    }
    
    @Test
    public void testMaaginLevelitMonta() {
        maagi.addExp(1000);
        assertEquals(maagi.getExp(),0);
        assertEquals(maagi.getLvl(),5);
        
        assertEquals(maagi.getStr(), 12);
        assertEquals(maagi.getVit(), 12);
        assertEquals(maagi.getIntl(), 12);
        
        assertEquals(maagi.getMaxHP(), 36);
        assertEquals(maagi.getMaxMP(), 24);
        assertEquals(maagi.getHP(), 36);
        assertEquals(maagi.getMP(), 24);
    }
}
