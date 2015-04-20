/*
 * Zach Niemann
 * ID: 1000625866 
 * Homework #1
 */
package pkgbyte.me;

import javax.swing.JOptionPane;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * The menu class is made up of all the menus 
 * in the program. This is where the user navigates
 * through the program
 */
public class Menu {
    
    public void mainMenu(Map map) {
       Scanner input = new Scanner(System.in);
       String selection;
       boolean again; //if true, it loops again
       
       do{ //menu loop. Breaking out of this means the user has quit
            again = true; //reset
            try{
               
                System.out.println("\nMain Menu");
                System.out.println("------------------");
                System.out.println("1. Show Student ID");
                System.out.println("2. Load System");
                System.out.println("3. Ship Menu");
                System.out.println("4. Port Menu");
                System.out.println("5. Show Map");
                System.out.println("6. Display Report");
                System.out.println("7. Quit");

                System.out.print("\nEnter the menu number: ");
                System.out.flush(); //clears buffer
                selection = input.next();
            
                switch(selection) {
                case "1": 
                    studentID();
                    break;
                case "2": 
                    loadSystem(map);
                    break;
                case "3": 
                    shipMenu(map);
                    break;
                case "4": 
                    portMenu(map);
                    break;
                case "5":
                    map.showMap();                      
                    break;
                case "6": 
                    System.out.println("Need to code display report function");
                    break;
                case "7": //quit
                    JOptionPane.showMessageDialog(null, "You're a quitter!", "User Type: Quitter", JOptionPane.PLAIN_MESSAGE);
                    again = false; //doesn't loop again
                    break;
                }
                
            }catch(NullPointerException e){ //catches all null pointer exceptions from the menu functions
                System.out.println("Null pointer caught");
                e.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }
            
       }while(again == true);
    }
    
    public void studentID() { //displays the student ID info 
        String about = "Byte Me\nCSE 1325-002\nApril 17,2015\n\nName: Cam Nguyen\nID: ?\n\nName: Pauline Nguyen\n ID: ?\n\nName: Zach Niemann\nID: 1000625866\n\n";
        JOptionPane.showMessageDialog(null, about, "About Us", JOptionPane.PLAIN_MESSAGE);
    }
    
    public void loadSystem(Map map){
        String fileName = "";
        Scanner input = new Scanner(System.in);
        try{
            System.out.print("Please enter a tag for your load files: ");
            System.out.flush();
            fileName = input.next(); //reads in the file name to use in the FileHandler
            
            map.file = new FileHandler(map, fileName);
            map.file.loadAllFiles(map); 
        }catch(Exception e){
            e.printStackTrace();
        }      
    }
    
    public void shipMenu(Map map) throws NullPointerException{ //allows you to navigate through the 
        Scanner input = new Scanner(System.in);    //ship options. Includes cargo and ship
        String selection;
        boolean again = false; //if true, it loops again
        
        do{
            try{
                again = true; //reset

                System.out.println("\nShip Menu");
                System.out.println("---------------");
                System.out.println("1. Generate Ships");
                System.out.println("2. Update Ship");
                System.out.println("3. Display Ships");
                System.out.println("4. Remove Ships"); 
                System.out.println("5. Previous Menu");

                System.out.print("\nEnter the menu number: ");
                System.out.flush(); 
                selection = input.next();

                switch(selection) {
                    case "1": //Generate Ships
                        map.generateShips();                        
                        break;
                    case "2": //Update Ship
                         map.updateShip();
                        break;
                    case "3": //Display Ships
                        map.displayShips();
                        break;
                    case "4": //Remove all Ships
                        map.removeShips();
                        break;
                    case "5": //Previous Menu
                        again = false; //exit the current menu
                        System.out.println("Returning to previous menu.\n");
                        break;
                } 
            
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }while(again == true);
    }
    
    /*
     * Used to navigate all the updates that can be made
     * to the ship and cargo classes, which is why they're
     * used as parameters
    */
    public void shipPropertiesMenu(Map map, CargoShip ship) {  
        Scanner input = new Scanner(System.in);
        String selection;
        boolean again = false; //if true, it loops again
        
        do {
            try{
                again = false; //reset - default assumes it will not run again

                System.out.println("\nShip Properties Menu");
                System.out.println("--------------------");
                System.out.println("1. Update Name");
                System.out.println("2. Update Registration");
                System.out.println("3. Update Transponder");
                System.out.println("4. Update Capacity");
                System.out.println("5. Update Length");
                System.out.println("6. Update Beam(width)");
                System.out.println("7. Update Draft(depth)");
                System.out.println("8. Update Longitude and Latitude");
                System.out.println("9. Update Row and Column");
                System.out.println("10. Update Cargo");
                System.out.println("11. Display the Ship");
                System.out.println("12. Previous Menu");

                System.out.print("\nEnter the menu number: ");
                System.out.flush(); //clears buffer
                selection = input.next();


                switch(selection) {
                    case "1": //update name 
                        ship.setName();            
                        break;                    
                    case "2": //update registration
                        ship.setCountry();
                        break;
                    case "3": //update transponder
                        ship.setTransponder();
                        break;
                    case "4": //update capacity
                        ship.setCapacity();
                        break;
                    case "5": //update length
                        ship.setLength();
                        break;
                    case "6": //update beam
                        ship.setBeam();
                        break;
                    case "7": //update draft
                        ship.setDraft();
                        break;
                    case "8": //update longitude and latitude
                        ship.setLongitude();
                        ship.setLatitude();
                        break;
                    case "9": //update ship position
                        ship.setRowAndCol(map);
                        break;
                    case "10": //update cargo label
                        cargoPropertiesMenu(ship.getCargo());                    
                        break;
                    case "11": //display the ship
                        ship.display();
                        break;
                    case "12": //previous menu
                        again = false; //exits menu
                        System.out.println("Returning to previous menu");
                        break;
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }while(again == true); //loops until the user wants to return to the previous menu
    }
    
    /*
     * Used to navigate and modify the cargo menu, which is why
     * the cargo object is passed
    */
    public void cargoPropertiesMenu(Cargo cargo) { 
        Scanner input = new Scanner(System.in);
        String selection;
        boolean again = false; //if true, it loops again
        
        do {
            try{
                again = true; //reset

                System.out.println("Cargo Properties Menu");
                System.out.println("----------------------\n");
                System.out.println("1. Update Description");
                System.out.println("2. Update Weight");
                System.out.println("3. Display Cargo");
                System.out.println("4. Previous Menu");

                System.out.print("\nEnter the menu number: ");
                System.out.flush(); //clears buffer
                selection = input.next();

                switch(selection) {
                    case "1": //update description
                        cargo.setDescription();
                        break;
                    case "2": //update weight
                        cargo.setWeight();
                        break;
                    case "3": //display cargo
                        cargo.displayCargo();
                        break;
                    case "4": //previous menu
                        again = false; //doesn't loop again
                        System.out.println("Returning to previous menu");
                        break;
                }
            
            }catch(Exception e){
                System.out.println("An error has occurred D:");
            }
            
        }while(again == true);
    }
    
    /*
     * Used to navigate what you're able to do with the
     * dock object. The dock object is passed for access
     * and modification
    */
    public void dockMenu(Dock dock) {
        Scanner input = new Scanner(System.in);
        String selection;
        boolean again; //if true, it loops again
        
        do {
            again = true; //reset
            
            System.out.println("\nDock Menu: ");
            System.out.println("----------------------");
            System.out.println("1. Allocate Memory for Dock");
            System.out.println("2. Update Dock");
            System.out.println("3. Set Dock to Null");
            System.out.println("4. Display the Dock");
            System.out.println("5. Previous Menu");

            System.out.print("\nEnter the menu number: ");
            System.out.flush(); //clears buffer
            selection = input.next();
            
            switch(selection) {
                case "1": //allocate memory for Dock
                    dock = new Dock();
                    break;
                case "2": //update dock
                    dockPropertiesMenu(dock);
                    break;
                case "3": //Set Dock to Null
                    dock = null;
                    System.out.println("Dock set to null.");
                    break;
                case "4": //display the dock
                    if(dock != null)
                        dock.displayDockInfo();
                    else
                        System.out.println("Dock does not exist");
                    break;
                case "5": //Previous Menu
                    again = false; //doesn't loop again
                    System.out.println("Returning to main menu");
                    break;
            } 
            
        }while(again == true); 
    }
    
    /*
     * Used to change the settings of the dock object
    */
    public void dockPropertiesMenu(Dock dock) {
        Scanner input = new Scanner(System.in);
        String selection;
        boolean again = false; //menu loops if true
        
        if(dock != null){
            do {
                try{
                    again = true; //reset

                    System.out.println("\nDock Properties Menu");
                    System.out.println("----------------------");
                    System.out.println("1. Set the number");
                    System.out.println("2. Set the length");
                    System.out.println("3. Set the width");
                    System.out.println("4. Set the depth");
                    System.out.println("5. Set longitude and latitude");
                    System.out.println("6. Display the Dock");
                    System.out.println("7. Previous Menu");

                    System.out.print("\nEnter the menu number: ");
                    System.out.flush(); //clears buffer
                    selection = input.next();
                        
                    switch(selection) {
                        case "1": //set the number
                            dock.setNumber();
                            break;
                        case "2": //set the length
                            dock.setLength();
                            break;
                        case "3": //Set the width
                            dock.setWidth();
                            break;
                        case "4": //set the depth
                            dock.setDepth();
                            break;
                        case "5": //set longitude and latitude
                            dock.setLongitude();
                            dock.setLatitude();
                            break;
                        case "6": //display the dock
                            dock.displayDockInfo();
                            break;
                        case "7": //Previous Menu
                            again = false; //doesn't loop again
                            System.out.println("Return to the Previous Menu");
                            break;
                    } 
                    
                }catch(Exception e){
                    System.out.println("An error has occurred D:");
                }
                
            }while(again == true); 
        }
        
        else{
            System.out.println("Dock does not exist");
        }
    }
    
    public void portMenu(Map map) {
        Scanner input = new Scanner(System.in);
        String selection;
        boolean again = false;
        
        
        do{
            try{
                again = true; //reset
                
                System.out.println("\nPort Menu");
                System.out.println("------------");
                System.out.println("1. Update Dock");
                System.out.println("2. Unload Ship");
                System.out.println("3. Display all Cargos");
                System.out.println("4. Display all Docks");
                System.out.println("5. Return to previous menu\n");

                System.out.print("Enter selection number: ");
                System.out.flush();
                selection = input.next();

                switch(selection){
                    case "1": //update dock
                        map.getPort().updateDock(map);                        
                        break;
                    case "2": //unload ship
                       map.getPort().unloadShip(map);
                        break;
                    case "3":
                        map.getPort().displayAllCargo();
                        break;
                    case "4":
                        map.getPort().displayAllDocks();
                        break;
                    case "5": //previous menu
                        again = false;
                        System.out.println("Returning to previous menu.\n");
                        break;
                }
                
            }catch(Exception e){
                System.out.println("An error has occurred D:");
            }
                
        }while(again == true);
    }

    public void monsterMenu(){
        
    }
}       
