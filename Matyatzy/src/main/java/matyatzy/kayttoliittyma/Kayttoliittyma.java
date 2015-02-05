package matyatzy.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;
import matyatzy.logiikka.Peli;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Peli peli;

    public Kayttoliittyma() {
        this.peli = new Peli();
    }

    @Override
    public void run() {
        frame = new JFrame("Matyatzy");
        frame.setPreferredSize(new Dimension(640, 480));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);

        JToggleButton ykkosnoppa = new JToggleButton("0");
        JToggleButton kakkosnoppa = new JToggleButton("0");
        JToggleButton kolmosnoppa = new JToggleButton("0");
        JToggleButton nelosnoppa = new JToggleButton("0");
        JToggleButton viitosnoppa = new JToggleButton("0");

        JButton heittonappi = new JButton("heitä!");
        Heitto heitto = new Heitto(this.peli, ykkosnoppa, kakkosnoppa, kolmosnoppa, nelosnoppa, viitosnoppa);
        heittonappi.addActionListener(heitto);

        container.setLayout(layout);
        container.add(heittonappi);
        container.add(ykkosnoppa);
        container.add(kakkosnoppa);
        container.add(kolmosnoppa);
        container.add(nelosnoppa);
        container.add(viitosnoppa);
    }

    public JFrame getFrame() {
        return frame;
    }
}
