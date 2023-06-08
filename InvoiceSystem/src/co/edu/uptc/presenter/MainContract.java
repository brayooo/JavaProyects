package co.edu.uptc.presenter;

import co.edu.uptc.model.DocumentType;
import co.edu.uptc.model.Invoice;
import co.edu.uptc.pojo.Client;
import co.edu.uptc.pojo.InvoiceDetails;
import co.edu.uptc.pojo.Product;

import java.util.List;

public interface  MainContract {

    public interface Model{
        void setPresenter(Presenter presenter);
        void addClient(Client client);
        void deleteClient(Client client);
        boolean editClient(Client client);
        Client searchClient(String idClient);
        List<Client> getClients();
        void deleteSelectedClients();
        List<String> showReferencedClients();
        void addProduct(Product product);
        void deleteProduct(Product product);
        void editProduct(Product product);
        Product searchProduct(String ciu);
        List<Product> getProducts();
        void addInvoice(Invoice invoice);
        void addDetail(InvoiceDetails detail);
        void deleteInvoice(Invoice invoice);
        void editInvoice(Client client, InvoiceDetails invoiceDetail);
        void addInvoiceDetails(InvoiceDetails details);
        void createInvoice(Client client);
        void setInvoiceInModel(Invoice invoice);
        Invoice getInvoice();
        Invoice searchInvoice(int idInvoice);
        List<Invoice> getInvoices();
        List<InvoiceDetails> getDetails();
        void loadData();
    }

    public interface View{
        void notifyError(String prompt);
        void notifySuccession(String prompt);
        void setPresenter(Presenter presenter);
        void updateDetail();
        void start();
    }

    public interface Presenter{
        void setView(View view);
        void setModel(Model model);
        void notifyError(String prompt);
        void notifySuccession(String prompt);
        void addClientInModel(Client client);
        Client searchClient(String id);
        List<Client> getClient();
        void deleteClient(Client client);
        List<String> showReferencedClients();
        void deleteSelectedClients();
        boolean editClient(Client client);
        void addProductInModel(Product product);
        void deleteProduct(Product product);
        void editProduct(Product product);
        Product searchProduct(String ciu);
        List<Product> getProducts();
        void addInvoice(Invoice invoice);
        void deleteInvoice(Invoice invoice);
        void addInvoiceDetails(InvoiceDetails details);
        void editInvoice(Client client, InvoiceDetails invoiceDetail);
        void createInvoice(Client client);
        List<Invoice> getInvoices();
        List<InvoiceDetails> getDetails();
        Invoice getInvoice();
        Invoice searchInvoice(int idInvoice);
        void notifyUpdateDetail();
        void setInvoiceInModel(Invoice invoice);
    }




}
