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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;


public class GenerateShipsBox extends JFrame implements ActionListener{

    private final JButton okButton;
    private final JButton cancelButton;
    private final JLabel prompt;
    private final JTextField inputShip;
    private final GridBagLayout rootLayout;
    private final GridBagConstraints positions;
    
    
    public GenerateShipsBox()
    {
        
        super("Generate Ships"); //Sets the title for the window
        GenerateShipsBox.this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // enables the window to close after x is clicked
        this.getContentPane().setBackground(Color.WHITE);
        
        rootLayout = new GridBagLayout();
        positions = new GridBagConstraints();
        setLayout(rootLayout);// sets the gridbaglayout as the main layout for the dialog box
        
        prompt = new JLabel("\nEnter the amount of ships that will be generated."); // creates a jlabel to prompt the user for the number of ships
        positions.fill= GridBagConstraints.PAGE_START; // defines the area in which the componet will be added
        positions.insets = new Insets(5,5,5,5); //pads the window 
        addComponent(prompt,0,0,1,3);// adds the label with the dimensions
        
        inputShip = new JTextField("Ship Amount"); // creates a text field to take in the number of ships to be made
        positions.fill = GridBagConstraints.FIRST_LINE_END;
        addComponent(inputShip,0,1,2,1);
        
        okButton = new JButton("OK"); //creates the okay button
        cancelButton = new JButton("Cancel");// creates the cancel button
        
        positions.fill = GridBagConstraints.LAST_LINE_START;
        addComponent(okButton,3,1,1,1);
        positions.fill = GridBagConstraints.LINE_END;
        addComponent(cancelButton,3,2,1,1);


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
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
