package Game;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpWindow implements ActionListener {
    JFrame frameHelp = new JFrame();
    Icon icon = new ImageIcon("Textures/Exit.PNG");
    JButton backButton = new JButton(icon);

    HelpWindow() {
        backButton.setBounds(378, 0, 40, 40);
        backButton.setFocusable(false);
        backButton.setBackground(null);
        backButton.setBorderPainted(false);
        backButton.addActionListener(this);

        frameHelp.add(backButton);

        frameHelp.getContentPane().setBackground(Color.GRAY);
        frameHelp.setUndecorated(true);
        frameHelp.setSize(420, 420);
        frameHelp.setResizable(false);
        frameHelp.setLocationRelativeTo(null);
        frameHelp.setAlwaysOnTop(true);
        frameHelp.setLayout(null);
        frameHelp.setVisible(true);
        frameHelp.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));

        MainWindow.openHelp = true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            frameHelp.dispose();
            MainWindow.openHelp = false;
        }
    }
}