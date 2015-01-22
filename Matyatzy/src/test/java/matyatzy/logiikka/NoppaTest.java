/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package matyatzy.logiikka;

import matyatzy.logiikka.Noppa;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class NoppaTest {
    
    private Noppa noppa;
    
    public NoppaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        noppa = new Noppa();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void arvonAsetusToimii() {
        noppa.setArvo(4);
        assertEquals(4, noppa.getArvo());
        noppa.setArvo(2);
        assertEquals(2, noppa.getArvo());
    }
    
    
    
}
