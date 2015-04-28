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
    protected String label; //current monster type
    
    //monster count determined when the monster is created. Count will be 
    //one more than the current number of monsters of that type.
    protected int count; 
    
    public abstract void battleCry(); //overridden in each child class
    
    public Position getPosition(){
        return(this.position);
    }
    
    public void setPosition(Position p){
        this.position = p;
    }
    
    public String getLabel(){
        return(this.label);
    }
    
    public void setLabel(String t){
        this.label = t;
    }
    
    public int getCount(){
        return(this.count);
    }
    
    public void setCount(int c){
        this.count = c;
    }
    
}