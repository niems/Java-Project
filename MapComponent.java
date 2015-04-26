/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgbyte.me;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 *
 * @author Niems
 */
public class MapComponent extends JComponent{
    
    public MapComponent(){
        this.setLayout(new GridLayout(Map.mapRows, Map.mapCols, 0, 0));
        
        TileComponent tile = null;
        
        BufferedImage seaImage = null;
        BufferedImage landImage = null;
        
        try{
            
            seaImage = ImageIO.read(new File("sea.png"));
            landImage = ImageIO.read(new File("land.png"));
            
        }catch(IOException e){
            e.printStackTrace();
        }
        
        for(int i = 0; i < Map.mapRows * Map.mapCols; i++){
           tile = new TileComponent(landImage);
           this.add(tile);
        }
        
        validate();
        repaint();
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(10,10);
    }    
	 
    
    @Override
    public void paint(Graphics g){
            super.paint(g);
    } 
    
}