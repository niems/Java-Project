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
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class ShipsPropertyDialog extends JDialog implements ActionListener{
    
   // Strings to return for the action listener and for displaying in the textfields 
    public final static String commandOkButton = " OK ";
    public final static String commandCancelButton = " Canel ";
    public final static String commandShipName = " Name ";
    public final static String commandShipCountry = " Country ";
    public final static String commandShipTransponder = " Transponder ";
    public final static String commandShipCapacity = " Capacity ";
    public final static String commandShipLength = " Length ";            
    public final static String commandShipBeam = " Beam ";
    public final static String commandShipDraft = " Draft ";
    public final static String commandShipLongitude = " Longitude ";
    public final static String commandShipLatitude = " Latitude ";
    public final static String commandShipRow = " Row ";
    public final static String commandShipCol = " Column ";
    public final static String prompt = "Use the textfields to update the ships properties.";
    public final static String tag = "Ship";
    private GridBagLayout rootLayout; // layout to hold all the components
    private GridBagConstraints positions;
    private JButton okButton;
    private JButton cancelButton;
    
    private JLabel instructions;
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
    private JLabel shipRow;
    private JTextField inputRow;
    private JLabel shipCol;
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
        rootLayout = new GridBagLayout();
        positions = new GridBagConstraints();
        setLayout(rootLayout);
        
        setModalityType(ModalityType.APPLICATION_MODAL); //sets the window's modality 
        setTitle("Ship Properties"); //names the window
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);// closes the window if the x is clicked
        setLocationRelativeTo(getParent());//places the window in the center of the main window
        
        positions.insets = new Insets(4,4,4,4);
        
        String[] items = {commandShipName, commandShipCountry, commandShipTransponder,
            commandShipCapacity, commandShipLength, commandShipBeam, commandShipDraft, 
            commandShipLongitude, commandShipLatitude, commandShipRow, commandShipCol};
        JLabel[] labels = {shipName,shipCountry,
            shipTransponder,  shipCapacity, 
            shipLength,  shipBeam,  shipDraft, 
            shipLongitude,  shipLatitude,  shipRow, 
            shipCol, };
        JTextField[] fields = {inputName,inputCountry,inputTransponder,inputCapacity,inputLength,inputBeam,inputDraft,inputLongitude,inputLatitude,inputRow,inputCol};
        
        createLabelAndFields(items,labels,fields);
        //instatiates the buttons
        okButton = new JButton(commandOkButton);
        addComponent(okButton,12,1,0,0);
        cancelButton = new JButton(commandCancelButton);
        addComponent(cancelButton,12,2,0,0);
        
    }
    private void addComponent(Component component,int row, int column, int width, int height)
    {
        positions.gridx = column;
        positions.gridy = row;
        positions.gridwidth = height;
        positions.gridwidth = width;
        positions.anchor = GridBagConstraints.WEST;
        rootLayout.setConstraints(component,positions);
        add(component); //adds the component onto the layout
    }
    public void createLabelAndFields(String[] name, JLabel[] labels, JTextField[] fields)
    {
        int i = 0;
        for ( i = 0; i < name.length; i++)
        {
            labels[i] = new JLabel(tag + name[i]); //creates the labels
            addComponent(labels[i],i,1,1,2); // sets their position and adds them to the rootlayout
            fields[i] = new JTextField(name[i]);// creates the textfields 
            addComponent(fields[i],i,2,1,2); //adds them to the rootlayout
            fields[i].addActionListener(this);
        }
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
