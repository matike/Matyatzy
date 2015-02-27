package matyatzy.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import matyatzy.logiikka.Peli;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Peli peli;

    public Kayttoliittyma(Peli peli) {
        this.peli = peli;

    }

    @Override
    public void run() {
        frame = new JFrame("Matyatzy");
        frame.setPreferredSize(new Dimension(640, 480));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(new JLabel(new ImageIcon(getClass().getResource("/tausta.png"))));
        frame.setResizable(false);
        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        UIManager.put("ToggleButton.background", Color.BLACK);
        UIManager.put("ToggleButton.select", new Color(34, 177, 76));

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        container.setLayout(layout);

        Pistelista pistelista = new Pistelista(this.peli);
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        container.add(pistelista, gbc);

        Noppanappi ykkosnoppa = new Noppanappi();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 2;
        gbc.gridy = 3;
        container.add(ykkosnoppa, gbc);

        Noppanappi kakkosnoppa = new Noppanappi();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 3;
        gbc.gridy = 3;
        container.add(kakkosnoppa, gbc);

        Noppanappi kolmosnoppa = new Noppanappi();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 4;
        gbc.gridy = 3;
        container.add(kolmosnoppa, gbc);

        Noppanappi nelosnoppa = new Noppanappi();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 5;
        gbc.gridy = 3;
        container.add(nelosnoppa, gbc);

        Noppanappi viitosnoppa = new Noppanappi();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 6;
        gbc.gridy = 3;
        container.add(viitosnoppa, gbc);

        JButton heittonappi = new JButton();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 3;
        container.add(heittonappi, gbc);

        heittonappi.setIcon(new ImageIcon(getClass().getResource("/heitto.png")));
        heittonappi.setPreferredSize(new Dimension(117, 86));
        Heitto heitto = new Heitto(this.peli, ykkosnoppa, kakkosnoppa, kolmosnoppa, nelosnoppa, viitosnoppa);
        heittonappi.addActionListener(heitto);

        JButton ohjeet = new JButton("Ohjeet");
        OhjeetAvaaja ohjeetAvaaja = new OhjeetAvaaja();
        ohjeet.addActionListener(ohjeetAvaaja);
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 1;
        gbc.gridy = 1;
        container.add(ohjeet, gbc);

        JButton huipputulokset = new JButton("Huipputulokset");
        Huipputulosavaaja huipputulosavaaja = new Huipputulosavaaja();
        huipputulokset.addActionListener(huipputulosavaaja);
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 1;
        gbc.gridy = 2;
        container.add(huipputulokset, gbc);

    }

    public JFrame getFrame() {
        return frame;
    }
}
