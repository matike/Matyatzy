package matyatzy.matyatzy;

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
        nopat = new Nopat(5);
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
}
