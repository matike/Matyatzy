package matyatzy.logiikka;

import java.util.ArrayList;
import java.util.List;

public class Nopat {

    public List<Noppa> nopat;
    private int summa;

    public Nopat(int montako) {
        this.nopat = new ArrayList<>();
        for (int i = 0; i < montako; i++) {
            this.nopat.add(new Noppa());
        }

    }

    public List<Noppa> getNopat() {
        return nopat;
    }

    public void heitaKaikkiNopat() {
        for (Noppa noppa : nopat) {
            noppa.heitaNoppaa();
        }
    }

    public void heitaNoppaa(int moneskoNoppa) {
        this.nopat.get(moneskoNoppa - 1).heitaNoppaa();
    }

    public Noppa palautaNoppa(int moneskoNoppa) {
        return this.nopat.get(moneskoNoppa - 1);

    }

    public int palautaNopanArvo(int moneskoNoppa) {
        return this.nopat.get(moneskoNoppa - 1).getArvo();
    }

    public void asetaNopanArvo(int moneskoNoppa, int arvo) {
        this.nopat.get(moneskoNoppa - 1).setArvo(arvo);
    }

    public int palautaNoppienSumma() {
        this.summa = 0;
        for (Noppa noppa : nopat) {
            this.summa += noppa.getArvo();
        }
        return this.summa;
    }
    
    public List<Integer> palautaNoppienArvot() {
        ArrayList<Integer> noppienArvot = new ArrayList<>(); 
        for (Noppa noppa : nopat) {
            noppienArvot.add(noppa.getArvo());
        }
        return noppienArvot;
    }


}
