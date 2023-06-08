package view.screen1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PrincipalPanel extends JPanel {

    private MyPanel myPanel;
    private MyPanel2 myPanel2;
    private MyPanel3 myPanel3;
    private MyPanel4 myPanel4;

    public PrincipalPanel(ActionListener listener){
        initComponents(listener);
    }

    private void initComponents(ActionListener listener){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setBackground(new Color(29,39,50));
        myPanel = new MyPanel();
        gbc.gridy=0;
        add(myPanel,gbc);
        myPanel2 = new MyPanel2();
        gbc.insets = new Insets(40,0,0,10);
        gbc.gridy=1;
        add(myPanel2,gbc);
        myPanel3 = new MyPanel3(listener);
        gbc.gridy=2;
        gbc.insets = new Insets(30,0,0,0);
        add(myPanel3,gbc);
        myPanel4 = new MyPanel4();
        gbc.gridy=3;
        gbc.insets = new Insets(200,0,0,0);
        add(myPanel4,gbc);
    }
}

