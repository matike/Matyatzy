package matyatzy.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Tapahtumankuunteluluokka, joka avaa uuden huipputulosikkunan.
 * @author matti
 */
public class Huipputulosavaaja implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Huipputulosikkuna ikkuna = new Huipputulosikkuna();
    }
    
}
