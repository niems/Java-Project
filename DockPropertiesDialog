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
import javax.swing.JRadioButton;
import javax.swing.JTextField;
public class DockPropertiesDialog extends JDialog implements ActionListener{
    
   // Strings to return for the action listener and for displaying in the textfields 
    public final String commandOkButton = "OK";
    public final String commandCancelButton = "Canel";

    public final String commandDockName = " Name ";
    public final String commandDockSection = " Section ";
    public final String commandDockNumber = " Number ";
    public final String commandDockDepth = " Depth ";
    public final String commandDockLength = " Length ";            
    public final String commandDockWidth = " Width ";
    public final String commandDockLongitude = " Longitude ";
    public final String commandDockLatitude = " Latitude ";
    public final String commandDockRow = " Row ";
    public final String commandDockCol = " Column ";
    public final String prompt = "Use the textfields to update the dock properties.";
    public final String tag = "Dock";

    private GridBagLayout rootLayout; // layout to hold all the components
    private GridBagConstraints positions;
    private JButton okButton;
    private JButton cancelButton;
    

    JTextField inputName;
    JTextField inputSection;
    JTextField inputNumber;
    JTextField inputDepth; 
    JTextField inputLength;
    JTextField inputWidth;
    JTextField inputLongitude;
    JTextField inputLatitude;
    JTextField inputRow;
    JTextField inputCol;

    private Dock dock;
    
    
    public DockPropertiesDialog(MenuFrame menuFrame, Dock dock)
    {
        //makes menuFrame the parent
        super(menuFrame);
        this.dock = dock;
        initDockPropertyDialog();
    }
    
    public void initDockPropertyDialog()
    {
        rootLayout = new GridBagLayout();
        positions = new GridBagConstraints();
        setLayout(rootLayout);
        
        positions.insets = new Insets(4,4,4,4);// adds padding
        JLabel promptLabel = new JLabel(prompt);
        addComponent(promptLabel,0,1,1,2);
        
        
        //Creates the labels and textfields
        inputName = makeTextField(commandDockName ,1);
        inputSection = makeTextField(commandDockSection,2);
        inputNumber = makeTextField(commandDockNumber,3);
        inputDepth = makeTextField(commandDockDepth,4);
        inputLength = makeTextField(commandDockLength,5);
        inputWidth = makeTextField(commandDockWidth,6);
        inputLongitude = makeTextField(commandDockLongitude,8);
        inputLatitude = makeTextField(commandDockLatitude,9);
        inputRow = makeTextField(commandDockRow,12);
        inputCol = makeTextField(commandDockCol,13);

        //creates the buttons
        okButton = new JButton(commandOkButton);
        okButton.addActionListener(this);
        addComponent(okButton,14,2,1,1);

        cancelButton = new JButton(commandCancelButton);
        cancelButton.addActionListener(this);
        addComponent(cancelButton,14,3,1,1);
        

        pack();
        //setResizable(false); 
        setModalityType(ModalityType.APPLICATION_MODAL); //sets the window's modality 
        setTitle("Ship Properties"); //names the window
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);// closes the window if the x is clicked
        setLocationRelativeTo(getParent());//places the window in the center of the main window

    }
    private void addComponent(Component component,int row, int column, int width, int height)
    {
        positions.gridx = column; //sets column position
        positions.gridy = row; // sets row position
        positions.gridwidth = height; // sets the hieght of the component
        positions.gridwidth = width; // sets the width
        positions.anchor = GridBagConstraints.WEST; // algins it left
        rootLayout.setConstraints(component,positions); //positions it according to the specifcaitons
        add(component); //adds the component onto the layout
    }

    private JTextField makeTextField(String string,int num) 
    {
        JTextField field = new JTextField(10); //Creates a new textfield with column size 10
	JLabel label = new JLabel(tag + string); //creates a label for the object
        field.setEnabled(false);
	addComponent(field,num,2,15,15); //sets the field
	addComponent(label,num,1,1,2); //sets the label

	return field;
    }
    /*private JRadioButton makeRadioButton(String label,int num)
    {
	JRadioButton rb=new JRadioButton(tag + label);
	rb.addActionListener(this);
        addComponent(rb,num,1,1,2);
	//radioButtonPanel.add(rb);
	return rb;
    }*/
    @Override
    public void actionPerformed(ActionEvent ae) {

        Object source = ae.getSource();
        
        String tempName;
        String tempSection;
        String tempNumber;
        String tempDepth;
        String tempLength;
        String tempWidth;
        String tempLongitude;
        String tempLatitude ;
        String tempRow ;
        String tempCol;


        double capcitiy, length, depth, width, longitude, latitude;
        int number,row, column;

        
        
        if (source == okButton  )
        {
            
            try{
                System.out.println("Ok pushed");

                tempName = this.inputName.getText();
                tempSection = this.inputSection.getText();
                tempNumber = this.inputNumber.getText();
                tempDepth = this.inputDepth.getText();
                tempLength = this.inputLength.getText();
                tempWidth = this.inputWidth.getText();
                tempLatitude = this.inputLongitude.getText();
                tempLongitude = this.inputLatitude.getText();
                tempRow = this.inputRow.getText();
                tempCol = this.inputCol.getText();
                

                dock.setName(tempName);
                dock.setSection(tempSection.charAt(0));
                number = Integer.valueOf(tempNumber);
                dock.setNumber(number);
                depth = Double.valueOf(tempDepth);
                dock.setDepth(depth);
                length = Double.valueOf(tempLength);
                dock.setLength(length);
                width = Double.valueOf(tempWidth);
                longitude = Double.valueOf(tempLongitude);
                dock.setLongitude(longitude);
                latitude = Double.valueOf(tempLatitude);
                dock.setLatitude(latitude);
                row = Integer.valueOf(tempRow);
                dock.setLongitude(MapConverter.row2lat(row));
                column = Integer.valueOf(tempCol);
                dock.setLatitude(MapConverter.col2lon(column));
            }     
            catch (NumberFormatException  nfe)
            {        
                String errorMessage = "Please enter only integer values.";
                JOptionPane.showMessageDialog(this, errorMessage, "Error Inproper Input", JOptionPane.PLAIN_MESSAGE);
            }
        
        }
        
        else if(source == cancelButton ) //closes the dialog if the cancel button is clicked
        {
            System.out.println("Cancel pushed.");
            this.dispose();
        }

            
    }
    
}


