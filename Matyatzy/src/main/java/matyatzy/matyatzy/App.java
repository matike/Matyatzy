package matyatzy.matyatzy;

import matyatzy.logiikka.Nopat;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        
        Nopat nopat = new Nopat(5);
        
        System.out.println(nopat.palautaNopanArvo(1));
        
        nopat.heitaNoppaa(1);
        System.out.println(nopat.palautaNopanArvo(1));
        
        nopat.heitaNoppaa(2);
        System.out.println(nopat.palautaNopanArvo(2));
        
        
        nopat.heitaNoppaa(3);
        System.out.println(nopat.palautaNopanArvo(3));
        
        nopat.heitaNoppaa(4);
        System.out.println(nopat.palautaNopanArvo(4));
        
        nopat.heitaNoppaa(5);
        System.out.println(nopat.palautaNopanArvo(5));
        
        System.out.println(nopat.palautaNoppienSumma());
        
        nopat.heitaKaikkiNopat();
        System.out.println(nopat.palautaNoppienSumma());
        
    }
}
