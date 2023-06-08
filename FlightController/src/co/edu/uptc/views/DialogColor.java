package co.edu.uptc.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogColor extends JDialog implements ActionListener {

    private JButton blackColor;
    private JButton redColor;
    private JButton blueColor;
    private JButton greenColor;
    private JLabel planeInfo;
    private JLabel planeSelect;
    private JSlider jSlider;
    private PlayArea playArea;

    public DialogColor(PlayArea playArea){
        this.playArea = playArea;
        setLayout(null);
        initComponents();
        setSize(new Dimension(400,250));
        setLocationRelativeTo(playArea);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(false);
    }

    private void initComponents() {
       initButtons();
       initLabels();
       initSlider();
    }

    private void initSlider() {
        jSlider = new JSlider();
        jSlider.setBounds(88,100,200,50);
        jSlider.setMajorTickSpacing(10);
        jSlider.setMinorTickSpacing(5);
        jSlider.setPaintTicks(true);
        jSlider.setPaintLabels(true);
        this.add(jSlider);
    }

    private void initButtons(){
        blackColor = new JButton("Negro");
        blackColor.setActionCommand("Blck");
        blackColor.addActionListener(this);
        blackColor.setBounds(10,50,80,20);

        redColor = new JButton("Rojo");
        redColor.setActionCommand("Red");
        redColor.setBounds(100,50,80,20);
        redColor.addActionListener(this);

        blueColor = new JButton("Blue");
        blueColor.setActionCommand("Blue");
        blueColor.setBounds(200,50,80,20);
        blueColor.addActionListener(this);

        greenColor = new JButton("Green");
        greenColor.setActionCommand("Green");
        greenColor.setBounds(300,50,80,20);
        greenColor.addActionListener(this);

        this.add(blackColor);
        this.add(redColor);
        this.add(blueColor);
        this.add(greenColor);
    }
    private void initLabels(){
        planeSelect = new JLabel("Avion seleccionado: ");
        planeSelect.setBounds(90,10,150,20);

        planeInfo = new JLabel();
        planeInfo.setBounds(220,10,50,20);

        this.add(planeSelect);
        this.add(planeInfo);
    }

    public int setSliderValue(){
        return jSlider.getValue();
    }

    public void setPlaneInfo(){
        planeInfo.setText(String.valueOf(playArea.getPlane().getId()));
    }

    private void setColor(int color){
        playArea.getPlane().setColor(color);
    }

    private void closeDialog(){
        setVisible(false);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Blck" -> {
                setColor(0);
                closeDialog();
            }
            case "Blue" -> {
                setColor(1);
                closeDialog();
            }
            case "Red" -> {
                setColor(2);
                closeDialog();
            }
            case "Green" -> {
                setColor(3);
                closeDialog();
            }
        }
    }
}
