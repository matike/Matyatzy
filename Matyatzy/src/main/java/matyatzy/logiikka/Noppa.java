package matyatzy.logiikka;

import java.util.*;

/**
 * Luokka tarjoaa metodeja nopan arvon käsittelyä ja arpomista varten
 * @author matti
 */
public class Noppa {
    
    private Random random;
    private int arvo;
    
    public Noppa() {
        this.random = new Random();
    }
       
    /**
     * Metodi palauttaa satunnaisen luvun valilta 1-6
     */
    public void heitaNoppaa() {       
        this.arvo = this.random.nextInt(6)+1;
    }

    public int getArvo() {
        return this.arvo;
    }

    public void setArvo(int arvo) {
        if (arvo >=1 && arvo <=6) {
        this.arvo = arvo;
        }
    }

    
    
    
    
}
