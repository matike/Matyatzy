package matyatzy.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Tapahtumankuunteluluokka, joka avaa uuden Ohjeet-ikkunan
 * @author matti
 */
public class OhjeetAvaaja implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        OhjeetIkkuna ikkuna = new OhjeetIkkuna();
    }
    
    
}
