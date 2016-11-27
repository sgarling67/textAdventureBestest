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

    private int whichPart = 0;
    String gender;
    String imageName;

    public DialogAndButtons() {
        super();
        setLayout(null);
        setSize(1416,792);

        label = new JLabel("<html><h1><center>Long long ago, in the kingdom of alba there was a king and queen that lived in a castle.</center></h1></html>");
        label.setBounds(170, 30, 1300, 30);

        button = new JButton("Next");
        button.setBounds(100, 130, 100, 30);
        button.addActionListener(this);

        button1 = new JButton();
        button1.setBounds(300, 130, 125, 30);
        button1.addActionListener(this);

        imageName = outputPicture.getImage("title");

        mBackground = new ImageIcon(imageName);
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
            case 0:
                if(e.getSource() == button){
                    label.setText("<html><h1><center>They loved having friends and doing things everyone around the kingdom.</center></h1></html>");
                    whichPart = 1;
                }
                break;

            case 1:
                if(e.getSource() == button){
                    label.setText("<html><h1><center>They were especially loved by all of the knights and all of the faes.</center></h1></html>");
                    whichPart = 2;
                }
                break;

            case 2:
                if(e.getSource() == button){
                    label.setText("<html><h1><center>But as you could imagine, they were very different from one another.</center></h1></html>");
                    whichPart = 3;
                }
                break;

            case 3:
                if(e.getSource() == button){
                    label.setText("<html><h1><center>Welcome, are you a male or a female?</center></h1></html>");
                    button.setText("Male");
                    add(button1);
                    button1.setText("Female");
                    whichPart = 4;
                }
                break;

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

            case 5:

                break;

            case 6:
                if(e.getSource() == button){
                    label.setText("<html><h1><center>As you wonder where you are at you notice a fae approaching you.</center></h1></html>");
                    whichPart = 7;
                }
                break;

            case 7:
                if(e.getSource() == button){
                    label.setText("<html><h1><center>FAE: That tree is dying. I'm on my way to the Magical Pond of Healing to save it.</center></h1></html>");
                    whichPart = 8;
                }
                break;

            case 8:
                label.setText("<html><h1><center>FAE: Will you join me on my quest?</center></h1></html>");
                button1.setVisible(true);
                button1.setText("No");
                button.setText("Yes");
                whichPart = 9;
                break;

            case 9:
                if(e.getSource() == button1){
                    button.setVisible(false);
                    button1.setVisible(false);
                    label.setText("<html><h1><center>Game Over!</center></h1></html>");
                    imageName = outputPicture.getImage("game over");
                    mBackground = new ImageIcon(imageName);
                    update();
                    resizeBackground();
                }
                if(e.getSource() ==button){
                    button1.setVisible(false);
                    label.setText("<html><h1><center>FAE: Thank you so much. That is really kind of you!</center></h1></html>");
                    button.setText("Next");
                    whichPart = 10;
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
                    whichPart = 13;
                }
                break;

            case 13:
                if (e.getSource() == button){
                    label.setText("<html><h1><center>FAE: I'm so lucky to have ran into you!</center></h1></html>");
                    button1.setVisible(false);
                    button.setText("Next");
                    whichPart = 14;
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
                    whichPart = 16;
                    button.setText("Collect the water.");
                    button.setBounds(100, 130, 150, 30);
                    button1.setVisible(true);
                    button1.setText("Leave.");
                }
                break;

            case 15:
                if(e.getSource() == button){
                    label.setText("<html><h1><center>Hi this is the knights part</center></h1></html>");
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
            case 16:
                if(e.getSource() == button){
                    label.setText("<html><h1><center>You collect the water in a bottle provided by the fae.</center></h1></html>");
                    button1.setVisible(false);
                    button.setBounds(100, 130, 100, 30);
                    button.setText("Next");
                    // whichPart = #;
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
        }
    }
}