package co.edu.uptc.view.adminBoard;

import co.edu.uptc.model.ListUptc;
import co.edu.uptc.pojo.Product;
import co.edu.uptc.view.components.MyButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditProductPane extends JPanel implements ActionListener {
    private MyButton saveBt;
    private MyButton backBt;
    private GridBagConstraints gbc;
    private ListUptc<JLabel> labels;
    private ListUptc<JTextField> textFields;
    private ListUptc<String> texts;
    private AdminProductPane adminProductPane;

    public EditProductPane(AdminProductPane adminProductPane){
        this.adminProductPane = adminProductPane;
        texts = new ListUptc<>();
        labels = new ListUptc<>();
        textFields = new ListUptc<>();
        setLayout(new GridBagLayout());
        initComponents();
    }

    private void addTexts(){
        texts.add("Producto seleccionado: ");
        texts.add("Codigo de barras: ");
        texts.add("Ciu: ");
        texts.add("Descripcion: ");
        texts.add("Valor unitario: ");
    }

    private void initComponents(){
        gbc = new GridBagConstraints();
        addTexts();
        initLabels(gbc);
        initFields(gbc);

        saveBt = new MyButton(new Color(68,65,65),"Guardar cambios");
        backBt = new MyButton(new Color(68,65,65),"Volver");
        setInfoButton(saveBt,"SET");
        setInfoButton(backBt, "BCK");
        gbc.gridy = 6;
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

    public void setField(){
        Product pr = (Product) adminProductPane.getProductCombo();
        textFields.get(0).setEditable(false);
        textFields.get(0).setText(pr.getCIU() +" "+ pr.getDescription());
    }

    public void editProduct(){
        Product pr = (Product) adminProductPane.getProductCombo();
        pr.setBarCode(textFields.get(1).getText());
        pr.setCIU(textFields.get(2).getText());
        pr.setDescription(textFields.get(3).getText());
        pr.setUnitPrice(Integer.parseInt(textFields.get(4).getText()));
        adminProductPane.editProduct(pr);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(command.equals("SET")){
            editProduct();
        }else if(command.equals("BCK")){
            adminProductPane.clearCombo();
            adminProductPane.hideEditProduct();
        }
    }
}
