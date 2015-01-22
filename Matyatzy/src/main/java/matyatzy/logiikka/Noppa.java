package matyatzy.logiikka;

import java.util.*;

public class Noppa {
    
    private Random random;
    private int arvo;
    
    public Noppa() {
        this.random = new Random();
    }
       
    public void heitaNoppaa() {       
        this.arvo = this.random.nextInt(5)+1;
    }

    public int getArvo() {
        return this.arvo;
    }

    public void setArvo(int arvo) {
        this.arvo = arvo;
    }

    
    
    
    
}
