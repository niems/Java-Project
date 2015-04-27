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
    public final String commandOkButton = "OK";
    public final String commandCancelButton = "Canel";

    public final String commandShipName = " Name ";
    public final String commandShipCountry = " Country ";
    public final String commandShipTransponder = " Transponder ";
    public final String commandShipCapacity = " Capacity ";
    public final String commandShipLength = " Length ";            
    public final String commandShipBeam = " Beam ";
    public final String commandShipDraft = " Draft ";
    public final String commandShipLongitude = " Longitude ";
    public final String commandShipLatitude = " Latitude ";
    public final String commandShipRow = " Row ";
    public final String commandShipCol = " Column ";
    public final String prompt = "Use the textfields to update the ships properties.";
    public final String tag = "Ship";

    private GridBagLayout rootLayout; // layout to hold all the components
    private GridBagConstraints positions;
    private JButton okButton;
    private JButton cancelButton;
    

    JTextField inputName;
    JTextField inputCountry;
    JTextField inputTransponder;
    JTextField inputCapacity; 
    JTextField inputLength;
    JTextField inputBeam;
    JTextField inputDraft;
    JTextField inputLongitude;
    JTextField inputLatitude;
    JTextField inputRow;
    JTextField inputCol;
    CargoShip ship;


    
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
        
        positions.insets = new Insets(4,4,4,4);// adds padding
        
        //Creates the labels and textfields
        inputName = makeTextField(commandShipName,0);
        inputCountry = makeTextField(commandShipCountry,1);
        inputTransponder = makeTextField(commandShipTransponder,2);
        inputCapacity = makeTextField(commandShipCapacity,3);
        inputLength = makeTextField(commandShipLength,4);
        inputBeam = makeTextField(commandShipBeam,5);
        inputDraft = makeTextField(commandShipDraft,6);
        inputLongitude = makeTextField(commandShipLongitude,7);
        inputLatitude = makeTextField(commandShipLatitude,8);
        inputRow = makeTextField(commandShipRow,9);
        inputCol = makeTextField(commandShipCol,10);

        //creates the buttons
        okButton = new JButton(commandOkButton);
        okButton.addActionListener(this);
        addComponent(okButton,14,2,1,1);

        cancelButton = new JButton(commandCancelButton);
        cancelButton.addActionListener(this);
        addComponent(cancelButton,14,3,1,1);
        

        pack();
        setResizable(false); 
        setModalityType(ModalityType.APPLICATION_MODAL); //sets the window's modality 
        setTitle("Ship Properties"); //names the window
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);// closes the window if the x is clicked
        setLocationRelativeTo(getParent());//places the window in the center of the main window

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

    private JTextField makeTextField(String string,int num) 
    {
        JTextField field = new JTextField(10);
	JLabel label = new JLabel(tag + string);
                
	addComponent(field,num,2,20,20);
	addComponent(label,num,1,1,2);

	return field;
}
    @Override
    public void actionPerformed(ActionEvent ae) {

        Object source = ae.getSource();
        
        String tempName;
        String tempCountry;
        String tempTransponder;
        String tempCapacity;
        String tempLength;
        String tempDraft;
        String tempBeam;
        String tempLongitude;
        String tempLatitude ;
        String tempRow ;
        String tempCol;

        long transponder;
        double capcitiy, length, draft, beam, longitude, latitude;
        int row, column;
        

        if (source == okButton  )
        {
            
        
                System.out.println("Ok pushed");

                tempName = this.inputName.getText();
                tempCountry = this.inputCountry.getText();
                tempTransponder = this.inputTransponder.getText();
                tempCapacity = this.inputCapacity.getText();
                tempLength = this.inputLength.getText();
                tempDraft = this.inputDraft.getText();
                tempBeam = this.inputBeam.getText();
                tempLongitude = this.inputLongitude.getText();
                tempLatitude = this.inputLatitude.getText();
                tempRow = this.inputRow.getText();
                tempCol = this.inputCol.getText();

                try
                {
                if (!tempName.isEmpty())
                {
                    ship.setName(tempName);
                    System.out.println("name");
                }
                else if ( !tempCountry.isEmpty())
                {
                    ship.setCountry(tempCountry);
                    System.out.println("country");
                }
                else if (!tempTransponder.isEmpty())
                {
                    transponder = Long.valueOf(tempTransponder);
                    System.out.println("transponder");
                    ship.setTransponder(transponder);
                }
                else if (!tempCapacity.isEmpty())
                {   
                    capcitiy = Double.valueOf(tempCapacity);
                    System.out.println("capicity");
                    ship.setCapacity(capcitiy);
                }
                else if (!tempLength.isEmpty())
                {   
                    length = Double.valueOf(tempLength);
                    System.out.println("length");
                    ship.setLength(length);
                }
                else if ( !tempDraft.isEmpty())
                {
                    draft = Double.valueOf(tempDraft);
                    System.out.println("draft");
                    ship.setDraft(draft);
                }
                else if ( !tempBeam.isEmpty())
                {
                    beam = Double.valueOf(tempBeam);
                    System.out.println("beam");
                    ship.setBeam(beam);
                }
                else if (!tempCol.isEmpty() && !tempLongitude.isEmpty() || !tempRow.isEmpty() && tempLatitude.isEmpty() )
                {
                    String errorMessage = "Error. You can change the position using rows and columns\n or longitude and latitude but not both.";
                    JOptionPane.showMessageDialog(this, errorMessage, "Error Inproper Input", JOptionPane.PLAIN_MESSAGE);
                }
                else if (!tempLongitude.isEmpty() && tempCol.isEmpty())
                {
                    longitude = Double.valueOf(tempLongitude);
                    System.out.println("longitude");
                    ship.setLongitude(longitude);
                }
                else if (!tempLatitude.isEmpty() && tempRow.isEmpty())
                {
                    latitude = Double.valueOf(tempLatitude);
                    System.out.println("latitude");
                    ship.setLatitude(latitude);
                }
                else if (!tempRow.isEmpty() && tempLatitude.isEmpty())
                {
                    row = Integer.valueOf(tempRow);
                    System.out.println("row");
                    ship.setLatitude(MapConverter.row2lat(row));
                }
                else if (!tempCol.isEmpty() && tempLongitude.isEmpty())
                {
                    column = Integer.valueOf(tempCol);
                    System.out.println("column");
                    ship.setLongitude(MapConverter.col2lon(column));
                }

                
                this.dispose();
                
            

        }
        
        else if(source == cancelButton ) //closes the dialog if the cancel button is clicked
        {
            System.out.println("Cancel pushed.");
            this.dispose();
        }

    }
    
}
