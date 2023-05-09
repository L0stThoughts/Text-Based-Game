package Windows;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JTextField;

public class MainWindow implements ActionListener{
    
    JFrame frame = new JFrame();
    JButton invetoryButton = new JButton("Inventory");
    JButton musicButton = new JButton("Music");
    JButton statsButton = new JButton("Stats");
    JButton questsButton = new JButton("Quests");
    JTextField textField = new JTextField("insert command");
    JButton textButton = new JButton("submit");
    

    public MainWindow() {
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280 , 720);
        frame.setTitle("Text Adventures");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        
        textButton.setBounds(529, 630, 150, 39);
        textButton.setFocusable(false);
        textButton.addActionListener(this);
        textButton.setContentAreaFilled(true);

        frame.add(textButton);

        textField.setBounds(30, 630, 500, 40);
        textField.addActionListener(this);

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
        if(e.getSource() == invetoryButton){
            InventoryWindow inventoryWindow = new InventoryWindow();
        }

        if(e.getSource() == musicButton){
            MusicWindow musicWindow = new MusicWindow();
        }

        if(e.getSource() == statsButton){
            StatsWindow statsButton = new StatsWindow();
        }

        if(e.getSource() == questsButton){
            QuestsWindow questsButton = new QuestsWindow();
        }

        if(e.getSource() == textField){
            
            
        }

        if(e.getSource() == textButton){
            textField.setText(" ");
            
        }
    }
}