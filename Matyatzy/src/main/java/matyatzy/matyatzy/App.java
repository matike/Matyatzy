package matyatzy.matyatzy;

import matyatzy.logiikka.Nopat;
import matyatzy.logiikka.Yhdistelmat;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        
        Nopat nopat = new Nopat(5);
        Yhdistelmat yhdistelmat = new Yhdistelmat();
        
        nopat.heitaKaikkiNopat();
        
        System.out.println(yhdistelmat.ykkoset(nopat));
        
        System.out.println(yhdistelmat.kakkoset(nopat));
        
        System.out.println(yhdistelmat.kolmoset(nopat));
        
        System.out.println(yhdistelmat.neloset(nopat));
        
        System.out.println(yhdistelmat.viitoset(nopat));
        
        
        System.out.println(yhdistelmat.kuutoset(nopat));
        
        

        
    }
}
