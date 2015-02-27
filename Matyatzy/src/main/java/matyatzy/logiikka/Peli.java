package matyatzy.logiikka;

import java.util.HashMap;

/**
 * Luokka luo uuden Yatzy-pelin ja tarjoaa sen käsittelyyn tarvittavia metodeja.
 * @author matti
 */
public class Peli extends Yhdistelmat {

    private Nopat nopat;
    private int monestiHeitetty;
    private HashMap<String, Integer> pisteet;
    private boolean pisteetAsetettu;

    /**
     * Luo uuden Peli-olion.
     */
    public Peli() {
        
        this.pisteet = new HashMap();
        this.nopat = new Nopat();
        this.pisteetAsetettu = false;
    }

    /**
     * Metodi palauttaa pelin nopat.
     *
     * @return pelissä käytettävät Nopat
     */
    public Nopat palautaNopat() {
        return this.nopat;
    }

    /**
     * Metodi tarkistaa onko pelaajalla vielä heittoja jäljellä tällä vuorolla
     * ja palauttaa true, jos niitä on.
     *
     * @return
     */
    public boolean onkoHeittojaJaljella() {
        if (this.monestiHeitetty >= 3) {
            return false;
        }
        return true;
    }

    /**
     * Metodi lisää heiton tälle vuorolle.
     */
    public void lisaaHeitto() {
        this.monestiHeitetty++;
    }

    /**
     * Metodi nollaa vuoron heitot.
     */
    public void nollaaHeitot() {
        this.monestiHeitetty = 0;
    }

    /**
     * Metodi lisää pisteet parametrina annetulle yhdistelmälle.
     *
     * @param yhdistelma halutun yhdistelmän nimi merkkijonona
     * @param pisteet pisteet annetulle yhdistelmälle
     */
    public void lisaaPisteet(String yhdistelma, int pisteet) {
        this.pisteet.put(yhdistelma, pisteet);
        
    }

    /**
     * Metodi palauttaa parametrina annetun yhdistelmän pisteet.
     *
     * @param yhdistelma halutun yhdistelmän nimi merkkijonona
     * @return annetun yhdistelmän pisteet
     */
    public int palautaYhdistelmanPisteet(String yhdistelma) {
        if (this.pisteet.containsKey(yhdistelma)) {
            return this.pisteet.get(yhdistelma);
        }
        return 0;
    }

    /**
     * Metodi palauttaa pelin yhteispisteet.
     *
     * @return pelin yhteispisteet
     */
    public int palautaYhteispisteet() {
        int yhteispisteet = 0;
        for (String yhdistelma : this.pisteet.keySet()) {
            yhteispisteet += this.pisteet.get(yhdistelma);
        }
        return yhteispisteet;
    }

    /**
     * Metodia käytetään merkitsemään onko pelaaja vielä asettanut pisteitä
     * tulostaululle tällä vuorolla.
     *
     * @param onko jos annetaan true, pelaaja on asettanut pisteitä, jos false niin ei
     */
    public void onkoPisteetAsetettu(boolean onko) {
        this.pisteetAsetettu = onko;
    }

    public boolean getPisteetAsetettu() {
        return this.pisteetAsetettu;
    }

    /**
     * Metodi tarkistaa onko pelaaja oikeutettu pisteisiin bonuksesta. Palauttaa true, jos on, false jos ei.
     * @return true jos pelin pisteistä muodostoo bonus, false jos ei
     */
    public boolean onkoBonus() {
        int bonus = 0;
        bonus += palautaYhdistelmanPisteet("ykköset");
        bonus += palautaYhdistelmanPisteet("kakkoset");
        bonus += palautaYhdistelmanPisteet("kolmoset");
        bonus += palautaYhdistelmanPisteet("neloset");
        bonus += palautaYhdistelmanPisteet("viitoset");
        bonus += palautaYhdistelmanPisteet("kuutoset");
        if (bonus >= 63) {
            return true;
        }
        return false;
    }
    
    /**
     * Tarkistaa onko peli loppunut, eli onko kaikille yhdistelmille asetettu pisteet.
     * @return true, jos peli on päättynyt, false jos ei
     */
    public boolean onkoPeliLoppu() {
        if (this.pisteet.containsKey("bonus")) {
            return this.pisteet.size() >= 16;
        }
        else {
            return this.pisteet.size() >= 15;
        }
    } 

    public int getMonestiHeitetty() {
        return monestiHeitetty;
    }

    public HashMap<String, Integer> getPisteet() {
        return pisteet;
    }
    
    
    
}
