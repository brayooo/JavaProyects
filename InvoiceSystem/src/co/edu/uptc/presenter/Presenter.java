package co.edu.uptc.presenter;

import co.edu.uptc.model.DocumentType;
import co.edu.uptc.model.Invoice;
import co.edu.uptc.pojo.Client;
import co.edu.uptc.pojo.InvoiceDetails;
import co.edu.uptc.pojo.Product;

import java.util.List;

public class Presenter implements MainContract.Presenter{
    private MainContract.Model model;
    private MainContract.View view;

    @Override
    public void setView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void setModel(MainContract.Model model) {
        this.model = model;
    }

    @Override
    public void notifyError(String prompt) {
        view.notifyError(prompt);
    }

    @Override
    public void notifySuccession(String prompt) {
        view.notifySuccession(prompt);
    }

    @Override
    public void addClientInModel(Client client) {
        model.addClient(client);
    }

    @Override
    public void addProductInModel(Product product) {
        model.addProduct(product);
    }

    @Override
    public Client searchClient(String id) {
        return model.searchClient(id);
    }

    @Override
    public List<Client> getClient() {
        return model.getClients();
    }

    @Override
    public void deleteClient(Client client) {
        model.deleteClient(client);
    }

    @Override
    public List<String> showReferencedClients() {
        return model.showReferencedClients();
    }

    @Override
    public void deleteSelectedClients() {
        model.deleteSelectedClients();
    }

    @Override
    public boolean editClient(Client client) {
        return model.editClient(client);
    }

    @Override
    public void deleteProduct(Product product) {
        model.deleteProduct(product);
    }
    @Override
    public void editProduct(Product pr) {
        model.editProduct(pr);
    }

    @Override
    public Product searchProduct(String ciu) {
        return model.searchProduct(ciu);
    }

    @Override
    public List<Product> getProducts() {
        return model.getProducts();
    }

    @Override
    public void addInvoice(Invoice invoice) {
        model.addInvoice(invoice);
    }

    @Override
    public void deleteInvoice(Invoice invoice) {
        model.deleteInvoice(invoice);
    }
    @Override
    public void addInvoiceDetails(InvoiceDetails details) {
        model.addInvoiceDetails(details);
    }

    @Override
    public void editInvoice(Client client, InvoiceDetails invoiceDetail) {
        model.editInvoice(client,invoiceDetail);
    }

    @Override
    public void createInvoice(Client client) {
       model.createInvoice(client);
    }

    @Override
    public List<Invoice> getInvoices() {
        return model.getInvoices();
    }

    @Override
    public List<InvoiceDetails> getDetails() {
        return model.getDetails();
    }

    @Override
    public Invoice getInvoice() {
        return model.getInvoice();
    }

    @Override
    public Invoice searchInvoice(int idInvoice) {
        return model.searchInvoice(idInvoice);
    }

    @Override
    public void notifyUpdateDetail() {
        view.updateDetail();
    }

    @Override
    public void setInvoiceInModel(Invoice invoice) {
        model.setInvoiceInModel(invoice);
    }
}
