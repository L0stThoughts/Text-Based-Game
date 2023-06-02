package Game;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import Windows.MainWindow;

public class MainGame extends MainWindow{
    JPanel mainText;
    JTextArea mainTextOutput;
    Font mainFont = new Font("Sans Serif", Font.PLAIN, 40);
    
    public MainGame(){
        mainText = new JPanel();
        mainText.setBounds(10, 0, 1245, 450);
        mainText.setBackground(Color.lightGray);
        con.add(mainText);

        mainTextOutput = new JTextArea("testing hardcore RAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        mainTextOutput.setBounds(10, 0, 1245, 450);
        mainTextOutput.setBackground(Color.lightGray);
        mainTextOutput.setForeground(Color.black);
        mainTextOutput.setFont(mainFont);
        mainTextOutput.setLineWrap(true);
        mainText.add(mainTextOutput);

        
    }
}
