package co.edu.uptc.model;

import co.edu.uptc.pojo.Client;
import co.edu.uptc.pojo.InvoiceDetails;
import co.edu.uptc.pojo.Product;

import java.util.List;

public class ValidateRules {
    private List<Client> clients;
    private List<Product> products;
    private List<Invoice> invoices;
    private static ValidateRules instance;

    private ValidateRules() {

    }

    public static ValidateRules getInstance() {
        if (instance == null) {
            instance = new ValidateRules();
        }
        return instance;
    }

    public boolean editProduct(Product product) {
        if (invoices != null) {
            for (Invoice invoice : invoices) {
                for (InvoiceDetails details : invoice.getDetails()) {
                    if (details.getProductCode().equals(product.getCIU())) {
                        details.setProductCode(product.getCIU());
                        details.setDescription(product.getDescription());
                        details.setUnitValue(product.getUnitPrice());
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean deleteProduct(Product product) {
        if (invoices != null) {
            for (Invoice invoice : invoices) {
                for (InvoiceDetails details : invoice.getDetails()) {
                    if (details.getProductCode().equals(product.getCIU())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean editClient(Client client) {
        if (invoices != null) {
            for (Invoice invoice : invoices) {
                if (invoice.getClientId().equals(client.getIdNumber()) &&
                        invoice.getDocumentType().equals(client.getDocumentType())) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<Client> deleteAllClients() {
        ListUptc<Client> clientsAux = new ListUptc<>();
        if (invoices.size() > 0) {
            for (int i = 0; i < invoices.size(); i++) {
                if (!(invoices.get(i).getClientId().equals(clients.get(i).getIdNumber()))) {
                    clientsAux.add(clients.get(i));
                }
            }
//            for (Invoice inv : invoices) {
//                for (Client client : clients) {
//                    if (!(inv.getClientId().equals(client.getIdNumber()))) {
//                        clientsAux.add(client);
//                    }
//                }
//            }
        }else {
            clientsAux.addAll(clients);
            return clientsAux;
        }
        return clientsAux;
    }

    public List<String> countReferencedInvoices() {
        List<String> list = new ListUptc<>();
        int count = 1;
        if (invoices != null) {
            for (Invoice invoice : invoices) {
                for (Client client: clients) {
                    if (invoice.getClientId().equals(client.getIdNumber()) &&
                            invoice.getDocumentType().equals(client.getDocumentType())) {
                        list.add(client + String.valueOf(count));
                        count++;
                    }
                }
            }
        }
        return list;
    }

    public boolean deleteClient(Client client) {
        if (invoices != null) {
            for (Invoice invoice : invoices) {
                if (invoice.getClientId().equals(client.getIdNumber())) {
                    return false;
                }
            }
        }
        return true;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

}
