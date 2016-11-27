/**
 * Created by Carla Nayeli on 11/26/2016.
 */

//OKAY GUYS SO THIS IS BASICALLY WHAT I HAVE , I SPLIT EVERYTHING UP BY PARTS THAT WAY MAKING THE BUTTONS APPEAR AND DISAPPEAR
//WOULD BE EASIER. I HOPE YOU GUYS UNDERSTAND MY LOGIC. IF YOU HAVE ANY QUESTIONS JUST LET ME KNOW. YOU WILL NEED TO CHANGE
//THE SETBOUNDS AND THE SIZE FOR MOST THINGS BUT THAT WILL ALL DEPEND ON WHENEVER YOU ADD THE PICTURES AND STUFF.
//I DIDN'T FINISH THE FAE'S DIALOG BUT I WAS MAKING IT UP AS I WENT SO THAT WON'T BE DIFFICULT.
//ALSO, THE FAES PART IS FROM 6-15, BUT WILL NEED MORE AND THE KNIGHTS PART IS PART 5 AND WHEN YOU START MAKING MORE PARTS
//USE NUMBERS THAT WE HAVEN'T USED AND DO IT IN ACENDING ORDER. 


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TextAdventure extends JFrame implements ActionListener{

    JLabel label;
    JButton button;
    JButton button1;
    JButton button2;

    private int whichPart = 0;

    public TextAdventure(){
        setLayout(null);
        setSize(1416,792);
        setTitle("Text Adventure");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setResizable(false);

        label = new JLabel("Long long ago, in the kingdom of alba there was a king and queen that lived in a castle.");
        label.setBounds(170, 30, 1300, 30);

        button = new JButton("NEXT");
        button.setBounds(100, 130, 100, 30);
        button.addActionListener(this);

        button1 = new JButton();
        button1.setBounds(300, 130, 125, 30);
        button1.addActionListener(this);

        add(label);
        add(button);
    }

    public void actionPerformed(ActionEvent e){
        if(whichPart == 0){
            if(e.getSource() == button){
                label.setText("They loved having friends and doing things everyone around the kingdom.");
                whichPart = 1;
            }
        }
        else if (whichPart == 1){
            if(e.getSource() == button){
                label.setText("They were especially loved by all of the knights and all of the faes.");
                whichPart = 2;
            }
        }
        else if (whichPart ==2){
            if(e.getSource() == button){
                label.setText("But as you could imagine, they were very different from one another.");
                whichPart = 3;
            }
        }
        else if (whichPart == 3){
            if(e.getSource() ==button){
                label.setText("Welcome, are you a boy or a girl?");
                button.setText("BOY");
                add(button1);
                button1.setText("GIRL");
                whichPart = 4;
            }
        }
        else if (whichPart == 4){
            if(e.getSource() == button){
                label.setText("Are you a knight or a fae?");
                button.setText("KNIGHT");
                button1.setText("FAE");
                if(e.getSource()==button){
                    whichPart = 5;
                } else if(e.getSource() == button1){
                    whichPart = 6;
                }
            }
            if(e.getSource() == button1){
                label.setText("Are you a knight or a fae?");
                button.setText("KNIGHT");
                button1.setText("FAE");
                if(e.getSource()==button){
                    whichPart = 5;
                    button1.setVisible(false);
                    button.setText("NEXT");
                } else if(e.getSource() == button1){
                    whichPart = 6;
                    button.setText("Next");
                }
            }
        }






        //KNIGHT PART COMES IN
        else if (whichPart == 5){
            label.setText("Hi this is the knights part");
            button1.setVisible(false);
            button.setText("NEXT");
        }




        else if (whichPart == 6){
            label.setText("You're a fae in a very unfamiliar forest and notice that there is a large dying tree.");
            button1.setVisible(false);
            button.setText("NEXT");
            whichPart = 7;
        }
        else if (whichPart == 7){
            if(e.getSource() == button){
                label.setText("As you wonder where you are at you notice another fae approaching you");
                whichPart = 8;
            }
        }
        else if (whichPart == 8){
            if(e.getSource() == button){
                label.setText("FAE: That tree is dying. I'm on my way to the Pond of Wonder to save it.");
                whichPart = 9;
            }
        }
        else if (whichPart == 9){
            label.setText("FAE: Will you join me on my quest?");
            button1.setVisible(true);
            button1.setText("NO");
            button.setText("YES");
            whichPart = 10;
        }
        else if (whichPart == 10){
            if(e.getSource() == button1){
                button.setVisible(false);
                button1.setVisible(false);
                label.setText("GAME OVER!!!");
            }
            if(e.getSource() ==button){
                button1.setVisible(false);
                label.setText("FAE: Thank you so much. That is really kind of you!");
                button.setText("NEXT");
                whichPart = 11;
            }
        }
        else if (whichPart == 11){
            if(e.getSource() == button){
                label.setText("FAE: I don't like adventures alone. The pond isn't far from here.");
                whichPart = 12;
            }
        }
        else if (whichPart == 12){
            if (e.getSource() == button){
                label.setText("As you and the other fae continue your quest you notice you're approaching a dark cave");
                whichPart = 13;
            }
        }
        else if (whichPart == 13){
            if (e.getSource() == button){
                label.setText("FAE: Wow it's looking really scary. Are you sure you want to go in?");
                button.setText("Of course");
                button1.setVisible(true);
                button1.setText("HECK NO!!!");
                whichPart = 14;
            }
        }
        else if (whichPart == 14){
            if (e.getSource() == button){
                label.setText("FAE: I'm so lucky to have ran into you");
                button1.setVisible(false);
                button.setText("NEXT");
                whichPart = 15;
            }
            if (e.getSource() ==button1){
                button.setVisible(false);
                button1.setVisible(false);
                label.setText("GAME OVER!!!");
            }
        }
        else if (whichPart == 15){
            if (e.getSource() == button){
                label.setText("You observe your surroundings and see the water. What will you do?");
                button.setText("");
            }
        }
    }

    public static void main(String args[]){
        TextAdventure game = new TextAdventure();
        game.setVisible(true);
    }
}
