package matyatzy.logiikka;

import java.util.HashMap;

public class Peli extends Yhdistelmat {

    //private String[] mahdollisetYhdistelmat = {"ykköset", "kakkoset", "kolmoset", "neloset", "viitoset", "kuutoset", "pari", "kaksi paria", "kolmiluku", "neliluku", "mökki", "pieni suora", "iso suora", "sattuma", "yatzy"};
    private Nopat nopat;
    private Yhdistelmat yhdistelmat;
    private int monestiHeitetty;
    private HashMap<String, Integer> pisteet;
    private boolean pisteetAsetettu;

    /**
     * Luokka luo uuden yatzy-pelin ja tarjoaa metodeja sen ohjaamiseen
     */
    public Peli() {
        this.pisteet = new HashMap();
        this.nopat = new Nopat();
        this.pisteetAsetettu = false;
    }

    /**
     * Metodi palauttaa pelin nopat
     *
     * @return
     */
    public Nopat palautaNopat() {
        return this.nopat;
    }

    /**
     * Metodi tarkistaa onko pelaajalla vielä heittoja jäljellä tällä vuorolla
     * ja palauttaa true, jos niitä on
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
     * Metodi lisää heiton tälle vuorolle
     */
    public void lisaaHeitto() {
        this.monestiHeitetty++;
    }

    /**
     * Metodi nollaa vuoron heitot
     */
    public void nollaaHeitot() {
        this.monestiHeitetty = 0;
    }

    /**
     * Metodi lisää pisteet parametrina annetulle yhdistelmälle
     *
     * @param yhdistelma halutun yhdistelmän nimi merkkijonona
     * @param pisteet
     */
    public void lisaaPisteet(String yhdistelma, int pisteet) {
        this.pisteet.put(yhdistelma, pisteet);
    }

    /**
     * Metodi palauttaa parametrina annetun yhdistelmän pisteet
     *
     * @param yhdistelma halutun yhdistelmän nimi merkkijonona
     * @return
     */
    public int palautaYhdistelmanPisteet(String yhdistelma) {
        if (this.pisteet.containsKey(yhdistelma)) {
            return this.pisteet.get(yhdistelma);
        }
        return 0;
    }

    /**
     * Metodi palauttaa pelin yhteispisteet
     *
     * @return
     */
    public int palautaYhteisPisteet() {
        int yhteispisteet = 0;
        for (String yhdistelma : this.pisteet.keySet()) {
            yhteispisteet += this.pisteet.get(yhdistelma);
        }
        return yhteispisteet;
    }

    /**
     * Metodia käytetään merkitsemään onko pelaaja vielä asettanut pisteitä
     * tulostaululle tällä vuorolla
     *
     * @param onko
     */
    public void onkoPisteetAsetettu(boolean onko) {
        this.pisteetAsetettu = onko;
    }

    public boolean getPisteetAsetettu() {
        return this.pisteetAsetettu;
    }

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

    public int getMonestiHeitetty() {
        return monestiHeitetty;
    }

    public HashMap<String, Integer> getPisteet() {
        return pisteet;
    }
    
    
}
