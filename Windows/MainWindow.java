package Windows;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import Game.MainGame;

public class MainWindow implements ActionListener, FocusListener {

    
    JFrame frame = new JFrame();
    JButton invetoryButton = new JButton("Inventory");
    static boolean openInventory = false;
    JButton musicButton = new JButton("Music");
    static boolean openMusic = false;
    JButton statsButton = new JButton("Stats");
    static boolean openStats = false;
    JButton questsButton = new JButton("Quests");
    static boolean openQuests = false;
    JTextField textField = new JTextField("insert command");
    JButton textButton = new JButton("submit");
    public static Container con;

    public MainWindow() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setTitle("Text Adventures");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        con = frame.getContentPane();
        

        textButton.setBounds(529, 630, 150, 39);
        textButton.setFocusable(false);
        textButton.addActionListener(this);
        textButton.setContentAreaFilled(true);

        frame.add(textButton);

        textField.setBounds(30, 630, 500, 40);
        textField.addActionListener(this);
        textField.addFocusListener(this);

        frame.add(textField);

        invetoryButton.setBounds(1100, 630, 150, 39);
        invetoryButton.setFocusable(false);
        invetoryButton.addActionListener(this);

        frame.add(invetoryButton);

        musicButton.setBounds(1100, 580, 150, 39);
        musicButton.setFocusable(false);
        musicButton.addActionListener(this);

        frame.add(musicButton);

        questsButton.setBounds(1100, 530, 150, 39);
        questsButton.setFocusable(false);
        questsButton.addActionListener(this);

        frame.add(questsButton);

        statsButton.setBounds(1100, 480, 150, 39);
        statsButton.setFocusable(false);
        statsButton.addActionListener(this);

        frame.add(statsButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (openInventory == false) {
            if (e.getSource() == invetoryButton) {
                InventoryWindow inventoryWindow = new InventoryWindow();
            }
        } else {}

        if (openMusic == false) {
            if (e.getSource() == musicButton) {
                MusicWindow musicWindow = new MusicWindow();
            }
        } else {}

        if (openQuests == false) {
            if (e.getSource() == questsButton) {
                QuestsWindow questsButton = new QuestsWindow();
            }
        } else {}

        if (openStats == false) {
            if (e.getSource() == statsButton) {
                StatsWindow statsButton = new StatsWindow();
            }
        } else {}

        if (e.getSource() == textField) {
        
        }

        if (e.getSource() == textButton) {
            if(textField.getText().equalsIgnoreCase("start")){
                MainGame mainGame = new MainGame();
                frame.setVisible(false);
                textField.setText(" ");
            }
            textField.setText(" ");

        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (textField.getText().equals("insert command")) {
            textField.setText("");
            textField.setForeground(Color.BLACK);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (textField.getText().isEmpty()) {
            textField.setForeground(Color.GRAY);
            textField.setText("insert command");
        }
    }
}