package matyatzy.matyatzy;

import java.awt.EventQueue;
import javax.swing.SwingUtilities;
import matyatzy.kayttoliittyma.Kayttoliittyma;
import matyatzy.logiikka.Nopat;
import matyatzy.logiikka.Peli;
import matyatzy.logiikka.Yhdistelmat;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {

        Peli peli = new Peli();



                Kayttoliittyma kl = new Kayttoliittyma();
               SwingUtilities.invokeLater(kl);
            }
        

        }
