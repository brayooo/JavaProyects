package co.edu.uptc.model;

import co.edu.uptc.pojo.Client;
import co.edu.uptc.pojo.InvoiceDetails;
import co.edu.uptc.pojo.Product;
import co.edu.uptc.presenter.MainContract;

import java.util.List;

public class ModelManager implements MainContract.Model {

    public  MainContract.Presenter presenter;
    private ManageProduct manageProduct;
    private ManageClient manageClient;
    private ManageInvoices manageInvoices;
    private ManageInvoice manageInvoice;

    public ModelManager(){
        manageClient = new ManageClient(this);
        manageProduct = new ManageProduct(this);
        manageInvoices = new ManageInvoices(this);
        manageInvoice = new ManageInvoice(this);
    }

    public void loadData(){
        Client client =  new Client(DocumentType.CITIZENSHIP_CARD, "5151","Bryan","lopez","cra 039", "tunja");
        Client client1 = new Client(DocumentType.PASSPORT, "1587441","Carlos","martinez","Cra 594", "tunja");
        Product product = new Product("d4aca22d2a2ad","5555","manzana", 5100);
        Product product1 = new Product("daaca22d2a2a","5999","Pera", 1633);
        manageClient.addClient(client);
        manageClient.addClient(client1);
        manageProduct.addProduct(product);
        manageProduct.addProduct(product1);
    }
    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void addClient(Client client) {
          manageClient.addClient(client);
    }

    @Override
    public void deleteClient(Client client) {
        manageClient.deleteClient(client);
    }

    @Override
    public boolean editClient(Client client) {
        return manageClient.editClient(client);
    }

    @Override
    public Client searchClient(String idClient) {
       return manageClient.searchClient(idClient);
    }

    @Override
    public List<Client> getClients() {
        return manageClient.getClients();
    }

    @Override
    public void deleteSelectedClients() {
        manageClient.deleteSelectedClients();
    }

    @Override
    public List<String> showReferencedClients() {
        return manageClient.showReferencedClients();
    }

    @Override
    public void addProduct(Product product) {
        manageProduct.addProduct(product);
    }

    @Override
    public void deleteProduct(Product product) {
        manageProduct.deleteProduct(product);
    }

    @Override
    public void editProduct(Product product) {
        manageProduct.editProduct(product);
    }

    @Override
    public Product searchProduct(String ciu) {
        return manageProduct.searchProduct(ciu);
    }

    @Override
    public List<Product> getProducts() {
        return manageProduct.getProducts();
    }

    @Override
    public void addInvoice(Invoice invoice) {
        manageInvoices.addInvoice(invoice);
    }

    @Override
    public void addDetail(InvoiceDetails detail) {
        manageInvoice.addDetail(detail);
    }

    @Override
    public void deleteInvoice(Invoice invoice) {
        manageInvoices.deleteInvoice(invoice);
    }

    @Override
    public void editInvoice(Client client, InvoiceDetails invoiceDetail) {
        manageInvoices.editInvoice(client, invoiceDetail);
    }

    @Override
    public void addInvoiceDetails(InvoiceDetails details) {
        manageInvoice.addDetail(details);
    }

    @Override
    public void createInvoice(Client client) {
        manageInvoice.createInvoice(client);
    }

    @Override
    public void setInvoiceInModel(Invoice invoice) {
        manageInvoice.setInvoice(invoice);
    }

    @Override
    public Invoice getInvoice() {
        return manageInvoice.getInvoice();
    }

    @Override
    public Invoice searchInvoice(int idInvoice) {
        return manageInvoices.searchInvoice(idInvoice);
    }

    @Override
    public List<Invoice> getInvoices() {
        return manageInvoices.getInvoices();
    }

    @Override
    public List<InvoiceDetails> getDetails() {
        return manageInvoice.getDetails();
    }

}
