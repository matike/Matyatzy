package matyatzy.kayttoliittyma;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import matyatzy.huipputulokset.Huipputulokset;
import matyatzy.logiikka.Peli;
import matyatzy.logiikka.Yhdistelmat;

/**
 * Tapahtumankuunteluluokka, joka lisää pisteet listalle riviä klikattaessa.
 * @author matti
 */
public class PisteidenAsetus implements ListSelectionListener {

    private JTable table;
    private Peli peli;
    private Huipputulokset tulokset;

    public PisteidenAsetus(JTable table, Peli peli) {
        this.table = table;
        this.peli = peli;
        this.tulokset = new Huipputulokset();
        this.tulokset.lataaPisteetTiedostosta();

    }

    @Override
    public void valueChanged(ListSelectionEvent event) {
        if (!this.peli.getPisteetAsetettu()) {
            int valittuRivi = table.getSelectedRow();
            String yhdistelmanNimi = table.getValueAt(valittuRivi, 0).toString().toLowerCase();
            if (valittuRivi != 6 && valittuRivi != 16 && this.peli.getPisteet().containsKey(yhdistelmanNimi) == false) {
                int yhdistelmanPisteet = this.peli.palautaYhdistelmanPisteet(yhdistelmanNimi, this.peli.palautaNopat());

                this.peli.lisaaPisteet(yhdistelmanNimi, yhdistelmanPisteet);
                table.setValueAt(yhdistelmanPisteet, valittuRivi, 1);
            }
            //Tarkistaa onko peli loppu, ja jos peli on loppu ja tulos yltää huipputulosten listalle, avautuu ikkuna, johon syötetään nimi
            if (peli.onkoPeliLoppu()) {
                if (this.tulokset.onkoHuipputulos(this.peli.palautaYhteispisteet())) {
                TuloksenLisaysIkkuna lisays = new TuloksenLisaysIkkuna(this.peli);
                }
                
            }
        }
        this.peli.onkoPisteetAsetettu(true);
        this.peli.nollaaHeitot();

        table.setValueAt(this.peli.palautaYhteispisteet(), 16, 1);
        if (this.peli.onkoBonus()) {
            table.setValueAt(50, 6, 1);
            this.peli.lisaaPisteet("bonus", 50);
        }

        table.repaint();

    }

}
