package view.screen2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MyPanel5 extends JPanel {

    private JButton rowButton;
    private JLabel tittle;
    private JButton scanButton;

    public MyPanel5(ActionListener listener){
        initComponents(listener);
    }

    private void initComponents(ActionListener listener){
        setLayout(new GridBagLayout());
        setBackground(new Color(29,39,50));
        GridBagConstraints gbc = new GridBagConstraints();
        rowButton = new JButton();
        rowButton.addActionListener(listener);
        rowButton.setActionCommand("screen1");
        Image rowIcon = new ImageIcon("resources/row.png").getImage().getScaledInstance(20,20,0);
        rowButton.setIcon(new ImageIcon(rowIcon));
        rowButton.setBorderPainted(false);
        rowButton.setBackground(new Color(29,39,50));
        gbc.gridx=0;
        gbc.insets = new Insets(0,0,0,60);
        add(rowButton,gbc);
        tittle = new JLabel("Receive");
        tittle.setForeground(Color.white);
        tittle.setFont(new Font("Abadi MT Condensed Light",Font.PLAIN,15));
        gbc.insets = new Insets(0,0,0,30);
        gbc.gridx=1;
        add(tittle,gbc);
        scanButton = new JButton();
        Image scanIcon = new ImageIcon("resources/scan.png").getImage().getScaledInstance(20,20,0);
        scanButton.setIcon(new ImageIcon(scanIcon));
        scanButton.setBorderPainted(false);
        scanButton.setBackground(new Color(29,39,50));
        gbc.gridx=2;
        gbc.insets = new Insets(0,30,0,50);
        add(scanButton,gbc);
    }
}
