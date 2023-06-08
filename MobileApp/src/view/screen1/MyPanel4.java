package view.screen1;

import javax.swing.*;
import java.awt.*;

public class MyPanel4 extends JPanel {

    private JLabel voidLabel;
    private JLabel voidLabel1;
    private JButton rowButton;
    private JButton walletButton;
    private JButton securityButton;
    private JButton configButton;
    private JLabel walletLabel;
    private JLabel securityLabel;
    private JLabel configLabel;

    public MyPanel4(){
        initComponents();
    }
    private void initComponents(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setBackground(new Color(29,39,50));
        voidLabel = new JLabel("");
        voidLabel1 = new JLabel("");
        rowButton = new JButton();
        walletButton = new JButton();
        securityButton = new JButton();
        configButton = new JButton();
        walletLabel = new JLabel("Wallet");
        walletLabel.setForeground(new Color(204,206,210));
        walletLabel.setFont(new Font("Abadi MT Condensed Light",Font.BOLD,8));
        securityLabel = new JLabel("Security");
        securityLabel.setForeground(new Color(204,206,210));
        securityLabel.setFont(new Font("Abadi MT Condensed Light",Font.BOLD,8));
        configLabel = new JLabel("Settings");
        configLabel.setForeground(new Color(204,206,210));
        configLabel.setFont(new Font("Abadi MT Condensed Light",Font.BOLD,8));
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(voidLabel,gbc);
        Image rowIcon = new ImageIcon("resources/greyRow.png").getImage().getScaledInstance(10,10,0);
        rowButton.setIcon(new ImageIcon(rowIcon));
        rowButton.setBorderPainted(false);
        rowButton.setBackground(new Color(29,39,50));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0,0,25,0);
        add(rowButton,gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        add(voidLabel1,gbc);
        Image walletIcon = new ImageIcon("resources/wallet.png").getImage().getScaledInstance(20,20,0);
        walletButton.setIcon(new ImageIcon(walletIcon));;
        walletButton.setBorderPainted(false);
        walletButton.setBackground(new Color(29,39,50));
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.insets = new Insets(0,0,0,40);
        add(walletButton,gbc);
        Image securityIcon = new ImageIcon("resources/security.png").getImage().getScaledInstance(20,20,0);
        securityButton.setIcon(new ImageIcon(securityIcon));
        securityButton.setBackground(new Color(29,39,50));
        securityButton.setBorderPainted(false);
        gbc.gridx=1;
        gbc.gridy=1;
        gbc.insets = new Insets(0,1,0,0);
        add(securityButton,gbc);
        Image configIcon = new ImageIcon("resources/config.png").getImage().getScaledInstance(20,20,0);
        configButton.setIcon(new ImageIcon(configIcon));
        configButton.setBackground(new Color(29,39,50));
        configButton.setBorderPainted(false);
        gbc.gridx=2;
        gbc.gridy=1;
        gbc.insets = new Insets(0,30,0,0);
        add(configButton,gbc);
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.insets = new Insets(0,0,0,40);
        add(walletLabel,gbc);
        gbc.gridx=1;
        gbc.gridy=2;
        gbc.insets = new Insets(0,3,0,0);
        add(securityLabel,gbc);
        gbc.gridx=2;
        gbc.gridy=2;
        gbc.insets = new Insets(0,30,0,0);
        add(configLabel,gbc);

    }

}
