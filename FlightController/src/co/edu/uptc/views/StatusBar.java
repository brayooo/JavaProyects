package co.edu.uptc.views;

import javax.swing.*;
import java.awt.*;

public class StatusBar extends JPanel {

    private JLabel textPlanesPlaying;
    private JLabel planePlayingCount;
    private JLabel textPlanesLanded;
    private JLabel planesLandedCount;
    private Board board;

    public StatusBar(Board board){
        this.board = board;
        setLayout(null);
        setPreferredSize(new Dimension(board.getWidth(), 25));
        setBackground(new Color(253,253,150));
        initComponents();
    }

    private void initComponents(){
        textPlanesPlaying = new JLabel("Aviones en el aire: ");
        textPlanesPlaying.setBounds(300, 0,180,20);
        add(textPlanesPlaying);
        planePlayingCount = new JLabel();
        planePlayingCount.setBounds(415,0,25,20);
        add(planePlayingCount);
        textPlanesLanded = new JLabel("Aviones aterrizados: ");
        textPlanesLanded.setBounds(500,0,180,20);
        add(textPlanesLanded);
        planesLandedCount = new JLabel();
        planesLandedCount.setBounds(630,0,25,20);
        add(planesLandedCount);
    }

    public void setPlanePlayingCount(String count){
        planePlayingCount.setText(count);
    }

    public void setPlanesLandedCount(String count){
        planesLandedCount.setText(count);
    }
}
