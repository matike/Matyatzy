package matyatzy.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import matyatzy.logiikka.Nopat;
import matyatzy.logiikka.Peli;

/**
 *Tapahtumankuunteluluokka, joka heittää joko kaikki nopat tai valitut nopat
 * @author matti
 */
public class Heitto implements ActionListener {

    private ImageIcon[] kuvat;
    private ImageIcon icon;
    private ArrayList<JToggleButton> onkoValittu;
    private Nopat nopat;
    private Peli peli;
    private JToggleButton eka;
    private JToggleButton toka;
    private JToggleButton kolmas;
    private JToggleButton neljas;
    private JToggleButton viides;

    /**
     *
     * @param peli peli, jonka noppia heitetään
     * @param eka ensimmäisen nopan JToggleButton
     * @param toka toisen nopan JToggleButton
     * @param kolmas kolmannen nopan JToggleButton
     * @param neljas neljännen nopan JToggleButton
     * @param viides viidennen nopan JToggleButton
     */
    public Heitto(Peli peli, JToggleButton eka, JToggleButton toka, JToggleButton kolmas, JToggleButton neljas, JToggleButton viides) {
        this.kuvat = new ImageIcon[7];
        for (int i = 1; i <= 6; i++) {
            this.kuvat[i] = new ImageIcon((getClass().getResource("/" + i + ".png")));
        }
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
        int valittuja = 0;

        if (this.peli.onkoHeittojaJaljella()) {
            for (int i = 0; i <= 4; i++) {
                if (this.peli.getMonestiHeitetty() == 0) {
                    valittuja++;
                    this.nopat.heitaNoppaa(i + 1);
                    this.onkoValittu.get(i).setIcon(this.kuvat[this.nopat.palautaNopanArvo(i + 1)]);                
                }

                else if (this.onkoValittu.get(i).isSelected()) {
                    valittuja++;
                    this.nopat.heitaNoppaa(i + 1);
                    this.onkoValittu.get(i).setIcon(this.kuvat[this.nopat.palautaNopanArvo(i + 1)]);                 
                }
                
            }
            if (valittuja > 0) {
                this.peli.lisaaHeitto();
            }
            this.peli.onkoPisteetAsetettu(false);

        }
    }
}
