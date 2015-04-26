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
        setSize(300, 425);
        setResizable(false); 
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);// closes the window if the x is clicked
        setLocationRelativeTo(getParent());//places the window in the center of the main window
        positions.insets = new Insets(4,4,4,4);// adds padding
        
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
        //creates the buttons
        okButton = new JButton(commandOkButton);
        addComponent(okButton,14,2,1,1);
        positions.anchor = GridBagConstraints.CENTER;
        okButton.addActionListener(this);

        cancelButton = new JButton(commandCancelButton);
        addComponent(cancelButton,14,3,1,1);
        positions.anchor = GridBagConstraints.CENTER;        
        cancelButton.addActionListener(this);

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
        int i;
        for ( i = 0; i < name.length; i++)
        {
            labels[i] = new JLabel(tag + name[i]); //creates the labels
            addComponent(labels[i],i,1,1,2); // sets their position and adds them to the rootlayout
            //fields[i] = new JTextField(name[i]);// creates the textfields 
            fields[i] = new JTextField(10);
            addComponent(fields[i],i,2,20,20); //adds them to the rootlayout
            fields[i].addActionListener(this);
        }
    }
    @Override
    public void actionPerformed(ActionEvent ae) {

        Object source = null;
        source =  ae.getSource();
        
        String tempName;
        String tempCountry;
        String tempTransponder;
        String tempCapacity;
        String tempLength;
        String tempDraft;
        String tempBeam;
        String tempLongitude;
        String tempLatitude;
        String tempRow;
        String tempCol;

        long transponder;
        double capcitiy, length, draft, beam, longitude, latitude;
        int row, column;
        

        if (source == okButton  )
        {
            
            try
            {
                System.out.println("Ok pushed");
                if (inputName.getText() != null)
                {
                    tempName = this.inputName.getText();
                }
                else if ( inputCountry.getText() != null)
                {
                    tempCountry = this.inputCountry.getText();
                }
                else if (inputTransponder.getText() != null)
                {
                    tempTransponder = this.inputTransponder.getText();
                }
                else if (inputCapacity.getText() != null)
                {
                    tempCapacity = this.inputCapacity.getText();
                }
                else if ( inputLength.getText() != null)
                {        
                    tempLength = this.inputLength.getText();
                }    
                else if ( inputDraft.getText() != null)
                {
                    tempDraft = this.inputDraft.getText();
                }
                else if ( inputBeam.getText() != null)
                {
                    tempBeam = this.inputBeam.getText();
                }
                else if (inputLongitude.getText() != null)
                {
                    tempLongitude = this.inputLongitude.getText();
                }
                else if (inputLatitude.getText() != null)
                {
                    tempLatitude = this.inputLatitude.getText();
                }
                else if (inputRow.getText() != null)
                {    
                    tempRow = this.inputRow.getText();
                }
                else if (inputCol.getText() != null)
                {
                    tempCol = this.inputCol.getText();
                }
                    /*transponder = Long.valueOf(tempTransponder);
                capcitiy = Double.valueOf(tempCapacity);
                length = Double.valueOf(tempLength);
                draft = Double.valueOf(tempDraft);
                beam = Double.valueOf(tempBeam);
                longitude = Double.valueOf(tempLongitude);
                latitude = Double.valueOf(tempLatitude);
                row = Integer.valueOf(tempRow);
                column = Integer.valueOf(tempCol);
                dispose();//destroys the box*/
                this.dispose();
                
            }
            catch(NumberFormatException ex) //displays the an error dialog box if the input is not an integer
            {
                System.out.println("Cancel pushed.");
                String errorMessage = "Please enter only integer values.";
                JOptionPane.showMessageDialog(this, errorMessage, "Error Inproper Input", JOptionPane.PLAIN_MESSAGE);

            }

        }
        
        else if(source == cancelButton ) //closes the dialog if the cancel button is clicked
        {
            this.dispose();
        }

        

    
    }
    
}
