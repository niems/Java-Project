
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
//holds the current position of the object
public class Position {
    private double longitude;
    private double latitude;
    private int row;
    private int column;
    private int xPixel;
    private int yPixel;    
    
    public Position(){
        this.longitude = 0.0;
        this.latitude = 0.0;
        this.row = 0;
        this.column = 0;
        this.xPixel = 0;
        this.yPixel = 0;
    }

    /**
     * @return the longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     * @param row the row to set
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * @return the column
     */
    public int getColumn() {
        return column;
    }

    /**
     * @param column the column to set
     */
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     * @return the xPixel
     */
    public int getxPixel() {
        return xPixel;
    }

    /**
     * @param xPixel the xPixel to set
     */
    public void setxPixel(int xPixel) {
        this.xPixel = xPixel;
    }

    /**
     * @return the yPixel
     */
    public int getyPixel() {
        return yPixel;
    }

    /**
     * @param yPixel the yPixel to set
     */
    public void setyPixel(int yPixel) {
        this.yPixel = yPixel;
    }
}

