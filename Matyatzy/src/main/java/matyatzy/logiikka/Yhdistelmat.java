package matyatzy.logiikka;

import java.util.*;

public class Yhdistelmat {

    private static int laskeYksittaiset(int silmaluku, Nopat nopat) {
        int pisteet = 0;
        for (Noppa noppa : nopat.getNopat()) {
            if (noppa.getArvo() == silmaluku) {
                pisteet += silmaluku;
            }
        }
        return pisteet;
    }

    public int ykkoset(Nopat nopat) {
        return laskeYksittaiset(1, nopat);
    }

    public int kakkoset(Nopat nopat) {
        return laskeYksittaiset(2, nopat);
    }

    public int kolmoset(Nopat nopat) {
        return laskeYksittaiset(3, nopat);
    }

    public int neloset(Nopat nopat) {
        return laskeYksittaiset(4, nopat);
    }

    public int viitoset(Nopat nopat) {
        return laskeYksittaiset(5, nopat);
    }

    public int kuutoset(Nopat nopat) {
        return laskeYksittaiset(6, nopat);
    }

    public int sattuma(Nopat nopat) {
        int summa = 0;
        for (Noppa noppa : nopat.getNopat()) {
            summa += noppa.getArvo();
        }
        return summa;
    }

    public int kolmiluku(Nopat nopat) {
        for (int i = 0; i <= 6; i++) {
            if (Collections.frequency(nopat.palautaNoppienArvot(), i) >= 3) {
                return i * 3;
            }
        }
        return 0;
    }

    public int neliluku(Nopat nopat) {
        for (int i = 0; i <= 6; i++) {
            if (Collections.frequency(nopat.palautaNoppienArvot(), i) >= 4) {
                return i * 4;
            }
        }
        return 0;
    }

    public int pari(Nopat nopat) {
        int suurinPari = 0;
        for (int i = 0; i <= 6; i++) {
            if (Collections.frequency(nopat.palautaNoppienArvot(), i) >= 2) {
                suurinPari = i * 2;
            }
        }
        return suurinPari;
    }

    public int kaksiParia(Nopat nopat) {
        int parienSumma = 0;
        int parienMaara = 0;
        for (int i = 0; i <= 6; i++) {
            if (Collections.frequency(nopat.palautaNoppienArvot(), i) >= 2) {
                parienMaara++;
                parienSumma += i * 2;
            }
        }
        if (parienMaara == 2) {
            return parienSumma;
        }
        return 0;
    }

}
