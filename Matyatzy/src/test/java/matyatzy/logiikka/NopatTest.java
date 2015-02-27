package matyatzy.logiikka;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class NopatTest {
    
    private Nopat nopat;
    
    public NopatTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        nopat = new Nopat();
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void nopanHeittoToimii() {
        assertEquals(0, nopat.palautaNopanArvo(1));
        nopat.heitaNoppaa(1);
        
        assertTrue(nopat.palautaNopanArvo(1) >= 1);
        assertTrue(nopat.palautaNopanArvo(1) <=6);
    }
    
    @Test
    public void noppienSummaOnOikein() {
        nopat.asetaNopanArvo(1, 2);
        nopat.asetaNopanArvo(2, 4);
        nopat.asetaNopanArvo(3, 1);
        nopat.asetaNopanArvo(4, 6);
        nopat.asetaNopanArvo(5, 2);
        
        assertEquals(15, nopat.palautaNoppienSumma());
    }
    
    @Test
    public void vaaraaArvoaEiVoiAsettaa() {
        nopat.asetaNopanArvo(1, 1);
        nopat.asetaNopanArvo(1, -1);
        assertEquals(1, nopat.palautaNopanArvo(1));
        nopat.asetaNopanArvo(1, 53);
        assertEquals(1, nopat.palautaNopanArvo(1));
    }
}
