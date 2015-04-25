/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgbyte.me;

import java.awt.GridLayout;
import javax.swing.JComponent;

/**
 *
 * @author Niems
 */
public class MapComponent extends JComponent{
    
    public MapComponent(){
        this.setLayout(new GridLayout(Map.mapRows, Map.mapCols, 0, 0));
    }
    
}