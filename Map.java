/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgbyte.me;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Niems
 */
/*
 * The Map class is used to represent where a ship, port, and dock can exist.
 * It's also used to draw the map to the screen containing the ships, docks, 
 * and port.
*/
public class Map {
    public static int stateUnsafe = 0; //if the ship is unsafe
    public static int stateSafeAtSea = 1; //if the ship is safe at sea
    public static int stateSafeAtDock = 2; //if the ship is safe at a dock
    
    protected FileHandler file; //used to read and save files
    protected Menu menu; //the navigation for the program
    private char water;
    private char land; 
    private char dockWithoutShip; //dock with no ship
    private char shipAtSea;
    private char shipAtDock;
    
    private char unoccupiedDock;
    private char cargoShipSafeAtSea;
    private char unoccupiedCrane;
    private char containerShipSafeAtSea;
    private char unoccupiedPier;
    private char tankerSafeAtSea;
    private char unsafeShip;
    private char shipReadyToUnload;
    
    private int mapRows; //number of rows in the map
    private int mapCols; //number of columns in the map
    private String[][] geoStatus; //land or sea 
    private String[][] currentMap; //includes ship and dock locations
    private ArrayList<CargoShip> currentShips; //current ships displayed on the map
    private ArrayList<SeaMonster> seamonsters; //current seamonsters displayed on the map
    private Port port; //current port
   
    
    public Map() {
        this.port = new Port();
        this.currentShips = new ArrayList();
        this.seamonsters = new ArrayList();
        this.file = null;
        this.menu = new Menu();
        this.water = '.';
        this.land = '*';
        this.mapRows = 36;
        this.mapCols = 54; 
        this.geoStatus = null;
        this.currentMap = null;
        
        this.unoccupiedDock = 'D';
        this.cargoShipSafeAtSea = 'S';
        this.unoccupiedCrane = 'C';
        this.containerShipSafeAtSea = 'B';
        this.unoccupiedPier = 'P';
        this.tankerSafeAtSea = 'T';
        this.unsafeShip = 'X';
        this.shipReadyToUnload = '$';
    }
    
    //this will display the map of all the components if the map exists
    public void showMap() throws InterruptedException {
        if(this.currentMap != null){
            int tempRow = 0, tempColumn = 0; //used to determine the placement of the objects on the map
            int shipStatus = 0; //determines the status of the current ship
            
            //MAP RESET
            for(int i = 0; i < this.mapRows; i++){
                for(int j = 0; j < this.mapCols; j++){
                    this.currentMap[i][j] = this.geoStatus[i][j];
                }
            } 
            
            
            //LOADS ALL DOCKS ONTO MAP
            for(int i = 0; i < this.port.getDock().size(); i++){
                tempRow = MapConverter.lat2row(this.port.getDock().get(i).getLatitude());
                tempColumn = MapConverter.lon2col(this.port.getDock().get(i).getLongitude());
                
                if(this.port.getDock().get(i) instanceof Pier){
                    this.currentMap[tempRow][tempColumn] = String.valueOf(this.unoccupiedPier);
                }
                        
                else if(this.port.getDock().get(i) instanceof Crane){
                    this.currentMap[tempRow][tempColumn] = String.valueOf(this.unoccupiedCrane);
                }
                
                else if(this.port.getDock().get(i) instanceof Dock){
                    this.currentMap[tempRow][tempColumn] = String.valueOf(this.unoccupiedDock);
                }
            } 
            
            System.out.println("Ship size: " + this.currentShips.size());
            
            //LOADS ALL SHIPS ONTO MAP
            for(int i = 0; i < this.currentShips.size(); i++){ 
                tempRow = MapConverter.lat2row(this.currentShips.get(i).latitude);
                tempColumn = MapConverter.lon2col(this.currentShips.get(i).longitude);
                
                shipStatus = this.currentShips.get(i).safe(i, this); //returns status of current ship
                
                if(shipStatus == Map.stateUnsafe){
                    this.currentMap[tempRow][tempColumn] = String.valueOf(this.unsafeShip);
                }
                
                else if(shipStatus == Map.stateSafeAtDock){
                    this.currentMap[tempRow][tempColumn] = String.valueOf(this.shipReadyToUnload);
                }
                
                else if(shipStatus == Map.stateSafeAtSea){
                    this.currentMap[tempRow][tempColumn] = String.valueOf(this.currentShips.get(i).getSymbol());
                }
            }

            //DISPLAY MAP
            for(int i = 0; i < this.mapRows; i++) {
                for(int j = 0; j < this.mapCols; j++) {
                    System.out.print(this.currentMap[i][j]);
                }
                System.out.println();
            }
        }
        else{
            System.out.println("Must load system before using this.\n");
        }
    }
    
    public void display() {
        //this will use previously written display functions to display
        //the information for 
    }
    
    public Port getPort() {
        return this.port;
    }
    
    public void setPort(Port port) {
        this.port = port;
    }

    /**
     * @return the water
     */
    public char getWater() {
        return water;
    }

    /**
     * @param water the water to set
     */
    public void setWater(char water) {
        this.water = water;
    }

    /**
     * @return the land
     */
    public char getLand() {
        return this.land;
    }

    /**
     * @param land the land to set
     */
    public void setLand(char land) {
        this.land = land;
    }

    /**
     * @return the dockWithoutShip
     */
    public char getDockWithoutShip() {
        return this.dockWithoutShip;
    }

    /**
     * @param dockWithoutShip the dockWithoutShip to set
     */
    public void setDockWithoutShip(char dockWithoutShip) {
        this.dockWithoutShip = dockWithoutShip;
    }

    /**
     * @return the shipAtSea
     */
    public char getShipAtSea() {
        return this.shipAtSea;
    }

    /**
     * @param shipAtSea the shipAtSea to set
     */
    public void setShipAtSea(char shipAtSea) {
        this.shipAtSea = shipAtSea;
    }

    /**
     * @return the shipAtDock
     */
    public char getShipAtDock() {
        return this.shipAtDock;
    }

    /**
     * @param shipAtDock the shipAtDock to set
     */
    public void setShipAtDock(char shipAtDock) {
        this.shipAtDock = shipAtDock;
    }

    /**
     * @return the shipUnsafe
     */
    public char getUnsafeShip() {
        return this.unsafeShip;
    }

    /**
     * @param unsafeShip the shipUnsafe to set
     */
    public void setUnsafeShip(char unsafeShip) {
        this.unsafeShip = unsafeShip;
    }

    /**
     * @return the mapRows
     */
    public int getMapRows() {
        return this.mapRows;
    }

    /**
     * @param mapRows the mapRows to set
     */
    public void setMapRows(int mapRows) {
        this.mapRows = mapRows;
    }

    /**
     * @return the mapCols
     */
    public int getMapCols() {
        return this.mapCols;
    }

    /**
     * @param mapCols the mapCols to set
     */
    public void setMapCols(int mapCols) {
        this.mapCols = mapCols;
    }

    /**
     * @return the geoStatus
     */
    public String[][] getGeoStatus() {
        return this.geoStatus;
    }

    /**
     * @param geoStatus the geoStatus to set
     */
    public void setGeoStatus(String[][] geoStatus) {
        this.geoStatus = geoStatus;
    }

    /**
     * @return the currentMap
     */
    public String[][] getCurrentMap() {
        return currentMap;
    }

    /**
     * @param currentMap the currentMap to set
     */
    public void setCurrentMap(String[][] currentMap) {
        this.currentMap = currentMap;
    }

    /**
     * @return the currentShips
     */
    public ArrayList<CargoShip> getCurrentShips() {
        return this.currentShips;
    }

    /**
     * @param currentShips the currentShips to set
     */
    public void setCurrentShips(ArrayList<CargoShip> currentShips) {
        this.currentShips = currentShips;
    }
    
    
    
    public void generateShips( int size) throws NullPointerException {
        if(this.geoStatus != null){
            CargoShip cargoShip = null;
            ContainerShip containerShip = null;
            OilTanker tanker = null;
            
            Scanner input = new Scanner(System.in);
            Random rand = new Random();
            String name = new String();
            String fName[] = {"Red", "Green", "Dark", "Light", "Day", "Night", "Savanah", "Mountain", "Captain's", "Admiral's"};
            String lName[] = {"Buffalo", "Pastures", "Knight", "Wave", "Star", "Moon", "Lion", "Goat", "Pride", "Joy"};
            double highLimit = 0.0, lowLimit = 0.0;
            double latitude = 0.0, longitude = 0.0;
            //int size = 0, i = 0; //number of ships to generate  
            int tempRow = 0, tempColumn = 0; //used to determine if the ship is valid(not on land)
            int shipType = 0; //determines which ship type to generate
            boolean valid = true; //true if the ship isn't generated on land
            int i = 0;
            rand.setSeed(System.currentTimeMillis()); 
            
            
            try{

                /*do{
                    System.out.print("Enter the number of ships to generate(1-10): ");
                    System.out.flush();
                    size = input.nextInt();

                    if(size < 1 || size > 10){ 
                        System.out.println("You must enter a number between 1 and 10.");
                    }

                }while(size < 1 || size > 10);*/

                for(i = 0; i < size; i++) { //creates the ships

                    do{ 
                        valid = true; //reset
                        //generates the location to use for the ship
                        tempRow = rand.nextInt(this.mapRows);
                        tempColumn = rand.nextInt(this.mapCols);
                        
                        latitude = MapConverter.row2lat(tempRow);
                        longitude = MapConverter.col2lon(tempColumn);
                                                                           
                        if(this.geoStatus[tempRow][tempColumn].equals(String.valueOf(this.land))){
                            valid = false; //the ship was generated on land
                        }

                    }while(valid == false); //loops until the ship isn't generated on land
                    
                    shipType = rand.nextInt(3); //new ship type generated each iteration
                    name = fName[rand.nextInt(10)] + " " + lName[rand.nextInt(10)]; //generates new ship name
                    int randomNum = rand.nextInt((9000000 - 1000000) + 1) + 1000000;
                    
                    if(shipType == 0){
                        cargoShip = new CargoShip(); //memory for new ship
                        cargoShip.setName(name);
                        cargoShip.setTransponder(randomNum); //generates new transponder number
                        cargoShip.setLatitude(latitude);
                        cargoShip.setLongitude(longitude);
                        this.currentShips.add(cargoShip);
                    }
                    else if(shipType == 1){
                        containerShip = new ContainerShip();
                        containerShip.setName(name);
                        containerShip.setTransponder(randomNum); //generates new transponder number 
                        containerShip.setLatitude(latitude);
                        containerShip.setLongitude(longitude);
                        this.currentShips.add(containerShip);
                        
                    }
                    else if(shipType >= 2){
                        tanker = new OilTanker();
                        tanker.setName(name);
                        tanker.setTransponder(randomNum); //generates new transponder number
                        tanker.setLatitude(latitude);
                        tanker.setLongitude(longitude);
                        this.currentShips.add(tanker);
                    }
                }
                
                System.out.println("Ships successfully generated.");
            }catch(InputMismatchException e){
                System.out.println("Invalid input given.");
            }catch(Exception e) {
                System.out.println("An error occurred D:");
            }
        }
        else{
            System.out.println("The map must be loaded before trying to generate ships.");
        }
    }
    
    public void updateShip() { //don't run function call if size is < 1
        Scanner input = new Scanner(System.in);
        int i = 0, selection = -1;
        
        if(this.currentShips.size() > 0)
        {
            try{
                System.out.println("\nCurrent Ships");
                    System.out.println("--------------------");
                for(i = 0; i < currentShips.size(); i++) {
                    System.out.println(i + " " + currentShips.get(i).getName());
                }

                System.out.println(i + " Previous Menu");

                do{
                    System.out.println("--------------------");
                    System.out.print("Enter ship number to update: ");
                    System.out.flush();
                    selection = input.nextInt();    

                    if(selection < 0 || selection > currentShips.size()){
                        System.out.println("Enter a valid selection.");
                    }

                }while(selection < 0 || selection > currentShips.size());

                //call ship properties menu with specific ship here
                if(selection <= currentShips.size() - 1) 
                    menu.shipPropertiesMenu(this, currentShips.get(selection));
            
            }catch(ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
            }catch(InputMismatchException e){
                e.printStackTrace();
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
        
        else{
            System.out.println("No ships to display.");
        }
        
    }
    
    public void displayShips() {
        
        if(this.currentShips.size() > 0){
           for(int i = 0; i < this.currentShips.size(); i++){
                this.currentShips.get(i).display();
                System.out.println("****************************\n");
            } 
        }
        
        else{
            System.out.println("No ships to display.");
        }
        
    }
    
    public void removeShips() {
        int tempRow = 0, tempCol = 0;
        
        if(this.currentShips.size() > 0){
            for(int i = 0; i < this.currentShips.size(); i++){
                tempRow = MapConverter.lat2row(this.currentShips.get(i).latitude);
                tempCol = MapConverter.lon2col(this.currentShips.get(i).longitude);

                this.currentMap[tempRow][tempCol] = this.geoStatus[tempRow][tempCol];
            }

            this.currentShips.clear(); //removes all ships
        }
        
        else{
            System.out.println("No ships to remove");
        }
    }

    /**
     * @return the unoccupiedDock
     */
    public char getUnoccupiedDock() {
        return this.unoccupiedDock;
    }

    /**
     * @param unoccupiedDock the unoccupiedDock to set
     */
    public void setUnoccupiedDock(char unoccupiedDock) {
        this.unoccupiedDock = unoccupiedDock;
    }

    /**
     * @return the cargoShipSafeAtSea
     */
    public char getCargoShipSafeAtSea() {
        return this.cargoShipSafeAtSea;
    }

    /**
     * @param cargoShipSafeAtSea the cargoShipSafeAtSea to set
     */
    public void setCargoShipSafeAtSea(char cargoShipSafeAtSea) {
        this.cargoShipSafeAtSea = cargoShipSafeAtSea;
    }

    /**
     * @return the unoccupiedCrane
     */
    public char getUnoccupiedCrane() {
        return this.unoccupiedCrane;
    }

    /**
     * @param unoccupiedCrane the unoccupiedCrane to set
     */
    public void setUnoccupiedCrane(char unoccupiedCrane) {
        this.unoccupiedCrane = unoccupiedCrane;
    }

    /**
     * @return the containerShipSafeAtSea
     */
    public char getContainerShipSafeAtSea() {
        return this.containerShipSafeAtSea;
    }

    /**
     * @param containerShipSafeAtSea the containerShipSafeAtSea to set
     */
    public void setContainerShipSafeAtSea(char containerShipSafeAtSea) {
        this.containerShipSafeAtSea = containerShipSafeAtSea;
    }

    /**
     * @return the unoccupiedPier
     */
    public char getUnoccupiedPier() {
        return this.unoccupiedPier;
    }

    /**
     * @param unoccupiedPier the unoccupiedPier to set
     */
    public void setUnoccupiedPier(char unoccupiedPier) {
        this.unoccupiedPier = unoccupiedPier;
    }

    /**
     * @return the tankerSafeAtSea
     */
    public char getTankerSafeAtSea() {
        return this.tankerSafeAtSea;
    }

    /**
     * @param tankerSafeAtSea the tankerSafeAtSea to set
     */
    public void setTankerSafeAtSea(char tankerSafeAtSea) {
        this.tankerSafeAtSea = tankerSafeAtSea;
    }

    /**
     * @return the shipReadyToUnload
     */
    public char getShipReadyToUnload() {
        return this.shipReadyToUnload;
    }

    /**
     * @param shipReadyToUnload the shipReadyToUnload to set
     */
    public void setShipReadyToUnload(char shipReadyToUnload) {
        this.shipReadyToUnload = shipReadyToUnload;
    }

    /**
     * @return the seamonsters
     */
    public ArrayList<SeaMonster> getSeamonsters() {
        return seamonsters;
    }

    /**
     * @param seamonsters the seamonsters to set
     */
    public void setSeamonsters(ArrayList<SeaMonster> seamonsters) {
        this.seamonsters = seamonsters;
    }
    
}
