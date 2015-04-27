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
public class MapComponent extends JComponent {
	BufferedImage image;

	public MapComponent() {
		this.setLayout(new GridLayout(Map.mapRows, Map.mapCols, 0, 0));
	}
	
	// updates the base layer of the map (land or sea tiles)
	// comment out everything in constructor except for the layout. The rest
	// of the information is to be set in this function
	public void updateBaseMap(Map map) {

		/**************************************
		 * Reading in land and sea graphics 
		 * and adding to map GUI
		 * 
		 **************************************/
		
		try {
			// used to tile the map
			TileComponent tile = null;
			BufferedImage seaImage = ImageIO.read(new File("sea.png"));
			BufferedImage landImage = ImageIO.read(new File("land.png"));

			for (int i = 0; i < Map.mapRows; i++) {
				for (int j = 0; j < Map.mapCols; j++) {
					if (map.getGeoStatus()[i][j].equals(String.valueOf(map.getLand()))) {
						tile = new TileComponent(landImage);
						this.add(tile);
					}
					
					else if (map.getGeoStatus()[i][j].equals(String.valueOf(map.getWater()))){
						tile = new TileComponent(seaImage);
						this.add(tile);
					}
				}
			}

			validate();
			repaint();

		} catch (IOException e) {
			e.printStackTrace();
		}

		/**************************************
		 * Reading in docks, ports, and crane 
		 * graphics and adding to map GUI
		 * 
		 **************************************/
		
		try {
			int index, row, col;
			double lon, lat;
			// used to tile the map
			TileComponent tile = null;
			BufferedImage dockImage = ImageIO.read(new File("Dock.png"));
			BufferedImage pierImage = ImageIO.read(new File("Pier.png"));
			BufferedImage craneImage = ImageIO.read(new File("Crane.png"));

			
			for (int i = 0; i < map.getPort().getDock().size(); i++) {
				if(map.getPort().getDock().get(i).symbol == map.getUnoccupiedDock()) {
					tile = new TileComponent(dockImage);
				}
				
				else if(map.getPort().getDock().get(i).symbol == map.getUnoccupiedPier()) {
					tile = new TileComponent(pierImage);
				}
				
				else {
					tile = new TileComponent(craneImage);
				}
				
				lon = map.getPort().getDock().get(i).getLongitude();
				lat = map.getPort().getDock().get(i).getLatitude();
				
				col = MapConverter.lon2col(lon);
				row = MapConverter.lat2row(lat);
				
				index = row * Map.mapCols + col;
				
				this.remove(index);
				this.add(tile,index);
			}

			//this.add(new TileComponent(dockImage));
			
			validate();
			repaint();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Dimension getPreferredSize() {
		if (image == null) {
			return new Dimension(800, 600);
		} else {
			return new Dimension(600, 600);
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		/*
		BufferedImage dockImage;
		try {
			dockImage = ImageIO.read(new File("Dock.png"));
			g.drawImage(dockImage,0 * 25, 0 * 25, this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*
		try {
			// used to tile the map
			TileComponent tile = null;
			BufferedImage seaImage = ImageIO.read(new File("sea.png"));
			BufferedImage landImage = ImageIO.read(new File("land.png"));

			for (int i = 0; i < 54; i++) {
				for (int j = 0; j < 36; j++) {
					seaImage = ImageIO.read(new File("sea.png"));
					g.drawImage(seaImage, i* 10, j * 10, this);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}

}
