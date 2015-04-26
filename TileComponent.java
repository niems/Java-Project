/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgbyte.me;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

/**
 *
 * @author Niems
 */
public class TileComponent extends JComponent{
    
    protected BufferedImage image;
    
    public TileComponent(BufferedImage img){
        image = img;
    }
    
    @Override
    public void paint(Graphics g) {
        
        g.drawImage(image, 0, 0, null);
    }
    
    @Override
    public Dimension getPreferredSize(){
        if (image == null) {
            return new Dimension(800,600);
        } 
        
        else {
            return new Dimension(image.getWidth(null), image.getHeight(null));
        }
    }
    
}
