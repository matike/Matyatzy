package matyatzy.matyatzy;

import javax.swing.SwingUtilities;
import matyatzy.kayttoliittyma.Kayttoliittyma;
import matyatzy.huipputulokset.Huipputulokset;
import matyatzy.logiikka.Peli;

public class App {

    public static void main(String[] args) {

        Huipputulokset tulokset = new Huipputulokset();
        tulokset.lataaPisteetTiedostosta();

        Peli peli = new Peli();
        Kayttoliittyma kl = new Kayttoliittyma(peli);
        SwingUtilities.invokeLater(kl);

    }

}
