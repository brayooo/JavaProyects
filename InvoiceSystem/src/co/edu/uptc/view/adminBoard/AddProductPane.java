package co.edu.uptc.view.adminBoard;

import co.edu.uptc.model.ListUptc;
import co.edu.uptc.pojo.Product;
import co.edu.uptc.view.components.MyButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProductPane extends JPanel implements ActionListener {

    private ListUptc<String> texts;
    private ListUptc<JTextField> textFields;
    private ListUptc<JLabel> labels;
    private MyButton saveBt;
    private MyButton backBt;
    private GridBagConstraints gbc;
    private AdminProductPane adminProductPane;

    public AddProductPane(AdminProductPane adminProductPane){
        this.adminProductPane = adminProductPane;
        texts = new ListUptc<>();
        textFields = new ListUptc<>();
        labels = new ListUptc<>();
        setLayout(new GridBagLayout());
        initComponents();
    }

    private void addTexts(){
        texts.add("Codigo de barras: ");
        texts.add("CIU: ");
        texts.add("Descripción: ");
        texts.add("Precio unitario: ");
    }

    private void initComponents(){
        gbc = new GridBagConstraints();
        addTexts();
        initFields(gbc);
        initLabels(gbc);

        saveBt = new MyButton(new Color(68,65,65),"Añadir productos");
        setInfoButton(saveBt,"ADD");
        backBt = new MyButton(new Color(68,65,65),"Volver");
        setInfoButton(backBt,"BCK");
        gbc.gridy = 5;
        gbc.gridx = 0;
        add(saveBt,gbc);
        gbc.gridx = 1;
        add(backBt,gbc);

    }


    private void setInfoButton(MyButton myButton, String command){
        myButton.setRadius(10);
        myButton.setForeground(new Color(255,255,255));
        myButton.setPreferredSize(new Dimension(150,50));
        myButton.setBorderPainted(false);
        myButton.setActionCommand(command);
        myButton.addActionListener(this);
    }

    private void initLabels(GridBagConstraints gbc){
        int inX = 0;
        for (int i = 0; i < texts.size(); i++) {
            gbc.gridx = inX;
            gbc.gridy = i;
            gbc.insets = new Insets(10,0,0,0);
            JLabel label = new JLabel();
            labels.add(label);
            labels.get(i).setText(texts.get(i));
            add(labels.get(i),gbc);
        }
    }
    private void initFields(GridBagConstraints gbc){
        int inAux = 1;
        for (int i = 0; i < texts.size(); i++) {
            gbc.gridy = i;
            gbc.gridx = inAux;
            gbc.insets = new Insets(10,0,0,0);
            JTextField textField = new JTextField();
            textFields.add(textField);
            textFields.get(i).setColumns(20);
            add(textFields.get(i),gbc);
        }
    }

    public Product getProduct(){
        Product pr = new Product();
        pr.setBarCode(textFields.get(0).getText());
        pr.setCIU(textFields.get(1).getText());
        pr.setDescription(textFields.get(2).getText());
        pr.setUnitPrice(Double.parseDouble(textFields.get(3).getText()));
        return pr;
    }

    public void addProduct(){
        Product pr = getProduct();
        System.out.println(pr);
        adminProductPane.addProduct(pr);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("ADD")){
            addProduct();
        }else if(e.getActionCommand().equals("BCK")){
            adminProductPane.hideAddPanel();
        }
    }
}
