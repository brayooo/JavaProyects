package view.screen1;

import javax.swing.*;
import java.awt.*;

public class MyPanel2 extends JPanel {

    private JLabel label;
    private JLabel label1;
    private JLabel label2;

    public MyPanel2(){
        initComponents();
    }

    private void initComponents(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setBackground(new Color(29,39,50));
        label = new JLabel("0,00");
        label.setForeground(Color.white);
        label.setFont(new Font("Arial Rounden MT",Font.BOLD,35));
        gbc.gridx=0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0,20,0,0);
        add(label,gbc);
        label1 = new JLabel("BTC");
        label1.setFont(new Font("Arial Rounden MT",Font.BOLD,15));
        label1.setForeground(Color.white);
        gbc.insets = new Insets(15,0,0,0);
        gbc.gridx=1;
        gbc.gridy = 0;
        add(label1,gbc);
        label2= new JLabel("0 COP");
        label2.setForeground(new Color(211,214,220));
        gbc.insets = new Insets(0,48,0,0);
        gbc.ipadx = 20;
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(label2,gbc);
    }
}
