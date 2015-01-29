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

/**
 *
 * @author matti
 */
public class PistelistaTest {
    
    Yhdistelmat yhdistelmat;
    Nopat nopat;
    Pistelista pistelista;
    
    public PistelistaTest() {
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
        pistelista = new Pistelista();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void yhdistelmanPisteetLisataanOikein() {
        nopat.asetaNopanArvo(1, 2);
        nopat.asetaNopanArvo(2, 1);
        nopat.asetaNopanArvo(3, 2);
        nopat.asetaNopanArvo(4, 5);
        nopat.asetaNopanArvo(5, 2);
        pistelista.lisaaYhdistelmanPisteet("kolmiluku", yhdistelmat.kolmiluku(nopat));
        assertEquals(6, pistelista.palautaYhdistelmanPisteet("kolmiluku"));
    }
}
