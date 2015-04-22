/*
 * Zach Niemann
 * ID: 1000625866 
 * Homework #1
 */
package pkgbyte.me;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * The Dock class deals with the size, location,
 * and number of the current dock. This is used to
 * determine the status of the ship in relation to the dock.
*/
public class Dock {
    protected String name; //current dock name
    protected char section; //current dock section
    protected int number; //number of the current dock
    protected double depth; //depth of the dock in meters
    protected double length; //length of the dock in meters
    protected double width; //width of the dock in meters
    protected double latitude; //latitude of the dock in degrees
    protected double longitude; //longitude of the dock in degrees
    protected char symbol; //dock symbol
    
    Dock() { //sets all the default dock values
        this.name = "Rudolf's Dock";
        this.section = 'N';
        this.number = 100;
        this.depth = 15;
        this.length = 100;
        this.width = 6;
        this.longitude = -2.977838;
        this.latitude = 53.410777;
        this.symbol = 'D'; //dock symbol
    }
    
    Dock(String name, char section, int dockNum, double depth, double length, double width, double lat, double lon, char symbol){
        this.name = name;
        this.section = section;
        this.number = dockNum;
        this.depth = depth;
        this.length = length;
        this.width = width;
        this.longitude = lon;
        this.latitude = lat;
        this.symbol = 'D'; //dock symbol
    }
    
    Dock(String values){ //name, section, docknum, depth, length, width, lat, lon, symbol
        String[] parts = new String[9];
        
        parts = values.split(",");
        this.name = parts[0];
        this.section = parts[1].charAt(0);
        this.number = Integer.valueOf(parts[2]);
        this.length = Double.valueOf(parts[3]);
        this.width = Double.valueOf(parts[4]);
        this.depth = Double.valueOf(parts[5]);
        this.longitude = Double.valueOf(parts[6]);
        this.latitude = Double.valueOf(parts[7]);
        this.symbol = 'D'; //dock symbol
    }
    /*
    public boolean sameLocation(CargoShip ship){ //used with cargo ship, container ship, and tanker
        if(this.latitude == ship.getLatitude() && this.longitude == ship.getLongitude()){
            return true; //ship is at the dock
        }
        
        return false; //ship isn't at the dock
    }
    public boolean sizeCompatible(CargoShip ship) { //used with cargo ship, container ship, and tanker
        
        //if the ship size is incompatible
        if(ship.getLength() > this.length || ship.getBeam() > this.width || ship.getDraft() > this.depth){ 
            return false; 
        }
        
        return true; //ship size is compatible with dock
    }
    
    public boolean shipCompatible(CargoShip ship){ //used with cargo ship, container ship, and tanker
        //compatible ship and dock types
        
        if(ship instanceof ContainerShip && this instanceof Crane){
            return true;
        }        
        else if(ship instanceof OilTanker && this instanceof Pier){
            return true;
        }
        else if(ship instanceof CargoShip && this instanceof Dock){
            return true;
        }
        
        return false; //ship is not compatible with dock
    } */
    
    public int getRow(){ //returns dock row
        return(MapConverter.lat2row(this.latitude));
    }
    
    public int getColumn(){ //returns dock column
        return(MapConverter.lon2col(this.longitude));
    }
    
    public char getSymbol(){
        return this.symbol;
    }
    
    public String getName() { //returns the current dock name
        return( this.name );
    }
    
    public char getSection() { //returns the current dock section
        return( this.section );
    }
    public int getNumber() { //returns the number of the dock
        return( this.number );
    }
    
    public double getDepth() { //returns the depth of the dock in meters
        return( this.depth );
    }
    
    public double getLength() { //returns the length of the dock in meters
        return( this.length );
    }
    
    public double getWidth() { //returns the width of the dock in meters
        return( this.width );
    }
    
    public double getLongitude() { //returns the longitude of the dock in degrees
        return( this.longitude );
    }
    
    public double getLatitude() { //returns the latitude of the dock in degrees
        return( this.latitude );
    }
    
    
    public void setName(String name) { //sets the name of the current dock
        this.name = name;
    }
    
    public void setSection(char section) { //sets the section of the current dock
        this.section = section;
    }
    
    public void setNumber(){
        Scanner input = new Scanner(System.in);
        int number = 0;
        
        try{
            System.out.print("Enter the new dock number: ");
            System.out.flush();
            number = input.nextInt();
            
            this.number = number;
        }catch(InputMismatchException e){
            System.out.println("Invalid type entered.");
        }catch(Exception e){
            System.out.println("An error has occurred D:");
        }
    }
    
    public void setNumber(int number) { //sets the dock number to the integer that's passed
        this.number = number;
    }
    
    public void setDepth(){
        Scanner input = new Scanner(System.in);
        double depth = 0.0;
        
        try{
            System.out.println("Enter new dock depth: ");
            System.out.flush();
            depth = input.nextDouble();
            
            this.depth = depth;
            
        }catch(InputMismatchException e){
            System.out.println("Invalid type entered");
        }catch(Exception e){
            System.out.println("An error has occurred D:");
        }
    }
    
    public void setDepth(double depth) { //sets the dock depth to the double that's passed in meters
        this.depth = depth;
    }
    
    public void setLength(){
        Scanner input = new Scanner(System.in);
        double length = 0.0;
        
        try{
            System.out.println("Enter the new dock length: ");
            System.out.flush();
            length = input.nextDouble();
            
            this.length = length;
            
        }catch(InputMismatchException e){
            System.out.println("Invalid type entered");
        }catch(Exception e){
            System.out.println("An error has occurred D:");
        }
    }
    
    public void setLength(double length) { //sets the dock length to the double that's passed in meters
        this.length = length;
    }
    
    public void setWidth(){
        Scanner input = new Scanner(System.in);
        double width = 0.0;
        
        try{
            System.out.println("New dock width: ");
            System.out.flush();
            width = input.nextDouble();
            
            this.width = width;
            
        }catch(InputMismatchException e){
            System.out.println("Invalid type entered");
        }catch(Exception e){
            System.out.println("An error has occurred D:");
        }
    }
    
    public void setWidth(double width) { //sets the dock width to the double that's passed in meters
        this.width = width;
    }
    
    public void setLongitude(){
        Scanner input = new Scanner(System.in);
        double longitude = 0.0;
        
        try{
            System.out.println("Enter dock longitude: ");
            System.out.flush();
            longitude = input.nextDouble();
            
            this.longitude = longitude;
            
        }catch(InputMismatchException e){
            System.out.println("Invalid type entered");
        }catch(Exception e){
            System.out.println("An error has occurred D:");
        }
    }
    
    public void setLongitude(double longitude) { //sets the dock longitude to the double that's passed in degrees
        this.longitude = longitude;
    }
    
    public void setLatitude(){
        Scanner input = new Scanner(System.in);
        double latitude = 0.0;
        
        try{
            System.out.println("Enter dock latitude: ");
            System.out.flush();
            latitude = input.nextDouble();
            
            this.latitude = latitude;
            
        }catch(InputMismatchException e){
            System.out.println("Invalid type entered");
        }catch(Exception e){
            System.out.println("An error has occurred D:");
        }
    }
    
    public void setLatitude(double latitude) { //sets the dock latitude to the double that's passed in degrees
        this.latitude = latitude;
    }
    
    public String toString(){ //returns a string of the dock info
        return(this.name + "," + this.section + "," + this.number + "," + this.length + "," + this.depth + "," + this.width + "," + this.longitude + "," + this.latitude);
    }
    
    public void displayDockInfo() { //displays the dock info to the screen
        System.out.println(this.name);
        System.out.println("Dock Number: " + this.number);
        System.out.println("Size: " + this.length + " X " + this.depth + " X " + this.width + " metres");
        System.out.println("Location(" + this.longitude + ", " + this.latitude + ")");
        System.out.println("Location(" + MapConverter.lon2col(this.longitude) + ", " + MapConverter.lat2row(this.latitude) + ")\n");
    }
}
