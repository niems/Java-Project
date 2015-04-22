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
public class Pier extends Dock{
    public Pier(){
        super(); //calls the dock constructor
        this.name = "South Pier"; 
        this.number = 2;
        this.section = 'S';
        this.symbol = 'P'; //pier symbol
    }
    
    public Pier(String name, char section, int num, double depth, double length, double width, double lat, double lon, char symbol){
        this.name = name;
        this.section = section;
        this.number = num;
        this.depth = depth;
        this.length = length;
        this.width = width;
        this.longitude = lon;
        this.latitude = lat;
        this.symbol = 'P'; //pier symbol
    }
    
    public Pier(String values){
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
        this.symbol = 'P'; //pier symbol
    }
    
    public String toString(){
        return(this.name + " " + this.number + "," + this.section + "," + this.number + "," + this.length + "," + this.depth + "," + this.width + "," + this.longitude + "," + this.latitude);
    }
    
    public void display(){
        System.out.println(this.name);
        System.out.println("Pier Number: " + this.number);
        System.out.println("Size: " + this.length + " X " + this.depth + " X " + this.width + " metres");
        System.out.println("Location(" + this.longitude + ", " + this.latitude + ")");
        System.out.println("Location(" + MapConverter.lon2col(this.longitude) + ", " + MapConverter.lat2row(this.latitude));
    }
}
