package view.screen2;

import javax.swing.*;
import java.awt.*;

public class MyPanel9 extends JPanel {

    private JLabel label;
    private JButton rowButton;

    public MyPanel9(){
        initComponents();
    }

    private void initComponents(){
        setLayout(new GridBagLayout());
        setBackground(new Color(7,9,19));
        GridBagConstraints gbc = new GridBagConstraints();
        label = new JLabel("Address settings");
        label.setForeground(new Color(52,152,255));
        gbc.gridx=0;
        add(label,gbc);
        rowButton = new JButton();
        Image rowImage = new ImageIcon("resources/bluerow.png").getImage().getScaledInstance(10,10,0);
        rowButton.setIcon(new ImageIcon(rowImage));
        rowButton.setBorderPainted(false);
        rowButton.setBackground(new Color(7,9,19));
        gbc.gridx=1;
        add(rowButton,gbc);

    }
}
