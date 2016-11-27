package csu.csci325;

/**
 * Created by Carla Nayeli on 11/26/2016.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DialogAndButtons extends JPanel implements ActionListener{

    JLabel label;
    JButton button;
    JButton button1;

    ImageIcon mBackground;

    // Changed the order after a lot was coded in, so had to make the number 22 and not 0
    private int whichPart = 22;
    String gender;
    String imageName;

    public DialogAndButtons() {
        super();
        setLayout(null);
        setSize(1416,792);

        label = new JLabel();

        button = new JButton("Next");
        button.setBounds(100, 130, 100, 30);
        button.addActionListener(this);

        button1 = new JButton();
        button1.setBounds(300, 130, 100, 30);
        button1.addActionListener(this);

        imageName = outputPicture.getImage("title");
        mBackground = new ImageIcon(imageName);
        update();
        resizeBackground();

        add(label);
        add(button);
    }

    private void resizeBackground() {
        if (getWidth() != 0 && getHeight() != 0) {
            mBackground = new ImageIcon(imageName);
            mBackground.setImage(mBackground.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT));
        }
    }

    public void paintComponent(Graphics page) {
        super.paintComponent(page);
        mBackground.paintIcon(this, page, 0, 0);
        if (getWidth() != mBackground.getIconWidth()) {
            resizeBackground();
        }
    }

    public void update() {
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        switch(whichPart) {
            // Beginning part related to both paths available
            case 0:
                if(e.getSource() == button){
                    label.setText("<html><h1><center>They loved having friends over and doing things with all their subjects around the kingdom.</center></h1></html>");
                    whichPart = 1;
                }
                break;

            case 1:
                if(e.getSource() == button){
                    label.setText("<html><h1><center>They were especially loved by all of the knights and fae.</center></h1></html>");
                    whichPart = 2;
                }
                break;

            case 2:
                if(e.getSource() == button){
                    label.setText("<html><h1><center>But as you could imagine, it wasn't always happy days in the kingdom.</center></h1></html>");
                    whichPart = 3;
                }
                break;

            // Selecting your gender
            case 3:
                if(e.getSource() == button){
                    label.setText("<html><h1><center>Welcome, are you a male or a female?</center></h1></html>");
                    button.setText("Male");
                    add(button1);
                    button1.setText("Female");
                    whichPart = 4;
                }
                break;

            // Selecting the quest to partake in
            case 4:
                if(e.getSource() == button){
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

                if(e.getSource() == button1){
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

            // First piece of Dragon quest
            case 5:
                if(e.getSource() == button){
                    label.setText("<html><h1><center>They request your services to rid the kingdom of this terrible menace. Will you accept?</center></h1></html>");
                    button1.setVisible(true);
                    button.setText("Yes");
                    button1.setText("No");
                    whichPart = 23;
                }
                break;

            // Fae dialogue below
            case 6:
                if(e.getSource() == button){
                    label.setText("<html><h1><center>As you wonder where you are at you notice a fae approaching you.</center></h1></html>");
                    whichPart = 7;
                }
                break;

            case 7:
                if(e.getSource() == button){
                    label.setText("<html><h1><center>FAE: The Magical Tree of Life tree is dying. I'm on my way to the Pond of Healing to save it.</center></h1></html>");
                    whichPart = 8;
                }
                break;

            case 8:
                label.setText("<html><h1><center>FAE: Will you join me on my quest?</center></h1></html>");
                button.setText("Yes");
                button1.setVisible(true);
                button1.setText("No");
                whichPart = 9;
                break;

            case 9:
                if(e.getSource() ==button){
                    button1.setVisible(false);
                    label.setText("<html><h1><center>FAE: Thank you so much. That is really kind of you!</center></h1></html>");
                    button.setText("Next");
                    whichPart = 10;
                }
                if(e.getSource() == button1){
                button.setVisible(false);
                button1.setVisible(false);
                label.setText("<html><h1><center>Game Over!</center></h1></html>");
                imageName = outputPicture.getImage("game over");
                mBackground = new ImageIcon(imageName);
                update();
                resizeBackground();
            }
                break;

            case 10:
                if(e.getSource() == button){
                    label.setText("<html><h1><center>FAE: I don't like adventures alone. The cave containing the pond isn't far from here.</center></h1></html>");
                    whichPart = 11;
                }
                break;

            case 11:
                if (e.getSource() == button){
                    label.setText("<html><h1><center>As you and the fae continue your quest, you notice you're approaching a dark cave.</center></h1></html>");
                    whichPart = 12;
                }
                break;

            case 12:
                if (e.getSource() == button){
                    label.setText("<html><h1><center>FAE: Wow it's looking really scary. Are you sure you want to go in?</center></h1></html>");
                    button.setText("Of course");
                    button1.setVisible(true);
                    button1.setText("HECK NO!!!");
                    whichPart = 14;
                }
                break;

            case 13:
                if (e.getSource() == button){
                    label.setText("<html><h1><center>FAE: I'm so lucky to have ran into you!</center></h1></html>");
                    button1.setVisible(false);
                    button.setText("Next");
                    whichPart = 16;
                    imageName = outputPicture.getImage("cave with fae");
                    mBackground = new ImageIcon(imageName);
                    update();
                    resizeBackground();
                }
                if (e.getSource() ==button1){
                    button.setVisible(false);
                    button1.setVisible(false);
                    label.setText("<html><h1><center>Game Over!</center></h1></html>");
                    imageName = outputPicture.getImage("game over");
                    mBackground = new ImageIcon(imageName);
                    update();
                    resizeBackground();
                }
                break;

            case 14:
                if (e.getSource() == button){
                    label.setText("<html><h1><center>You observe your surroundings and see the water. What will you do?</center></h1></html>");
                    button.setText("");
                    whichPart = 13;
                    button.setText("Collect the water.");
                    button.setBounds(100, 130, 150, 30);
                    button1.setVisible(true);
                    button1.setText("Leave.");
                    imageName = outputPicture.getImage("crystal cave");
                    mBackground = new ImageIcon(imageName);
                    update();
                    resizeBackground();
                }
                if (e.getSource() == button1){
                    button.setVisible(false);
                    button1.setVisible(false);
                    label.setText("<html><h1><center>Game Over!</center></h1></html>");
                    imageName = outputPicture.getImage("game over");
                    mBackground = new ImageIcon(imageName);
                    update();
                    resizeBackground();
                }
                break;

            // Splits the dialog into their two pieces now
            case 15:
                if(e.getSource() == button){
                    label.setText("<html><h1><center>You just received notice from the king and queen of a dragon that has been ransacking the edge of the surrounding villages.</center></h1></html>");
                    button1.setVisible(false);
                    button.setText("Next");
                    whichPart = 5;
                } else if(e.getSource() == button1){
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

            // Fae dialogue
            case 16:
                if(e.getSource() == button){
                    label.setText("<html><h1><center>You collect the water in a bottle provided by the fae.</center></h1></html>");
                    button1.setVisible(false);
                    button.setBounds(100, 130, 100, 30);
                    button.setText("Next");
                    whichPart = 17;
                } else if(e.getSource() == button1){
                    label.setText("<html><h1><center>Game over!</center></h1></html>");
                    button1.setVisible(false);
                    button.setVisible(false);
                    imageName = outputPicture.getImage("game over");
                    mBackground = new ImageIcon(imageName);
                    update();
                    resizeBackground();
                }
                break;

            case 17:
                if(e.getSource() == button){
                    label.setText("<html><h1><center>FAE: We should head back to the tree. I worry we may not make it back in time.</center></h1></html>");
                    button.setText("Let's go!");
                    button1.setVisible(true);
                    button1.setText("Oh well.");
                    whichPart = 18;
                }
                break;

            case 18:
                if(e.getSource() == button){
                    label.setText("<html><h1><center>You and the fae head back to the tree.</center></h1></html>");
                    button1.setVisible(false);
                    button.setText("Next");
                    whichPart = 19;
                } else if(e.getSource() == button1){
                    label.setText("<html><h1><center>Game over!</center></h1></html>");
                    button1.setVisible(false);
                    button.setVisible(false);
                    imageName = outputPicture.getImage("game over");
                    mBackground = new ImageIcon(imageName);
                    update();
                    resizeBackground();
                }
                break;

            case 19:
                if(e.getSource() == button){
                    label.setText("<html><h1><center>FAE: Oh no! Its condition has worsened. Quickly Knight, the water!</center></h1></html>");
                    button.setBounds(100, 130, 150, 30);
                    button.setText("Water the tree.");
                    button1.setVisible(true);
                    button1.setBounds(300, 130, 175, 30);
                    button1.setText("Drink the water instead.");
                    whichPart = 20;
                    imageName = outputPicture.getImage("dying tree scene");
                    mBackground = new ImageIcon(imageName);
                    update();
                    resizeBackground();
                }
                break;

            case 20:
                if(e.getSource() == button){
                    label.setText("<html><h1><center>FAE: Thank you, brave Knight, for all that you have done! You saved the tree!</center></h1></html>");
                    button1.setVisible(false);
                    button.setText("Next");
                    whichPart = 21;
                    imageName = outputPicture.getImage("healthy tree scene");
                    mBackground = new ImageIcon(imageName);
                    update();
                    resizeBackground();
                } else if(e.getSource() == button1){
                    label.setText("<html><h1><center>Your selfishness caused the tree to die. Game over!</center></h1></html>");
                    button1.setVisible(false);
                    button.setVisible(false);
                }
                break;

            case 21:
                if(e.getSource() == button){
                    label.setText("<html><h1><center>You won! You saved the Magical Tree! Congratulations!</center></h1></html>");
                    button.setVisible(false);
                }
                break;

            // Beginning after first button click... was added after the above code, which is why it is all the way down here
            case 22:
                if(e.getSource() == button){
                    label.setText("<html><h1><center>Long long ago, in the kingdom of alba there was a king and queen that lived in a castle.</center></h1></html>");
                    label.setBounds(170, 30, 1300, 30);
                    whichPart = 0;
                    imageName = outputPicture.getImage("castle beginning");
                    mBackground = new ImageIcon(imageName);
                    update();
                    resizeBackground();
                }
                break;

            // More of the knight code
            case 23:
                if(e.getSource() ==button){
                    button1.setVisible(false);
                    label.setText("<html><h1><center>You are informed of the location of the dragon's cave in the nearby mountains. You set out immediately.</center></h1></html>");
                    button.setText("Next");
                    whichPart = 24;
                }
                if(e.getSource() == button1) {
                    button.setVisible(false);
                    button1.setVisible(false);
                    label.setText("<html><h1><center>Game Over!</center></h1></html>");
                    imageName = outputPicture.getImage("game over");
                    mBackground = new ImageIcon(imageName);
                    update();
                    resizeBackground();
                }
                break;

            case 24:
                if(e.getSource() ==button){
                    label.setText("<html><h1><center>After a few hours wandering the woods, you managed to find the cave. You walk towards the cave entrance.</center></h1></html>");
                    whichPart = 25;
                }
                break;

            case 25:
                if(e.getSource() ==button){
                    label.setText("<html><h1><center>You look into the cave and see a bright glow coming from around a corner. You walk right up to the corner and listen. You hear deep breathing and get a strange feeling in your gut.</center></h1></html>");
                    whichPart = 26;
                }
                break;
        }
    }
}