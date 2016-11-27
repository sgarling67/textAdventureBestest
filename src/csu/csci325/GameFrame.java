package csu.csci325;

import javax.swing.*;

/**
 * Created by Sydney on 11/26/16.
 */
public class GameFrame extends JPanel {
    public static void main(String[] args) {
        JFrame gf = new JFrame("Text Adventure Bestest!");
        gf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gf.add(new project2());
        gf.pack();
        gf.setSize(1416,792);
        gf.setVisible(true);
    }
}
