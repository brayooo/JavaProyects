package co.edu.uptc.view.adminBoard;

import co.edu.uptc.model.Invoice;
import co.edu.uptc.pojo.Client;
import co.edu.uptc.pojo.InvoiceDetails;
import co.edu.uptc.view.components.MyButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;

public class AdminInvoicePane extends JPanel implements ActionListener {

    private JTextField textField;
    private JComboBox<Invoice> comboBox;
    private MyButton searchBt;
    private MyButton deleteBt;
    private MyButton editInvoice;
    private MyButton backBt;
    private AdminBoard adminBoard;
    private EditInvoicePane editInvoicePane;
    private DialogDeleteInvoice dialogDeleteInvoice;

    public AdminInvoicePane(AdminBoard adminBoard) {
        this.adminBoard = adminBoard;
        initComponents();
        setLayout(null);
        dialogDeleteInvoice = new DialogDeleteInvoice(this);
        editInvoicePane = new EditInvoicePane(this);
    }

    private void initComponents() {
        comboBox = new JComboBox<>();
        comboBox.setBounds(150,150,450,30);
        JScrollPane scrollPane = new JScrollPane(comboBox);
        scrollPane.setBounds(150,150,370,41);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        add(scrollPane);
        initField();
        addButtons();
    }


    private void initField(){
        textField = new JTextField(25);
        textField.setText("Ingrese numero de factura");
        textField.setBounds(150,50,200,30);
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().trim().equals("Ingrese numero de factura"))
                    textField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().trim().equals(""))
                    textField.setText("Ingrese numero de factura");
            }
        });
        add(textField);
    }

    private void addButtons() {
        searchBt = new MyButton(new Color(68, 65, 65), "Buscar");
        setInfoButtons(searchBt, "SRCH");
        searchBt.setBounds(380,50,100,30);
        add(searchBt);

        deleteBt = new MyButton(new Color(68, 65, 65), "Borrar factura");
        setInfoButtons(deleteBt, "DEL");
        deleteBt.setBounds(320,230,150,30);
        add(deleteBt);

        editInvoice = new MyButton(new Color(68, 65, 65), "Editar factura");
        setInfoButtons(editInvoice, "EDIT");
        editInvoice.setBounds(150,230,150,30);
        add(editInvoice);

        backBt = new MyButton(new Color(68, 65, 65), "Regresar");
        setInfoButtons(backBt, "BACK");
        backBt.setBounds(230,280,130,30);
        add(backBt);
    }

    private void setInfoButtons(MyButton button, String command) {
        button.setRadius(20);
        button.setForeground(new Color(255, 255, 255));
        button.setPreferredSize(new Dimension(130, 50));
        button.setBorderPainted(false);
        button.setActionCommand(command);
        button.addActionListener(this);
    }

    private void showEditInvPane(){
        editInvoicePane.setVisible(true);
        this.setVisible(false);
        adminBoard.addInvoiceEdit(editInvoicePane);
    }

    public void hideInvoiceEdit(){
        editInvoicePane.setVisible(false);
        adminBoard.showInvoiceAdmin();
    }

    private void showDeleteDialog(){
        dialogDeleteInvoice.setVisible(true);
    }

    public Invoice searchInvoice(int idInvoice){
        return adminBoard.searchInvoice(idInvoice);
    }

    public void setInvoices(){
        if(textField.getText().equals("Ingrese numero de factura")){
            for (Invoice inv: adminBoard.getInvoices() ) {
                System.out.println("combooooo: " + inv);
                comboBox.addItem(inv);
            }
        }else {
            comboBox.addItem(searchInvoice(Integer.parseInt(textField.getText())));
        }
    }

    public Object getInvoiceOfCombo(){
        return comboBox.getSelectedItem();
    }
    public void clearInvoices(){
        comboBox.removeAllItems();
    }

    public void deleteInvoice() {
        Invoice inv = (Invoice) getInvoiceOfCombo();
        adminBoard.deleteInvoice(inv);
    }

    public void editInvoice(Client client, InvoiceDetails details){
        adminBoard.editInvoice(client, details);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "SRCH":
                setInvoices();
                break;
            case "BACK":
                clearInvoices();
                adminBoard.hideInvoicePanel();
                break;
            case "EDIT":
                showEditInvPane();
                editInvoicePane.setInvoiceField();
                editInvoicePane.setComboDetails();
                break;
            case "DEL":
                showDeleteDialog();
                break;
        }
    }
}
