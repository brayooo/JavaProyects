package co.edu.uptc.model;

import co.edu.uptc.pojo.Client;
import co.edu.uptc.pojo.InvoiceDetails;

import java.util.ArrayList;
import java.util.List;

public class ManageInvoice {
    private Invoice invoice;
    private ModelManager modelManager;
    private double subTotal;
    private double ivaTotal;
    private static final double IVA = 0.19;

    public ManageInvoice(ModelManager modelManager){
        this.modelManager = modelManager;
    }

    public void createInvoice(Client client){
        this.invoice = new Invoice(client);
        setInfoFooter();
    }

    public void addDetail(InvoiceDetails detail){
        detail.setQuantityValue(detail.getUnitValue()*detail.getQuantity());
        invoice.manageDetail(detail);
        setInfoFooter();
        modelManager.presenter.notifyUpdateDetail();
    }

    public void setInfoFooter(){
        invoice.setInvoiceFooter(calculateSubTotal(),calculateIva(),totalPayment());
    }

    public double calculateSubTotal(){
        subTotal = 0;
        List<InvoiceDetails> listAux = invoice.getDetails();
        for (InvoiceDetails products: listAux) {
            subTotal += products.getQuantityValue();
        }
        return subTotal;
    }

    public double calculateIva( ){
        ivaTotal = subTotal * IVA;
        return ivaTotal;
    }

    public double totalPayment(){
        return subTotal + ivaTotal;
    }

    public List<InvoiceDetails> getDetails(){
        ArrayList<InvoiceDetails> auxList = new ArrayList<>();
        for (InvoiceDetails details: invoice.getDetails()) {
            auxList.add(details.clone());
        }
        return auxList;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
