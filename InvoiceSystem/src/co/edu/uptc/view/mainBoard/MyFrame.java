package co.edu.uptc.view.mainBoard;

import co.edu.uptc.model.Invoice;
import co.edu.uptc.pojo.Client;
import co.edu.uptc.pojo.InvoiceDetails;
import co.edu.uptc.pojo.Product;
import co.edu.uptc.presenter.MainContract;
import co.edu.uptc.view.adminBoard.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MyFrame extends JFrame implements MainContract.View {

    private MainContract.Presenter presenter;
    private DataClient dataClient;
    private InvoicePanel invoicePanel;
    private MyMenu myMenu;
    private Header header;
    private AdminBoard adminBoard;

    public MyFrame() {
        setSize(new Dimension(1200,800));
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        //setVisible(true);
    }

    private void initComponents(){
          createBody();
          adminBoard = new AdminBoard(this);
    }

    private void createBody(){
        myMenu = new MyMenu(this);
        header = new Header(this);
        dataClient = new DataClient(this);
        invoicePanel = new InvoicePanel(this);
        add(myMenu, BorderLayout.WEST);
        add(header, BorderLayout.NORTH);
        add(dataClient);
    }

    public void showBodyClient(){
        myMenu.setVisible(true);
        header.setVisible(true);
        dataClient.setVisible(true);
        invoicePanel.setVisible(false);
        add(dataClient);
    }

    public void showBodyInvoice(){
        myMenu.setVisible(true);
        header.setVisible(true);
        dataClient.setVisible(false);
        invoicePanel.setVisible(true);
        add(invoicePanel);
    }

    public void hideAdminBoard(){
        adminBoard.setVisible(false);
        this.setSize(new Dimension(1200,800));
        showBodyClient();
    }

    public void showAdminBoard(){
        adminBoard.setVisible(true);
        myMenu.setVisible(false);
        header.setVisible(false);
        dataClient.setVisible(false);
        invoicePanel.setVisible(false);
        this.setSize(new Dimension(600,400));
        add(adminBoard);
    }

    public void addClient(Client client){
        presenter.addClientInModel(client);
    }

    public void addProduct(Product product){
        presenter.addProductInModel(product);
    }
    public void addInvoice(Invoice invoice){
        presenter.addInvoice(invoice);
    }

    public Client searchClient(String idClient){
        return presenter.searchClient(idClient);
    }

    public boolean editClient(Client client){
        return presenter.editClient(client);
    }

    public Product searchProduct(String ciu){
        return presenter.searchProduct(ciu);
    }

    public void editProduct(Product pr) {
        presenter.editProduct(pr);
    }

    public void createInvoice(Client client){
        presenter.createInvoice(client);
    }

    public void addInvoiceDetails(InvoiceDetails detail){
        presenter.addInvoiceDetails(detail);
    }

    public List<InvoiceDetails> getDetails(){
        return presenter.getDetails();
    }

    public Invoice getInvoice(){
        return presenter.getInvoice();
    }

    public List<Invoice> getInvoices(){
        return presenter.getInvoices();
    }

    public void editInvoice(Client client, InvoiceDetails invoiceDetail){
        presenter.editInvoice(client,invoiceDetail);
    }

    public Invoice searchInvoice(int idInvoice){
        return presenter.searchInvoice(idInvoice);
    }

    public List<Client> getClients() {
        return presenter.getClient();
    }

    public void deleteSelectedCLients(){
        presenter.deleteSelectedClients();
    }
    public List<Product> getProducts(){
        return presenter.getProducts();
    }

    public List<String> getReferencedClients(){
        return presenter.showReferencedClients();
    }

    public void deleteClient(Client client){
        presenter.deleteClient(client);
    }

    public void deleteProduct(Product pr) {
        presenter.deleteProduct(pr);
    }

    public void deleteInvoice(Invoice inv) {
        presenter.deleteInvoice(inv);
    }

    @Override
    public void notifyError(String prompt) {
        JOptionPane.showMessageDialog(this,prompt,"Error",JOptionPane.ERROR_MESSAGE);
    }
    @Override
    public void notifySuccession(String prompt) {
        JOptionPane.showMessageDialog(this,prompt);
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void updateDetail() {
        invoicePanel.loadDetails();
    }

    @Override
    public void start() {
        this.setVisible(true);
    }

    public void setInvoiceInModel(Invoice invoice) {
        presenter.setInvoiceInModel(invoice);
    }
}
