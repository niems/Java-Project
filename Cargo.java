
/*
 * Zach Niemann
 * ID: 1000625866 
 * Homework #1
 */
package pkgbyte.me;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The Cargo class holds all the information
 * about the material being carried on the ship.
 * This includes the weight of the material and
 * what is being shipped.
 */
public class Cargo {
    
    private double weight; //weight in tonnage
    protected String description; //what's being shipped
    
    public Cargo() { //sets default values for cargo
        this.weight = 10.0; 
        this.description = "Bananas!";
    }
    
    public Cargo(double weight, String description){
        this.weight = weight;
        this.description = description;
    }
    
    public Cargo(String values){ //should be weight,description
        String[] items = new String[2];
        
        items = values.split(",");
        this.weight = Double.valueOf(items[0]);
        this.description = items[1];        
    }
    
    /*
     * setWeight sets the current weight of the cargo
     * to the weight passed in tons.
    */
    public void setWeight(){
        Scanner input = new Scanner(System.in);
        double weight = 0.0;
        
        try{
            System.out.print("Enter new cargo weight: ");
            System.out.flush();
            weight = input.nextDouble();
            
            this.weight = weight;
            
        }catch(InputMismatchException e){
            System.out.println("Invalid type entered");
        }catch(Exception e){
            System.out.println("An error has occurred D:");
        }
    }
    
    public void setWeight(double weight) {
        this.weight = weight;
    }
    
     /*
      * setDescription sets the current description of the cargo
      * to the description passed.
     */
    public void setDescription(){
        Scanner input = new Scanner(System.in);
        String description = "";
        
        try{
            System.out.print("Enter new cargo description: ");
            System.out.flush();
            description = input.next();
            
            this.description = description;
            
        }catch(Exception e){
            System.out.println("An error has occurred D:");
        }
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
     /*
      * getWeight returns the current weight of the cargo
      * as a double.
     */
    public double getWeight() {
        return( this.weight );
    }

    public String getDescription() {
        return( this.description );
    }  
    
    public String toString(){
        return( this.getDescription() +"," + this.getWeight() );
    }
    
    public void displayCargo() {
        System.out.println(this.weight + " tons of " + this.description);
    }
    
    public String displayCurrentCargo(){
        return(this.weight + " tons of " + this.description);
    }
}

