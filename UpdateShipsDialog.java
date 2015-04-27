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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class UpdateShipsDialog extends JDialog implements ActionListener,ListSelectionListener {
    
    public final String commandOkButton = "OK";
    public final String commandCancelButton = "Canel";
    
    private  JList <CargoShip> shipList;
    private  JButton okButton;
    private  JButton cancelButton;
    private  Map map;
    private  JLabel prompt;
    private  JPanel buttonPanel;
    
    public UpdateShipsDialog(MenuFrame menuFrame, Map map)
    {
        super(menuFrame);// sets the parent where the window will be fixed to 
        this.map = map;// sets the map to the current map
        
        buttonPanel = new JPanel();
        shipList = new JList(map.getCurrentShips().toArray());
        shipList.setVisibleRowCount(10);
        shipList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(shipList));
        
        prompt = new JLabel("Chose the ship you would like to update.");
        okButton = new JButton(commandOkButton);
        okButton.addActionListener(this);
        cancelButton = new JButton(commandCancelButton);
        cancelButton.addActionListener(this);
        
        setTitle("Update Ships");//names the window
        setModalityType(ModalityType.APPLICATION_MODAL); //sets the window's modality 
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(getParent());
        createDialog();
        pack();
        
    }
    public void createDialog()
    {
        this.setLayout(new BorderLayout());
        this.add(prompt,BorderLayout.PAGE_START);
        
        buttonPanel.setLayout(new GridLayout(1,2));
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        this.add(buttonPanel,BorderLayout.SOUTH);
        
        
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void valueChanged(ListSelectionEvent lse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
