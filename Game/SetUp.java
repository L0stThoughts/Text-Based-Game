package Game;

import Game.Items.Coin;
import Game.Items.Item_Empty;
import Game.Items.Potion;
import Game.Items.SuperItem;
import Game.Weapons.Fists;
import Playables.Player;

public class SetUp {

    MainWindow game;
    Player player = new Player();
    Potion potion = new Potion();
    Coin coin = new Coin();
    Item_Empty empty = new Item_Empty();
    static SuperItem[] playerItem = new SuperItem[5];

    public SetUp(MainWindow g) {
        game = g;

    }
    
    public void defaultSetup() {
        MainWindow.hpLabelNumber.setText(" " + player.hp);
        player.currentWeapon = new Fists();
        MainWindow.weaponLabelName.setText(player.currentWeapon.name);


        
    }
    
    public void gameStoryLine() {
        MainWindow.choice1.setText("Attack");
        MainWindow.choice2.setText("Defend");
        MainWindow.choice3.setText("Rest");
        MainWindow.choice4.setText("Stand");

        MainWindow.mainTextOutput.setText("A wild enemy appeared! What will you do?");
    }

    
}
