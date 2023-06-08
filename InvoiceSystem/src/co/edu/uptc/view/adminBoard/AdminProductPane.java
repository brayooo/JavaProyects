package co.edu.uptc.view.adminBoard;

import co.edu.uptc.pojo.Client;
import co.edu.uptc.pojo.Product;
import co.edu.uptc.view.components.MyButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class AdminProductPane extends JPanel implements ActionListener {

    private JTextField textField;
    private JComboBox<Product> comboBox;
    private MyButton addBt;
    private MyButton searchBt;
    private MyButton deleteBt;
    private MyButton editBt;
    private MyButton backBt;
    private AdminBoard adminBoard;
    private DialogDeleteProduct dialogDeleteProduct;
    private EditProductPane editProductPane;
    private AddProductPane addProductPane;

    public AdminProductPane(AdminBoard adminBoard){
        this.adminBoard = adminBoard;
        dialogDeleteProduct = new DialogDeleteProduct(this);
        addProductPane = new AddProductPane(this);
        setLayout(null);
        initComponents();
        editProductPane = new EditProductPane(this);
    }

    private void initComponents(){
        comboBox = new JComboBox<>();
        comboBox.setBounds(150,150,300,30);
        add(comboBox);
        addFields();
        addButtons();
    }

    private void addFields(){
        textField = new JTextField(25);
        textField.setBounds(150,50,200,30);
        textField.setText("Ingrese codigo del producto");
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(textField.getText().trim().equals("Ingrese codigo del producto"))
                    textField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(textField.getText().trim().equals(""))
                    textField.setText("Ingrese codigo del producto");
            }
        });
        add(textField);
    }

    private void addButtons(){
        searchBt = new MyButton(new Color(68,65,65), "Buscar");
        setInfoButtons(searchBt,"SRCH");
        searchBt.setBounds(380,50,100,30);
        add(searchBt);

        addBt  = new MyButton(new Color(68,65,65),"<html>Agregar nuevo<br>producto</html>");
        addBt.setHorizontalAlignment(SwingConstants.CENTER );
        setInfoButtons(addBt,"ADD");
        addBt.setBounds(100,230,130,45);
        add(addBt);

        editBt = new MyButton(new Color(68,65,65),"Editar producto");
        setInfoButtons(editBt,"EDIT");
        editBt.setBounds(240,230,150,30);
        add(editBt);

        deleteBt = new MyButton(new Color(68,65,65),"Eliminar");
        setInfoButtons(deleteBt, "DEL");
        deleteBt.setBounds(390,230,100,30);
        add(deleteBt);

        backBt = new MyButton(new Color(68,65,65),"REGRESAR");
        setInfoButtons(backBt,"BACK");
        backBt.setBounds(230,280,130,30);
        add(backBt);
    }

    private void setInfoButtons(MyButton button, String text){
        button.setRadius(20);
        button.setForeground(new Color(255,255,255));
        button.setPreferredSize(new Dimension(130,35));
        button.setBorderPainted(false);
        button.setActionCommand(text);
        button.addActionListener(this);
    }


    private void showEditClient(){
        this.setVisible(false);
        editProductPane.setVisible(true);
        adminBoard.addProductEdit(editProductPane);
    }

    private void showAddProduct(){
        setVisible(false);
        addProductPane.setVisible(true);
        adminBoard.addProductAddPanel(addProductPane);
    }

    public void hideEditProduct(){
        editProductPane.setVisible(false);
        adminBoard.showProductAdmin();
    }

    public void hideAddPanel() {
        addProductPane.setVisible(false);
        adminBoard.showProductAdmin();
    }

    public void addProduct(Product product){
        adminBoard.addProduct(product);
    }

    private void showDelDialog(){
        dialogDeleteProduct.setVisible(true);
    }

    // TODO: 17/03/2023 agregar para cuando no lo encuentro 
    public void setProducts(){
        if(textField.getText().equals("Ingrese codigo del producto")){
            for (Product p: adminBoard.getProducts()) {
                comboBox.addItem(p);
            }
        }else {
            comboBox.addItem(adminBoard.getProduct(textField.getText()));
        }
    }

    public Object getProductCombo(){
        if(comboBox.getSelectedItem()!= null){
            return comboBox.getSelectedItem();
        }else{
            return null;
        }
    }

    public void clearCombo(){
        comboBox.removeAllItems();
    }

    public void editProduct(Product pr) {
        adminBoard.editProduct(pr);
    }

    public void deleteProduct(){
        Product pr = (Product) getProductCombo();
        adminBoard.deleteProduct(pr);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case "SRCH":
                setProducts();
                break;
            case "BACK":
                clearCombo();
                adminBoard.hideProductPanel();
                break;
            case "EDIT":
                showEditClient();
                editProductPane.setField();
                break;
            case "DEL":
                showDelDialog();
                break;
            case "ADD":
                showAddProduct();
                break;

        }
    }
}
