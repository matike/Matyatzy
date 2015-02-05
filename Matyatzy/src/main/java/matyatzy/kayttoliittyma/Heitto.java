package matyatzy.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JToggleButton;
import matyatzy.logiikka.Nopat;
import matyatzy.logiikka.Peli;

public class Heitto implements ActionListener {

    private ArrayList<JToggleButton> onkoValittu;
    private Nopat nopat;
    private Peli peli;
    private JToggleButton eka;
    private JToggleButton toka;
    private JToggleButton kolmas;
    private JToggleButton neljas;
    private JToggleButton viides;

    public Heitto(Peli peli, JToggleButton eka, JToggleButton toka, JToggleButton kolmas, JToggleButton neljas, JToggleButton viides) {
        this.peli = peli;
        this.nopat = peli.palautaNopat();
        this.onkoValittu = new ArrayList();
        this.onkoValittu.add(eka);
        this.onkoValittu.add(toka);
        this.onkoValittu.add(kolmas);
        this.onkoValittu.add(neljas);
        this.onkoValittu.add(viides);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (this.peli.heittojaJaljella()) {
            for (int i = 0; i <= 4; i++) {

                if (this.onkoValittu.get(i).isSelected()) {
                    this.nopat.heitaNoppaa(i + 1);
                    this.onkoValittu.get(i).setText("" + this.nopat.palautaNopanArvo(i + 1));
                }
            }
                this.peli.lisaaHeitto();
                
            

        }

        System.out.println(this.nopat.palautaNopanArvo(1));
        System.out.println(this.nopat.palautaNopanArvo(2));
        System.out.println(this.nopat.palautaNopanArvo(3));
        System.out.println(this.nopat.palautaNopanArvo(4));
        System.out.println(this.nopat.palautaNopanArvo(5));
    }
}
