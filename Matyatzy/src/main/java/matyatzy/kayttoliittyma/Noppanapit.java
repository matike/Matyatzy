/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matyatzy.kayttoliittyma;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 *
 * @author matti
 */
public class Noppanapit extends JPanel {

    JToggleButton ykkosnoppa = new JToggleButton();
    JToggleButton kakkosnoppa = new JToggleButton();
    JToggleButton kolmosnoppa = new JToggleButton();
    JToggleButton nelosnoppa = new JToggleButton();
    JToggleButton viitosnoppa = new JToggleButton();

    JButton heittonappi = new JButton("heitä!");
    Heitto heitto = new Heitto(this.peli, ykkosnoppa, kakkosnoppa, kolmosnoppa, nelosnoppa, viitosnoppa);

    heittonappi.addActionListener (heitto);

}
