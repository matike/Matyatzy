package matyatzy.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * Luokka luo uuden Ohjeet-ikkunan.
 *
 * @author matti
 */
public class OhjeetIkkuna extends JFrame {

    public OhjeetIkkuna() {
        super("Ohjeet");
        setPreferredSize(new Dimension(360, 360));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        luoKomponentit(getContentPane());
        setResizable(false);
        pack();
        setVisible(true);
    }

    private void luoKomponentit(Container container) {
      
        JTextArea ohjeet = new JTextArea();

        ohjeet.setLineWrap(true);
        ohjeet.setWrapStyleWord(true);
        ohjeet.setEditable(false);

        
        
            try {
                ohjeet.read(new FileReader("ohjeet.txt"), null);
            } catch (IOException ex) {
                Logger.getLogger(OhjeetIkkuna.class.getName()).log(Level.SEVERE, null, ex);
            }

        container.add(ohjeet);
    }
}
