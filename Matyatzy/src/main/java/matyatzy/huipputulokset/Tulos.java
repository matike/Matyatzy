package matyatzy.huipputulokset;

import java.io.Serializable;

/**
 * Luokka luo uuden Tulos-olion ja tarjoaa metodeja sen käsittelyyn.
 * @author matti
 */
public class Tulos implements Serializable, Comparable<Tulos> {
    
    String nimi;
    int tulos;
    
    /**
     * Luo uuden Tulos-olion.
     * @param nimi tuloksen tekijän nimi
     * @param tulos tuloksen pisteet
     */
    public Tulos(String nimi, int tulos) {
        this.nimi = nimi;
        this.tulos = tulos;       
    }

 
    public String getNimi() {
        return nimi;
    }

   
    public int getTulos() {
        return tulos;
    }

    @Override
    public int compareTo(Tulos tulos) {
        if (this.tulos == tulos.getTulos()) {
            return 0;
        }
        else if (this.tulos < tulos.getTulos()) {
            return 11;
        }
        return -1;
    }

    
    
}
