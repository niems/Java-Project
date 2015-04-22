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
import java.awt.event.ActionEvent;
//import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;

public class UpdateShipsDialog extends JDialog implements ActionListener {
    
    public final String commandOkButton = "OK";
    public final String commandCancelButton = "Canel";
    
    //private final JList <CargoShip> shipList;
    private final JButton okButton;
    private final JButton cancelButton;
    private final Map map;
    private final JComboBox <CargoShip> shipBox;
    private final JLabel prompt;
    
    public UpdateShipsDialog(MenuFrame menuFrame, Map map)
    {
        super(menuFrame);// sets the parent where the window will be fixed to 
        this.map = map;// sets the map to the current map
        setTitle("Update Ships");
        setSize(300,150);
        setResizable(false);
        setModalityType(ModalityType.APPLICATION_MODAL); //sets the window's modality 
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(getParent());
        
        prompt = new JLabel("Chose the ship you would like to update.");
        okButton = new JButton(commandOkButton);
        okButton.addActionListener(this);
        
        cancelButton = new JButton(commandCancelButton);
        cancelButton.addActionListener(this);
        //shipList = new JList(map.getCurrentShips().toArray());
        
        shipBox = new JComboBox(map.getCurrentShips().toArray());
        
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
