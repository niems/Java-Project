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
public class Oil extends Cargo{
    private int barrels;
    
    public Oil(){
        this.barrels = 700000;
        this.description = "Light Crude";
    }
    
    public Oil(int barrels, String description){
        this.barrels = barrels;
        this.description = description;
    }
    
    public Oil(String values){ //barrels,description
        String[] parts = new String[2];
        
        parts = values.split(",");
        this.barrels = Integer.valueOf(parts[0]);
        this.description = parts[1];        
    }
    
    public String toString(){
        return(this.description + "," + this.barrels );
    }
    
    public void display() {
        System.out.println(this.barrels + " barrels of " + this.description);
    }
    
}
