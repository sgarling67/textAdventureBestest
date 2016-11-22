package Buttons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by joel on 11/20/2016.
 */
public class ButtonsPanel extends JPanel {
    private JButton elfButton; // creating all the buttons.
    private JButton knightButton;
    private JButton proceed;
    private JButton choiceOne;
    private JButton choiceTwo;
    private JButton choiceThree;
    public ButtonsPanel(){
        super();
        knightButton = new JButton("Click to start knight's story!");
        elfButton = new JButton("Click to start the elf's story!");
        proceed = new JButton ("Continue");
        choiceOne = new JButton("A");
        choiceTwo = new JButton("B");
        choiceThree = new JButton("C");

        //adding to the panel at the beginning of the story.
        add(knightButton);
        add(elfButton);
        add(proceed);
        add(choiceOne);
        add(choiceTwo);
        add(choiceThree);

        //gets rid of buttons at start that are not needed.
        choiceOne.setVisible(false);
        choiceTwo.setVisible(false);
        choiceThree.setVisible(false);
        proceed.setVisible(false);

        //adding the action listeners to the buttons
        knightButton.addActionListener(new knightsTale());
        elfButton.addActionListener(new elfsTale());
        proceed.addActionListener(new continueAction());
        choiceOne.addActionListener(new decisionOne());
        choiceTwo.addActionListener(new decisionTwo());
        choiceThree.addActionListener(new decisionThree());

    }

    class knightsTale implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //call knight's story section of code.

            //gets updates buttons that are important.
            knightButton.setVisible(false);
            elfButton.setVisible(false);
            proceed.setVisible(true);

        }
    }

    class elfsTale implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //call elf's story section of code.
            knightButton.setVisible(false);
            elfButton.setVisible(false);
            choiceOne.setVisible(true);
            choiceTwo.setVisible(true);
            choiceThree.setVisible(true);
        }
    }

    class continueAction implements ActionListener{
        public void actionPerformed(ActionEvent e){
            // call next section of the story.

        }

    }

    class decisionOne implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            //sends the next part of story for the decision one(the first button)
            // theDecision(1,DecisionPoint)

        }
    }

    class decisionTwo implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //sends the next part of story for decision two(the second button)
            // theDecision(2,DecisionPoint)
        }
    }

    class decisionThree implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //sends the next part of story for the decision three(the third button)
            //theDecision(3,decisionPoint[])
        }
    }

    private String theDecision(int buttonChosen, String[] DecisionPoint){
        switch(buttonChosen){
              case(1):{ return DecisionPoint[0];}
              case(2):{ return DecisionPoint[1];}
              case(3):{ return DecisionPoint[2];}
        }
        return null;
        //  case(1):{ return DecisionPoint[0];}
        //  case(2):{ return DecisionPoint[1];}
        //  case(3):{ return DecisionPoint[2];}
    }
}