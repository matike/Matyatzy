package matyatzy.kayttoliittyma;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import matyatzy.huipputulokset.Huipputulokset;
import matyatzy.huipputulokset.Tulos;

/**
 *Luokka luo ulkoasun huipputuloslistalle
 * @author matti
 */
public class HuipputuloslistaModel extends AbstractTableModel {
    
    private Huipputulokset tulokset;

    private Object[][] data;
    String[] columnNames = {"Nimi",
        "Tulos"};

    public HuipputuloslistaModel() {
        this.tulokset = new Huipputulokset();
        tulokset.lataaPisteetTiedostosta();
        ArrayList<Tulos> tuloslista = this.tulokset.getTulokset();
        this.data = new Object[10][10];
        if(!tuloslista.isEmpty()) {
        for (int i = 0; i < tuloslista.size(); i++) {
            data[i][0] = tuloslista.get(i).getNimi();
            data[i][1] = tuloslista.get(i).getTulos();
        }
        }

        }
        
    

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        data[rowIndex][columnIndex] = value;
    }

}

