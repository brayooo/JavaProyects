package view.screen2;

import view.screen1.BoundButton;

import javax.swing.*;
import java.awt.*;

public class MyPanel8 extends JPanel {

    private BoundButton shareButton;
    private BoundButton copyButton;

    public MyPanel8(){
        initComponents();
    }

    private void initComponents(){
        setLayout(new GridBagLayout());
        setBackground(new Color(7,9,19));
        GridBagConstraints gbc = new GridBagConstraints();
        shareButton = new BoundButton("SHARE",new Color(52,152,255));
        gbc.gridx=0;
        gbc.insets = new Insets(0,0,0,25);
        shareButton.setBackground(new Color(7,9,19));
        add(shareButton,gbc);
        copyButton = new BoundButton("COPY",new Color(52,152,255));
        gbc.gridx=1;
        copyButton.setBackground(new Color(7,9,19));
        add(copyButton,gbc);
    }
}
