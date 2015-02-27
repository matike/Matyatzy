    package matyatzy.kayttoliittyma;

import java.awt.Dimension;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

/**
 *Luokka luo uuden JToggleButtonin noppaulkoasulla
 * @author matti
 */
public class Noppanappi extends JToggleButton {
    
public Noppanappi() {  
    setIcon(new ImageIcon(getClass().getResource("/1.png")));
    setPreferredSize(new Dimension(68, 68));
    
}
}
