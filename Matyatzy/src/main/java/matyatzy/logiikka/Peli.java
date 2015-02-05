package matyatzy.logiikka;

import java.util.HashMap;

public class Peli extends Nopat{

    private Pisteet pisteet;
    private Nopat nopat;
    private Yhdistelmat yhdistelmat;
    private int monestiHeitetty;

    public Peli() {
        this.pisteet = new Pisteet();
        this.nopat = new Nopat();
        this.yhdistelmat = new Yhdistelmat();
    }

    
    public Nopat palautaNopat() {
        return this.nopat;
    }
    
    public boolean heittojaJaljella() {
        if (this.monestiHeitetty >=3) {
            return false;
        }
        return true;
    }
    
    public void lisaaHeitto() {
        this.monestiHeitetty++;
    }
}
