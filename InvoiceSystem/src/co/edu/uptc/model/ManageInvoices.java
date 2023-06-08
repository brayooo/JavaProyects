package co.edu.uptc.model;

import co.edu.uptc.pojo.Client;
import co.edu.uptc.pojo.InvoiceDetails;

import java.util.ArrayList;
import java.util.List;

public class ManageInvoices {

    private List<Invoice> invoices;
    private ModelManager modelManager;
    private Invoice selectedInvoice;


    public ManageInvoices(ModelManager modelManager) {
        this.modelManager = modelManager;
        invoices = new ListUptc<>();
        ValidateRules.getInstance().setInvoices(invoices);
    }

    public void addInvoice(Invoice invoice) {
        if (searchInvoice(invoice.getInvoiceId()) != null) {
            modelManager.presenter.notifyError("No se puede agregar, la factura ya existe");
        } else {
            invoices.add(invoice.clone());
            modelManager.presenter.notifySuccession("Factura generada con exito ¡vuelva pronto!");
            System.out.println("Invoice modelo anadida:");showList();
        }
    }

    public Invoice searchInvoice(int id) {
        for (Invoice inv : invoices) {
            if (inv.getInvoiceId() == id) {
                this.selectedInvoice = inv;
                return inv;
            }
        }
        return null;
    }

    public void deleteInvoice(Invoice invoice) {
        if (invoices != null) {
            Invoice inv = searchInvoice(invoice.getInvoiceId());
            invoices.remove(inv);
        }
    }

    public void editInvoice(Client client, InvoiceDetails invoiceDetail) {
        if (invoices != null) {
            for (Invoice invoiceAux : invoices) {
                if (invoiceAux.getInvoiceId() == selectedInvoice.getInvoiceId()) {
                    selectedInvoice.modifyHeader(client);
                    editDetail(invoiceDetail,invoiceDetail.getDescription(),invoiceDetail.getQuantity());
                }
            }
        }
        System.out.println("-----------Despues de editar---------------------");
        showList();
    }

    public InvoiceDetails searchDetail(int productItem){
        for (InvoiceDetails invDet: searchInvoice(selectedInvoice.getInvoiceId()).getDetails()) {
            if(invDet.getItemNumber()==productItem){
                return invDet;
            }
        }
        return null;
    }

    public InvoiceDetails editInvoiceDetail(InvoiceDetails details, String desc, int quantity){
        InvoiceDetails invoiceDetails = searchDetail(details.getItemNumber());
        invoiceDetails.setDescription(desc);
        invoiceDetails.setQuantity(quantity);
        return invoiceDetails;
    }

    public void editDetail(InvoiceDetails invoiceDetail, String desc, int quantity){
        List<InvoiceDetails> newList = new ListUptc<>();
        for (InvoiceDetails det:selectedInvoice.getDetails() ) {
            if(det.getItemNumber()==invoiceDetail.getItemNumber()){
                newList.add(editInvoiceDetail(invoiceDetail,desc,quantity));
            }else {
                newList.add(det);
            }
        }
        selectedInvoice.setDetails(newList);
    }

    public List<Invoice> getInvoices() {
        ArrayList<Invoice> auxList = new ArrayList<>();
        for (Invoice inv : invoices) {
            auxList.add(inv.clone());
        }
        return auxList;
    }

    public void showList() {
        for (Invoice inv : invoices) {
            System.out.println(inv);
        }
    }

}
