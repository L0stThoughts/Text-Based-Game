package Playables;

import Game.MainWindow;
import Game.Weapons.Knife;
import Game.Weapons.SuperWeapon;

public class Npc {
    private String name;
    public int hp;
    public SuperWeapon currentWeapon;

    public Npc(String name, int health) {
        this.name = name;
        this.hp = health;
        this.currentWeapon = new Knife();
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void attack(Player player) {
        int damage = currentWeapon.getDamage();
        MainWindow.mainTextOutput.append("\n"+name + " attacks with " + currentWeapon.getName() + " and deals " + damage + " damage.");
        player.hp -= damage;
        if (player.hp <= 0) {
            // Player defeated
            MainWindow.mainTextOutput.append("\nYou have been defeated. Game over!");
            disableButtons();
        } else {
            MainWindow.hpLabelNumber.setText(Integer.toString(player.hp));
        }
    }

    public void defend() {
        // Perform defend logic
        int damage = currentWeapon.getDamage() / 2;
        MainWindow.mainTextOutput.setText(name + " defends and takes reduced damage.");
        hp -= damage;
        if (hp <= 0) {
            // Enemy defeated
            MainWindow.mainTextOutput.append("\nYou defeated " + name + "!");
            disableButtons();
        }
    }

    public void rest() {
        // Perform rest logic
        int healAmount = 3;
        hp += healAmount;
        MainWindow.mainTextOutput.setText(name + " rests and heals " + healAmount + " health. Current health: " + hp);
    }

    public void stand() {
        // Perform stand logic
        MainWindow.mainTextOutput.setText(name + " stands still and does nothing.");
    }

    private void disableButtons() {
        MainWindow.choice1.setEnabled(false);
        MainWindow.choice2.setEnabled(false);
        MainWindow.choice3.setEnabled(false);
        MainWindow.choice4.setEnabled(false);
        MainWindow.textButton.setEnabled(false);
    }
}
