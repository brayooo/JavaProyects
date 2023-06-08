package view.screen1;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    private JLabel label;
    private JButton feedBackButton;

    public MyPanel (){
        initComponents();
    }

    private void initComponents(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setBackground(new Color(29,39,50));
        label = new JLabel("Muun");
        feedBackButton = new JButton();
        label.setForeground(Color.white);
        label.setFont(new Font("Abadi MT Condensed Light",Font.PLAIN,15));
        gbc.insets = new Insets(0,0,110,90);
        add(label,gbc);
        Image feedBackIcon = new ImageIcon("resources/adver.png").getImage().getScaledInstance(20,20,0);
        feedBackButton.setIcon(new ImageIcon(feedBackIcon));
        feedBackButton.setBorderPainted(false);
        feedBackButton.setBackground(new Color(29,39,50));
        gbc.insets = new Insets(0,90,0,0);
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(feedBackButton,gbc);

    }
}
