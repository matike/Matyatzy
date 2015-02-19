package matyatzy.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
        frame.setContentPane(new JLabel(new ImageIcon("images/tausta.png")));
        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        UIManager.put("ToggleButton.background", Color.BLACK);
        UIManager.put("ToggleButton.select", new Color(34, 177, 76));

        Pistelista pistelista = new Pistelista(this.peli);
        GridBagLayout layout = new GridBagLayout();

        Noppanappi ykkosnoppa = new Noppanappi();
        Noppanappi kakkosnoppa = new Noppanappi();
        Noppanappi kolmosnoppa = new Noppanappi();
        Noppanappi nelosnoppa = new Noppanappi();
        Noppanappi viitosnoppa = new Noppanappi();      

        JButton heittonappi = new JButton();
        heittonappi.setIcon(new ImageIcon("images/heitto.png"));
        heittonappi.setPreferredSize(new Dimension(117, 86));
        Heitto heitto = new Heitto(this.peli, ykkosnoppa, kakkosnoppa, kolmosnoppa, nelosnoppa, viitosnoppa);
        heittonappi.addActionListener(heitto);

        container.setLayout(layout);
        container.add(pistelista);
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
