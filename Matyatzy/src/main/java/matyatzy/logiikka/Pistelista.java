package matyatzy.logiikka;

import java.util.HashMap;

public class Pistelista {

    private HashMap<String, Integer> pistelista;

    public Pistelista() {
        this.pistelista = new HashMap<>();

    }

    public void lisaaYhdistelma(String nimi, int pisteet) {
        this.pistelista.put(nimi, pisteet);
    }
    
    public int palautaYhdistelmanPisteet(String nimi) {
        return this.pistelista.get(nimi);
    } 

}
