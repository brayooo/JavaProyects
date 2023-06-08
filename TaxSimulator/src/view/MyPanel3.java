package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MyPanel3 extends JPanel {

    private JButton jButton;
    private JLabel label;

    public MyPanel3(ActionListener listener){
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        jButton = new JButton("Liquidar: ");
        jButton.addActionListener(listener);
        jButton.setActionCommand("control");
        add(jButton);
        label = new JLabel();
        add(label);
    }

    public void setLabel(String message){
        label.setText(message);
    }
}
