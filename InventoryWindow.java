import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class InventoryWindow implements ActionListener{


    JFrame frame = new JFrame();
    JLabel label = new JLabel("Hi");
    JButton backButton = new JButton("Back");

    InventoryWindow(){
        backButton.setBounds(100, 330, 200, 40);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        frame.add(backButton);

        label.setBounds(0, 0, 100, 50);
        label.setFont(new Font(null, Font.PLAIN, 25));

        frame.add(label);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton){
            frame.dispose();
            MainWindow mainWindow = new MainWindow();
        }
    }
}
