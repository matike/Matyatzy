package matyatzy.huipputulokset;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Luokka luo uuden huipputuloslistan ja tarjoaa metodeja sen käsittelyyn.
 * @author matti
 */
public class Huipputulokset {

    private ArrayList<Tulos> tulokset;
    private ObjectOutputStream outObject;
    private ObjectInputStream inObject;
    private String[] nimi;
    private int[] tulos;
    private String tiedosto;

    /**
     * Luo uuden Huipputulokset-olion.
     */
    public Huipputulokset() {
        this.tulokset = new ArrayList<>();
        this.tiedosto = "huipputulokset.dat";

    }

    /**
     * Metodi, jonka avulla täytetään huipputulosten lista oletustuloksilla.
     */
    public void josTiedostoaEiOle() {
        for (int i = 0; i < 10; i++) {
            this.tulokset.add(new Tulos("matti", 100 - i*10));
            tallennaPisteetTiedostoon();
        }
    }

    public int getTulos(int moneskoTulos) {
        return this.tulos[moneskoTulos - 1];

    }

    public int getNimi(int moneskoNimi) {
        return this.tulos[moneskoNimi - 1];
    }

    public ArrayList<Tulos> getTulokset() {
        return this.tulokset;
    }

    /**
     * Metodi järjestää huipputulokset oikeaan järjestykseen.
     */
    public void jarjestaTulokset() {
        Collections.sort(this.tulokset);
    }

    /**
     * Metodi listalla viimeisenä olevan tuloksen ja lisää uuden tuloksen listalle.
     * @param nimi tuloksen tekijän nimi
     * @param tulos tuloksen pisteet
     */
    public void lisaaTulos(String nimi, int tulos) {
        this.tulokset.remove(9);
        this.tulokset.add(new Tulos(nimi, tulos));
        jarjestaTulokset();

    }

    /**
     * Metodi tarkastaa onko annettu tulos huipputulos.
     * @param tulos tarkistettavan tuloksen pisteet
     * @return
     */
    public boolean onkoHuipputulos(int tulos) {
        jarjestaTulokset();

        if (this.tulokset.get(9).getTulos() < tulos) {
            return true;
        }

        return false;

    }

    /**
     * Metodi lataa pisteet tiedostosta. Jos tiedostoa ei ole, se luo sen.
     */
    public void lataaPisteetTiedostosta() {
        if (new File(tiedosto).exists()) {

            try {
                this.inObject = new ObjectInputStream(new FileInputStream(tiedosto));
            } catch (IOException ex) {
            }
            try {
                this.tulokset = (ArrayList<Tulos>) this.inObject.readObject();
            } catch (IOException ex) {
                System.out.println("Tiedoston lukeminen epäonnistui. Virhe: " + ex.getMessage());
            } catch (ClassNotFoundException ex) {
                System.out.println("Tiedoston lukeminen epäonnistui. Virhe: " + ex.getMessage());

            }
        } else {
            josTiedostoaEiOle();
        }

    }

    /**
     * Metodi tallentaa pisteet tiedostoon.
     */
    public void tallennaPisteetTiedostoon() {
        try {
            this.outObject = new ObjectOutputStream(new FileOutputStream(tiedosto));
        } catch (IOException ex) {
            System.out.println("Tiedostoon kirjoittaminen epäonnistui. Virhe: " + ex.getMessage());
        }
        try {
            this.outObject.writeObject(this.tulokset);
        } catch (IOException ex) {
            System.out.println("Tiedostoon kirjoittaminen epäonnistui. Virhe: " + ex.getMessage());
        }

    }

}
