package co.edu.uptc.pojo;

import co.edu.uptc.model.DocumentType;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InvoiceHeader {

    private static int counter = 0;
    private int invoiceId;
    private String invoiceDate;
    private String clientName;
    private String idClient;
    private DocumentType documentType;

    public InvoiceHeader(String clientName, String idClient, DocumentType documentType) {
        formatDate();
        this.clientName = clientName;
        this.idClient = idClient;
        this.documentType = documentType;
        this.invoiceId = counter++;
    }

    public void formatDate(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        invoiceDate = formatter.format(date);
    }
    public DocumentType getDocumentType(){return documentType;}
    public int getInvoiceId() {
        return invoiceId;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public String getIdClient() {
        return idClient;
    }

    public String getClientName() {
        return clientName;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    public void setDocumentType(DocumentType documentType){this.documentType = documentType;}

    @Override
    public String toString() {
        return "IdFactura: " + invoiceId + " date: " +invoiceDate+ " Name: " + clientName + " ClientId: " + idClient;
    }
}

