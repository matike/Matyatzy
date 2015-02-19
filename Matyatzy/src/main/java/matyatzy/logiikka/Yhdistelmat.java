package matyatzy.logiikka;

import java.util.Collections;

/**
 * Luokka käsittelee Yatzyssa vaadittavia noppien yhdistelmiä ja laskee niiden
 * pisteet annetuilla nopilla
 *
 * @author matti
 */
public class Yhdistelmat {

    /**
     * Metodi toimii apumetodina monta samaa arvoa sisältävien yhdistelmien
     * laskemiseen
     *
     * @param silmaluku
     * @param nopat
     * @return
     */
    private static int laskeYksittaiset(int silmaluku, Nopat nopat) {
        int pisteet = 0;
        for (Noppa noppa : nopat.getNopat()) {
            if (noppa.getArvo() == silmaluku) {
                pisteet += silmaluku;
            }
        }
        return pisteet;
    }

    /**
     * Metodi palauttaa annettujen noppien pisteet ykkosista
     *
     * @param nopat
     * @return
     */
    public int ykkoset(Nopat nopat) {
        return laskeYksittaiset(1, nopat);
    }

    /**
     * Metodi palauttaa annettujen noppien pisteet kakkosista
     *
     * @param nopat
     * @return
     */
    public int kakkoset(Nopat nopat) {
        return laskeYksittaiset(2, nopat);
    }

    /**
     * Metodi palauttaa annettujen noppien pisteet kolmosista
     *
     * @param nopat
     * @return
     */
    public int kolmoset(Nopat nopat) {
        return laskeYksittaiset(3, nopat);
    }

    /**
     * Metodi palauttaa annettujen noppien pisteet nelosista
     *
     * @param nopat
     * @return
     */
    public int neloset(Nopat nopat) {
        return laskeYksittaiset(4, nopat);
    }

    /**
     * Metodi palauttaa annettujen noppien pisteet viitosista
     *
     * @param nopat
     * @return
     */
    public int viitoset(Nopat nopat) {
        return laskeYksittaiset(5, nopat);
    }

    /**
     * Metodi palauttaa annettujen noppien pisteet kuutosista
     *
     * @param nopat
     * @return
     */
    public int kuutoset(Nopat nopat) {
        return laskeYksittaiset(6, nopat);
    }

    /**
     * Metodi palauttaa annettujen noppien pisteet sattumasta
     *
     * @param nopat
     * @return
     */
    public int sattuma(Nopat nopat) {
        int summa = 0;
        for (Noppa noppa : nopat.getNopat()) {
            summa += noppa.getArvo();
        }
        return summa;
    }

    /**
     * Metodi palauttaa annettujen noppien pisteet kolmiluvusta
     *
     * @param nopat
     * @return
     */
    public int kolmiluku(Nopat nopat) {
        for (int i = 1; i <= 6; i++) {
            if (Collections.frequency(nopat.palautaNoppienArvot(), i) >= 3) {
                return i * 3;
            }
        }
        return 0;
    }

    /**
     * Metodi palauttaa annettujen noppien pisteet neliluvusta
     *
     * @param nopat
     * @return
     */
    public int neliluku(Nopat nopat) {
        for (int i = 1; i <= 6; i++) {
            if (Collections.frequency(nopat.palautaNoppienArvot(), i) >= 4) {
                return i * 4;
            }
        }
        return 0;
    }

    /**
     * Metodi palauttaa annettujen noppien pisteet parista
     *
     * @param nopat
     * @return
     */
    public int pari(Nopat nopat) {
        int suurinPari = 0;
        for (int i = 1; i <= 6; i++) {
            if (Collections.frequency(nopat.palautaNoppienArvot(), i) >= 2) {
                suurinPari = i * 2;
            }
        }
        return suurinPari;
    }

    /**
     * Metodi palauttaa annettujen noppien pisteet kahdesta parista
     *
     * @param nopat
     * @return
     */
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

    /**
     * Metodi palauttaa annettujen noppien pisteet mökistä
     *
     * @param nopat
     * @return
     */
    public int mokki(Nopat nopat) {
        //Kahden parin ja kolmiluvun loytyminen takaa, etta nopista muodostuu myos mokki
        if (kaksiParia(nopat) != 0 && kolmiluku(nopat) != 0) {
            return nopat.palautaNoppienSumma();
        }
        return 0;

    }

    //Laskee suoran. Aloitusluku riippuu suorasta: isossa 2 ja pienessa 1
    /**
     * Metodi toimii apumetodina suorien laskemiseen
     *
     * @param aloitusluku
     * @param nopat
     * @return
     */
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

    /**
     * Metodi palauttaa annettujen noppien pisteet isosta suorasta
     *
     * @param nopat
     * @return
     */
    public int isoSuora(Nopat nopat) {
        return suora(2, nopat);
    }

    /**
     * Metodi palauttaa annettujen noppien pisteet pienestä suorasta
     *
     * @param nopat
     * @return
     */
    public int pieniSuora(Nopat nopat) {
        return suora(1, nopat);
    }

    /**
     * Metodi palauttaa annettujen noppien pisteet yatzysta
     *
     * @param nopat
     * @return
     */
    public int yatzy(Nopat nopat) {
        for (int i = 1; i <= 6; i++) {
            if (Collections.frequency(nopat.palautaNoppienArvot(), i) >= 5) {
                return 50;
            }
        }
        return 0;
    }

    /**
     * Metodi palauttaa sille parametrina annetun yhdistelman pisteet
     *
     * @param yhdistelma yhdistelman nimi
     * @param nopat
     * @return
     */
    public int palautaYhdistelmanPisteet(String yhdistelma, Nopat nopat) {
        switch (yhdistelma.toLowerCase()) {
            case "ykköset":
                return ykkoset(nopat);
            case "kakkoset":
                return kakkoset(nopat);
            case "kolmoset":
                return kolmoset(nopat);
            case "neloset":
                return neloset(nopat);
            case "viitoset":
                return viitoset(nopat);
            case "kuutoset":
                return kuutoset(nopat);
            case "pari":
                return pari(nopat);
            case "kaksi paria":
                return kaksiParia(nopat);
            case "kolmiluku":
                return kolmiluku(nopat);
            case "neliluku":
                return neliluku(nopat);
            case "mökki":
                return mokki(nopat);
            case "pieni suora":
                return pieniSuora(nopat);
            case "iso suora":
                return isoSuora(nopat);
            case "sattuma":
                return sattuma(nopat);
            case "yatzy":
                return yatzy(nopat);
        }
        return 0;

    }

}
