package matyatzy.kayttoliittyma;

import javax.swing.table.AbstractTableModel;

/**
 * Luokka luo uuden pistelistan ulkoasun.
 * @author matti
 */
public class PistelistaModel extends AbstractTableModel {

    Object[][] data = {{"Ykköset", null}, {"Kakkoset", null}, {"Kolmoset", null}, {"Neloset", null}, {"Viitoset", null}, {"Kuutoset", null}, {"Bonus", 0}, {"Pari", null}, {"Kaksi paria", null}, {"Kolmiluku", null}, {"Neliluku", null}, {"Mökki", null}, {"Pieni suora", null}, {"Iso suora", null}, {"Sattuma", null}, {"Yatzy", null}, {"Yhteensä", null}};
    String[] columnNames = {"Yhdistelmä",
        "Pisteet"};

    public PistelistaModel() {

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
