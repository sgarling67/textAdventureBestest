package csu.csci325;

/**
 * Created by Carla Nayeli on 11/26/2016.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DialogAndButtons extends JPanel implements ActionListener {

    JLabel label;
    JLabel secondLineLabel;
    JLabel rectangularBackground;
    JButton button;
    JButton button1;
    JButton button2;

    ImageIcon mBackground;

    // Changed the order after a lot was coded in, so had to make the number 22 and not 0
    private int whichPart = 22;
    String gender;
    String imageName;

    public DialogAndButtons() {
        super();
        setLayout(null);
        setSize(1416, 792);

        // Creates the labels to hold the text
        label = new JLabel();
        label.setFont(new Font("Trattatello", Font.PLAIN, 50));
        secondLineLabel = new JLabel();
        secondLineLabel.setFont(new Font("Trattatello", Font.PLAIN, 50));
        rectangularBackground = new JLabel();
        rectangularBackground.setOpaque(true);
        rectangularBackground.setBackground(Color.WHITE);
        rectangularBackground.setBounds(150, 650, 916, 100);
        rectangularBackground.setVisible(false);
        label.setBounds(170, 665, 1000, 30);
        label.setForeground(Color.BLACK);
        secondLineLabel.setForeground(Color.BLACK);

        // Creates the first button
        button = new JButton("Next");
        button.setBounds(1100, 660, 100, 30);
        button.addActionListener(this);

        // Creates the second button
        button1 = new JButton();
        button1.setBounds(1100, 690, 100, 30);
        button1.addActionListener(this);

        // Creates the third button
        button2 = new JButton();
        button2.setBounds(1100, 720, 200, 30);
        button2.addActionListener(this);

        // Creates the background picture and gets the file
        imageName = outputPicture.getImage("title");
        mBackground = new ImageIcon(imageName);
        update();
        resizeBackground();

        // Adds the labels and the first button to the program
        add(label);
        add(secondLineLabel);
        add(button);
        add(rectangularBackground);
    }

    // Changes the background sizing whenever a new picture is used
    private void resizeBackground() {
        if (getWidth() != 0 && getHeight() != 0) {
            mBackground = new ImageIcon(imageName);
            mBackground.setImage(mBackground.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT));
        }
    }

    // Paints the picture on the GUI
    public void paintComponent(Graphics page) {
        super.paintComponent(page);
        mBackground.paintIcon(this, page, 0, 0);
        if (getWidth() != mBackground.getIconWidth()) {
            resizeBackground();
        }
    }

    // Updates the GUI
    public void update() {
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (whichPart) {
            // First screen to appear is actually related to case 22
            // Beginning dialogue related to both paths available
            case 0:
                if (e.getSource() == button) {
                    label.setText("<html><h1><center>They loved having friends over and doing things with all their subjects around the kingdom.</center></h1></html>");
                    whichPart = 1;
                }
                break;

            case 1:
                if (e.getSource() == button) {
                    label.setText("<html><h1><center>They were especially loved by all of the knights and fae.</center></h1></html>");
                    whichPart = 2;
                }
                break;

            case 2:
                if (e.getSource() == button) {
                    label.setText("<html><h1><center>But as you could imagine, it wasn't always happy days in the kingdom.</center></h1></html>");
                    whichPart = 3;
                }
                break;

            // Selecting your gender
            case 3:
                if (e.getSource() == button) {
                    label.setText("<html><h1><center>Welcome, are you a male or a female?</center></h1></html>");
                    button.setText("Male");
                    add(button1);
                    button1.setText("Female");
                    whichPart = 4;
                }
                break;

            // Selecting the quest to partake in
            case 4:
                if (e.getSource() == button) {
                    gender = "male";
                    label.setText("<html><h1><center>Do you want the Dragon Quest or the Fae Quest?</center></h1></html>");
                    button.setText("Dragon");
                    button1.setText("Fae");
                    whichPart = 15;
                    imageName = outputPicture.getImage("knight scene one male");
                    mBackground = new ImageIcon(imageName);
                    update();
                    resizeBackground();
                }

                if (e.getSource() == button1) {
                    gender = "female";
                    label.setText("<html><h1><center>Do you want the Dragon Quest or the Fae Quest?</center></h1></html>");
                    button.setText("Dragon");
                    button1.setText("Fae");
                    whichPart = 15;
                    imageName = outputPicture.getImage("knight scene one female");
                    mBackground = new ImageIcon(imageName);
                    update();
                    resizeBackground();
                }
                break;

            // User can accept or decline dragon quest
            case 5:
                if (e.getSource() == button) {
                    label.setText("<html><h1><center>They request your services to rid the kingdom of this terrible menace. Will you accept?</center></h1></html>");
                    secondLineLabel.setText("");
                    button1.setVisible(true);
                    button.setText("Yes");
                    button1.setText("No");
                    whichPart = 23;
                }
                break;

            // More of fae dialogue
            case 6:
                if (e.getSource() == button) {
                    label.setText("<html><h1><center>As you wonder where you are at, you notice a fae approaching you.</center></h1></html>");
                    whichPart = 7;
                }
                break;

            case 7:
                if (e.getSource() == button) {
                    label.setText("<html><h1><center>FAE: The Magical Tree of Life is dying. I'm on my way to the Pond of Healing to save it.</center></h1></html>");
                    whichPart = 8;
                }
                break;

            // User can accept or deny the Fae's quest
            case 8:
                label.setText("<html><h1><center>FAE: Will you join me on my quest?</center></h1></html>");
                button.setText("Yes");
                button1.setVisible(true);
                button1.setText("No");
                whichPart = 9;
                break;

            // Fae dialogue continues...
            case 9:
                if (e.getSource() == button) {
                    button1.setVisible(false);
                    label.setText("<html><h1><center>FAE: Thank you so much. That is really kind of you!</center></h1></html>");
                    button.setText("Next");
                    whichPart = 10;
                }
                // If you decline to accept the quest, GAME OVER
                if (e.getSource() == button1) {
                    button.setVisible(false);
                    button1.setVisible(false);
                    label.setVisible(false);
                    rectangularBackground.setVisible(false);
                    imageName = outputPicture.getImage("game over");
                    mBackground = new ImageIcon(imageName);
                    update();
                    resizeBackground();
                }
                break;

            // The fae dialogue continues...
            case 10:
                if (e.getSource() == button) {
                    label.setText("<html><h1><center>FAE: I don't like adventures alone. Oh, and the pond isn't much further from here.</center></h1></html>");
                    whichPart = 11;
                }
                break;

            case 11:
                if (e.getSource() == button) {
                    label.setText("<html><h1><center>As you and the fae continue your quest, you notice you're approaching a dark cave.</center></h1></html>");
                    whichPart = 12;
                }
                break;

            // User can decide to enter the cave or not, jumps to case 14
            case 12:
                if (e.getSource() == button) {
                    label.setText("<html><h1><center>FAE: Wow, it's looking really scary. The pond is located inside. Are you sure you want to go in?</center></h1></html>");
                    button.setText("Of course");
                    button1.setVisible(true);
                    button1.setText("HECK NO!!!");
                    whichPart = 14;
                }
                break;

            case 13:
                // If you go in, this continues the dialogue and goes to case 16
                if (e.getSource() == button) {
                    label.setText("<html><h1><center>FAE: I'm so lucky to have ran into you!</center></h1></html>");
                    button1.setVisible(false);
                    button.setText("Next");
                    whichPart = 16;
                    imageName = outputPicture.getImage("cave with fae");
                    mBackground = new ImageIcon(imageName);
                    update();
                    resizeBackground();
                }
                // If you don't go in, GAME OVER
                if (e.getSource() == button1) {
                    button.setVisible(false);
                    button1.setVisible(false);
                    label.setVisible(false);
                    rectangularBackground.setVisible(false);
                    imageName = outputPicture.getImage("game over");
                    mBackground = new ImageIcon(imageName);
                    update();
                    resizeBackground();
                }
                break;

            // User can decide whether or not to collect the water, if user does, goes back to case 13
            case 14:
                if (e.getSource() == button) {
                    label.setText("<html><h1><center>You observe your surroundings and see the water. What will you do?</center></h1></html>");
                    button.setText("");
                    whichPart = 13;
                    button.setText("Collect the water.");
                    button.setBounds(1100, 660, 150, 30);
                    button1.setVisible(true);
                    button1.setText("Leave.");
                    imageName = outputPicture.getImage("crystal cave");
                    mBackground = new ImageIcon(imageName);
                    update();
                    resizeBackground();
                }
                if (e.getSource() == button1) {
                    button.setVisible(false);
                    button1.setVisible(false);
                    label.setVisible(false);
                    rectangularBackground.setVisible(false);
                    imageName = outputPicture.getImage("game over");
                    mBackground = new ImageIcon(imageName);
                    update();
                    resizeBackground();
                }
                break;

            // Splits the dialogue into their two pieces now, the fae or the dragon, goes to cases 5 or 6
            case 15:
                label.setBounds(170, 665, 1300, 30);
                button.setBounds(1100, 660, 100, 30);
                button1.setBounds(1100, 690, 100, 30);
                if (e.getSource() == button) {
                    label.setText("<html><h1><center>You just received notice from the king and queen of a dragon that has been ransacking</center></h1></html>");
                    secondLineLabel.setBounds(170, 695, 1300, 30);
                    secondLineLabel.setText("<html><h1><center>the edges of the surrounding villages.</center></h1></html>");
                    button1.setVisible(false);
                    button.setText("Next");
                    whichPart = 5;
                } else if (e.getSource() == button1) {
                    label.setText("<html><h1><center>You're in a very unfamiliar forest and notice that there is a large dying tree.</center></h1></html>");
                    button1.setVisible(false);
                    button.setText("Next");
                    whichPart = 6;
                    imageName = outputPicture.getImage("dying tree scene");
                    mBackground = new ImageIcon(imageName);
                    update();
                    resizeBackground();
                }
                break;

            // Fae dialogue continues with collecting the water from case 13
            case 16:
                if (e.getSource() == button) {
                    label.setText("<html><h1><center>You collect the water in a bottle provided by the fae.</center></h1></html>");
                    button1.setVisible(false);
                    button.setBounds(1100, 660, 100, 30);
                    button.setText("Next");
                    whichPart = 17;
                } else if (e.getSource() == button1) {
                    label.setVisible(false);
                    button1.setVisible(false);
                    button.setVisible(false);
                    rectangularBackground.setVisible(false);
                    imageName = outputPicture.getImage("game over");
                    mBackground = new ImageIcon(imageName);
                    update();
                    resizeBackground();
                }
                break;

            // After you collect the water, fae dialogue continues...
            case 17:
                if (e.getSource() == button) {
                    label.setText("<html><h1><center>FAE: We should head back to the tree. I worry we may not make it back in time.</center></h1></html>");
                    button.setText("Let's go!");
                    button1.setVisible(true);
                    button1.setText("Oh well.");
                    whichPart = 18;
                }
                break;

            // User can decide whether or not to bring back the water to the tree.
            case 18:
                if (e.getSource() == button) {
                    label.setText("<html><h1><center>You and the fae head back to the tree.</center></h1></html>");
                    button1.setVisible(false);
                    button.setText("Next");
                    whichPart = 19;
                } else if (e.getSource() == button1) {
                    label.setVisible(false);
                    button1.setVisible(false);
                    button.setVisible(false);
                    rectangularBackground.setVisible(false);
                    imageName = outputPicture.getImage("game over");
                    mBackground = new ImageIcon(imageName);
                    update();
                    resizeBackground();
                }
                break;

            // The tree has worsened, user gets the option to water the tree or drink it him/herself
            case 19:
                if (e.getSource() == button) {
                    label.setText("<html><h1><center>FAE: Oh no! Its condition has worsened. Quickly Knight, the water!</center></h1></html>");
                    button.setBounds(1100, 660, 150, 30);
                    button.setText("Water the tree.");
                    button1.setVisible(true);
                    button1.setBounds(1100, 690, 175, 30);
                    button1.setText("Drink the water instead.");
                    whichPart = 20;
                    imageName = outputPicture.getImage("dying tree scene");
                    mBackground = new ImageIcon(imageName);
                    update();
                    resizeBackground();
                }
                break;

            case 20:
                // User wins if they decide to water the tree
                if (e.getSource() == button) {
                    label.setText("<html><h1><center>FAE: Thank you, brave Knight, for all that you have done! You saved the tree!</center></h1></html>");
                    button1.setVisible(false);
                    button.setText("Next");
                    whichPart = 21;
                    imageName = outputPicture.getImage("healthy tree scene");
                    mBackground = new ImageIcon(imageName);
                    update();
                    resizeBackground();
                }
                // If user decides to drink the water, GAME OVER
                else if (e.getSource() == button1) {
                    label.setText("<html><h1><center>Your selfishness caused the tree to die. You lose!</center></h1></html>");
                    button1.setVisible(false);
                    button.setVisible(false);
                }
                break;

            // Scene that appears when the user waters the tree
            case 21:
                if (e.getSource() == button) {
                    label.setText("<html><h1><center>You won! You saved the Magical Tree! Congratulations!</center></h1></html>");
                    button.setVisible(false);
                }
                break;

            // Beginning after first button click... was added after the above code, which is why it is all the way down here
            case 22:
                if (e.getSource() == button) {
                    rectangularBackground.setVisible(true);
                    label.setText("<html><h1><center>Long long ago, in the kingdom of Alba, there was a king and queen that lived in a castle.</center></h1></html>");
                    whichPart = 0;
                    imageName = outputPicture.getImage("castle beginning");
                    mBackground = new ImageIcon(imageName);
                    update();
                    resizeBackground();
                }
                break;

            case 23:
                // After accepting the dragon quest, the dialogue continues here...
                if (e.getSource() == button) {
                    button1.setVisible(false);
                    label.setText("<html><h1><center>You are informed of the location of the dragon's cave in the nearby mountains.</center></h1></html>");
                    secondLineLabel.setText("<html><h1><center>You set out immediately.</center></h1></html>");
                    button.setText("Next");
                    whichPart = 24;
                }
                // If he/she declines the quest, GAME OVER
                if (e.getSource() == button1) {
                    button.setVisible(false);
                    button1.setVisible(false);
                    label.setVisible(false);
                    rectangularBackground.setVisible(false);
                    imageName = outputPicture.getImage("game over");
                    mBackground = new ImageIcon(imageName);
                    update();
                    resizeBackground();
                }
                break;

            // Dragon quest dialogue continues...
            case 24:
                if (e.getSource() == button) {
                    label.setText("<html><h1><center>After a few hours wandering the woods, you managed to find the cave. You look into the cave</center></h1></html>");
                    secondLineLabel.setText("<html><h1><center>and see a bright glow coming from around a corner.</center></h1></html>");
                    whichPart = 25;
                }
                break;

            case 25:
                if (e.getSource() == button) {
                    label.setText("<html><h1><center>You walk right up to the corner and listen. You hear deep breathing and get a strange feeling</center></h1></html>");
                    secondLineLabel.setText("<html><h1><center>in your gut.</center></h1></html>");
                    whichPart = 26;
                }
                break;

            case 26:
                if (e.getSource() == button) {
                    button1.setVisible(true);
                    label.setText("<html><h1><center>Do you wish to enter the cave?</center></h1></html>");
                    secondLineLabel.setText("");
                    button.setBounds(1100, 660, 200, 30);
                    button.setText("I am a knight of my word.");
                    button1.setText("HECK NO!!!");
                    whichPart = 27;
                }
                break;

            case 27:
                // If the user decides to enter the cave, dialogue continues here...
                if (e.getSource() == button) {
                    button1.setVisible(false);
                    label.setText("<html><h1><center>Everything appears to be normal...</center></h1></html>");
                    button.setBounds(1100, 660, 100, 30);
                    button.setText("Next");
                    whichPart = 28;
                    imageName = outputPicture.getImage("crystal cave");
                    mBackground = new ImageIcon(imageName);
                    update();
                    resizeBackground();
                }
                // If user doesn't, GAME OVER
                if (e.getSource() == button1) {
                    button.setVisible(false);
                    button1.setVisible(false);
                    label.setVisible(false);
                    rectangularBackground.setVisible(false);
                    imageName = outputPicture.getImage("game over");
                    mBackground = new ImageIcon(imageName);
                    update();
                    resizeBackground();
                }
                break;

            // When the user selected their gender, a string stored it so that I could have the dialogue split
            // accordingly and show the proper gender knight in the dragon cave scene
            case 28:
                if (gender.equals("female")) {
                    whichPart = 34;
                } else if (gender.equals("male")) {
                    whichPart = 35;
                }
                break;

            // User can decide to fight the dragon, run away, or join him/her
            case 29:
                if (e.getSource() == button) {
                    button1.setVisible(true);
                    add(button2);
                    button2.setVisible(true);
                    label.setText("<html><h1><center>What will you do, Knight? Fight, run, or work with the dragon?</center></h1></html>");
                    button.setText("Fight!");
                    button1.setText("RUN!");
                    button2.setText("Work with the dragon.");
                    whichPart = 30;
                }
                break;

            case 30:
                // If user fights, he/she wins
                if (e.getSource() == button) {
                    button1.setVisible(false);
                    button2.setVisible(false);
                    label.setText("<html><h1><center>After a bit, you successfully killed the dragon!</center></h1></html>");
                    button.setText("Next");
                    if (gender.equals("male")) {
                        whichPart = 32;
                    } else if (gender.equals("female")) {
                        whichPart = 36;
                    }
                }

                // If user runs away, continues into case 31
                if (e.getSource() == button1) {
                    button1.setVisible(false);
                    button2.setVisible(false);
                    label.setText("<html><h1><center>You run away and knowing you can't go back to the kingdom, you make a home in the woods.</center></h1></html>");
                    button.setText("Next");
                    whichPart = 31;
                }

                // If user decides to join dragon, they burn the village
                if (e.getSource() == button2) {
                    button1.setVisible(false);
                    button2.setVisible(false);
                    label.setText("<html><h1><center>You have changed sides and joined with the dragon. You both go and burn the village...</center></h1></html>");
                    button.setText("Next");
                    whichPart = 33;
                }
                break;

            // GAME OVER
            case 31:
                if (e.getSource() == button) {
                    button.setVisible(false);
                    label.setVisible(false);
                    rectangularBackground.setVisible(false);
                    imageName = outputPicture.getImage("game over");
                    mBackground = new ImageIcon(imageName);
                    update();
                    resizeBackground();
                }
                break;

            // Male user fought dragon, male user WINS
            case 32:
                if (e.getSource() == button) {
                    label.setText("<html><h1><center>You come back to the kingdom a hero! Congratulations!</center></h1></html>");
                    button.setVisible(false);
                    imageName = outputPicture.getImage("knight scene one male");
                    mBackground = new ImageIcon(imageName);
                    update();
                    resizeBackground();
                }
                break;

            // User joins dragon, GAME OVER
            case 33:
                if (e.getSource() == button) {
                    label.setText("");
                    button.setVisible(false);
                    rectangularBackground.setVisible(false);
                    imageName = outputPicture.getImage("burning village end");
                    mBackground = new ImageIcon(imageName);
                    update();
                    resizeBackground();
                }
                break;

            // So if the user gender is female, this outputs the female knight/dragon picture
            case 34:
                if (e.getSource() == button) {
                    label.setText("<html><h1><center>A ferocious roar pierced the silence, and the dragon appeared.</center></h1></html>");
                    button.setText("Next");
                    whichPart = 29;
                    imageName = outputPicture.getImage("knight cave scene female");
                    mBackground = new ImageIcon(imageName);
                    update();
                    resizeBackground();
                }
                break;

            // So if the user gender is male, this outputs the male knight/dragon picture
            case 35:
                if (e.getSource() == button) {
                    label.setText("<html><h1><center>A ferocious roar pierced the silence, and the dragon appeared.</center></h1></html>");
                    button.setText("Next");
                    whichPart = 29;
                    imageName = outputPicture.getImage("knight cave scene male");
                    mBackground = new ImageIcon(imageName);
                    update();
                    resizeBackground();
                }
                break;

            // Female user fought dragon, female user WINS
            case 36:
                label.setText("<html><h1><center>You come back to the kingdom a hero! Congratulations!</center></h1></html>");
                button.setVisible(false);
                imageName = outputPicture.getImage("knight scene one female");
                mBackground = new ImageIcon(imageName);
                update();
                resizeBackground();
                break;
        }
    }
}