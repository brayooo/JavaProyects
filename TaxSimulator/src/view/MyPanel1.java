package view;

import model.Property;
import model.TaxCalculator;
import model.Usage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MyPanel1 extends JPanel{

    private JLabel lblSide;
    private JButton button1;
    private JTextField textField;
    private JLabel address;
    private JLabel addressResult;
    private JLabel cadastralCode;
    private JLabel cadastralCodeResult;
    private JLabel stratum;
    private JLabel stratumResult;
    private JLabel area;
    private JLabel areaResult;
    private JLabel value;
    private JLabel valueResult;
    private JLabel usage;
    private JLabel usageResult;

    public MyPanel1(ActionListener listener){
        initComponents(listener);
    }

    private void initComponents(ActionListener listener){
        setLayout(new GridLayout(7,1));
        lblSide = new JLabel("Ingrese el numero predio: ");
        textField = new JTextField(5);
        button1 = new JButton("Buscar");
        button1.addActionListener(listener);
        button1.setActionCommand("comando");
        address = new JLabel("Direccion: ");
        addressResult = new JLabel("");
        cadastralCode = new JLabel("Código catastral: ");
        cadastralCodeResult = new JLabel("");
        stratum = new JLabel("Estrato: ");
        stratumResult = new JLabel("");
        area = new JLabel("Area: ");
        areaResult = new JLabel("");
        value = new JLabel("Avalúo: ");
        valueResult = new JLabel("");
        usage = new JLabel("Uso: ");
        usageResult = new JLabel("");
        add(lblSide);
        add(textField);
        add(button1);
        add(address);
        add(addressResult);
        add(cadastralCode);
        add(cadastralCodeResult);
        add(stratum);
        add(stratumResult);
        add(area);
        add(areaResult);
        add(value);
        add(valueResult);
        add(usage);
        add(usageResult);

        /*setLayout(new GridLayout(5,2,3,3));
        setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
        setLayout(new GridLayout(7,1));
        lblSide = new JLabel("Ingrese el numero predio: ");
        textField = new JTextField(5);
        button1 = new JButton("Buscar");
        button1.addActionListener(listener);
        button1.setActionCommand("Comando");
        address = new JLabel("Direccion: ");
        addressResult = new JLabel("");
        cadastralCode = new JLabel("Código catastral: ");
        cadastralCodeResult = new JLabel("");
        stratum = new JLabel("Estrato: ");
        stratumResult = new JLabel("");
        area = new JLabel("Area: ");
        areaResult = new JLabel("");
        value = new JLabel("Avalúo: ");
        valueResult = new JLabel("");
        usage = new JLabel("Uso: ");
        usageResult = new JLabel("");
        add(lblSide);
        add(textField);
        add(button1);
        add(address);
        add(addressResult);
        add(cadastralCode);
        add(cadastralCodeResult);
        add(stratum);
        add(stratumResult);
        add(area);
        add(areaResult);
        add(value);
        add(valueResult);
        add(usage);
        add(usageResult);
         */
    }

    public String getCadastralCode(){
        return textField.getText();
    }
    public void setTxtAddress(String message){
        addressResult.setText(message);
    }
    public void setTxtStratum(String message){
        stratumResult.setText(message);
    }
    public void setTxtArea(String message){
        areaResult.setText(message);
    }
    public void setTxtValue(String message){
        valueResult.setText(message);
    }
    public void setTxtUsage(Usage message){
        usageResult.setText(message.toString());
    }

    public void setCadastralCode(){
        cadastralCodeResult.setText(textField.getText());
    }

}
