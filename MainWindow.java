import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MainWindow implements ActionListener{
    
    JFrame frame = new JFrame();
    JButton invetoryButton = new JButton("Inventory");
    JTextField textField = new JTextField("insert command");
    JButton textButton = new JButton("submit");

    MainWindow() {

        textButton.setBounds(529, 630, 150, 39);
        textButton.setFocusable(false);
        textButton.addActionListener(this);
        textButton.setContentAreaFilled(true);

        frame.add(textButton);

        textField.setBounds(30, 630, 500, 40);
        textField.addActionListener(this);

        frame.add(textField);

        invetoryButton.setBounds(955, 630, 300, 39);
        invetoryButton.setFocusable(false);
        invetoryButton.addActionListener(this);

        frame.add(invetoryButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280 , 720);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == invetoryButton){
            frame.dispose();
            InventoryWindow inventoryWindow = new InventoryWindow();
        }

        if(e.getSource() == textField){
            
            
        }

        if(e.getSource() == textButton){
            textField.setText(" ");
            
        }
    }
}
