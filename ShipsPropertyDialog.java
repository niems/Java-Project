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
    private CargoShip ship;
    


    
    public ShipsPropertyDialog(MenuFrame menuFrame, CargoShip ship)
    {
        //makes menuFrame the parent
        super(menuFrame);
        this.ship = ship;
        initShipPropertyDialog();
    }
    
    public void initShipPropertyDialog()
    {
        rootLayout = new GridBagLayout();
        positions = new GridBagConstraints();
        setLayout(rootLayout);
        
        positions.insets = new Insets(4,4,4,4);// adds padding
        JLabel promptLabel = new JLabel(prompt);
        addComponent(promptLabel,0,1,1,2);
        //Creates the labels and textfields
        inputName = makeTextField(commandShipName,1);
        inputCountry = makeTextField(commandShipCountry,2);
        inputTransponder = makeTextField(commandShipTransponder,3);
        inputCapacity = makeTextField(commandShipCapacity,4);
        inputLength = makeTextField(commandShipLength,5);
        inputBeam = makeTextField(commandShipBeam,6);
        inputDraft = makeTextField(commandShipDraft,7);
        inputLongitude = makeTextField(commandShipLongitude,8);
        inputLatitude = makeTextField(commandShipLatitude,9);
        inputRow = makeTextField(commandShipRow,10);
        inputCol = makeTextField(commandShipCol,11);

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
            
        //try{
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


                if( !tempName.isEmpty() && !tempCountry.isEmpty() && !tempTransponder.isEmpty() && !tempCapacity.isEmpty() &&
                        !tempLength.isEmpty() && !tempDraft.isEmpty() && !tempBeam.isEmpty() && !tempLongitude.isEmpty() && !tempLatitude.isEmpty() && tempRow.isEmpty() && tempCol.isEmpty())
                {
                    ship.setName(tempName);
                    ship.setCountry(tempCountry);
                    transponder = Long.valueOf(tempTransponder);
                    ship.setTransponder(transponder);
                    capcitiy = Double.valueOf(tempCapacity);
                    ship.setCapacity(capcitiy);
                    length = Double.valueOf(tempLength);
                    ship.setLength(length);     
                    draft = Double.valueOf(tempDraft);
                    ship.setDraft(draft);
                    beam = Double.valueOf(tempBeam);
                    ship.setBeam(beam);
                    longitude = Double.valueOf(tempLongitude);
                    ship.setLongitude(longitude);
                    latitude = Double.valueOf(tempLatitude);
                    /*ship.setLatitude(latitude);
                    row = Integer.valueOf(tempRow);
                    ship.setLatitude(MapConverter.row2lat(row));
                    column = Integer.valueOf(tempCol);
                    ship.setLongitude(MapConverter.col2lon(column));*/
                }
                else
                {
                    String errorMessage = "The position can only be changed with the \n longitude and latitude or using row and column but not both.";
                    JOptionPane.showMessageDialog(this, errorMessage, "Error Inproper Input", JOptionPane.PLAIN_MESSAGE);   
                }

                
                    this.dispose();
        //}
                   /* catch (NumberFormatException  nfe)
                    {        
                        String errorMessage = "Please enter only integer values.";
                        JOptionPane.showMessageDialog(this, errorMessage, "Error Inproper Input", JOptionPane.PLAIN_MESSAGE);
                    }*/
        
        }
        
        else if(source == cancelButton ) //closes the dialog if the cancel button is clicked
        {
            System.out.println("Cancel pushed.");
            this.dispose();
        }

    }
    
}
