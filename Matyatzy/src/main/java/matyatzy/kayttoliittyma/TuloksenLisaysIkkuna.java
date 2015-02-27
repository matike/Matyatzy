package matyatzy.kayttoliittyma;


import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import matyatzy.logiikka.Peli;

/**
 * Luokka luo uuden ikkunan, johon voi syöttää uuden huipputuloksen tekijän nimen.
 * @author matti
 */
public class TuloksenLisaysIkkuna extends JFrame {

    private Peli peli;

    public TuloksenLisaysIkkuna(Peli peli) {
        super("Huipputulos!");
        this.peli = peli;
        setPreferredSize(new Dimension(540, 60));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        luoKomponentit(getContentPane());
        setResizable(false);
        pack();
        setVisible(true);
        


    }

    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(1, 3);
        container.setLayout(layout);

        JLabel teksti = new JLabel("Pääsit huipputulosten listalle!");
        container.add(teksti);

        JTextField nimi = new JTextField("nimi");
        container.add(nimi);

        JButton laheta = new JButton("OK");
        TuloksenLisaaja lisaaja = new TuloksenLisaaja(this.peli, nimi, this);
        laheta.addActionListener(lisaaja);

        container.add(laheta);

    }

}
