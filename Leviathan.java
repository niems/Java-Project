
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
public class Leviathan extends SeaMonster{
    public static int totalCount = 0; //total leviathan count
    public Leviathan(){
        this.position = new Position();
        this.label = "";
        this.count = 0;        
    }
    
    public void battleCry(){
        System.out.println("Come! Ahab beckons!");
    }
}

