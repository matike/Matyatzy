package matyatzy.kayttoliittyma;

import javax.swing.table.AbstractTableModel;

public class PistelistaModel extends AbstractTableModel {

    Object[][] data = {{"Ykkoset", 0}, {"Kakkoset", 0}, {"Kolmoset", 0}, {"Neloset", 0}, {"Viitoset", 0}, {"Kuutoset", 0}, {"Bonus", 0}, {"Pari", 0}, {"Kaksi paria", 0}, {"Kolmiluku", 0}, {"Neliluku", 0}, {"Mokki", 0}, {"Pieni suora", 0}, {"Iso suora", 0}, {"Sattuma", 0}, {"Yatzy", 0}, {"Yhteensa", 0}};
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
