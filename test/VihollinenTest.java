
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VihollinenTest {

    public VihollinenTest() {
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
    public void testLuonti() {
        Vihollinen vihu = new Vihollinen(1, 2, 3, 4);
        assertEquals(vihu.getHP(), 5);
        assertEquals(vihu.getMP(), 8);
        assertTrue(vihu.getWeak().isEmpty());
    }

    @Test
    public void testHeikkoudet() {
        Vihollinen vihu = new Vihollinen();
        ArrayList<String> heikkoudet = new ArrayList<>();
        heikkoudet.add("Tuli");
        heikkoudet.add("Vesi");
        vihu.setWeak(heikkoudet);
        assertTrue(vihu.getWeak().containsAll(heikkoudet));
        vihu.addWeak("Maa");
        assertTrue(vihu.getWeak().containsAll(heikkoudet));
        assertTrue(vihu.getWeak().contains("Maa"));
    }
}
