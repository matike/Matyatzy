package matyatzy.kayttoliittyma;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import matyatzy.logiikka.Nopat;
import matyatzy.logiikka.Peli;
import matyatzy.logiikka.Yhdistelmat;

public class Pistelista extends JPanel {

    private JTable table;
    private Peli peli;
    private Yhdistelmat yhdistelmat;

    public Pistelista(Peli peli) {
        this.peli = peli;
        this.yhdistelmat = new Yhdistelmat();

        this.table = new JTable();
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        table.setModel(new PistelistaModel());
        add(table);

        table.getSelectionModel().addListSelectionListener(new PisteidenAsetus(table, this.peli));
        table.setValueAt(this.peli.palautaYhteisPisteet(), 16, 1);

    }

}
