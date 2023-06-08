package Playables;

import Game.MainWindow;
import Game.Weapons.Fists;
import Game.Weapons.SuperWeapon;

public class Player {
    public int hp;
    public SuperWeapon currentWeapon;

    public Player() {
        this.hp = 50;
        this.currentWeapon = new Fists();
    }

    public int getHp() {
        return hp;
    }

    public void attack(Npc enemy) {
        // Perform attack logic
        int damage = currentWeapon.getDamage();
        MainWindow.mainTextOutput.setText("You attack with " + currentWeapon.getName() + " and deal " + damage + " damage.");
        enemy.hp -= damage;
        if (enemy.hp <= 0) {
            // Enemy defeated
            MainWindow.mainTextOutput.append("\nYou defeated " + enemy.getName() + "!");
            MainWindow.weaponLabelName.setText("");
            MainWindow.choice1.setEnabled(false);
            MainWindow.choice2.setEnabled(false);
            MainWindow.choice3.setEnabled(false);
            MainWindow.choice4.setEnabled(false);
            MainWindow.textButton.setEnabled(false);
        } else {
            MainWindow.mainTextOutput.append("\n" + enemy.getName() + " health: " + enemy.hp);
        }
    }

    public void defend() {
        // Perform defend logic
        int damage = currentWeapon.getDamage() / 2;
        MainWindow.mainTextOutput.setText("You defend and take reduced damage.");
        hp -= damage;
        if (hp <= 0) {
            // Player defeated
            MainWindow.mainTextOutput.append("\nYou have been defeated. Game over!");
            MainWindow.hpLabelNumber.setText("");
            MainWindow.weaponLabelName.setText("");
            MainWindow.choice1.setEnabled(false);
            MainWindow.choice2.setEnabled(false);
            MainWindow.choice3.setEnabled(false);
            MainWindow.choice4.setEnabled(false);
            MainWindow.textButton.setEnabled(false);
        } else {
            MainWindow.hpLabelNumber.setText(Integer.toString(hp));
        }
    }

    public void rest() {
        // Perform rest logic
        int healAmount = 5;
        hp += healAmount;
        MainWindow.mainTextOutput.setText("You rest and heal " + healAmount + " health. Current health: " + hp);
    }

    public void stand() {
        // Perform stand logic
        MainWindow.mainTextOutput.setText("You stand still and do nothing.");
    }
}