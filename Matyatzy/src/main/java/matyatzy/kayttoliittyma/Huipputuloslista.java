package matyatzy.kayttoliittyma;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 * Luokka luo uuden huipputuloslistan
 * @author matti
 */
public class Huipputuloslista extends JPanel {
    
    private JTable table;
    
    public Huipputuloslista() {
        
        this.table = new JTable();
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        table.setModel(new HuipputuloslistaModel());
        add(table);
    }
    
}
