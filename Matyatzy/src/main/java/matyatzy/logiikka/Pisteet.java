package matyatzy.logiikka;

import java.util.HashMap;

public class Pisteet {

    private HashMap<String, Integer> pisteet;

    public Pisteet() {
        this.pisteet = new HashMap();
    }

    public void lisaaYhdistelmanPisteet(String nimi, int pisteet) {
        this.pisteet.put(nimi, pisteet);
    }
    
    public int palautaYhdistelmanPisteet(String nimi) {
        return this.pisteet.get(nimi);
    }

    public HashMap<String, Integer> getPisteet() {
        return pisteet;
    }
    

}
