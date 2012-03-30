import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TaikaTest {
    
    public TaikaTest() {
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
    public void testLuonti1Tyyppi() {
        Taika taika=new Taika("Tulipallo", "Tuli", 2, 8);
        assertEquals(taika.getNimi(), "Tulipallo");
        assertTrue(taika.getTyyppi().contains("Tuli"));
        assertEquals(taika.getHinta(), 2);
        assertEquals(taika.getTeho(), 8);
    }
    
    @Test
    public void testLuontiMoniTyyppi() {
        ArrayList<String> tyyppi=new ArrayList<>();
        tyyppi.add("Tuli");
        tyyppi.add("Vesi");
        Taika taika=new Taika("Tulipallo", tyyppi, 2, 8);
        assertEquals(taika.getNimi(), "Tulipallo");
        assertTrue(taika.getTyyppi().contains("Tuli"));
        assertTrue(taika.getTyyppi().contains("Vesi"));
        assertEquals(taika.getHinta(), 2);
        assertEquals(taika.getTeho(), 8);
    }
    
    @Test
    public void testSetterit() {
        ArrayList<String> tyyppi=new ArrayList<>();
        tyyppi.add("Tuli");
        tyyppi.add("Vesi");
        Taika taika=new Taika("Tulipallo", tyyppi, 2, 8);
        assertEquals(taika.getNimi(), "Tulipallo");
        assertTrue(taika.getTyyppi().contains("Tuli"));
        assertTrue(taika.getTyyppi().contains("Vesi"));
        assertEquals(taika.getHinta(), 2);
        assertEquals(taika.getTeho(), 8);
    }
}
