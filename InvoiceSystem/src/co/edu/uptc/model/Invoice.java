package co.edu.uptc.model;

import co.edu.uptc.pojo.*;

import java.util.Date;
import java.util.List;

public class Invoice {
    private InvoiceHeader invoiceHeader;
    private List<InvoiceDetails> details;
    private InvoiceFooter invoiceFooter;

    public Invoice(InvoiceHeader invoiceHeader, List<InvoiceDetails> details, InvoiceFooter invoiceFooter) {
        this.invoiceHeader = invoiceHeader;
        this.details = details;
        this.invoiceFooter = invoiceFooter;
    }

    public Invoice(InvoiceHeader invoiceHeader, ListUptc<InvoiceDetails> details) {
        this.invoiceHeader = invoiceHeader;
        this.details = details;
    }

    public Invoice() {

    }

    public Invoice(Client client){
        details = new ListUptc<>();
        setInvoiceHeader(client);
    }


    public void setInvoiceHeader(Client client){
        invoiceHeader = new InvoiceHeader(client.getName(),client.getIdNumber(),client.getDocumentType());
    }

    public void modifyHeader(Client client){
        invoiceHeader.setIdClient(client.getIdNumber());
        invoiceHeader.setClientName(client.getName());
    }

    protected void setInvoiceFooter(double valueProducts, double ivaProducts, double total){
        invoiceFooter = new InvoiceFooter(valueProducts,ivaProducts,total);
    }

    public void  manageDetail(InvoiceDetails detail){
        detail.setItemNumber(details.size());
        details.add(detail);
    }

    public int getInvoiceId(){
        return invoiceHeader.getInvoiceId();
    }
    public List<InvoiceDetails> getDetails() {
        return details;
    }

    public void setDetails(List<InvoiceDetails> details) {
        this.details = details;
    }

    public String getClientId(){
        return invoiceHeader.getIdClient();
    }
    public DocumentType getDocumentType(){
        return invoiceHeader.getDocumentType();
    }

    public InvoiceFooter getInvoiceFooter(){
        return invoiceFooter;
    }

    public InvoiceHeader getInvoiceHeader(){
        return invoiceHeader;
    }

    private String showDetails(){
        String aux = "";
        for (InvoiceDetails inDet: details) {
            aux += inDet.toString() + "\n";
        }
        return aux;
    }

    @Override
    public Invoice clone(){
        return new Invoice(invoiceHeader,details,invoiceFooter);
    }

    @Override
    public String toString() {
        return invoiceHeader  + " Prod: " + showDetails() + invoiceFooter;
    }
}
