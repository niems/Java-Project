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
    BufferedImage image;
    public MapComponent(){
        this.setLayout(new GridLayout(Map.mapRows, Map.mapCols, 0, 0));
        
        TileComponent tile = null;
        File seaFile = null;
        File landFile = null;
        
        BufferedImage seaImage = null;
        BufferedImage landImage = null;
        
        try{
            seaFile = new File("sea.png");
            landFile = new File("land.png");
            
            seaImage = ImageIO.read(seaFile);
            landImage = ImageIO.read(landFile);
            
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
        if (image == null)
        {
            return new Dimension(800,600);
        }
        else
        {
            return new Dimension(600,600);
        }
    }    
	  
	  

    /*public void paint(Graphics g){
            super.paint(g);
    }*/
    
}