package view.screen2;

import javax.swing.*;
import java.awt.*;

public class MyPanel7 extends JPanel {

    private JLabel walletAddress;
    private JButton viewButton;

    public MyPanel7() {
        initComponents();
    }
    private void initComponents()  {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setBackground(new Color(7,9,19));
        gbc.gridx=0;
        walletAddress = new JLabel("bc1q63s0q7z72d3...eju83ghq8k48m8");
        walletAddress.setForeground(Color.WHITE);
        walletAddress.setFont(new Font("Tahoma",Font.PLAIN,10));
        add(walletAddress,gbc);
        viewButton = new JButton();
        gbc.gridx=1;
        Image eyeButton = new ImageIcon("resources/eye.png").getImage().getScaledInstance(20,15,0);
        viewButton.setBackground(new Color(7,9,19));
        viewButton.setBorderPainted(false);
        viewButton.setIcon(new ImageIcon(eyeButton));
        add(viewButton,gbc);
    }

}
