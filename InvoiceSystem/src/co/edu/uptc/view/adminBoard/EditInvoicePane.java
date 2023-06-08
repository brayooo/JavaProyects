package co.edu.uptc.view.adminBoard;

import co.edu.uptc.model.Invoice;
import co.edu.uptc.model.ListUptc;
import co.edu.uptc.pojo.Client;
import co.edu.uptc.pojo.InvoiceDetails;
import co.edu.uptc.view.components.MyButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class EditInvoicePane extends JPanel {
    private JTextField invoiceSelectedField;
    private JTextField clientNameField;
    private JTextField idClientField;
    private JTextField productDescriptionField;
    private JTextField quantityField;
    private JLabel invoiceSelectLbl;
    private JLabel clientNameLbl;
    private JLabel idClientLbl;
    private JLabel prodDescLbl;
    private JLabel quantityLbl;
    private JLabel productSelectLbl;
    private JComboBox<InvoiceDetails> invoiceDetailsJComboBox;
    private MyButton saveBt;
    private MyButton backButton;
    private AdminInvoicePane adminInvoicePane;

    public EditInvoicePane(AdminInvoicePane adminInvoicePane) {
        this.adminInvoicePane = adminInvoicePane;
        setLayout(null);
        initComponents();
    }

    private void initComponents() {
        invoiceDetailsJComboBox = new JComboBox<>();
        invoiceDetailsJComboBox.setBounds(220, 180, 250, 20);
        add(invoiceDetailsJComboBox);
        initFields();
        initLabels();
        initButtons();
    }

    private void initLabels() {
        invoiceSelectLbl = new JLabel("Factura seleccionada: ");
        invoiceSelectLbl.setBounds(10, 25, 150, 30);
        add(invoiceSelectLbl);

        clientNameLbl = new JLabel("Nombre cliente: ");
        clientNameLbl.setBounds(140, 70, 100, 30);
        add(clientNameLbl);

        idClientLbl = new JLabel("Id cliente: ");
        idClientLbl.setBounds(140, 100, 130, 30);
        add(idClientLbl);

        productSelectLbl = new JLabel("Seleccione el producto que desea editar: ");
        productSelectLbl.setBounds(140, 140, 250, 30);
        add(productSelectLbl);

        prodDescLbl = new JLabel("Descripcion: ");
        prodDescLbl.setBounds(140, 220, 150, 30);
        add(prodDescLbl);

        quantityLbl = new JLabel("Cantidad: ");
        quantityLbl.setBounds(140, 250, 120, 30);
        add(quantityLbl);
    }

    private void initFields() {
        invoiceSelectedField = new JTextField(25);
        invoiceSelectedField.setEditable(false);
        invoiceSelectedField.setBounds(145, 30, 200, 20);
        add(invoiceSelectedField);

        clientNameField = new JTextField(25);
        clientNameField.setBounds(250, 80, 150, 20);
        add(clientNameField);

        idClientField = new JTextField(25);
        idClientField.setBounds(250, 110, 150, 20);
        add(idClientField);

        productDescriptionField = new JTextField(25);
        productDescriptionField.setBounds(250, 230, 150, 20);
        add(productDescriptionField);

        quantityField = new JTextField(25);
        quantityField.setBounds(250, 259, 150, 20);
        add(quantityField);
    }

    private void initButtons() {
        saveBt = new MyButton(new Color(68, 65, 65), "Guardar cambios");
        setInfoButton(saveBt, "SAVE");
        saveBt.setBounds(170, 300, 135, 30);
        saveBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editInvoice();
                clearCombo();
            }
        });
        add(saveBt);

        backButton = new MyButton(new Color(68, 65, 65), "Volver");
        setInfoButton(backButton, "BCK");
        backButton.setBounds(335, 300, 80, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminInvoicePane.clearInvoices();
                adminInvoicePane.hideInvoiceEdit();
                clearCombo();
            }
        });
        add(backButton);
    }

    private void setInfoButton(MyButton myButton, String command) {
        myButton.setRadius(10);
        myButton.setForeground(new Color(255, 255, 255));
        myButton.setPreferredSize(new Dimension(150, 50));
        myButton.setBorderPainted(false);
    }

    public void setInvoiceField() {
        Invoice inv = (Invoice) adminInvoicePane.getInvoiceOfCombo();
        invoiceSelectedField.setText(inv.getInvoiceHeader() + " " + inv.getInvoiceFooter());
        invoiceSelectedField.setEditable(false);
    }

    public List<InvoiceDetails> getDetails() {
        Invoice inv = (Invoice) adminInvoicePane.getInvoiceOfCombo();
        if (inv != null) {
            return inv.getDetails();
        }
        return new ListUptc<InvoiceDetails>();
    }

    public void setComboDetails() {
        for (InvoiceDetails detail : getDetails()) {
            invoiceDetailsJComboBox.addItem(detail);
        }
    }

    public void clearCombo() {
        invoiceDetailsJComboBox.removeAllItems();
    }

    public InvoiceDetails getDetailCombo() {
        if (invoiceDetailsJComboBox.getSelectedItem() != null) {
            return (InvoiceDetails) invoiceDetailsJComboBox.getSelectedItem();
        }
        return null;
    }

    public void editInvoice() {
        Client cl = new Client();
        InvoiceDetails invDet = getDetailCombo();
        cl.setName(clientNameField.getText());
        cl.setIdNumber(idClientField.getText());
        invDet.setDescription(productDescriptionField.getText());
        invDet.setQuantity(Integer.parseInt(quantityField.getText()));
        adminInvoicePane.editInvoice(cl, invDet);
    }

}
