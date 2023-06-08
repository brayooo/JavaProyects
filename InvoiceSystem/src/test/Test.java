package test;

import co.edu.uptc.model.*;
import co.edu.uptc.pojo.Client;
import co.edu.uptc.pojo.InvoiceDetails;
import co.edu.uptc.pojo.Product;

public class Test {

    ModelManager modelManager = new ModelManager();
    ManageClient manageClient = new ManageClient(modelManager);
    ManageProduct manageProduct = new ManageProduct(modelManager);
    ManageInvoices manageInvoices = new ManageInvoices(modelManager);
    ManageInvoice manageInvoice = new ManageInvoice(modelManager);
//
private void initInvoice(){
    Client client =  new Client(DocumentType.CITIZENSHIP_CARD, "5151","Bryan","lopez","cc55", "tunja");
    Invoice invoice = new Invoice(client);
    Product product = new Product("daaca22d2a2a","5555","manzasaa", 51);
    Product product1 = new Product("daaca22d2a2a","599","rrrrr", 1633);
    manageInvoice.setInvoice(invoice);
    InvoiceDetails invDet = new InvoiceDetails(product.getCIU(), product.getDescription(),
            product.getUnitPrice(), 1);
    manageInvoice.addDetail(invDet);
    manageInvoice.addDetail(new InvoiceDetails(product1.getCIU(), product1.getDescription(),
            product1.getUnitPrice(), 2));
    manageInvoices.addInvoice(invoice);
    System.out.println("--------------------------------------------------");
    manageInvoices.showList();
    Invoice invoice1 = new Invoice(client);
    manageInvoice.setInvoice(invoice1);
    manageInvoice.addDetail(new InvoiceDetails(product.getCIU(), product.getDescription(),
            product.getUnitPrice(), 1));
    manageInvoices.addInvoice(invoice1);
    System.out.println("--------------------------------------------------");
    manageInvoices.searchInvoice(0);

    InvoiceDetails invoiceDetails = new InvoiceDetails();
    invoiceDetails.setDescription("pera");
    invoiceDetails.setQuantity(4);
    Client client1 = new Client();
    client1.setIdNumber("558888");
    client1.setName("priaaaa");
    manageInvoices.editInvoice(client1,invoiceDetails);
    System.out.println("--------------------------------------------------");
    manageInvoices.showList();
}

    public Test(){
        initInvoice();

    }

//    public static void main(String[] args) {
//        new Test();
//    }

}
