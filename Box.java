/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgbyte.me;

/**
 *
 * @author Niems
 */
public class Box extends Cargo {
    private int teu; //twenty-foot equivalent units
    
    public Box(){
        this.teu = 10000;
        this.description = "Marble";
    }
    
    public Box(int teu, String description){
        this.teu = teu;
        this.description = description;
    }
    
    public Box(String values){ //should be teu,description
        String[] parts = new String[2];
        
        parts = values.split(",");
        this.teu = Integer.valueOf(parts[1]);
        this.description = parts[2];
    }
    
    public String toString(){
        return(this.description + "," + this.teu);
    }
    
    public void display(){
        System.out.println(this.teu + " teus of " + this.description);
    }
}
