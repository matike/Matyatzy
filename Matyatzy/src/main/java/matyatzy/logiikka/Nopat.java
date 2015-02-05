package matyatzy.logiikka;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author matti
 */
public class Nopat {

    /**
     *
     */
    public List<Noppa> nopat;
    private int summa;

    /**
     * Luokka tarjoaa noppien käsittelyyn tarvittavia metodeja
     * @param montako Noppien määrä
     */
    public Nopat(int montako) {
        this.nopat = new ArrayList<>();
        for (int i = 0; i < montako; i++) {
            this.nopat.add(new Noppa());
        }

    }

    public List<Noppa> getNopat() {
        return nopat;
    }

    /**
     * Metodi heittää kaikki nopat
     */
    public void heitaKaikkiNopat() {
        for (Noppa noppa : nopat) {
            noppa.heitaNoppaa();
        }
    }

    /**
     * Metodi heittaa tiettyä noppaa. Nopan järjestysluku annetaan parametrina
     * @param moneskoNoppa Monesko noppa heitetään
     */
    public void heitaNoppaa(int moneskoNoppa) {
        this.nopat.get(moneskoNoppa - 1).heitaNoppaa();
    }

    /**
     * Metodi palauttaa tietyn nopan
     * @param moneskoNoppa Monesko noppa heitetään
     * @return
     */
    public Noppa palautaNoppa(int moneskoNoppa) {
        return this.nopat.get(moneskoNoppa - 1);

    }

    /**
     * Metodi palauttaa tietyn nopan arvon
     * @param moneskoNoppa Monennen nopan arvo palautetaan
     * @return nopan arvo
     */
    public int palautaNopanArvo(int moneskoNoppa) {
        return this.nopat.get(moneskoNoppa - 1).getArvo();
    }

    /**
     * Metodilla saa asetettua tietylle nopalle arvon
     * @param moneskoNoppa Monennen nopan arvo muutetaan
     * @param arvo
     */
    public void asetaNopanArvo(int moneskoNoppa, int arvo) {
        this.nopat.get(moneskoNoppa - 1).setArvo(arvo);
    }

    /**
     * Metodi palauttaa kaikkien noppien summan
     * @return noppien summa
     */
    public int palautaNoppienSumma() {
        this.summa = 0;
        for (Noppa noppa : nopat) {
            this.summa += noppa.getArvo();
        }
        return this.summa;
    }
    
    /**
     * Metodi palauttaa kaikkien noppien arvot listana
     * @return noppien arvot listana
     */
    public List<Integer> palautaNoppienArvot() {
        ArrayList<Integer> noppienArvot = new ArrayList<>(); 
        for (Noppa noppa : nopat) {
            noppienArvot.add(noppa.getArvo());
        }
        return noppienArvot;
    }


}
