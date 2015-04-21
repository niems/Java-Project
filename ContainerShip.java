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
public class ContainerShip extends CargoShip {
    ContainerShip(){
        super();
        Box boxCargo = new Box();
        this.setCargo(boxCargo);
        this.symbol = 'B'; //container ship symbol
    }
    
    ContainerShip(String name, String country, long transponder, double cargoCapacity, double length, double beam, double draft, double longitude, double latitude){
        super(name, country, transponder, cargoCapacity, length, beam, draft, longitude, latitude);
        Box boxCargo = new Box();
        this.setCargo(boxCargo);
        this.symbol = 'B'; //container ship symbol
    }
    
    ContainerShip(String values){
        super(values);
        Box boxCargo = new Box();
        this.setCargo(boxCargo);
        this.symbol = 'B'; //container ship symbol
    }
    
    
    public String toString(){        
        String temp = new String();
        temp ="Container Ship," + this.getName() + "," + this.getCountry() + "," + this.getCapacity() + "," + this.getLength() + "," + this.getBeam() + "," + this.getDraft() + "," + this.getLatitude() + "," + this.getLongitude();
        
        if(this.getCargo() != null){ //adds cargo if it exists for the current ship
            temp += "," + this.getCargo().toString();
        }
        
        return(temp);
    }
    
    @Override
    public void display(){        
        System.out.println("Container Ship: " + this.name);
        System.out.println("Country of Origin: " + this.country);
        System.out.println("Transponder: " + this.transponder);
        System.out.println("Size: " + (int)this.getLength() + "(length) x " + (int)this.getDraft() + "(depth) x " + (int)this.getBeam() + "(width) metres");
        //number of holds here
        System.out.println("Location (" + this.longitude + "," + this.latitude + ")");
        System.out.println("Location (" + MapConverter.lon2col(this.longitude) + "," + MapConverter.lat2row(this.latitude) + ")");
        this.cargo.displayCargo();
    }
}
