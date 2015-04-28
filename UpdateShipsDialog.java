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
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

public class UpdateShipsDialog extends JDialog implements ActionListener {
    
    public final String commandOkButton = "OK";
    public final String commandCancelButton = "Canel";
    
    private  JList <CargoShip> shipList;
    private  JButton okButton;
    private  JButton cancelButton;
    private  Map map;
    private  JLabel prompt;
    private  JPanel buttonPanel;
    private  MenuFrame menuFrame;
    private  GridBagLayout rootLayout;
    private  GridBagConstraints positions;
    public UpdateShipsDialog(MenuFrame menuFrame, Map map)
    {
        super(menuFrame);// sets the parent where the window will be fixed to 
        this.menuFrame = menuFrame;
        this.map = map;// sets the map to the current map
        this.positions = new GridBagConstraints();
        this.positions.insets = new Insets(5,5,5,5);
        
        this.rootLayout = new GridBagLayout();
        buttonPanel = new JPanel();

        
        prompt = new JLabel("Choose the ship you would like to update.");
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
        this.setLayout(rootLayout);
        this.addComponent(prompt,0,1,1,2);
        
        shipList = new JList(map.getCurrentShips().toArray());
        shipList.setVisibleRowCount(10);
        shipList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.addComponent(new JScrollPane(shipList), 2,1,1,2);
        buttonPanel.setLayout(new GridLayout(1,2));
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        this.addComponent(buttonPanel,3,1,1,2);
        
       
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
       String command = ae.getActionCommand();
       
       if (command == commandOkButton)
       {
            int index = shipList.getSelectedIndex();
            System.out.println(index);
            System.out.println(map.getCurrentShips().toArray()[index]);
            ShipsPropertyDialog spd = new ShipsPropertyDialog(menuFrame,map.getCurrentShips().get(index));
            this.dispose();
            spd.setVisible(true);

       }
       else if ( command == commandCancelButton)
       {
           this.dispose();
       }
    }

    
}
