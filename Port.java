<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgbyte.me;

import com.sun.corba.se.impl.io.TypeMismatchException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Niems
 */
public class Port {
    private String name; //name of the current port
    private ArrayList<Dock> dock; //all the docks 
    private ArrayList<Cargo> cargo; //all the cargo delivered to the Port
    
    public Port() {
        this.name = "Liverpool";
        this.dock = new ArrayList();
        this.cargo = new ArrayList();
    }
    
    public void updateDock(Map map){       
        try{
            Scanner input = new Scanner(System.in);
            int selection = -1;
            int max_selection = map.getPort().getDock().size();
            int i = 0;
        
            for(i = 0; i < max_selection; i++){
                System.out.printf("%d. %s\n", i, map.getPort().getDock().get(i).getName());
            }
            
            System.out.printf("%d. Cancel\n\n", max_selection);
            
            do{
                
                System.out.print("Enter a dock number to update: ");
                System.out.flush();
                selection = input.nextInt();
                
                if(selection < 0 || selection > max_selection){
                    System.out.printf("Enter a dock number in range(%d - %d)\n", 0, max_selection);
                }
                
            }while(selection < 0 || selection > max_selection);
            
            if(selection < max_selection){
                //map.menu.dockMenu(this.dock.get(selection));
                map.menu.dockPropertiesMenu(this.dock.get(selection));
            }
            
        }catch(InputMismatchException e){
            System.out.println("Invalid input. Must enter a valid dock number.");
        }catch(Exception e){
            System.out.println("An error has occurred");
        }       
    }
    
    public void unloadShip(Map map){
        ArrayList<CargoShip> safeShips = new ArrayList();
        Scanner input = new Scanner(System.in);
        int selection = 0;
        boolean again = true; //loops if true
        
        try{            
            //finds all the ships that can be unloaded
            for(int i = 0; i < map.getCurrentShips().size(); i++){
                for(int j = 0; j < map.getPort().getDock().size(); j++){

                    //if the current ship is at the dock
                    if(map.getCurrentShips().get(i).atDock(map.getPort().getDock().get(j))){
                        //if the current ship is compatible with the dock and fits
                        if(map.getCurrentShips().get(i).dockCompatible(map.getPort().getDock().get(j), map) &&
                           map.getCurrentShips().get(i).shipSizeCompatible(map.getPort().getDock().get(j))){
                            
                            if(map.getCurrentShips().get(i).getCargo() != null) //if the cargo exists
                                safeShips.add(map.getCurrentShips().get(i)); //ship ready to be unloaded
                        }

                        else //ship is not compatible with dock
                            break;
                    }
                }
            }

            do{
                again = true; //reset

                if(safeShips.size() > 0){ //if there are ships to unload
                    System.out.println("Unloadable ships");
                    System.out.println("-----------------");

                    //displays all ships that can be unloaded
                    for(int i = 0; i < safeShips.size(); i++){
                        System.out.println(String.format("%d: %s", i, safeShips.get(i).getName()));
                    }
                    
                    System.out.println(String.format("%d: Previous Menu", safeShips.size()));

                    System.out.print("\nEnter selection: ");
                    System.out.flush();
                    selection = input.nextInt();

                    if(selection < 0 || selection > safeShips.size()){
                        System.out.println("Invalid: selection out of range\n");
                    }

                    else if(selection < safeShips.size()){
                        if(safeShips.get(selection).getCargo() != null){ //if the cargo for the current ship exists
                            map.getPort().getCargo().add(safeShips.get(selection).getCargo()); //adds ship cargo to the port
                            safeShips.get(selection).setCargo(null); //removes ships cargo from ship
                            again = false;
                        }
                    }
                    
                    else{
                        again = false; //return to previous menu
                    }
                }

                else{
                    System.out.println("No ships to unload");
                    again = false; //breaks loop
                }

            }while(again == true);
        
        }catch(InputMismatchException e){
            System.out.println("Invalid input");
        }catch(Exception e){
            System.out.println("An error has occurred");
        }
    }
    
    public void displayAllCargo(){
        if(this.cargo.size() > 0){
            System.out.println("    Cargo at Port");
            System.out.println("---------------");

            for(int j = 0; j < this.cargo.size(); j++){ //displays the info for all cargo
                this.cargo.get(j).displayCargo();
            }
        }
        
        else{
            System.out.println("No cargo to display");
        }
    }
    
    public void displayAllDocks() {
        if(this.dock.size() > 0){
            System.out.println("    Docks");
            System.out.println("---------------");

            for(int i = 0; i < this.getDock().size(); i++) { //display the info for all docks
                this.getDock().get(i).displayDockInfo();
            }
        }
        
        else{
            System.out.println("No docks to display");
        }
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the dock
     */
    public ArrayList<Dock> getDock() {
        return this.dock;
    }

    /**
     * @param dock the dock to set
     */
    public void setDock(ArrayList<Dock> dock) {
        this.dock = dock;
    }

    /**
     * @return the cargo
     */
    public ArrayList<Cargo> getCargo() {
        return this.cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(ArrayList<Cargo> cargo) {
        this.cargo = cargo;
    }
    
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgbyte.me;

import com.sun.corba.se.impl.io.TypeMismatchException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Niems
 */
public class Port {
    private String name; //name of the current port
    private ArrayList<Dock> dock; //all the docks 
    private ArrayList<Cargo> cargo; //all the cargo delivered to the Port
    
    public Port() {
        this.name = "Liverpool";
        this.dock = new ArrayList();
        this.cargo = new ArrayList();
    }
    
    public void updateDock(Map map){       
        try{
            Scanner input = new Scanner(System.in);
            int selection = -1;
            int max_selection = map.getPort().getDock().size();
            int i = 0;
        
            for(i = 0; i < max_selection; i++){
                System.out.printf("%d. %s\n", i, map.getPort().getDock().get(i).getName());
            }
            
            System.out.printf("%d. Cancel\n\n", max_selection);
            
            do{
                
                System.out.print("Enter a dock number to update: ");
                System.out.flush();
                selection = input.nextInt();
                
                if(selection < 0 || selection > max_selection){
                    System.out.printf("Enter a dock number in range(%d - %d)\n", 0, max_selection);
                }
                
            }while(selection < 0 || selection > max_selection);
            
            if(selection < max_selection){
                //map.menu.dockMenu(this.dock.get(selection));
                map.menu.dockPropertiesMenu(this.dock.get(selection));
            }
            
        }catch(InputMismatchException e){
            System.out.println("Invalid input. Must enter a valid dock number.");
        }catch(Exception e){
            System.out.println("An error has occurred");
        }       
    }
    
    public void unloadShip(Map map){
        ArrayList<CargoShip> safeShips = new ArrayList();
        Scanner input = new Scanner(System.in);
        int selection = 0;
        boolean again = true; //loops if true
        
        try{            
            //finds all the ships that can be unloaded
            for(int i = 0; i < map.getCurrentShips().size(); i++){
                for(int j = 0; j < map.getPort().getDock().size(); j++){

                    //if the current ship is at the dock
                    if(map.getCurrentShips().get(i).atDock(map.getPort().getDock().get(j))){
                        //if the current ship is compatible with the dock and fits
                        if(map.getCurrentShips().get(i).dockCompatible(map.getPort().getDock().get(j), map) &&
                           map.getCurrentShips().get(i).shipSizeCompatible(map.getPort().getDock().get(j))){
                            
                            if(map.getCurrentShips().get(i).getCargo() != null) //if the cargo exists
                                safeShips.add(map.getCurrentShips().get(i)); //ship ready to be unloaded
                        }

                        else //ship is not compatible with dock
                            break;
                    }
                }
            }

            do{
                again = true; //reset

                if(safeShips.size() > 0){ //if there are ships to unload
                    System.out.println("Unloadable ships");
                    System.out.println("-----------------");

                    //displays all ships that can be unloaded
                    for(int i = 0; i < safeShips.size(); i++){
                        System.out.println(String.format("%d: %s", i, safeShips.get(i).getName()));
                    }
                    
                    System.out.println(String.format("%d: Previous Menu", safeShips.size()));

                    System.out.print("\nEnter selection: ");
                    System.out.flush();
                    selection = input.nextInt();

                    if(selection < 0 || selection > safeShips.size()){
                        System.out.println("Invalid: selection out of range\n");
                    }

                    else if(selection < safeShips.size()){
                        if(safeShips.get(selection).getCargo() != null){ //if the cargo for the current ship exists
                            map.getPort().getCargo().add(safeShips.get(selection).getCargo()); //adds ship cargo to the port
                            safeShips.get(selection).setCargo(null); //removes ships cargo from ship
                            again = false;
                        }
                    }
                    
                    else{
                        again = false; //return to previous menu
                    }
                }

                else{
                    System.out.println("No ships to unload");
                    again = false; //breaks loop
                }

            }while(again == true);
        
        }catch(InputMismatchException e){
            System.out.println("Invalid input");
        }catch(Exception e){
            System.out.println("An error has occurred");
        }
    }
    
    public void displayAllCargo(){
        if(this.cargo.size() > 0){
            System.out.println("    Cargo at Port");
            System.out.println("---------------");

            for(int j = 0; j < this.cargo.size(); j++){ //displays the info for all cargo
                this.cargo.get(j).displayCargo();
            }
        }
        
        else{
            System.out.println("No cargo to display");
        }
    }
    
    public void displayAllDocks() {
        if(this.dock.size() > 0){
            System.out.println("    Docks");
            System.out.println("---------------");

            for(int i = 0; i < this.getDock().size(); i++) { //display the info for all docks
                this.getDock().get(i).displayDockInfo();
            }
        }
        
        else{
            System.out.println("No docks to display");
        }
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the dock
     */
    public ArrayList<Dock> getDock() {
        return this.dock;
    }

    /**
     * @param dock the dock to set
     */
    public void setDock(ArrayList<Dock> dock) {
        this.dock = dock;
    }

    /**
     * @return the cargo
     */
    public ArrayList<Cargo> getCargo() {
        return this.cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(ArrayList<Cargo> cargo) {
        this.cargo = cargo;
    }
    
}
>>>>>>> 97be854b4d79c8369d658420ba92056ad1a4a845
