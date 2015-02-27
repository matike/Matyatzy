package matyatzy.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import matyatzy.huipputulokset.Huipputulokset;
import matyatzy.logiikka.Peli;

/**
 * Tapahtumankuunteluluokka, joka lisää uuden huipputuloksen listalle.
 * @author matti
 */
public class TuloksenLisaaja implements ActionListener {

    private Peli peli;
    private JTextField nimi;
    private int tulos;
    private Huipputulokset tulokset;
    private TuloksenLisaysIkkuna ikkuna;
    
    public TuloksenLisaaja(Peli peli, JTextField nimi, TuloksenLisaysIkkuna ikkuna) {
        this.ikkuna = ikkuna;
        this.peli = peli;
        this.nimi = nimi;
        this.tulokset = new Huipputulokset();
        this.tulokset.lataaPisteetTiedostosta();
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.tulokset.lisaaTulos(this.nimi.getText(), this.peli.palautaYhteispisteet());
        this.tulokset.tallennaPisteetTiedostoon();
        ikkuna.dispose();
       
        
    }

}
