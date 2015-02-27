package matyatzy.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * Luokka luo uuden ikkunan, jossa näkyy huipputulokset
 * @author matti
 */
public class Huipputulosikkuna extends JFrame {
    

public Huipputulosikkuna() {
        super("Huipputulokset");
        setPreferredSize(new Dimension(360, 240));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        luoKomponentit(getContentPane());
        setResizable(false);
        pack();
        setVisible(true);
}

private void luoKomponentit(Container container) {
    Huipputuloslista tulokset = new Huipputuloslista();
    container.add(tulokset);
}
}