package view.screen2;

import view.screen1.BoundButton;

import javax.swing.*;
import java.awt.*;

public class MyPanel6 extends JPanel {

    private BoundButton button;
    private BoundButton button1;

    public MyPanel6(){
        initComponents();
    }

    private void initComponents(){
        setLayout(new GridBagLayout());
        setBackground(new Color(7,9,19));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx=0;
        button = new BoundButton("       Bitcoin      ",new Color(94,97,108));
        button.setBackground(new Color(7,9,19));
        button.setBorderPainted(false);
        add(button,gbc);
        gbc.gridx=1;
        button1 = new BoundButton("      Lightning ",new Color(34,37,47));
        button1.setBackground(new Color(7,9,19));
        button1.setBorderPainted(false);
        add(button1,gbc);
    }
}
