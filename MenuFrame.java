/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgbyte.me;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Cam
 */
public class MenuFrame extends JFrame implements ActionListener{
    
    private static Map map; 
    
    private final JMenuBar menuBar;
    private JMenuItem menuItem; //used for all menu items
    
    private final JMenu fileMenu;
    private final JMenu menuShip;
    private final JMenu menuPort;
    private final JMenu menuMonster;
    
    private final JMenuItem menuitemAbout;
    private final JTextArea messageBox;
    
    // Constants defining the file menu name and items
    public final static String labelFile = "File";
    public final static String commandOpen = "Open";
    public final static String commandExit = "Exit";
    public final static String commandClose ="Close";
    public final static String commandSnapShot = "SnapShot";
    
    //Constants defining the ship menu name and items
    public final static String labelShip = "Ship";
    public final static String commandGenerateShips = "Generate Ships";
    public final static String commandUpdateShips = "Update Ships";
    public final static String commandDisplayAllShips ="Display All Ships";
    public final static String commandRemoveAllShips = "Remove All Ships";
    
    // Constants defining the port menu name and associated items
    public final static String labelPort = "Port";
    public final static String commandUnloadShip = "Unload Ship";
    public final static String commandUpdateDock = "Update Dock";
    public final static String commandDisplayAllDocks ="Display All Docks";
    public final static String commandDisplayAllCargo = "Display All Cargos";
    
    // constants defining the monster menu and associate items
    public final static String labelMonster = "Monster";
    public final static String commandGenerateMonsters = "Generate Monster";
    public final static String commandUpdateMonsters = "Update Monsters";
    public final static String commandDisplayAllMonsters ="Display All Monsters";
    public final static String commandRemoveAllMonsters = "Remove All Monsters";
    public final static String commandSummonGodzilla = "Summon Godzilla";
    
    public final static String commandAbout = "About";
    
    
    public MenuFrame()
    {
        //Puts the group name on the window
        super("Byte Me Project");
        MenuFrame.this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        MenuFrame.this.getContentPane().setBackground(Color.WHITE);
        
        //creates the map and file handler to load in system files
        map = new Map();
        //map.file = new FileHandler(map);

        //Creates the menubar to hold the menus and items
        menuBar = new JMenuBar();
        
        //Creates the file menu
        fileMenu = new JMenu(labelFile);
        fileMenu.setMnemonic('F');
        
        //Creates the components for the file menu and adds them to the menu
        String[] menuItems = {commandOpen, commandClose, commandSnapShot, commandExit};
        createMenuItems(menuItems, fileMenu);
        
        
        //Creates the ship Menu
        menuShip = new JMenu(labelShip);
        menuShip.setMnemonic('S');
        
        //creates the components for the ship menu
        String[] shipItems = {commandGenerateShips, commandUpdateShips, commandDisplayAllShips, commandRemoveAllShips};
        createMenuItems(shipItems, menuShip);
        
        
        //Creates the port menu
        menuPort = new JMenu(labelPort);
        menuPort.setMnemonic('P');        
        
        //creates the components for the port menu
        String[] portItems = {commandUnloadShip, commandUpdateDock, commandDisplayAllDocks, commandDisplayAllCargo};
        createMenuItems(portItems, menuPort);
        
        //creates the monster menu
        menuMonster = new JMenu(labelMonster);
        menuMonster.setMnemonic('M');
        
        //creates the components for the monster menu
        String[] monsterItems = {commandGenerateMonsters, commandUpdateMonsters, commandDisplayAllMonsters, commandRemoveAllMonsters, commandSummonGodzilla};
        createMenuItems(monsterItems, menuMonster);
        
        menuitemAbout=new JMenuItem(commandAbout);
        menuitemAbout.addActionListener(MenuFrame.this);
        //        
        // Add the menus onto the menubar and the about button
        menuBar.add(fileMenu);
        menuBar.add(menuShip);
        menuBar.add(menuPort);
        menuBar.add(menuMonster);
        menuBar.add(menuitemAbout);
        this.setJMenuBar(menuBar);
        
        //Create the root Layout for the window
        BorderLayout borderLayout = new BorderLayout();
        this.setLayout(borderLayout);
        
        //Creates an textArea
        messageBox = new JTextArea(8,200);//text area being created with a set size
        messageBox.setEditable(false);// makes it uneditable for the user
        messageBox.setLineWrap(true);
        JScrollPane scrollbar = new JScrollPane (messageBox, 
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//puts it in a scrollpane with a vertical scrollbar
        this.add(scrollbar,BorderLayout.SOUTH);
        
        // Sets the size of the main window        
        Dimension size = new Dimension(800,600);
        this.setSize(size);
        this.setVisible(true);
        
    }

    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        
        switch(command)
        {
            case commandOpen:
                open();
                break;
            case commandClose:
                close();
                break;
            case commandSnapShot:
                snapshot();
                break;
            case commandExit:
                System.exit(0);
                break;
            case commandGenerateShips:
                generateShips();
                break;
            case commandUpdateShips:
                updateShips();
                break;
            case commandDisplayAllShips:
                displayAllShips();
                break;
            case commandUnloadShip:
                unloadShip();
                break;
            case commandUpdateDock:
                updateDock();
                break;
            case commandDisplayAllDocks:
                displayAllDocks();
                break;
            case commandDisplayAllCargo:
                displayAllCargo();
                break;
            case commandGenerateMonsters:
                generateMonsters();
                break;
            case commandUpdateMonsters:
                updateMonsters();
                break;
            case commandDisplayAllMonsters:
                displayAllMonsters();
                break;
            case commandRemoveAllMonsters:
                removeAllMonsters();
                break;
            case commandSummonGodzilla:
                summonGodzilla();
                break;
            case commandAbout:
                about();
                break;
        }
    }
    
    //used to create the menu items for the menu passed
    public final void createMenuItems(String[] items, JMenu menu){
        for(int i = 0; i < items.length; i++){
            this.menuItem = new JMenuItem(items[i]);
            this.menuItem.addActionListener(MenuFrame.this);
            menu.add(this.menuItem);
        }
    }
    
    /********FILE MENU**********/
    public void open(){ //loads the files
        
        //gets the info from the files
        String tag = JOptionPane.showInputDialog("Enter file tag: "); 
        MenuFrame.map.file = new FileHandler(map, tag); 
        MenuFrame.map.file.loadAllFiles(MenuFrame.map);
        
        //update graphically here
        
    }
    
    public void close(){ //erases all map info
        
        //removes all the info
        MenuFrame.map.setCurrentMap(null);
        MenuFrame.map.getCurrentShips().clear(); //erases all ships
        MenuFrame.map.getPort().getDock().clear(); //erases all docks
        MenuFrame.map.getPort().getCargo().clear(); //erases all cargo
        MenuFrame.map.getSeamonsters().clear(); //erases all seamonsters
        
        //update graphically here
    }
    
    public void snapshot(){
        /*Opens a file dialog to prompt the user for a filename and directory,
        then the program will write the current list of ships, docks, sea monsters, 
        and cargos to a file using a comma separated value format.*/
    }
    
    
    /********SHIP MENU**********/
    public void generateShips()
    {
        GenerateShipsBox gsb = new GenerateShipsBox();
        gsb.setSize(new Dimension(500,150));
        gsb.setVisible(true);        
        
    }
    
    public void updateShips(){
        /*Prompt the user with a dialog box with a list item containing the names
        of all available ships. Once a ship has been slected, open a second dialog
        box that will allow the user to update the current ship properties.*/
    }
    
    public void displayAllShips(){
        /*Show the current ships in the status message box at the bottom of the screen */
        String output;
        
        if(MenuFrame.map.getCurrentShips().size() > 0){
            for(int i = 0; i < MenuFrame.map.getCurrentShips().size(); i++){
                output = MenuFrame.map.getCurrentShips().get(i).toString();
                this.messageBox.append(output);
            }
        }
        
        else{
            this.messageBox.append("No ships to display.\n");
        }
    }
    
    public void removeAllShips(){
        /*Remove all ships from the current map */
    }
    
    
    /********PORT MENU**********/
    public void unloadShip(){
        /*Prompt the user with a dialog box, showing a list of all the ships
        safely in dock*/
    }
    
    public void updateDock(){
        /*Prompt the user with a dialog box with a list item contatining the names
        of all avaialble docks. Once a dock has been selected, open a second dialog
        box that will allow the user to update the current dock properties.*/
    }
    
    public void displayAllDocks(){
        /*Show the current docks in the status message box at the bottom of the screen.*/
        String output;
        
        if(MenuFrame.map.getPort().getDock().size() > 0){
            this.messageBox.append("Docks:\n");
            for(int i = 0; i < MenuFrame.map.getPort().getDock().size(); i++){
                output = MenuFrame.map.getPort().getDock().get(i).toString();
                this.messageBox.append(i + ": " + output);
            }
        }
        
        else{
            this.messageBox.append("No docks to display\n");
        }
    }
    
    public void displayAllCargo(){
        /*Shows the current cargos in the port in the status message at the bottom
        of the screen.*/
        String output;
        
        if(MenuFrame.map.getPort().getCargo().size() > 0){
            this.messageBox.append("Cargo:");
            for(int i = 0; i < MenuFrame.map.getPort().getCargo().size(); i++){
                output = MenuFrame.map.getPort().getCargo().get(i).toString();
                this.messageBox.append(i + ": " + output);
            }
        }
        
        else{
            this.messageBox.append("No cargo to display\n");
        }
    }
    
    
    /********MONSTER MENU**********/
    public void generateMonsters(){
        /*Prompts the user with a dialog box, and request a number of monsters
        (sea serpents, leviathans, and krakens) to be generated. The monsters
        will then be placed on the map in the sea.*/
    }
    
    public void updateMonsters(){
        /*Prompt the user with a dialog box with a list item contatining the current
        monsters. Once a monster has been selected, open a second dialog box that will
        allow the user to update the current monster properties*/
    }
    
    public void displayAllMonsters(){
        /*Show the current monsters in the status message at the bottom of the screen*/
        String output;
        
        if(MenuFrame.map.getSeamonsters().size() > 0){
            for(int i = 0; i < MenuFrame.map.getSeamonsters().size(); i++){
                output = i + ": " + MenuFrame.map.getSeamonsters().get(i).type;
                this.messageBox.append(output);
            }
        }
        
        else{
            this.messageBox.append("No sea monsters to display");
        }
        
    }
    
    public void removeAllMonsters(){
        /*Remove all monsters from the map*/
        MenuFrame.map.getSeamonsters().clear();
    }
    
    public void summonGodzilla(){
        /*Put Godzilla on the map. Prompt the user for the location of where Godzilla
        would appear. Godzilla, being an amphibian, can be on either land or water.*/
    }
    
    /*********ABOUT***************/
    public void about(){
        String about = "Byte Me\nCSE 1325-002\nApril 17,2015\n\nName: Cam Nguyen\nID: 1000952534\n\nName: Pauline Nguyen\n ID: 1000781109\n\nName: Zach Niemann\nID: 1000625866\n\n";
        JOptionPane.showMessageDialog(null, about, "About Us", JOptionPane.PLAIN_MESSAGE);
    }
}
