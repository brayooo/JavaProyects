package co.edu.uptc.views;

import javax.swing.*;
import java.awt.*;

public class StatsDialog extends JDialog {

    private JLabel flightsLanded;
    private JLabel landedCount;
    private JLabel timePlayed;
    private JLabel timeCount;
    private JLabel minutes;

    public StatsDialog(Board board){
        setLayout(null);
        initComponents();
        setSize(new Dimension(400,250));
        setLocationRelativeTo(board);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(false);
    }

    private void initComponents() {
        flightsLanded = new JLabel("Aviones aterrizados: ");
        flightsLanded.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 18));
        flightsLanded.setBounds(75,50,190,20);
        add(flightsLanded);
        landedCount = new JLabel();
        landedCount.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 18));
        landedCount.setBounds(250,50,50,20);
        add(landedCount);

        timePlayed = new JLabel("Tiempo jugado: ");
        timePlayed.setBounds(75,130,190,20);
        timePlayed.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 18));
        add(timePlayed);
        timeCount = new JLabel();
        timeCount.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 18));
        timeCount.setBounds(200,130,50,20);
        add(timeCount);

        minutes = new JLabel("Minutos");
        minutes.setBounds(250,130,80,20);
        minutes.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 18));
        add(minutes);
    }

    public void setLandedCount(String msg){
        landedCount.setText(msg);
    }

    public void setTimeCount(String msg){
        timeCount.setText(msg);
    }
}
