package Game;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Playables.Npc;
import Playables.Player;

public class MainWindow implements ActionListener, FocusListener {

    static JFrame frame = new JFrame();
    Font mainOutputFont = new Font("SansSerif", Font.PLAIN, 35);
    Font buttonFont = new Font("SansSerif", Font.PLAIN, 20);
    Font mainFont = new Font("SansSerif", Font.PLAIN, 40);
    JButton invetoryButton = new JButton("Inventory");
    JButton musicButton = new JButton("Music");
    JButton helpButton = new JButton("Help");
    static boolean openInventory = false;
    static boolean openMusic = false;
    static boolean openHelp = false;
    JTextField textField = new JTextField("insert command");
    public static JButton textButton = new JButton("submit");
    static Container con;
    JButton startButton;
    public static JButton choice1;
    public static JButton choice2;
    public static JButton choice3;
    public static JButton choice4; 
    JPanel mainText, titleNamePanel, startButtonPanel, choiceButtonPanel, healthPanel, weaponPanel;
    JLabel titleNameLabel, hpLabel, weaponLabel;
    public static JLabel hpLabelNumber;
    public static JLabel weaponLabelName;
    public static JTextArea mainTextOutput;
    int playerHP;
    String weapon, position, nextPosition1, nextPosition2, nextPosition3, nextPosition4;
    ChoiceHandler choiceHandler = new ChoiceHandler();
    SetUp setup = new SetUp(this);
    Npc enemy = new Npc("John", 50);
    Player player = new Player();
    

    public MainWindow() {
        // main frame of the whole window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setTitle("Fight or Flight");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

        con = frame.getContentPane();

        // main player panel for displaying hitpoints and weapons
        healthPanel = new JPanel();
        healthPanel.setBounds(0, 450, 400, 50);
        healthPanel.setBackground(Color.lightGray);
        healthPanel.setLayout(new GridLayout(1, 2));
        healthPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        con.add(healthPanel);
        hpLabel = new JLabel("HP:");
        hpLabel.setFont(mainFont);
        hpLabel.setForeground(Color.black);
        healthPanel.add(hpLabel);
        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(mainFont);
        hpLabelNumber.setForeground(Color.black);
        healthPanel.add(hpLabelNumber);

        weaponPanel = new JPanel();
        weaponPanel.setBounds(0, 500, 400, 50);
        weaponPanel.setBackground(Color.lightGray);
        weaponPanel.setLayout(new GridLayout(1, 2));
        weaponPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        con.add(weaponPanel);
        weaponLabel = new JLabel("Weapon:");
        weaponLabel.setFont(mainFont);
        weaponLabel.setForeground(Color.black);
        weaponPanel.add(weaponLabel);
        weaponLabelName = new JLabel();
        weaponLabelName.setFont(mainFont);
        weaponLabelName.setForeground(Color.black);
        weaponPanel.add(weaponLabelName);
        // button layout
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(750, 475, 300, 200);
        choiceButtonPanel.setBackground(Color.gray);
        choiceButtonPanel.setLayout(new GridLayout(4, 1));
        con.add(choiceButtonPanel);
        // choice1 button
        choice1 = new JButton("choice1");
        choice1.setBackground(Color.white);
        choice1.setFont(buttonFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);
        // choice2 button
        choice2 = new JButton("choice2");
        choice2.setBackground(Color.white);
        choice2.setFont(buttonFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);
        // choice3 button
        choice3 = new JButton("choice3");
        choice3.setBackground(Color.white);
        choice3.setFont(buttonFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);
        // choice4 button
        choice4 = new JButton("choice4");
        choice4.setBackground(Color.white);
        choice4.setFont(buttonFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);
        // submit button
        textButton.setBounds(509, 630, 150, 39);
        textButton.setFocusable(false);
        textButton.setBackground(Color.white);
        textButton.addActionListener(this);
        textButton.setContentAreaFilled(true);

        frame.add(textButton);
        // input text field
        textField.setBounds(10, 630, 500, 40);
        textField.addActionListener(this);
        textField.addFocusListener(this);

        frame.add(textField);
        // open inventory
        invetoryButton.setBounds(1100, 525, 150, 50);
        invetoryButton.setBackground(Color.white);
        invetoryButton.setFocusable(false);
        invetoryButton.addActionListener(this);

        frame.add(invetoryButton);
        // open music
        musicButton.setBounds(1100, 575, 150, 50);
        musicButton.setBackground(Color.white);
        musicButton.setFocusable(false);
        musicButton.addActionListener(this);

        frame.add(musicButton);
        // open help menu
        helpButton.setBounds(1100, 625, 150, 50);
        helpButton.setBackground(Color.white);
        helpButton.setFocusable(false);
        helpButton.addActionListener(this);

        frame.add(helpButton);

        // main output text panel
        mainText = new JPanel();
        mainText.setBounds(0, 0, 1264, 450);
        mainText.setBackground(Color.lightGray);
        mainText.setBorder(BorderFactory.createLineBorder(Color.black));
        con.add(mainText);

        mainTextOutput = new JTextArea(
                "Welcome to 'Fight or Flight' to play input 'start' into the command line");
        mainTextOutput.setBounds(5, 0, 1250, 450);
        mainTextOutput.setBackground(Color.lightGray);
        mainTextOutput.setForeground(Color.black);
        mainTextOutput.setWrapStyleWord(true);
        mainTextOutput.setFont(mainOutputFont);
        mainTextOutput.setLineWrap(true);
        mainTextOutput.setEditable(false);

        mainText.add(mainTextOutput);

        setup.defaultSetup();

    }
    public class ChoiceHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String yourChoice = e.getActionCommand();

            switch (yourChoice) {
                case "start":
                    setup.gameStoryLine();
                    break;
                case "c1":
                    player.attack(enemy);
                    enemyTurn();
                    break;
                case "c2":
                    player.defend();
                    enemyTurn();
                    break;
                case "c3":
                    player.rest();
                    enemyTurn();
                    break;
                case "c4":
                    enemy.stand();
                    enemyTurn(); // Trigger the enemy's turn
                    break;
            }
        }

    }

    public void enemyTurn() {
        int randomChoice = (int) (Math.random() * 4) + 1;
    
        switch (randomChoice) {
            case 1:
                enemy.attack(player);
                break;
            case 2:
                enemy.defend();
                break;
            case 3:
                enemy.rest();
                break;
            case 4:
                enemy.stand();
                break;
        }
    
        // Check if the player is defeated after enemy's attack
        if (player.getHp() <= 0) {
            mainTextOutput.append("\nYou have been defeated. Game over!");
            return; // Exit the method
        }
    
        // Check if the enemy is defeated after player's attack or actions
        if (enemy.getHp() <= 0) {
            mainTextOutput.append("\nYou defeated " + enemy.getName() + "!");
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (openInventory == false) { // open inventory function
            if (e.getSource() == invetoryButton) {
                InventoryWindow inventoryWindow = new InventoryWindow();
            }
        } else {
        }

        if (openMusic == false) { // open music function
            if (e.getSource() == musicButton) {
                MusicWindow musicWindow = new MusicWindow();
            }
        } else {
        }

        if (openHelp == false) { // open help function
            if (e.getSource() == helpButton) {
                HelpWindow helpButton = new HelpWindow();
            }
        } else {
        }

        if (e.getSource() == textButton) { // submit button functions
            if (textField.getText().equalsIgnoreCase("start")) {
                setup.gameStoryLine();
            }
            textField.setText(" ");

        }
    }

    @Override
    public void focusGained(FocusEvent e) { // text input placeholder
        if (textField.getText().equals("insert command")) {
            textField.setText("");
            textField.setForeground(Color.BLACK);
        }
    }

    @Override
    public void focusLost(FocusEvent e) { // text input placeholder
        if (textField.getText().isEmpty()) {
            textField.setForeground(Color.GRAY);
            textField.setText("insert command");
        }
    }

}
