package matyatzy.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class YhdistelmatTest {
    Yhdistelmat yhdistelmat;
    Nopat nopat;
    
    public YhdistelmatTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        yhdistelmat = new Yhdistelmat();
        nopat = new Nopat(5);
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void ykkosetLasketaanOikein() {
        nopat.asetaNopanArvo(1, 1);
        nopat.asetaNopanArvo(3, 1);
        assertEquals(2, yhdistelmat.ykkoset(nopat));
        nopat.asetaNopanArvo(5, 1);
        assertEquals(3, yhdistelmat.ykkoset(nopat));
        
        
    }
}
