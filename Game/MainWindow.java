package Game;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainWindow implements ActionListener, FocusListener {

    JFrame frame = new JFrame();
    Font mainOutputFont = new Font("SansSerif", Font.PLAIN, 35);
    Font buttonFont = new Font("SansSerif", Font.PLAIN, 20);
    Font mainFont = new Font("SansSerif", Font.PLAIN, 40);
    JButton invetoryButton = new JButton("Inventory");
    JButton musicButton = new JButton("Music");
    JButton helpButton = new JButton("Help");
    static boolean openInventory = false;
    static boolean openMusic = false;
    static boolean openHelp = false;
    protected static JTextField textField = new JTextField("insert command");
    JButton textButton = new JButton("submit");
    public static Container con;
    JButton startButton;
    JPanel mainText, titleNamePanel, startButtonPanel, choiceButtonPanel, healthPanel, weaponPanel;
    JLabel titleNameLabel, hpLabel;
    public static JLabel hpLabelNumber;
    JLabel weaponLabel;
    public static JLabel weaponLabelName;
    public static JTextArea mainTextOutput;
    static int playerHP;
    static String weapon, position;
    static JButton choice1, choice2, choice3, choice4;
    ChoiceHandler choiceHandler = new ChoiceHandler();

    public MainWindow() {
        // main frame of the whole window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setTitle("One shot story");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

        con = frame.getContentPane();

        // main player panel for displaying hitpoints and weapons
        healthPanel = new JPanel();
        healthPanel.setBounds(0, 450, 400, 50);
        healthPanel.setBackground(Color.lightGray);
        healthPanel.setLayout(new GridLayout(1, 2));
        healthPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        con.add(healthPanel);
        hpLabel = new JLabel("HP:");
        hpLabel.setFont(mainFont);
        hpLabel.setForeground(Color.black);
        healthPanel.add(hpLabel);
        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(mainFont);
        hpLabelNumber.setForeground(Color.black);
        healthPanel.add(hpLabelNumber);

        weaponPanel = new JPanel();
        weaponPanel.setBounds(0, 500, 400, 50);
        weaponPanel.setBackground(Color.lightGray);
        weaponPanel.setLayout(new GridLayout(1, 2));
        weaponPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        con.add(weaponPanel);
        weaponLabel = new JLabel("Weapon:");
        weaponLabel.setFont(mainFont);
        weaponLabel.setForeground(Color.black);
        weaponPanel.add(weaponLabel);
        weaponLabelName = new JLabel();
        weaponLabelName.setFont(mainFont);
        weaponLabelName.setForeground(Color.black);
        weaponPanel.add(weaponLabelName);
        // button layout
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(750, 475, 300, 200);
        choiceButtonPanel.setBackground(Color.gray);
        choiceButtonPanel.setLayout(new GridLayout(4, 1));
        con.add(choiceButtonPanel);
        // choice1 button
        choice1 = new JButton("choice1");
        choice1.setBackground(Color.lightGray);
        choice1.setFont(buttonFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);
        // choice2 button
        choice2 = new JButton("choice2");
        choice2.setBackground(Color.lightGray);
        choice2.setFont(buttonFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);
        // choice3 button
        choice3 = new JButton("choice3");
        choice3.setBackground(Color.lightGray);
        choice3.setFont(buttonFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);
        // choice4 button
        choice4 = new JButton("choice4");
        choice4.setBackground(Color.lightGray);
        choice4.setFont(buttonFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);
        // submit button
        textButton.setBounds(509, 630, 150, 39);
        textButton.setFocusable(false);
        textButton.addActionListener(this);
        textButton.setContentAreaFilled(true);

        frame.add(textButton);
        // input text field
        textField.setBounds(10, 630, 500, 40);
        textField.addActionListener(this);
        textField.addFocusListener(this);

        frame.add(textField);
        // open inventory
        invetoryButton.setBounds(1100, 530, 150, 39);
        invetoryButton.setFocusable(false);
        invetoryButton.addActionListener(this);

        frame.add(invetoryButton);
        // open music
        musicButton.setBounds(1100, 580, 150, 39);
        musicButton.setFocusable(false);
        musicButton.addActionListener(this);

        frame.add(musicButton);
        // open help menu
        helpButton.setBounds(1100, 630, 150, 39);
        helpButton.setFocusable(false);
        helpButton.addActionListener(this);

        frame.add(helpButton);

        // main output text panel
        mainText = new JPanel();
        mainText.setBounds(0, 0, 1264, 450);
        mainText.setBackground(Color.lightGray);
        mainText.setBorder(BorderFactory.createLineBorder(Color.black));
        con.add(mainText);

        mainTextOutput = new JTextArea(
                "testing hardcore RAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        mainTextOutput.setBounds(5, 0, 1250, 450);
        mainTextOutput.setBackground(Color.lightGray);
        mainTextOutput.setForeground(Color.black);
        mainTextOutput.setWrapStyleWord(true);
        mainTextOutput.setFont(mainOutputFont);
        mainTextOutput.setLineWrap(true);
        mainTextOutput.setEditable(false);

        mainText.add(mainTextOutput);

       
    }

    public static void Player() {
        playerHP = 15;
        weapon = "Fists";
        MainWindow.weaponLabelName.setText(weapon);
        MainWindow.hpLabelNumber.setText(" " + playerHP);
        gameStoryLine();
    }

    public static void gameStoryLine() {
        position = "start";
        

        choice1.setText("Speak to the Village Elder");
        choice2.setText("Take a Different Path");
        choice3.setText("Explore the Abandoned Mine");
        choice4.setText("Attack the Bandit Camp");
    }

    public static void speakToElder() {
        position = "elder";
        mainTextOutput.setText(
                "The wise Village Elder, with his long gray beard and knowledgeable gaze, offered you guidance and insight into the challenges that lay ahead. He spoke of a sacred amulet rumored to hold immense power, lost deep within the Forbidden Forest. He also warned of dangerous creatures lurking within. The Elder advised you to seek a local hermit named Malachi, who might possess more information about the amulet.");
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public static void takeDifferentPath() {
        position = "path";
        mainTextOutput.setText(
                "You decided to venture away from the village and follow an unmarked trail that led into the heart of the mystical Whispering Woods. This path was known to be treacherous, but you were eager to explore the unknown. The woods were enchanted, with ethereal whispers carried on the wind. As you walked deeper, you stumbled upon an ancient shrine covered in moss. The shrine radiated an otherworldly aura, and you wondered if it held a secret or a hidden treasure.");
        choice1.setText("");
        choice2.setText(">");
        choice3.setText("");
        choice4.setText("");
    }

    public static void exploreAbandonedMine() {
        position = "abandonedMines";
        mainTextOutput.setText(
                "An abandoned mine stood at the edge of the village, shrouded in mystery and tales of lost riches. Intrigued by the rumors, you decided to delve into the dark depths and explore the forgotten tunnels. Inside, you discovered a network of treacherous paths, echoing with distant sounds. Your heart raced as you stumbled upon a rusty chest hidden in a corner, hinting at untold treasures.");
        choice1.setText("");
        choice2.setText("");
        choice3.setText(">");
        choice4.setText("");
    }

    public static void attackBanditCamp() {
        position = "banditCamp";
        mainTextOutput.setText(
                "Driven by a desire for justice, you heard rumors of a bandit camp that plagued the nearby roads, terrorizing innocent travelers. With your sword in hand, you marched towards the camp, ready to confront the villains head-on. As you approached, you were ambushed by a gang of bandits. A fierce battle ensued, with the outcome uncertain. Victory promised riches and the gratitude of the kingdom's people, while defeat meant a shameful retreat.");
        choice1.setText("");
        choice2.setText("");
        choice3.setText("");
        choice4.setText(">");
    }

    public static void continueElderStory() {
        position = "elderContinue";
        choice1.setText("Seek Malachi's Guidance");
        choice2.setText("Uncover the Elder's Secret");
        choice3.setText("Go back");
        choice4.setText("Rest");
    }

    public static void seekMalachi() {
        position = "malachi";
        mainTextOutput.setText(
                "Following the Village Elder's advice, you set out to find the hermit named Malachi. Venturing into the dense forest, you navigate through winding trails and overgrown foliage until you stumble upon a small, secluded cabin. Inside, you find Malachi, a wise and reclusive figure. He reveals that the sacred amulet is guarded by an ancient creature residing in the Caverns of Eternal Darkness. Malachi offers you a mystical charm that can weaken the creature's defenses, advising you to make haste and face the challenge ahead.");
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public static void uncoverElderSecret() {
        position = "elderSecret";
        mainTextOutput.setText(
                "Curiosity tugs at you, and instead of seeking out Malachi, you decide to investigate the Village Elder further. Engaging in conversation, you gradually realize that the Elder has a hidden agenda. They confess their desire to obtain the sacred amulet for personal gain. Caught in a moral quandary, you must decide whether to confront the Elder and thwart their plans or play along, hoping to uncover more information about the amulet's true power.");
        choice1.setText("");
        choice2.setText(">");
        choice3.setText("");
        choice4.setText("");
    }

    public static void chooseDifferentPath() {
        position = "differentPath";
        choice1.setText("Decode the Ancient Shrine");
        choice2.setText("Listen to the Whispering Woods");
        choice3.setText("Go back");
        choice4.setText("Rest");
    }

    public static void ancientShrine() {
        position = "ancientShrine";
        mainTextOutput.setText(
                "Drawn to the mysterious shrine, you examine its intricate carvings and symbols. Channeling your inner intuition and knowledge, you decipher a hidden message, leading you to the forgotten Tomb of the Ancients. Inside the tomb, you encounter ancient guardians and perilous traps but also discover a legendary artifact rumored to grant the wielder the power to control the elements.");
        choice1.setText("");
        choice2.setText("");
        choice3.setText(">");
        choice4.setText("");
    }

    public static void listenWhisperingWoods() {
        position = "whisperingWoods";
        mainTextOutput.setText(
                "Immersing yourself in the ethereal whispers of the woods, you attune your senses to the environment. The whispers guide you deeper into the forest, revealing a hidden grove where a mythical creature dwells. It offers you a choice: prove your worth by completing a series of challenges or receive its guidance on a different quest altogether. Depending on your decision, you may gain the creature's favor, a unique ability, or valuable information about the realm's history.");
        choice1.setText("");
        choice2.setText("");
        choice3.setText(">");
        choice4.setText("");
    }

    public static void exploreAbandonedMineContinue() {
        position = "abandonedMinesCon";
        choice1.setText("Solve the Mine's Riddles");
        choice2.setText("Unleash an Ancient Evil");
        choice3.setText("Go back");
        choice4.setText("Rest");
    }

    public static void solveMinesRiddles() {
        position = "minesRiddles";
        mainTextOutput.setText(
                "As you traverse the dark tunnels of the abandoned mine, you encounter enigmatic riddles inscribed on the walls. Your sharp intellect and deduction skills are put to the test as you solve each riddle, unlocking secret chambers within the mine. Inside, you find ancient artifacts, including a legendary shield renowned for its impenetrable defense.");
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public static void unleashAncientEvil() {
        position = "ancientEvil";
        mainTextOutput.setText(
                "While exploring the mine, you accidentally awaken an ancient evil entity imprisoned within. The malevolent creature possesses immense power and seeks vengeance upon the world. To save the kingdom from its wrath, you must engage in a relentless battle, utilizing every ounce of your strength and skill. Slaying the creature would bring an end to its reign of terror and grant you a cursed weapon infused with dark magic.");
        choice1.setText("");
        choice2.setText(">");
        choice3.setText("");
        choice4.setText("");
    }

    public static void attackBanditCampContinue() {
        position = "banditCampCon";
        choice1.setText("Spare the Bandits");
        choice2.setText("Discover the Bandits' Hideout");
        choice3.setText("Go back");
        choice4.setText("Rest");
    }

    public static void spareBandits() {
        position = "spareBandits";
        mainTextOutput.setText(
                "During the intense battle against the bandits, you realize that some of them are merely desperate individuals driven to thievery out of necessity. Pity tugs at your heart, and you choose to show mercy. You convince the bandits to abandon their criminal ways, offering them an opportunity for redemption. Together, you form a band of honorable outlaws, fighting against true evil while protecting the innocent.");
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public static void banditsHideout() {
        position = "banditsHideout";
        mainTextOutput.setText(
                "Upon defeating the bandits, you search their camp for clues. Hidden beneath a pile of stolen goods, you find a torn map leading to their secret hideout. Intrigued, you follow the map's fragmented directions, ultimately discovering the bandits' hidden trove. The stolen riches, along with ancient artifacts gathered by the band");
        choice1.setText("");
        choice2.setText(">");
        choice3.setText("");
        choice4.setText("");
    }

    public static void goBack() {
        position = "goBack";
        mainTextOutput.setText("You decide to head back to look for some more adventure you might have missed.");
        choice1.setText("");
        choice2.setText("");
        choice3.setText(">");
        choice4.setText("");
    }

    public static void rest() {
        position = "rest";
        mainTextOutput.setText("Heaviness comes upon you, you decide to rest");
        choice1.setText("");
        choice2.setText("");
        choice3.setText("");
        choice4.setText(">");
    }

    public class ChoiceHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String yourChoice = e.getActionCommand();

            switch (position) {
                case "start":
                    switch (yourChoice) {
                        case "c1":
                            speakToElder();
                            continueElderStory();
                            break;
                        case "c2":
                            takeDifferentPath();
                            chooseDifferentPath();
                            break;
                        case "c3":
                            exploreAbandonedMineContinue();
                            exploreAbandonedMine();
                            break;
                        case "c4":
                            attackBanditCampContinue();
                            attackBanditCamp();
                            break;
                    }
                    break;
                case "elder":
                    switch (yourChoice) {
                        case "c1":

                            break;
                    }
                case "elderContinue":
                    switch (yourChoice) {
                        case "c1":
                            seekMalachi();
                            break;
                        case "c2":
                            uncoverElderSecret();
                            break;
                        case "c3":
                            goBack();
                            break;
                        case "c4":
                            rest();
                            break;

                    }

                case "goBack":
                    switch (yourChoice) {
                        case "c3":
                        gameStoryLine();
                            break;
            
                    }
                case "rest":
                    switch (yourChoice) {
                        case "c4":
                            rest();
                            break;
                    }

            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (openInventory == false) { // open inventory function
            if (e.getSource() == invetoryButton) {
                InventoryWindow inventoryWindow = new InventoryWindow();
            }
        } else {
        }

        if (openMusic == false) { // open music function
            if (e.getSource() == musicButton) {
                MusicWindow musicWindow = new MusicWindow();
            }
        } else {
        }

        if (openHelp == false) { // open quests function
            if (e.getSource() == helpButton) {
                HelpWindow helpButton = new HelpWindow();
            }
        } else {
        }

        if (e.getSource() == textField) { // text input functions

        }

        if (e.getSource() == textButton) { // submit button funtions
            if(textField.getText().equalsIgnoreCase("start"));
            Player();
            MainWindow.mainTextOutput.setText(
                    "Once upon a time, in the kingdom of Veridora, you, a young and courageous adventurer, set out on a quest to unravel the mysteries hidden within the realm. The kingdom was renowned for its lush forests, treacherous mountains, and the remnants of ancient civilizations. Equipped with a rusty sword and a tattered map, you embarked on your journey. As you traveled along a narrow path, you stumbled upon a bustling village, its thatched roofs and wooden huts creating a cozy ambiance. Intrigued, you decided to explore the village further and learn about its inhabitants. Four options presented themselves before you:");    
            textField.setText(" ");

        }
    }

    @Override
    public void focusGained(FocusEvent e) { // text input placeholder
        if (textField.getText().equals("insert command")) {
            textField.setText("");
            textField.setForeground(Color.BLACK);
        }
    }

    @Override
    public void focusLost(FocusEvent e) { // text input placeholder
        if (textField.getText().isEmpty()) {
            textField.setForeground(Color.GRAY);
            textField.setText("insert command");
        }
    }

}