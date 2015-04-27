
/*
 * Zach Niemann
 * ID: 1000625866 
 * Homework #1
 */
package pkgbyte.me;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * The Ship class stores all the information to do
 * with the cargo ship, including its current coordinates
 * to determine if it's docked or at sea.
*/

public class CargoShip {
    protected Cargo cargo;
    
    protected String name; //name of ship
    protected String country; //country of ship registration
    protected long transponder; //ship transponder number
    protected double capacity; //weight of cargo, in tons
    protected double length; //length of ship, in meters
    protected double beam; //width of the ship, in meters
    protected double draft; //depth of the ship, in meters
    protected double longitude; //longitude of the ship, in degrees
    protected double latitude; //latitude of the ship, in degrees
    protected int row; //current row of the ship
    protected int column; //current column of the ship
    protected char symbol; //ship symbol
    
    public CargoShip() { //default ship values
        this.cargo = new Cargo();
        this.name = "Zenda";
        this.country = "Ruritania";
        this.transponder = 0;
        this.capacity = 10;
        this.length = 90;
        this.beam = 3; //width - 10
        this.draft = 5; //depth
        this.longitude = -2.977838;
        this.latitude = 53.410777; 
        this.symbol = 'S'; //cargo ship symbol
        this.row = 0;
        this.column = 0;
    }
    
    public CargoShip(String name, String country, long transponder, double cargoCapacity, double length, double beam, double draft, double longitude, double latitude){
        this.cargo = new Cargo();
        this.name = name;
        this.country = country;
        this.transponder = transponder;
        this.capacity = cargoCapacity;
        this.length = length;
        this.beam = beam;
        this.draft = draft;
        this.longitude = longitude;
        this.latitude = latitude;
        this.symbol = 'S'; //cargo ship symbol
        this.row = 0;
        this.column = 0;
    }
    
    public CargoShip(String values){ //name,country,transponder,capacity,length,beam,draft,longitude,latitude
        String[] parts = new String[9];
        this.cargo = new Cargo();
        
        parts = values.split(",");
        this.name = parts[0];
        this.country = parts[1];
        this.transponder = Long.valueOf(parts[2]);
        this.capacity = Double.valueOf(parts[3]);
        this.length = Double.valueOf(parts[4]);
        this.beam = Double.valueOf(parts[5]);
        this.draft = Double.valueOf(parts[6]);
        this.longitude = Double.valueOf(parts[7]);
        this.latitude = Double.valueOf(parts[8]);     
        this.symbol = 'S'; //cargo ship symbol
        this.row = 0;
        this.column = 0;
    }
    
    public boolean shipCollision(int currentIteration, Map map){ //checks for ship collision with current ship
        for(int i = 0; i < map.getCurrentShips().size(); i++){ 
            if(i != currentIteration){ //so it doesn't check itself
                if(this.latitude == map.getCurrentShips().get(i).getLatitude() &&
                   this.longitude == map.getCurrentShips().get(i).getLongitude()){
                   return false; //ship collision
                }
            }
        }
        
        return true; //no collision with the current ship
    }
    
    //checks if the current ship is at this particular dock
    public boolean atDock(Dock dock){
        if(this.getRow() == dock.getRow() && this.getColumn() == dock.getColumn())
            return true; //ship is at current dock
        
        return false; //the current ship is not at this dock
    }
    
    public boolean dockCompatible(Dock dock, Map map){ //returns if the dock is compatible with the current ship
        
        if(this.symbol == map.getCargoShipSafeAtSea() && dock.getSymbol() == map.getUnoccupiedDock())
            return true; //current ship and dock are compatible
        
        else if(this.symbol == map.getContainerShipSafeAtSea() && dock.getSymbol() == map.getUnoccupiedCrane())
            return true; //current ship and dock are compatible
        
        else if(this.symbol == map.getTankerSafeAtSea() && dock.getSymbol() == map.getUnoccupiedPier())
            return true; //current ship and dock are compatible
        
        System.out.println("Source: dockCompatible() ");
        return false; //current ship and dock are not compatible
    }
    
    public boolean shipSizeCompatible(Dock dock){ //returns if the ship size is compatible with the dock
        
        if(this.length <= dock.getLength() && this.beam <= dock.getWidth() && this.draft <= dock.getDepth())
            return true; //the ship is compatible with the dock
        
        return false; //ship size incompatible with dock
    }
   
    public int safe(int currentIteration, Map map){ //checks to see if the current ship is safe
        
        //checks for ship collision
        if(shipCollision(currentIteration, map) == false) 
            return Map.stateUnsafe; //unsafe - a ship collision occurred
        
        //checks all docks against current ship for safety concerns
        for(int i = 0; i < map.getPort().getDock().size(); i++){ 
            
            if(this.atDock(map.getPort().getDock().get(i)) == true){ //if the ship is at the dock
                
                if(this.dockCompatible(map.getPort().getDock().get(i), map) == false)
                    return Map.stateUnsafe; //unsafe - ship is not compatible with dock
                
                else if(this.shipSizeCompatible(map.getPort().getDock().get(i)) == false)
                    return Map.stateUnsafe; //unsafe - ship is too big for dock
                
                return Map.stateSafeAtDock; //safe - ship is compatible with dock
            }
        }
        
        return Map.stateSafeAtSea; //ship is safe
    }
    
    public int getRow(){ //gets the current row of the ship
        return(this.row);
    }
    
    public int getColumn(){ //gets the current column of the ship
        return(this.column);
    }
    
    public String getName() { //returns the current ship name
        return( this.name );
    }
    
    public String getCountry() { //returns the country the ships registered in
        return( this.country );
    }
    
    public long getTransponder() { //returns the ship transponder number
        return( this.transponder );
    }
    
    public double getCapacity() { //returns the cargo capacity of the ship in tons
        return( this.capacity );
    }
    
    public double getLength() { //returns the length of the ship in meters
        return ( this.length );
    }
    
    public double getBeam() { //returns the width of the ship in meters
        return( this.beam );
    }
    
    public double getDraft() { //returns the depth of the ship in meters 
        return( this.draft );
    }
    
    public double getLongitude() { //returns the longitude of the ship in degrees
        return( this.longitude );
    }
    
    public double getLatitude() { //returns the latitude of the ship in degrees
        return( this.latitude );
    }
    
    
    public void setRowAndCol(Map map){
        Scanner input = new Scanner(System.in);
        int tempRow = 0, tempCol = 0;
        int maxRow = Map.mapRows - 1;
        int maxCol = Map.mapCols - 1;
        boolean valid = true; //false if input given is invalid
        
        try{
            do{
                valid = true; //reset
                
                System.out.printf("Enter the new row(%d - %d): ", 0, maxRow);
                System.out.flush();
                tempRow = input.nextInt();
                
                if(tempRow < 0 || tempRow > maxRow){ //out of range
                    valid = false;
                }
                
                System.out.printf("Enter the new column(%d - %d): ", 0, maxCol);
                System.out.flush();
                tempCol = input.nextInt();
                
                if(tempCol < 0 || tempCol > maxCol){ //out of range
                    valid = false;
                }
                
                if(valid){ //only updates the position if valid input was given  
                    
                    //if the position entered is on land
                    if(map.getCurrentMap()[tempRow][tempCol].equals(String.valueOf(map.getLand()))){
                        System.out.println("Invalid position: row & col is on land");
                        valid = false;
                    }
                    
                    else{                        
                        this.setLatitude(MapConverter.row2lat(tempRow));
                        this.setLongitude(MapConverter.col2lon(tempCol));  
                    }
                }
                
                else{
                    System.out.println("Invalid row and column entered.\n");
                }
                
            }while(!valid);
                
        }catch(InputMismatchException e){
            System.out.println("Invalid input.");
        }catch(Exception e){
            e.printStackTrace();
        }
         
    }
    
    public void setName(){
        Scanner input = new Scanner(System.in);
        String name; //new name of ship
        
        try{
            System.out.print("Enter a new name: ");
            System.out.flush();
            name = input.next();
            
            this.name = name;
            
        }catch(Exception e){
            System.out.println("An error has occurred D:");
        }
    }
    
    public void setName(String name) { //sets the current ship name to the string passed
        this.name = name;
    }
    
    public void setCountry(){
        Scanner input = new Scanner(System.in);
        String country;
        
        try{
            System.out.print("New country registered: ");
            System.out.flush();
            country = input.next();
            
            this.country = country;
            
        }catch(Exception e){
            System.out.println("An error has occurred D:");
        }
    }
    
    public void setCountry(String country) { //sets the current registered country of the ship to the string passed
        this.country = country;
    }
    
    public void setTransponder(){
        Scanner input = new Scanner(System.in);
        long transponder = 0;
        
        try{
            System.out.println("Enter transponder number: ");
            System.out.flush();
            transponder = input.nextLong();
            
            this.transponder = transponder;
            
        }catch(InputMismatchException e){
            System.out.println("Invalid type entered.");
        }catch(Exception e){
            System.out.println("An error has occurred D:");
        }
    }
    
    public void setTransponder(long number) { //sets the current transponder number to the long number passed
        this.transponder = number;
    }
    
    public void setCapacity(){
        Scanner input = new Scanner(System.in);
        double capacity = 0.0;
        
        try{
            System.out.print("Enter the new capacity: ");
            System.out.flush();
            capacity = input.nextDouble();
            
            this.capacity = capacity;
            
        }catch(InputMismatchException e){
            System.out.println("Invalid type entered.");
        }catch(Exception e){
            System.out.println("An error has occurred D:");
        }
    }
    
    public void setCapacity(double capacity) { //sets the current cargo capacity to the capacity passed in tons
        this.capacity = capacity;
    }
    
    public void setLength(){
        Scanner input = new Scanner(System.in);
        double length = 0.0;
        
        try{
            System.out.print("Enter new ship length: ");
            System.out.flush();
            length = input.nextDouble();
            
            this.length = length;
            
        }catch(InputMismatchException e){
            System.out.println("Invalid type entered");
        }catch(Exception e){
            System.out.println("An error has occurred D:");
        }
    }
    
    public void setLength(double length) { //sets the ship length to the length passed in meters
        this.length = length;
    }
    
    public void setBeam(){
        Scanner input = new Scanner(System.in);
        double beam = 0.0;
        
        try{
            System.out.print("Enter new ship beam(width): ");
            System.out.flush();
            beam = input.nextDouble();
            
            this.beam = beam;
            
        }catch(InputMismatchException e){
            System.out.println("Invalid type entered");
        }catch(Exception e){
            System.out.println("An error has occurred D:");
        }
    }
    
    public void setBeam(double width) { //sets the ship width based on the width passed in meters
        this.beam = width;
    }
    
    public void setDraft(){
        Scanner input = new Scanner(System.in);
        double draft = 0.0;
        
        try{
            System.out.print("Enter new ship draft(depth): ");
            System.out.flush();
            draft = input.nextDouble();
            
            this.draft = draft;
            
        }catch(InputMismatchException e){
            System.out.println("Invalid type entered");
        }catch(Exception e){
            System.out.println("An error has occurred D:");
        }
    }
    
    public void setDraft(double depth) { //sets the depth of the ship based on the depth passed in meters
       this.draft = depth;
    }
    
    public void setLongitude(){
        Scanner input = new Scanner(System.in);
        double longitude = 0.0;
        
        try{
            System.out.print("Enter new ship longitude: ");
            System.out.flush();
            longitude = input.nextDouble();
            
            this.longitude = longitude;
            
        }catch(InputMismatchException e){
            System.out.println("Invalid type entered");
        }catch(Exception e){
            System.out.println("An error has occurred D:");
        }
    }  
    
    public void setLatitude(){
        Scanner input = new Scanner(System.in);
        double latitude = 0.0;
        
        try{
            System.out.print("Enter new ship latitude: ");
            System.out.flush();
            latitude = input.nextDouble();
            
            this.latitude = latitude;
            
        }catch(InputMismatchException e){
            System.out.println("Invalid type entered");
        }catch(Exception e){
            System.out.println("An error has occurred D:");
        }
    }
    
    public void setLongitude(double longitude) { //sets the longitude of the ship in degrees
        this.longitude = longitude;
    }
    
    public void setLatitude(double latitude) { //sets the latitude of the ship in degrees
        this.latitude = latitude;
    }
    
    public void setRow(int row){
       this.row = row;
    }
    
    public void setColumn(int column){
        this.column = column;
    }
    
    public String toString(){
        String temp = new String();
        temp ="Cargo Ship," + this.getName() + "," + this.getCountry() + "," + this.getCapacity() + "," + this.getLength() + ","
                            + this.getBeam() + "," + this.getDraft() + "," + this.getLatitude() + "," + this.getLongitude();
        
        if(this.getCargo() != null){ //adds cargo if it exists for the current ship
            temp += "," + this.getCargo().toString();
        }
        
        
        return(temp);                
    }
    
    public void display() { //displays the current information about the ship
        System.out.println("Cargo Ship: " + this.name);
        System.out.println("Country of Origin: " + this.country);
        System.out.println("Transponder: " + this.transponder);
        System.out.println("Size: " + (int)this.getLength() + "(length) x " + (int)this.getDraft() + "(depth) x " + (int)this.getBeam() + "(width) meters");
        
        System.out.println("Capacity: " + this.capacity + " tons");
        System.out.println("Location (" + this.longitude + "," + this.latitude + ")");
        System.out.println("Location (" + MapConverter.lon2col(this.longitude) + "," + MapConverter.lat2row(this.latitude) + ")");
        this.getCargo().displayCargo();
    }

    /**
     * @return the cargo
     */
    public Cargo getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the symbol
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * @param symbol the symbol to set
     */
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

}