package Game;

import java.awt.*;
import javax.swing.*;

import Game.Items.Coin;
import Game.Items.Item_Empty;
import Game.Items.Potion;
import Game.Items.SuperItem;
import Playables.Player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryWindow {
    JFrame frameInventory = new JFrame();
    Icon icon = new ImageIcon("Textures/Exit.PNG");
    JButton backButton = new JButton(icon);
    JPanel inventoryPanel;
    InventoryHandler iHandler = new InventoryHandler();
    JButton[] itemButtons = new JButton[5];
    SuperItem[] playerItems = new SuperItem[5];
    Player player = new Player();
    Item_Empty empty = new Item_Empty();

    InventoryWindow() {

        frameInventory.getContentPane().setBackground(Color.GRAY);
        frameInventory.setUndecorated(true);
        frameInventory.setSize(300, 420);
        frameInventory.setResizable(false);
        frameInventory.setLocationRelativeTo(null);
        frameInventory.setAlwaysOnTop(true);
        frameInventory.setLayout(null);
        frameInventory.setVisible(true);
        frameInventory.setBounds(MainWindow.frame.getX() - 290, MainWindow.frame.getY(), frameInventory.getWidth(),
                frameInventory.getHeight());
        frameInventory.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));

        inventoryPanel = new JPanel();
        inventoryPanel.setBounds(0, 0, 300, 420);
        inventoryPanel.setLayout(null);
        inventoryPanel.setBackground(Color.WHITE);
        frameInventory.add(inventoryPanel);

        playerItems[0] = new Potion();
        playerItems[1] = new Coin();
        playerItems[2] = empty;
        playerItems[3] = empty;
        playerItems[4] = empty;

        for (int i = 0; i < 5; i++) {
            itemButtons[i] = new JButton();
            itemButtons[i].setBounds(10, 50 + (75 * i), 280, 40);
            itemButtons[i].setBackground(Color.white);
            itemButtons[i].setVisible(true);
            itemButtons[i].setFocusable(false);
            itemButtons[i].addActionListener(iHandler);
            itemButtons[i].setActionCommand("item" + (i + 1));
            inventoryPanel.add(itemButtons[i]);
        }

        backButton.setBounds(258, 0, 40, 40);
        backButton.setFocusable(false);
        backButton.setBackground(null);
        backButton.setVisible(true);
        backButton.setBorderPainted(false);
        backButton.addActionListener(iHandler);

        frameInventory.add(backButton);

        MainWindow.openInventory = true;
        updateInventory();
    }

    public void updateInventory() {
        for (int i = 0; i < 5; i++) {
            SuperItem item = playerItems[i];
            if (item == null || item instanceof Item_Empty) {
                itemButtons[i].setText("Empty");
            } else {
                itemButtons[i].setText(item.getName());
            }
        }
    }

    public void itemUsed(int slotNumber){
        player.hp = player.getHp()+ playerItems[slotNumber].getHealingValue();
        MainWindow.hpLabelNumber.setText(""+player.hp);

        playerItems[slotNumber] = empty;
        itemButtons[0].setText(playerItems[0].getName());
        itemButtons[1].setText(playerItems[1].getName());
        itemButtons[2].setText(playerItems[2].getName());
        itemButtons[3].setText(playerItems[3].getName());
        itemButtons[4].setText(playerItems[4].getName());
    }

    public class InventoryHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == backButton) {
                frameInventory.dispose();
                MainWindow.openInventory = false;
            }

            String yourChoice = e.getActionCommand();

            switch (yourChoice) {
                case "item1":
                    itemUsed(0);
                    break;

                case "item2":
                    itemUsed(1);
                    break;

                case "item3":
                    itemUsed(2);
                    break;

                case "item4":
                    itemUsed(3);
                    break;
                case "item5":
                    itemUsed(4);
                    break;
            }

        }

    }

}
