package matyatzy.logiikka;

import java.util.HashMap;

public class Peli {

    private Pisteet pisteet;
    private Nopat nopat;
    private Yhdistelmat yhdistelmat;
    private int monestiHeitetty;

    public Peli() {
        this.pisteet = new Pisteet();
        this.nopat = new Nopat(5);
    }

    public void tulostaPisteet() {
        for (String yhdistelma : pisteet.getPisteet().keySet()) {
            System.out.println(yhdistelma + ": " + pisteet.getPisteet().get(yhdistelma));
        }
    }

    public void heitaNoppaa(String mitkaNopat) {
        for (int i = 0; i < mitkaNopat.length(); i++) {
            this.nopat.heitaNoppaa(Character.getNumericValue(mitkaNopat.charAt(i)));
        }
        this.monestiHeitetty++;

    }

    public void asetaPisteet(String yhdistelma) {
        this.pisteet.lisaaYhdistelmanPisteet(yhdistelma, yhdistelmat.palautaYhdistelmanPisteet(yhdistelma, nopat));
    }

    public boolean peliLoppu() {
        if (this.pisteet.getPisteet().containsValue(null)) {
            return false;
        }
        return true;

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
