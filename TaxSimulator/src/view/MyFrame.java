package view;

import model.Usage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame{

    private MyPanel1 panel1;
    private MyPanel2 panel2;
    private MyPanel3 panel3;

    public MyFrame(ActionListener listener) {
        super("Calculadora de impuestos");
        setLayout(new GridLayout(3,1));
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        intComponents(listener);
        setVisible(true);
    }

    private void intComponents(ActionListener listener) {
        panel1 = new MyPanel1(listener);
        panel2 = new MyPanel2(listener);
        panel3 = new MyPanel3(listener);
        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
    }

    public String getCadastralCode(){
        return panel1.getCadastralCode();
    }
    public void setTxtAddress(String message){
        panel1.setTxtAddress(message);
    }
    public void setTxtStratum(String message){
        panel1.setTxtStratum(message);
    }

    public void setCadastralCode(){
        panel1.setCadastralCode();
    }
    public void setTxtArea(String message){
        panel1.setTxtArea(message);
    }
    public void setTxtValue(String message){
        panel1.setTxtValue(message);
    }
    public void setTxtUsage(Usage message){
        panel1.setTxtUsage(message);
    }

    public boolean getStatusFirstCheckBox(){
        return panel2.getStatusFirstCheckBox();
    }

    public boolean getStatusSecondCheckBox(){
        return panel2.getStatusSecondCheckBox();
    }

    public void setValue(String message){
        panel3.setLabel(message);
    }
}

