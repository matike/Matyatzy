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
        nopat = new Nopat();
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

    @Test
    public void kolmilukuLasketaanOikein() {
        nopat.asetaNopanArvo(1, 2);
        nopat.asetaNopanArvo(2, 1);
        nopat.asetaNopanArvo(3, 2);
        nopat.asetaNopanArvo(4, 5);
        nopat.asetaNopanArvo(5, 2);
        assertEquals(6, yhdistelmat.kolmiluku(nopat));
    }

    @Test
    public void nelilukuLasketaanOikein() {
        nopat.asetaNopanArvo(1, 2);
        nopat.asetaNopanArvo(2, 2);
        nopat.asetaNopanArvo(3, 2);
        nopat.asetaNopanArvo(4, 5);
        nopat.asetaNopanArvo(5, 2);
        assertEquals(6, yhdistelmat.kolmiluku(nopat));
    }

    @Test
    public void pariLasketaanOikein() {
        nopat.asetaNopanArvo(1, 2);
        nopat.asetaNopanArvo(2, 2);
        nopat.asetaNopanArvo(3, 4);
        nopat.asetaNopanArvo(4, 5);
        nopat.asetaNopanArvo(5, 6);
        assertEquals(4, yhdistelmat.pari(nopat));
        nopat.asetaNopanArvo(4, 6);
        assertEquals(12, yhdistelmat.pari(nopat));
    }

    @Test
    public void kaksiPariaLasketaanOikein() {
        nopat.asetaNopanArvo(1, 2);
        nopat.asetaNopanArvo(2, 2);
        nopat.asetaNopanArvo(3, 4);
        nopat.asetaNopanArvo(4, 5);
        nopat.asetaNopanArvo(5, 5);
        assertEquals(14, yhdistelmat.kaksiParia(nopat));
        //neliluku ei ole kaksi paria
        nopat.asetaNopanArvo(4, 2);
        nopat.asetaNopanArvo(3, 2);
        assertEquals(0, yhdistelmat.kaksiParia(nopat));
    }

    @Test
    public void mokkiLasketaanOikein() {
        nopat.asetaNopanArvo(1, 2);
        nopat.asetaNopanArvo(2, 2);
        nopat.asetaNopanArvo(3, 4);
        nopat.asetaNopanArvo(4, 5);
        nopat.asetaNopanArvo(5, 5);
        assertEquals(0, yhdistelmat.mokki(nopat));
        nopat.asetaNopanArvo(3, 5);
        assertEquals(19, yhdistelmat.mokki(nopat));
        //yatzy ei ole mokki
        nopat.asetaNopanArvo(1, 5);
        nopat.asetaNopanArvo(2, 5);
        assertEquals(0, yhdistelmat.mokki(nopat));
    }

    @Test
    public void isoSuoraLasketaanOikein() {
        nopat.asetaNopanArvo(1, 2);
        nopat.asetaNopanArvo(2, 4);
        nopat.asetaNopanArvo(3, 3);
        nopat.asetaNopanArvo(4, 6);
        nopat.asetaNopanArvo(5, 5);
        assertEquals(20, yhdistelmat.isoSuora(nopat));
        nopat.asetaNopanArvo(1, 1);
        assertEquals(0, yhdistelmat.isoSuora(nopat));
    }

    @Test
    public void pieniSuoraLasketaanOikein() {
        nopat.asetaNopanArvo(1, 1);
        nopat.asetaNopanArvo(2, 4);
        nopat.asetaNopanArvo(3, 3);
        nopat.asetaNopanArvo(4, 2);
        nopat.asetaNopanArvo(5, 5);
        assertEquals(15, yhdistelmat.pieniSuora(nopat));
        nopat.asetaNopanArvo(1, 2);
        assertEquals(0, yhdistelmat.pieniSuora(nopat));
    }

    @Test
    public void yatzyLasketaanOikein() {
        nopat.asetaNopanArvo(1, 1);
        nopat.asetaNopanArvo(2, 1);
        nopat.asetaNopanArvo(3, 1);
        nopat.asetaNopanArvo(4, 1);
        nopat.asetaNopanArvo(5, 1);
        assertEquals(50, yhdistelmat.yatzy(nopat));

    }
    
    @Test
    public void halutunYhdistelmanPistemaaranPalautusToimii() {
        nopat.asetaNopanArvo(1, 1);
        nopat.asetaNopanArvo(2, 1);
        nopat.asetaNopanArvo(3, 1);
        nopat.asetaNopanArvo(4, 5);
        nopat.asetaNopanArvo(5, 5);
        assertEquals(13, yhdistelmat.palautaYhdistelmanPisteet("mokki", nopat));
    }

}
