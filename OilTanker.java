<<<<<<< HEAD
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
public class OilTanker extends CargoShip{
    OilTanker(){
        super();
        Oil oilCargo = new Oil();
        this.setCargo(oilCargo);
        this.symbol = 'T';
    }
    
    OilTanker(String name, String country, long transponder, double cargoCapacity, double length, double beam, double draft, double longitude, double latitude){
        super(name, country, transponder, cargoCapacity, length, beam, draft, longitude, latitude);
        Oil oilCargo = new Oil();
        this.setCargo(oilCargo);
        this.symbol = 'T';
    }
    
    OilTanker(String values){
        super(values);
        Oil oilCargo = new Oil();
        this.setCargo(oilCargo);
        this.symbol = 'T';
    }
    
    public String toString(){        
        String temp = new String();
        temp ="Tanker," + this.getName() + "," + this.getCountry() + "," + this.getCapacity() + "," + this.getLength() + "," + this.getBeam() + "," + this.getDraft() + "," + this.getLatitude() + "," + this.getLongitude();
        
        if(this.getCargo() != null){ //adds cargo if it exists for the current ship
            temp += "," + this.getCargo().toString();
        }
        
        return(temp);
    }
    
    @Override
    public void display(){        
        System.out.println("Tanker: " + this.name);
        System.out.println("Country of Origin: " + this.country);
        System.out.println("Transponder: " + this.transponder);
        System.out.println("Size: " + (int)this.getLength() + "(length) x " + (int)this.getDraft() + "(depth) x " + (int)this.getBeam() + "(width) metres");
        System.out.println("Location (" + this.longitude + "," + this.latitude + ")");
        System.out.println("Location (" + MapConverter.lon2col(this.longitude) + "," + MapConverter.lat2row(this.latitude) + ")");
        System.out.println("Barrel Capacity: " + this.cargo.getWeight()); //capacity and current weight are the same because the oil tanker is always shipped full
        this.cargo.displayCargo();
    }
}
=======
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
public class OilTanker extends CargoShip{
    OilTanker(){
        super();
        Oil oilCargo = new Oil();
        this.setCargo(oilCargo);
        this.symbol = 'T';
    }
    
    OilTanker(String name, String country, long transponder, double cargoCapacity, double length, double beam, double draft, double longitude, double latitude){
        super(name, country, transponder, cargoCapacity, length, beam, draft, longitude, latitude);
        Oil oilCargo = new Oil();
        this.setCargo(oilCargo);
        this.symbol = 'T';
    }
    
    OilTanker(String values){
        super(values);
        Oil oilCargo = new Oil();
        this.setCargo(oilCargo);
        this.symbol = 'T';
    }
    
    public String toString(){        
        String temp = new String();
        temp ="Tanker," + this.getName() + "," + this.getCountry() + "," + this.getCapacity() + "," + this.getLength() + "," + this.getBeam() + "," + this.getDraft() + "," + this.getLatitude() + "," + this.getLongitude();
        
        if(this.getCargo() != null){ //adds cargo if it exists for the current ship
            temp += "," + this.getCargo().toString();
        }
        
        return(temp);
    }
    
    @Override
    public void display(){        
        System.out.println("Tanker: " + this.name);
        System.out.println("Country of Origin: " + this.country);
        System.out.println("Transponder: " + this.transponder);
        System.out.println("Size: " + (int)this.getLength() + "(length) x " + (int)this.getDraft() + "(depth) x " + (int)this.getBeam() + "(width) metres");
        System.out.println("Location (" + this.longitude + "," + this.latitude + ")");
        System.out.println("Location (" + MapConverter.lon2col(this.longitude) + "," + MapConverter.lat2row(this.latitude) + ")");
        System.out.println("Barrel Capacity: " + this.cargo.getWeight()); //capacity and current weight are the same because the oil tanker is always shipped full
        this.cargo.displayCargo();
    }
}
>>>>>>> 97be854b4d79c8369d658420ba92056ad1a4a845
