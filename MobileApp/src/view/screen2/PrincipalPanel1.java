package view.screen2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PrincipalPanel1 extends JPanel {

    private MyPanel5 myPanel5;
    private MyPanel6 myPanel6;
    private MyPanel7 myPanel7;
    private MyPanel10 myPanel10;
    private MyPanel8 myPanel8;
    private MyPanel9 myPanel9;

    public PrincipalPanel1(ActionListener listener) {
        initComponents(listener);
    }

    private void initComponents(ActionListener listener){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setBackground(new Color(7,9,19));
        myPanel5 = new MyPanel5(listener);
        gbc.gridy=0;
        gbc.ipady = 8;
        gbc.ipadx = 50;
        gbc.insets = new Insets(0,0,0,0);
        add(myPanel5,gbc);
        myPanel6 = new MyPanel6();
        gbc.insets = new Insets(20,0,30,0);
        gbc.gridy=1;
        gbc.ipady = 25;
        gbc.ipadx = 100;
        add(myPanel6,gbc);
        myPanel10 = new MyPanel10();
        gbc.insets = new Insets(0,0,0,0);
        gbc.gridy=2;
        gbc.ipady=250;
        gbc.ipadx = 250;
        add(myPanel10,gbc);
        myPanel7 = new MyPanel7();
        gbc.gridy=3;
        gbc.ipady=0;
        gbc.insets = new Insets(0,0,0,150);
        add(myPanel7,gbc);
        myPanel8 = new MyPanel8();
        gbc.gridy=4;
        gbc.ipady = 50;
        gbc.ipadx = 300;
        gbc.insets = new Insets(0,0,10,170);
        add(myPanel8,gbc);
        myPanel9 = new MyPanel9();
        gbc.gridy=5;
        gbc.insets = new Insets(0,0,100,100);
        add(myPanel9,gbc);
    }

}
