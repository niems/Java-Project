
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
public class Godzilla extends SeaMonster{
    
    public Godzilla(){
        this.position = new Position();
        this.label = "Godzilla";
        this.count = 0;        
    }
    
    public void battleCry(){
        System.out.println("Baraaawr-rompf!");
    }
    
}
