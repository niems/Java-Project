/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgbyte.me;

/**
 *
 * @author Cam
 */
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class ShipsPropertyDialog extends JDialog implements ActionListener{
    
   // Strings to return for the action listener and for displaying in the textfields 
    public final String commandOkButton = "OK";
    public final String commandCancelButton = "Canel";
    public final String commandShipName = "Name";
    public final String commandShipCountry = "Country";
    public final String commandShipTransponder = "Transponder";
    public final String commandShipCapacity = "Capacity";
    public final String commandShipLength = "Length";            
    public final String commandShipBeam = "Beam";
    public final String commandShipDraft = "Draft";
    public final String commandShipLongitude = "Longitude";
    public final String commandShipLatitude = "Latitude";
    
    private GridBagLayout rootLayout;
    private GridBagConstraints positions;
    private JButton okButton;
    private JButton cancelButton;
    
    private JLabel shipName;
    private JTextField inputName;
    private JLabel shipCountry;
    private JTextField inputCountry;
    private JLabel shipTransponder;
    private JTextField inputTransponder;
    private JLabel shipCapacity;
    private JTextField inputCapacity; 
    private JLabel shipLength;
    private JTextField inputLength;
    private JLabel shipBeam;
    private JTextField inputBeam;
    private JLabel shipDraft;
    private JTextField inputDraft;
    private JLabel shipLongitude;
    private JTextField inputLongitude;
    private JLabel  shipLatitude;
    private JTextField inputLatitude;
    private CargoShip ship;
    
    
    public ShipsPropertyDialog(MenuFrame menuFrame, CargoShip ship)
    {
        super(menuFrame);
        this.ship = ship;
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
