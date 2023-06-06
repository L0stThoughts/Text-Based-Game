package Game;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpWindow implements ActionListener {
    JFrame frame = new JFrame();
    Icon icon = new ImageIcon("Textures/Exit.PNG");
    JButton backButton = new JButton(icon);

    HelpWindow() {
        backButton.setBounds(380, 0, 40, 40);
        backButton.setFocusable(false);
        backButton.setBackground(null);
        backButton.setBorderPainted(false);
        backButton.addActionListener(this);

        frame.add(backButton);

        frame.getContentPane().setBackground(Color.GRAY);
        frame.setUndecorated(true);
        frame.setSize(420, 420);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));

        MainWindow.openHelp = true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            frame.dispose();
            MainWindow.openHelp = false;
        }
    }
}
