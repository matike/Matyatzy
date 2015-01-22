package matyatzy.logiikka;

import java.util.*;

public class Nopat extends ArrayList<Noppa> {

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
       this.nopat.get(moneskoNoppa-1).heitaNoppaa();
    }
    

    public Noppa palautaNoppa(int moneskoNoppa) {
        return this.nopat.get(moneskoNoppa-1);

    }

    public int palautaNopanArvo(int moneskoNoppa) {
        return this.nopat.get(moneskoNoppa-1).getArvo();
    }
    
    public void asetaNopanArvo(int moneskoNoppa, int arvo) {
        this.nopat.get(moneskoNoppa).setArvo(arvo);
    }
    

    public int laskeNoppienSumma() {
        this.summa = 0;
        for (Noppa noppa : nopat) {
            this.summa += noppa.getArvo();
        }
        return this.summa;
    }

    public int palautaNoppienSumma() {
        laskeNoppienSumma();
        return this.summa;
    }

}
