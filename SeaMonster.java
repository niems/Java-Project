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
public abstract class SeaMonster {
    protected Position position; //holds the position of the sea monster
    protected String type; //current monster type
    
    //monster count determined when the monster is created. Count will be 
    //one more than the current number of monsters of that type.
    protected int count; 
    
    public abstract void battleCry(); //overridden in each child class
    
}
