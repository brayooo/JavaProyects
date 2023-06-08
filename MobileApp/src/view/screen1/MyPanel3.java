package view.screen1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MyPanel3 extends JPanel {

    private BoundButton button1;
    private BoundButton button2;

    public MyPanel3(ActionListener listener){
        initComponents(listener);
    }

    private void initComponents(ActionListener listener){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setBackground(new Color(29,39,50));
        button1 = new BoundButton("   RECEIVE   ",new Color(52,152,255));
        button1.addActionListener(listener);
        button1.setActionCommand("screen2");
        gbc.insets = new Insets(0,0,50,5);
        add(button1,gbc);
        button2 = new BoundButton("    SEND    ",new Color(52,152,255));
        gbc.insets = new Insets(0,5,50,0);
        add(button2,gbc);
    }
}
