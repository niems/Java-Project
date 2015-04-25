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
    public final String commandShipRow = "Row";
    public final String commandShipCol = "Column";
    public final String prompt = "Enter the ship's new ";
    
    private GridBagLayout rootLayout; // layout to hold all the components
    private GridBagConstraints positions;
    private JButton okButton;
    private JButton cancelButton;
    
    private final JLabel shipName;
    private JTextField inputName;
    private final JLabel shipCountry;
    private JTextField inputCountry;
    private final JLabel shipTransponder;
    private JTextField inputTransponder;
    private final JLabel shipCapacity;
    private JTextField inputCapacity; 
    private final JLabel shipLength;
    private JTextField inputLength;
    private final JLabel shipBeam;
    private JTextField inputBeam;
    private final JLabel shipDraft;
    private JTextField inputDraft;
    private final JLabel shipLongitude;
    private JTextField inputLongitude;
    private final JLabel  shipLatitude;
    private JTextField inputLatitude;
    private final JLabel shipRow;
    private JTextField inputRow;
    private final JLabel shipCol;
    private JTextField inputCol;
    private CargoShip ship;

    
    public ShipsPropertyDialog(MenuFrame menuFrame, CargoShip ship)
    {
        //makes menuFrame the parent
        super(menuFrame);
        this.ship = ship;
        initShipPropertyDialog();
    }
    
    private void initShipPropertyDialog()
    {
        //fills the labels with their prompts
        shipName = new JLabel(prompt + commandShipName);
        shipCountry = new JLabel(prompt + commandShipCountry + " of Registration");
        shipTransponder = new JLabel(prompt + commandShipTransponder + " Number");
        shipCapacity = new JLabel(prompt + "Cargo" + commandShipCapacity);
        shipLength = new JLabel(prompt + commandShipLength);
        shipBeam = new JLabel(prompt + commandShipBeam);
        shipDraft = new JLabel(prompt + commandShipDraft);
        shipLongitude = new JLabel(prompt + commandShipLongitude);
        shipLatitude = new JLabel(prompt + commandShipLatitude);
        shipRow = new JLabel(prompt + commandShipRow);
        shipCol = new JLabel(prompt + commandShipCol);
        
        //institates the the textfields and sets the default text
        inputShipName = new JTextField(commandShipName);
        inputShipCountry = new JTextField(commandShipCountry);
        inputShipTransponder = new JTextField(commandShipTransponder);
        inputShipCapacity = new JTextField(commandShipCapacity);
        inputShipLength = new JTextField(commandShipLength);
        inputShipBeam = new JTextField(commandShipBeam);
        inputShipDraft = new JTextField(commandShipDraft);
        inputShipLongitude = new JTextField(commandShipLongitude);
        inputShipLatitude = new JTextField(commandShipLatitude);
        inputShipRow = new JTextField(commandShipRow);
        inputShipCol = new JTextField(commandShipCol);
        //instatiates the buttons
        okButton = new JButton(commandOkButton);
        cancelButton = new JButton(commandCancelButton);
        
        
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
