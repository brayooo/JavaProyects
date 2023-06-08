package co.edu.uptc.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {

    private JButton panelColor;
    private JButton recColor;
    private Board board;
    private JColorChooser colorChooser;
    public ButtonPanel(int with, Board board){
        this.board = board;
        setBackground(Color.decode("#00C9A7"));
        setSize(with,200);
        initComponents();
    }

    public void initComponents(){
        colorChooser = new JColorChooser();
        panelColor = new JButton("Color panel");
        panelColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = JColorChooser.showDialog(board,"Seleccione color", Color.BLUE);
                board.setPanelColor(color);
            }
        });
        recColor = new JButton("Color rec");
        recColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.setRecColor(JColorChooser.showDialog(board, "Seleccione color", Color.PINK));
            }
        });
        add(panelColor);
        add(recColor);
    }



}
