/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matyatzy.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PeliTest {

    private Peli peli;

    public PeliTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.peli = new Peli();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void heittojenLisaysToimii() {
        assertEquals(true, this.peli.onkoHeittojaJaljella());
        this.peli.lisaaHeitto();
        assertEquals(true, this.peli.onkoHeittojaJaljella());
        this.peli.lisaaHeitto();
        assertEquals(true, this.peli.onkoHeittojaJaljella());
        this.peli.lisaaHeitto();
        assertEquals(false, this.peli.onkoHeittojaJaljella());

    }
    
    @Test
    public void pisteidenLisaysToimii() {
        this.peli.lisaaPisteet("ykköset", 1);
        assertEquals(1, this.peli.palautaYhdistelmanPisteet("ykköset"));        
    }
    
    @Test
    public void yhteispisteidenPalautusToimii() {
        this.peli.lisaaPisteet("ykköset", 1);
        this.peli.lisaaPisteet("mökki", 12);
        this.peli.lisaaPisteet("yatzy", 50);
        this.peli.lisaaPisteet("pari", 10);
        assertEquals(73, this.peli.palautaYhteisPisteet());
    }
    
    @Test
    public void toimiikoHeittojenNollaus() {
        assertEquals(true, this.peli.onkoHeittojaJaljella());
        this.peli.lisaaHeitto();
        this.peli.lisaaHeitto();
        this.peli.lisaaHeitto();
        assertEquals(false, this.peli.onkoHeittojaJaljella());
        this.peli.nollaaHeitot();
        assertEquals(true, this.peli.onkoHeittojaJaljella());
    }
    
    @Test
    public void toimiikoPisteidenAsetuksenTarkistus() {
        assertEquals(false, this.peli.getPisteetAsetettu());
        this.peli.onkoPisteetAsetettu(true);
        assertEquals(true, this.peli.getPisteetAsetettu());
    }
    
    @Test
    public void toimiikoBonuksenTarkistus() {
        assertEquals(false, this.peli.onkoBonus());
        this.peli.lisaaPisteet("ykköset", 3);
        this.peli.lisaaPisteet("kakkoset", 6);
        this.peli.lisaaPisteet("kolmoset", 9);
        this.peli.lisaaPisteet("neloset", 12);
        this.peli.lisaaPisteet("viitoset", 15);
        this.peli.lisaaPisteet("kuutoset", 0);
        assertEquals(false, this.peli.onkoBonus());
        this.peli.lisaaPisteet("kuutoset", 18);
        assertEquals(true, this.peli.onkoBonus());
        this.peli.lisaaPisteet("kuutoset", 24);
        assertEquals(true, this.peli.onkoBonus());
    }
}
