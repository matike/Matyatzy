/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matyatzy.kayttoliittyma;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import matyatzy.logiikka.Peli;
import matyatzy.logiikka.Yhdistelmat;

/**
 *
 * @author matti
 */
public class PisteidenAsetus implements ListSelectionListener {

    private JTable table;
    private Peli peli;
    private Yhdistelmat yhdistelmat;

    public PisteidenAsetus(JTable table, Peli peli) {
        this.table = table;
        this.peli = peli;
        this.yhdistelmat = new Yhdistelmat();
    }

    public void valueChanged(ListSelectionEvent event) {
        if(!peli.getPisteetAsetettu()) {
        int valittuRivi = table.getSelectedRow();
        int yhdistelmanPisteet = this.yhdistelmat.palautaYhdistelmanPisteet(table.getValueAt(valittuRivi, 0).toString().toLowerCase(), this.peli.palautaNopat());
        String yhdistelmanNimi = table.getValueAt(valittuRivi, 0).toString();
        this.peli.lisaaPisteet(yhdistelmanNimi, yhdistelmanPisteet);
        table.setValueAt(yhdistelmanPisteet, valittuRivi, 1);
        
        table.setValueAt(this.peli.palautaYhteisPisteet(), 16, 1);
        table.repaint();
        peli.onkoPisteetAsetettu(true);
        }
    }

}
