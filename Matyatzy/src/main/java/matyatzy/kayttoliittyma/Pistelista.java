package matyatzy.kayttoliittyma;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTable;
import matyatzy.logiikka.Peli;

/**
 * Luokka luo uuden pistelistan.
 * @author matti
 */
public class Pistelista extends JPanel {

    private JTable table;
    private Peli peli;

    public Pistelista(Peli peli) {
        this.peli = peli;

        this.table = new JTable();
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        table.setModel(new PistelistaModel());
        add(table);

        table.getSelectionModel().addListSelectionListener(new PisteidenAsetus(table, this.peli));
        table.setValueAt(this.peli.palautaYhteispisteet(), 16, 1);

    }
    

}
