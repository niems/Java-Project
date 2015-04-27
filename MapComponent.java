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
    }
    
    //updates the base layer of the map (land or sea tiles)
    //comment out everything in constructor except for the layout. The rest
    //of the information is to be set in this function
    public void updateBaseMap(Map map, int[] valid){
        this.removeAll(); //removes all components from the map
        
        TileComponent tile = null;
        int removeIndex, row, column; //index to remove from the map
        
        try{
            
            //used to tile the base of the map
            BufferedImage seaImage = ImageIO.read(new File("sea.png"));
            BufferedImage landImage = ImageIO.read(new File("land.png"));
            
            BufferedImage dockImage = ImageIO.read(new File("dock.png"));
            BufferedImage pierImage = ImageIO.read(new File("pier.png"));
            BufferedImage craneImage = ImageIO.read(new File("crane.png"));
            
            BufferedImage cargoShipImage = ImageIO.read(new File("cargoship.png"));
            BufferedImage containerShipImage = ImageIO.read(new File("containership.png"));
            BufferedImage oilTankerImage = ImageIO.read(new File("oiltanker.png"));
            
            for(int i = 0; i < Map.mapRows; i++){
                
                for(int j = 0; j < Map.mapCols; j++){
                    
                    if(map.getGeoStatus()[i][j].equals(String.valueOf(map.getLand()))){
                        tile = new TileComponent(landImage);
                        this.add(tile);
                    }

                    else if(map.getGeoStatus()[i][j].equals(String.valueOf(map.getWater()))){
                        tile = new TileComponent(seaImage);
                        this.add(tile);
                    }
                }           
            }
            
            validate();
            
            if(valid[1] == 1){ //loaded port file successfully
                for(int i = 0; i < map.getPort().getDock().size(); i++){
                    row = map.getPort().getDock().get(i).getRow();
                    column = map.getPort().getDock().get(i).getColumn();
                    
                    removeIndex = (row * Map.mapCols) + column; //current dock location
                    this.remove(removeIndex); //removes current component
                    
                    if(map.getPort().getDock().get(i).getSymbol() == map.getUnoccupiedDock()){
                        tile = new TileComponent(dockImage);
                        this.add(tile, removeIndex);
                    }
                    
                    else if(map.getPort().getDock().get(i).getSymbol() == map.getUnoccupiedPier()){
                        tile = new TileComponent(pierImage);
                        this.add(tile, removeIndex);
                    }
                    
                    else if(map.getPort().getDock().get(i).getSymbol() == map.getUnoccupiedCrane()){
                        tile = new TileComponent(craneImage);
                        this.add(tile, removeIndex);
                    }
                    
                    this.add(tile, removeIndex);
                }
                
                revalidate();
            }
            
            if(valid[2] == 1){ //loaded ship file successfully
                for(int i = 0; i < map.getCurrentShips().size(); i++){
                    row = map.getCurrentShips().get(i).getRow();
                    column = map.getCurrentShips().get(i).getColumn();
                    
                    removeIndex = (row * Map.mapCols) + column;
                    this.remove(removeIndex);
                    
                    if(map.getCurrentShips().get(i).getSymbol() == map.getCargoShipSafeAtSea()){
                        tile = new TileComponent(cargoShipImage);
                        this.add(tile, removeIndex);
                    }
                    
                    else if(map.getCurrentShips().get(i).getSymbol() == map.getContainerShipSafeAtSea()){
                        tile = new TileComponent(containerShipImage);
                        this.add(tile, removeIndex);
                    }
                    
                    else if(map.getCurrentShips().get(i).getSymbol() == map.getTankerSafeAtSea()){
                        tile = new TileComponent(oilTankerImage);
                        this.add(tile, removeIndex);
                    }
                }
                
                revalidate();
            }
            
            repaint();
            
        }catch(IOException e){
            e.printStackTrace();
        }
        
        
        
    }
    
    public void updateShips(Map map){
        TileComponent tile = null;
        int removeIndex, row, column; //index to remove from the map
        
        try{
            BufferedImage cargoShipImage = ImageIO.read(new File("cargoship.png"));
            BufferedImage containerShipImage = ImageIO.read(new File("containership.png"));
            BufferedImage oilTankerImage = ImageIO.read(new File("oiltanker.png"));
            BufferedImage unsafeShipImage = ImageIO.read(new File("unsafe.png"));
            BufferedImage unloadShipImage = ImageIO.read(new File("safe.png"));
            
            for(int i = 0; i < map.getCurrentShips().size(); i++){
                row = map.getCurrentShips().get(i).getRow();
                column = map.getCurrentShips().get(i).getColumn();
                
                removeIndex = (row * Map.mapCols) + column; //current dock location
                this.remove(removeIndex); //removes current component
                
                //if the ship is unsafe
                if(map.getCurrentMap()[row][column].equals(String.valueOf(map.getUnsafeShip()))){
                    tile = new TileComponent(unsafeShipImage);
                    this.add(tile, removeIndex);
                }
                
                //if the ship is at the correct type of dock and is ready to be unloaded
                else if(map.getCurrentMap()[row][column].equals(String.valueOf(map.getShipReadyToUnload()))){
                    tile = new TileComponent(unloadShipImage);
                    this.add(tile, removeIndex);
                }
                
                //if the ship is safe at sea and is a cargo ship
                else if(map.getCurrentMap()[row][column].equals(String.valueOf(map.getCargoShipSafeAtSea()))){
                    tile = new TileComponent(cargoShipImage);
                    this.add(tile, removeIndex);
                }
                
                //if the ship is safe at sea and is a container ship
                else if(map.getCurrentMap()[row][column].equals(String.valueOf(map.getContainerShipSafeAtSea()))){
                    tile = new TileComponent(containerShipImage);
                    this.add(tile, removeIndex);
                }
                
                //if the ship is safe at sea and is a oil tanker
                else if(map.getCurrentMap()[row][column].equals(String.valueOf(map.getTankerSafeAtSea()))){
                    tile = new TileComponent(oilTankerImage);
                    this.add(tile, removeIndex);
                }
            }
            
            validate();
            //repaint();
            
            
        }catch(IOException e){
            e.printStackTrace();
        }
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
	 
    
    @Override
    public void paint(Graphics g){
            super.paint(g);
    } 
    
}