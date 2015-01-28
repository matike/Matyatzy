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
        for (int i = 1; i <= 6; i++) {
            if (Collections.frequency(nopat.palautaNoppienArvot(), i) >= 3) {
                return i * 3;
            }
        }
        return 0;
    }

    public int neliluku(Nopat nopat) {
        for (int i = 1; i <= 6; i++) {
            if (Collections.frequency(nopat.palautaNoppienArvot(), i) >= 4) {
                return i * 4;
            }
        }
        return 0;
    }

    public int pari(Nopat nopat) {
        int suurinPari = 0;
        for (int i = 1; i <= 6; i++) {
            if (Collections.frequency(nopat.palautaNoppienArvot(), i) >= 2) {
                suurinPari = i * 2;
            }
        }
        return suurinPari;
    }

    public int kaksiParia(Nopat nopat) {
        int parienSumma = 0;
        int parienMaara = 0;
        for (int i = 1; i <= 6; i++) {
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

    public int mokki(Nopat nopat) {
        int summa = 0;
        boolean onkoKolmiluku = false;
        boolean onkoPari = false;

        for (int i = 1; i <= 6; i++) {
            if (Collections.frequency(nopat.palautaNoppienArvot(), i) == 2) {
                summa += i * 2;
                onkoPari = true;
            }
            if (Collections.frequency(nopat.palautaNoppienArvot(), i) == 3) {
                summa += i * 3;
                onkoKolmiluku = true;
            }
        }
        if (onkoPari && onkoKolmiluku) {
            return summa;
        }
        return 0;

    }

    //laskee suoran, aloitusluku riippuu suorasta: isossa 2 ja pienessa 1
    public int suora(int aloitusluku, Nopat nopat) {
        int onkoSuora = 0;
        for (int i = aloitusluku; i <= 4 + aloitusluku; i++) {
            if (nopat.palautaNoppienArvot().contains(i)) {
                onkoSuora++;
            }
        }
        if (onkoSuora == 5) {
            return nopat.palautaNoppienSumma();
        }
        return 0;
    }

    public int isoSuora(Nopat nopat) {
        return suora(2, nopat);
    }

    public int pieniSuora(Nopat nopat) {
        return suora(1, nopat);
    }

}
