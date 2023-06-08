package co.edu.uptc.view.adminBoard;

import co.edu.uptc.model.Invoice;
import co.edu.uptc.pojo.Client;
import co.edu.uptc.pojo.InvoiceDetails;
import co.edu.uptc.pojo.Product;
import co.edu.uptc.view.components.MyButton;
import co.edu.uptc.view.mainBoard.MyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AdminBoard extends JPanel implements ActionListener {

    private AdminProductPane adminProductPane;
    private AdminInvoicePane adminInvoicePane;
    private AdminClientPane adminClientPane;
    private MyButton clientBt;
    private MyButton productBt;
    private MyButton invoiceBt;
    private JButton back;
    private GridBagConstraints gbc;
    private MyFrame myFrame;

    public AdminBoard(MyFrame myFrame) {
        this.myFrame = myFrame;
        setLayout(new GridBagLayout());
        initComponents();
        initPanels();
    }

    private void initComponents() {
        gbc = new GridBagConstraints();
        clientBt = new MyButton(new Color(68, 65, 65), "Administrar clientes");
        productBt = new MyButton(new Color(68, 65, 65), "Administrar productos");
        invoiceBt = new MyButton(new Color(68, 65, 65), "Administrar facturas");
        back = new JButton();
        back.setPreferredSize(new Dimension(100, 100));
        back.setIcon(new ImageIcon(new ImageIcon("src/resources/arrowReturn.png").
                getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        back.setBorderPainted(false);
        back.setOpaque(false);
        back.setContentAreaFilled(false);
        back.setActionCommand("BACK");
        back.addActionListener(this);

        gbc.insets = new Insets(0,0,0,480);
        add(back,gbc);

        gbc.gridy = 1;
        gbc.insets = new Insets(0,0,0,0);
        clientBt.setRadius(20);
        clientBt.setForeground(new Color(255, 255, 255));
        clientBt.setPreferredSize(new Dimension(200, 80));
        clientBt.setBorderPainted(false);
        clientBt.setActionCommand("ScCLIENT");
        clientBt.addActionListener(this);
        add(clientBt, gbc);

        gbc.gridy = 2;
        productBt.setRadius(20);
        productBt.setForeground(new Color(255, 255, 255));
        productBt.setPreferredSize(new Dimension(200, 80));
        productBt.setBorderPainted(false);
        productBt.setActionCommand("ScPRODUCT");
        productBt.addActionListener(this);
        add(productBt, gbc);

        gbc.gridy = 3;
        gbc.insets = new Insets(0,0,20,0);
        invoiceBt.setRadius(20);
        invoiceBt.setForeground(new Color(255, 255, 255));
        invoiceBt.setPreferredSize(new Dimension(200, 80));
        invoiceBt.setBorderPainted(false);
        invoiceBt.setActionCommand("ScINVOICE");
        invoiceBt.addActionListener(this);
        add(invoiceBt, gbc);
    }

    private void initPanels(){
        adminClientPane = new AdminClientPane(this);
        adminInvoicePane = new AdminInvoicePane(this);
        adminProductPane = new AdminProductPane(this);
    }
    public void showClientAdmin(){
        adminClientPane.setVisible(true);
        this.setVisible(false);
        myFrame.add(adminClientPane);
    }

    public void showProductAdmin(){
        adminProductPane.setVisible(true);
        setVisible(false);
        myFrame.add(adminProductPane);
    }

    public void showInvoiceAdmin(){
        adminInvoicePane.setVisible(true);
        setVisible(false);
        myFrame.add(adminInvoicePane);
    }

    public void hideClientPanel(){
        adminClientPane.setVisible(false);
        this.setVisible(true);
        myFrame.add(this);
    }

    public void hideProductPanel(){
        adminProductPane.setVisible(false);
        this.setVisible(true);
        myFrame.add(this);
    }

    public void hideInvoicePanel(){
        adminInvoicePane.setVisible(false);
        this.setVisible(true);
        myFrame.add(this);
    }

    private void showProductPane(){
        adminProductPane.setVisible(true);
        this.setVisible(false);
        myFrame.setPreferredSize(new Dimension(600,400));
        myFrame.add(adminProductPane);
    }

    private void showInvoicePane(){
        adminInvoicePane.setVisible(true);
        this.setVisible(false);
        myFrame.setPreferredSize(new Dimension(600,400));
        myFrame.add(adminInvoicePane);
    }

    public void addClientEdit(EditClient editClient){
        myFrame.add(editClient);
    }

    public void addProductEdit(EditProductPane editProductPane){
        myFrame.add(editProductPane);
    }

    public void addInvoiceEdit(EditInvoicePane editInvoicePane){
        myFrame.add(editInvoicePane);}

    public void addProductAddPanel(AddProductPane addProductPane) {
        myFrame.add(addProductPane);
    }

    public void addProduct(Product product){
        myFrame.addProduct(product);
    }

    public boolean editClient(Client client){
        return myFrame.editClient(client);
    }

    public void deleteClient(Client client){
        myFrame.deleteClient(client);
    }

    public List<Client> getClients(){
        return myFrame.getClients();
    }

    public void deleteSelectedClients(){
        myFrame.deleteSelectedCLients();
    }

    public List<String> getReferencedClients(){
        return myFrame.getReferencedClients();
    }

    public Client getClient(String idClient){
        return myFrame.searchClient(idClient);
    }

    public List<Product> getProducts(){
        return myFrame.getProducts();
    }

    public Product getProduct(String ciu){
        return myFrame.searchProduct(ciu);
    }

    public void editProduct(Product pr) {
        myFrame.editProduct(pr);
    }

    public Invoice getInvoice() {
       return myFrame.getInvoice();
    }

    public Invoice searchInvoice(int idInvoice) {
        return myFrame.searchInvoice(idInvoice);
    }

    public List<Invoice> getInvoices() {
        return myFrame.getInvoices();
    }

    public void deleteProduct(Product pr) {
        myFrame.deleteProduct(pr);
    }

    public void deleteInvoice(Invoice inv) {
        myFrame.deleteInvoice(inv);
    }

    public void editInvoice(Client client, InvoiceDetails details) {
        myFrame.editInvoice(client, details);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case "BACK":
                myFrame.hideAdminBoard();
                break;
            case "ScCLIENT":
                showClientAdmin();
                break;
            case "ScPRODUCT":
                showProductPane();
                break;
            case "ScINVOICE":
                showInvoicePane();
                break;
        }
    }
}

