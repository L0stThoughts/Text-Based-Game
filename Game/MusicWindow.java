package Game;

import java.awt.*;
import javax.swing.*;

import Music.Music;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MusicWindow{
    JFrame frameMusic = new JFrame();
    Icon icon = new ImageIcon("Textures/Exit.PNG");
    JButton backButton = new JButton(icon);
    JButton musicR1, musicR2, musicR3, musicR4, musicR5, musicR6, musicR7;
    JButton musicL1, musicL2, musicL3, musicL4, musicL5, musicL6, musicL7;
    
    ButtonHandler bHandler = new ButtonHandler();
    String entryMusic = "./Music/EntryMusic.wav";
    String rightKeyMusic ="./Music/rightKey.wav";
    Music mu = new Music();



    MusicWindow() {
        
        frameMusic.getContentPane().setBackground(Color.GRAY);
        frameMusic.setUndecorated(true);
        frameMusic.setSize(420, 420);
        frameMusic.setResizable(false);
        frameMusic.setLocationRelativeTo(null);
        frameMusic.setAlwaysOnTop(true);
        frameMusic.setLayout(null);
        frameMusic.setVisible(true);
        frameMusic.setBounds(MainWindow.frame.getX()+1270, MainWindow.frame.getY(), frameMusic.getWidth(), frameMusic.getHeight());
        frameMusic.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));

        backButton.setBounds(378, 0, 40, 40);
        backButton.setFocusable(false);
        backButton.setBackground(null);
        backButton.setBorderPainted(false);
        backButton.addActionListener(bHandler);

        frameMusic.add(backButton);

        musicR1 = new JButton("");
        musicR1.setBounds(210, 50, 190, 40);
        musicR1.setFocusable(false);
        musicR1.setBackground(Color.white);
        musicR1.setBorderPainted(false);
        musicR1.addActionListener(bHandler);
        musicR1.setActionCommand("");
        frameMusic.add(musicR1);

        musicR2 = new JButton("");
        musicR2.setBounds(210, 100, 190, 40);
        musicR2.setFocusable(false);
        musicR2.setBackground(Color.white);
        musicR2.setBorderPainted(false);
        musicR2.addActionListener(bHandler);
        musicR2.setActionCommand("");
        frameMusic.add(musicR2);

        musicR3 = new JButton("");
        musicR3.setBounds(210, 150, 190, 40);
        musicR3.setFocusable(false);
        musicR3.setBackground(Color.white);
        musicR3.setBorderPainted(false);
        musicR3.addActionListener(bHandler);
        musicR3.setActionCommand("");
        frameMusic.add(musicR3);

        musicR4 = new JButton("");
        musicR4.setBounds(210, 200, 190, 40);
        musicR4.setFocusable(false);
        musicR4.setBackground(Color.white);
        musicR4.setBorderPainted(false);
        musicR4.addActionListener(bHandler);
        musicR4.setActionCommand("");
        frameMusic.add(musicR4);

        musicR5 = new JButton("");
        musicR5.setBounds(210, 250, 190, 40);
        musicR5.setFocusable(false);
        musicR5.setBackground(Color.white);
        musicR5.setBorderPainted(false);
        musicR5.addActionListener(bHandler);
        musicR5.setActionCommand("");
        frameMusic.add(musicR5);

        musicR6 = new JButton("");
        musicR6.setBounds(210, 300, 190, 40);
        musicR6.setFocusable(false);
        musicR6.setBackground(Color.white);
        musicR6.setBorderPainted(false);
        musicR6.addActionListener(bHandler);
        musicR6.setActionCommand("");
        frameMusic.add(musicR6);

        musicR7 = new JButton("");
        musicR7.setBounds(210, 350, 190, 40);
        musicR7.setFocusable(false);
        musicR7.setBackground(Color.white);
        musicR7.setBorderPainted(false);
        musicR7.addActionListener(bHandler);
        musicR7.setActionCommand("");
        frameMusic.add(musicR7);

        musicL1 = new JButton("Entry");
        musicL1.setBounds(10, 50, 190, 40);
        musicL1.setFocusable(false);
        musicL1.setBackground(Color.white);
        musicL1.setBorderPainted(false);
        musicL1.addActionListener(bHandler);
        musicL1.setActionCommand("entry");
        frameMusic.add(musicL1);

        musicL2 = new JButton("The right key in the rain");
        musicL2.setBounds(10, 100, 190, 40);
        musicL2.setFocusable(false);
        musicL2.setBackground(Color.white);
        musicL2.setBorderPainted(false);
        musicL2.addActionListener(bHandler);
        musicL2.setActionCommand("rightKey");
        frameMusic.add(musicL2);

        musicL3 = new JButton("");
        musicL3.setBounds(10, 150, 190, 40);
        musicL3.setFocusable(false);
        musicL3.setBackground(Color.white);
        musicL3.setBorderPainted(false);
        musicL3.addActionListener(bHandler);
        musicL3.setActionCommand("");
        frameMusic.add(musicL3);

        musicL4 = new JButton("");
        musicL4.setBounds(10, 200, 190, 40);
        musicL4.setFocusable(false);
        musicL4.setBackground(Color.white);
        musicL4.setBorderPainted(false);
        musicL4.addActionListener(bHandler);
        musicL4.setActionCommand("");
        frameMusic.add(musicL4);

        musicL5 = new JButton("");
        musicL5.setBounds(10, 250, 190, 40);
        musicL5.setFocusable(false);
        musicL5.setBackground(Color.white);
        musicL5.setBorderPainted(false);
        musicL5.addActionListener(bHandler);
        musicL5.setActionCommand("");
        frameMusic.add(musicL5);

        musicL6 = new JButton("");
        musicL6.setBounds(10, 300, 190, 40);
        musicL6.setFocusable(false);
        musicL6.setBackground(Color.white);
        musicL6.setBorderPainted(false);
        musicL6.addActionListener(bHandler);
        musicL6.setActionCommand("");
        frameMusic.add(musicL6);

        musicL7 = new JButton("");
        musicL7.setBounds(10, 350, 190, 40);
        musicL7.setFocusable(false);
        musicL7.setBackground(Color.white);
        musicL7.setBorderPainted(false);
        musicL7.addActionListener(bHandler);
        musicL7.setActionCommand("");
        frameMusic.add(musicL7);

        MainWindow.openMusic = true;
    }

    public class ButtonHandler implements ActionListener{

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == backButton) {
                frameMusic.dispose();
                MainWindow.openMusic = false;
            } 
            String clickedButton = e.getActionCommand();

            switch(clickedButton){
                case "entry":
                mu.setfile(entryMusic);
                mu.play();
                break;
                case "rightKey":
                mu.setfile(rightKeyMusic);
                mu.play();
                break;
            }
        }
    }
}
