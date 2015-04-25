/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgbyte.me;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Niems
 */
public class FileHandler {
    private Formatter output;
    private File mapFile;
    private File shipFile;
    private File portFile;
    private String currentLine; //current line read in from file
    private String fileName; //stores the base of the file name. ex. 'simple'
                             //used for all files. ex. fileName.category.txt
    
    FileHandler(Map map) {
        this.mapFile = null;
        this.shipFile = null;
        this.portFile = null;
        this.currentLine = null;
        this.fileName = null;      
    }
    
    FileHandler(Map map, String fileName){
        this.mapFile = null;
        this.shipFile = null;
        this.portFile = null;
        this.currentLine = null;
        this.fileName = fileName;
    }
    
    //loads all the files from the main menu
    public void loadAllFiles(Map map) throws NullPointerException{
        
        try{
            this.mapFile = new File(this.fileName + ".map.txt");
            this.portFile = new File(this.fileName + ".port.txt");
            this.shipFile = new File(this.fileName + ".ship.txt");

            //loads in all the file information
            if(this.mapFile.exists()){
                loadMapFile(map);
                System.out.println("Map file successfully loaded.");
            }
            else{
                System.out.println("Failed to load map file.");
            }

            if(this.portFile.exists()){
                loadPortFile(map);
                System.out.println("Port file successfully loaded.");
            }
            else{
                System.out.println("Failed to load port file.");
            }

            if(this.shipFile.exists()){
                loadShipFile(map);
                System.out.println("Ship file successfully loaded.");
            }  
            else{
                System.out.println("Failed to load ship file.");
            }

        }catch(FileNotFoundException e){
            System.out.println("The file name entered could not be found.");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void loadShipFile(Map map) throws FileNotFoundException{
        CargoShip tempShip = new CargoShip();
        Scanner fileInput; 
        String item[] = new String[11]; //splits the items apart
        
        try{
            fileInput = new Scanner(this.shipFile);
            
            //reads until eof
            while(fileInput.hasNext()) {
                currentLine = fileInput.next();
                item = currentLine.split(",");
                
                tempShip.setName(item[0]);
                tempShip.setCountry(item[1]);
                tempShip.setTransponder(Long.valueOf(item[2]));
                tempShip.setCapacity(Double.valueOf(item[3]));
                tempShip.setLength(Double.valueOf(item[4]));
                tempShip.setBeam(Double.valueOf(item[5]));
                tempShip.setDraft(Double.valueOf(item[6]));
                tempShip.setLongitude(Double.valueOf(item[7]));
                tempShip.setLatitude(Double.valueOf(item[8]));
                
                if(item.length > 9) { //if the cargo exists
                    tempShip.getCargo().setDescription(item[9]);
                    tempShip.getCargo().setWeight(Double.valueOf(item[10]));
                }
                
                map.getCurrentShips().add(tempShip); //adds the new ship to the array list
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void loadMapFile(Map map) throws NullPointerException, FileNotFoundException{
        Scanner fileInput; //reads input from the file
        Scanner userInput = new Scanner(System.in); //reads input from the keyboard
        String item[]; //holds the parts of the current line(column,row,type)
        String[][] tempGeoMap = new String[Map.mapRows][Map.mapCols];
        String[][] tempCurrentMap = new String[Map.mapRows][Map.mapCols];
        int row, column; //current row and column
        boolean again = false;
        
        do{
            try {
                again = false; //reset
                fileInput = new Scanner(this.mapFile);
                
                //reads until eof
                while(fileInput.hasNext()) {
                    currentLine = fileInput.next();
                    item = currentLine.split(","); //splits into column,row,type

                    column = Integer.valueOf(item[0]);
                    row = Integer.valueOf(item[1]);
                    tempGeoMap[row][column] = item[2];
                    tempCurrentMap[row][column] = item[2];
                }

                map.setGeoStatus(tempGeoMap); //sets up the layout for the land/sea map
                map.setCurrentMap(tempCurrentMap); //sets the background for the current map
                
                
            }catch(InputMismatchException e) {
                if(this.fileName != "0"){
                    System.out.println("Make sure to enter a string for the file category"); 
                }                
            }        
            catch(Exception e) {
                if(this.fileName != "0"){    
                    System.out.println("An error has occurred while trying to read in the file D:");
                }
            }
        }while(again == true); //loops until a valid file is read or they break to the previous menu
        
    }
    
    public void loadPortFile(Map map) throws NullPointerException, FileNotFoundException{
        //used to temporarily store the data before the arraylist
        Cargo tempCargo = new Cargo();
        Crane tempCrane = new Crane();
        Dock tempDock = new Dock();
        Pier tempPier = new Pier();
        Scanner finput;
        String currentLine;
        String[] part;
        int totalDocks = 0;
        int totalCranes = 0;
        int totalPiers = 0;
        int totalCargo = 0;
        
        
        try{
            finput = new Scanner(this.portFile);
            
            if(finput.hasNextLine()){ //reads in the number of elements for each type
                currentLine = finput.nextLine();
                part = currentLine.split(",");
                map.getPort().setName(part[0]);
                totalDocks = Integer.valueOf(part[1].trim());
                totalCranes = Integer.valueOf(part[2].trim());
                totalPiers = Integer.valueOf(part[3].trim());
                totalCargo = Integer.valueOf(part[4].trim());
                
                for(int i = 0; i < totalDocks && finput.hasNextLine(); i++){ //reads in all dock info
                    currentLine = finput.nextLine();  
                    tempDock = new Dock(currentLine);
                    map.getPort().getDock().add(tempDock);
                }
                
                for(int i = 0; i < totalCranes && finput.hasNextLine(); i++){ //reads in all crane info
                    currentLine = finput.nextLine();
                    tempCrane = new Crane(currentLine);
                    map.getPort().getDock().add(tempCrane);
                    
                }
                
                for(int i = 0; i < totalPiers && finput.hasNextLine(); i++){ //reads in all pier info
                    currentLine = finput.nextLine();
                    tempPier = new Pier(currentLine);
                    map.getPort().getDock().add(tempPier);
                }
                
                for(int i = 0; i < totalCargo && finput.hasNextLine(); i++){ //reads in all cargo
                    currentLine = finput.nextLine();
                    tempCargo = new Cargo(currentLine);
                    map.getPort().getCargo().add(tempCargo);
                }
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
