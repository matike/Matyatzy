package matyatzy.logiikka;

import java.util.HashMap;

public class Peli extends Nopat{

    private Nopat nopat;
    private Yhdistelmat yhdistelmat;
    private int monestiHeitetty;
    private HashMap<String, Integer> pisteet;
    private boolean pisteetAsetettu;

    public Peli() {
        this.pisteet = new HashMap();
        this.nopat = new Nopat();
        this.yhdistelmat = new Yhdistelmat();
        this.pisteetAsetettu=true;
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
    public void nollaaHeitot() {
        this.monestiHeitetty = 0;
    }
    
    public void lisaaPisteet(String yhdistelma, int pisteet) {
        this.pisteet.put(yhdistelma, pisteet);
    }
    
    public int palautaYhteisPisteet() {
        int yhteispisteet = 0;
        for (String yhdistelma : this.pisteet.keySet()) {
            yhteispisteet+=this.pisteet.get(yhdistelma);
        }
        return yhteispisteet;
    }
    
    public void onkoPisteetAsetettu(boolean onko) {
        this.pisteetAsetettu = onko;
    }
    
    public boolean getPisteetAsetettu() {
        return this.pisteetAsetettu;
    }
}
