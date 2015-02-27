package matyatzy.logiikka;

import java.util.Collections;

/**
 * Luokka käsittelee Yatzyssa vaadittavia noppien yhdistelmiä ja laskee niiden
 * pisteet annetuilla nopilla.
 *
 * @author matti
 */
public class Yhdistelmat {

    /**
     *Luo uuden Yhdistelmat-olion.
     */
    public Yhdistelmat() {
        
    }
    

    /**
     * Metodi toimii apumetodina monta samaa arvoa sisältävien yhdistelmien
     * laskemiseen.
     *
     * @param silmaluku minkä silmälukuisten noppien pistemäärä halutaan laskea
     * @param nopat Nopat-olio
     * @return halutunlaisten noppien pistemäärä
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
     * Metodi palauttaa annettujen noppien pisteet ykkosista.
     *
     * @param nopat Nopat-olio
     * @return ykkösten pistemäärä annetuilla nopilla
     */
    public int ykkoset(Nopat nopat) {
        return laskeYksittaiset(1, nopat);
    }

    /**
     * Metodi palauttaa annettujen noppien pisteet kakkosista.
     *
     * @param nopat Nopat-olio
     * @return kakkosten pistemäärä annetuilla nopilla
     */
    public int kakkoset(Nopat nopat) {
        return laskeYksittaiset(2, nopat);
    }

    /**
     * Metodi palauttaa annettujen noppien pisteet kolmosista.
     *
     * @param nopat Nopat-olio
     * @return kolmosten pistemäärä annetuilla nopilla
     */
    public int kolmoset(Nopat nopat) {
        return laskeYksittaiset(3, nopat);
    }

    /**
     * Metodi palauttaa annettujen noppien pisteet nelosista.
     *
     * @param nopat Nopat-olio
     * @return nelosten pistemäärä annetuilla nopilla
     */
    public int neloset(Nopat nopat) {
        return laskeYksittaiset(4, nopat);
    }

    /**
     * Metodi palauttaa annettujen noppien pisteet viitosista.
     *
     * @param nopat Nopat-olio
     * @return viitosten pistemäärä annetuilla nopilla
     */
    public int viitoset(Nopat nopat) {
        return laskeYksittaiset(5, nopat);
    }

    /**
     * Metodi palauttaa annettujen noppien pisteet kuutosista.
     *
     * @param nopat Nopat-olio
     * @return kuutosten pistemäärä annetuilla nopilla
     */
    public int kuutoset(Nopat nopat) {
        return laskeYksittaiset(6, nopat);
    }

    /**
     * Metodi palauttaa annettujen noppien pisteet sattumasta.
     *
     * @param nopat Nopat-olio
     * @return sattuman pistemäärä annetuilla nopilla
     */
    public int sattuma(Nopat nopat) {
        int summa = 0;
        for (Noppa noppa : nopat.getNopat()) {
            summa += noppa.getArvo();
        }
        return summa;
    }

    /**
     * Metodi palauttaa annettujen noppien pisteet kolmiluvusta.
     *
     * @param nopat Nopat-olio
     * @return kolmiluvun pistemäärä annetuilla nopilla
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
     * Metodi palauttaa annettujen noppien pisteet neliluvusta.
     *
     * @param nopat Nopat-olio
     * @return neliluvun pistemäärä annetuilla nopilla
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
     * Metodi palauttaa annettujen noppien pisteet parista.
     *
     * @param nopat Nopat-olio
     * @return parin pistemäärä annetuilla nopilla
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
     * Metodi palauttaa annettujen noppien pisteet kahdesta parista.
     *
     * @param nopat Nopat-olio
     * @return kahden parin pistemäärä annetuilla nopilla
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
     * Metodi palauttaa annettujen noppien pisteet mökistä.
     *
     * @param nopat Nopat-olio
     * @return mökin pistemäärä annetuilla nopilla
     */
    public int mokki(Nopat nopat) {
        //Kahden parin ja kolmiluvun loytyminen takaa, etta nopista muodostuu myos mokki
        if (kaksiParia(nopat) != 0 && kolmiluku(nopat) != 0) {
            return nopat.palautaNoppienSumma();
        }
        return 0;

    }

    
    /**
     * Metodi toimii apumetodina suorien laskemiseen.
     *
     * @param aloitusluku isossa suorssa 2, pienessä 1.
     * @param nopat Nopat-olio
     * @return halutunlaisten suoran (iso tai pieni) pistemäärä annetuilla nopilla
     */
    
    //Laskee suoran. Aloitusluku riippuu suorasta: isossa 2 ja pienessa 1
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
     * Metodi palauttaa annettujen noppien pisteet isosta suorasta.
     *
     * @param nopat Nopat-olio
     * @return ison suoran pistemäärä annetuilla nopilla
     */
    public int isoSuora(Nopat nopat) {
        return suora(2, nopat);
    }

    /**
     * Metodi palauttaa annettujen noppien pisteet pienestä suorasta.
     *
     * @param nopat Nopat-olio
     * @return pienen suoran pistemäärä annetuilla nopilla
     */
    public int pieniSuora(Nopat nopat) {
        return suora(1, nopat);
    }

    /**
     * Metodi palauttaa annettujen noppien pisteet yatzysta.
     *
     * @param nopat Nopat-olio
     * @return yatzyn pistemäärä annetuilla nopilla
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
     * Metodi palauttaa sille parametrina annetun yhdistelman pisteet.
     *
     * @param yhdistelma yhdistelman nimi
     * @param nopat Nopat-olio
     * @return Noppien pisteet annetusta yhdistelmästä
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
