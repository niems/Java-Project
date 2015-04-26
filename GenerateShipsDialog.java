
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgbyte.me;

import java.awt.Frame;
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

/**
 *
 * @author Cam
 */
public class GenerateShipsDialog extends JDialog implements ActionListener{
    
    public final String commandOkButton = "OK";
    public final String commandCancelButton = "Canel";
    public final String commandShipAmount = "Ship Amount";
    
    private GridBagLayout rootLayout;
    private GridBagConstraints positions;
    private JButton okButton;
    private JButton cancelButton;
    private JLabel prompt;
    private JTextField inputShip;
    private Map map;
    
    public GenerateShipsDialog(MenuFrame menuFrame, Map map){
        super(menuFrame);// sets the parent where the window will be centered on
        initGenerateShipsDialog();//creates the elements of the window
        this.map = map; //sets the map
    }
    public void initGenerateShipsDialog(){
        okButton = new JButton(commandOkButton);
        cancelButton = new JButton(commandCancelButton);
        prompt = new JLabel("Enter the amount of ships that will be generated.");
        inputShip = new JTextField(commandShipAmount);
        
        rootLayout = new GridBagLayout();
        positions = new GridBagConstraints();
        setLayout(rootLayout);// sets the window's layout
        
        
        setSize(500,150);//sets the size of the window
        setResizable(false);//stops the window from being resized
        positions.insets = new Insets(5,5,5,5); //pads the window 
        
        positions.fill= GridBagConstraints.PAGE_START; // defines the area in which the componet will be added
        addComponent(prompt,0,0,1,3);// adds the label with the dimensions

        positions.fill = GridBagConstraints.FIRST_LINE_END;
        addComponent(inputShip,0,1,2,1);
        inputShip.addActionListener(this);
        
        positions.fill = GridBagConstraints.LAST_LINE_START;
        addComponent(okButton,3,1,1,1);
        okButton.addActionListener(this);
        positions.fill = GridBagConstraints.LINE_END;
        addComponent(cancelButton,3,2,1,1);
        cancelButton.addActionListener(this);
        
        setModalityType(ModalityType.APPLICATION_MODAL); //sets the window's modality 
        setTitle("Generate Ships"); //names the window
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(getParent());
    }

    

    private void addComponent(Component component,int row, int column, int width, int height)
    {
        positions.gridx = column;
        positions.gridy = row;
        positions.gridwidth = height;
        positions.gridwidth = width;
        rootLayout.setConstraints(component,positions);
        add(component); //adds the component onto the layout
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String command =  e.getActionCommand();
        String shipData= inputShip.getText();
        int nShipAmount;
        boolean valid = true;
        if (command.equals(commandOkButton) && !commandShipAmount.equals(shipData) && map.getCurrentMap() != null )
        {
            
                try{
                    nShipAmount = Integer.parseInt(shipData);//converts the string into a integer
                    map.generateShips(nShipAmount);//passes it to the function
                    dispose();//destroys the box
                
                }
                catch(NumberFormatException ex) //displays the an error dialog box if the input is not an integer
                {

                    String errorMessage = "Please enter only integer values.";
                    JOptionPane.showMessageDialog(this, errorMessage, "Error Inproper Input", JOptionPane.PLAIN_MESSAGE);

                }

        }
        
        else if(command.equals(commandCancelButton) ) //closes the dialog if the cancel button is clicked
        {
            dispose();
        }
        else if (map.getCurrentMap() == null) //checks if the map is loaded or not
        {
            String errorMessage = "Please load the files before generating ships.";
            JOptionPane.showMessageDialog(this, errorMessage, "Error Missing Map", JOptionPane.PLAIN_MESSAGE);            
        }
        

    }
}
