
package matyatzy.kayttoliittyma;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import matyatzy.logiikka.Peli;
import matyatzy.logiikka.Yhdistelmat;

public class PisteidenAsetus implements ListSelectionListener {

    private JTable table;
    private Peli peli;
   

    public PisteidenAsetus(JTable table, Peli peli) {
        this.table = table;
        this.peli = peli;
       
    }

    public void valueChanged(ListSelectionEvent event) {
        
        int valittuRivi = table.getSelectedRow();
        int yhdistelmanPisteet = this.peli.palautaYhdistelmanPisteet(table.getValueAt(valittuRivi, 0).toString(), this.peli.palautaNopat());
        String yhdistelmanNimi = table.getValueAt(valittuRivi, 0).toString();
        this.peli.lisaaPisteet(yhdistelmanNimi, yhdistelmanPisteet);
        table.setValueAt(yhdistelmanPisteet, valittuRivi, 1);
        
        table.setValueAt(this.peli.palautaYhteisPisteet(), 16, 1);
        table.repaint();
        
        
    }

}
