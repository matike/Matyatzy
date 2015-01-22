package matyatzy.logiikka;

public class Yhdistelmat {

    private static int laskeYksittaiset(int silmaluku, Nopat nopat) {
        int pisteet = 0;
        for (Noppa noppa : nopat.getNopat()) {
            if (noppa.getArvo() == silmaluku) {
                pisteet++;
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

}
