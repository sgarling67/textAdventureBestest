package Buttons;

import javax.swing.*;

/**
 * Created by joel on 11/20/2016.
 */
public class Button extends JPanel {
    public static void main(String[] args) {
        JFrame jf = new JFrame("Button Example");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(new ButtonsPanel());
        jf.pack();
        jf.setVisible(true);
    }
}