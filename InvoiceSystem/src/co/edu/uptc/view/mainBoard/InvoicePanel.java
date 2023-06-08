package co.edu.uptc.view.mainBoard;

import co.edu.uptc.model.Invoice;
import co.edu.uptc.pojo.Client;
import co.edu.uptc.pojo.InvoiceDetails;
import co.edu.uptc.pojo.Product;
import co.edu.uptc.view.components.MyButton;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;

public class InvoicePanel extends JPanel implements ActionListener {

    private JTextField idClientFld;
    private JTextField codeProductFld;
    private JTextField productQtyFld;
    private MyButton searchIdBt;
    private MyButton searchProductBt;
    private MyButton registerPrBt;
    private MyButton closeInvBt;
    private JLabel infoClient;
    private JLabel date;
    private JLabel productSelected;
    private JLabel subTotal;
    private JLabel iva;
    private JLabel total;
    private JTable table;
    private MyFrame myFrame;
    private Invoice invoice;
    private Client client;
    private Product product;
    private InvoiceDetails invoiceDetails;


    public InvoicePanel(MyFrame myFrame) {
        this.myFrame = myFrame;
        setLayout(null);
        initComponents();
        setBackground(new Color(173,216,230));
    }
    private void initComponents() {
        initFields();
        initButtons();
        createTable();
        initLabels();
    }

    private void initLabels(){
        date = new JLabel();
        date.setBounds(150,50,100,25);
        add(date);

        infoClient = new JLabel();
        infoClient.setBounds(150,150,200,25);
        add(infoClient);

        productSelected = new JLabel();
        productSelected.setBounds(150,250,150,25);
        add(productSelected);

        JLabel aux = new JLabel("Subtotal: ");
        aux.setBounds(150,530,100,25);
        add(aux);
        subTotal = new JLabel("");
        subTotal.setBounds(210,530,100,25);
        add(subTotal);

        JLabel aux1 = new JLabel("Iva: ");
        aux1.setBounds(150,550,100,25);
        add(aux1);
        iva = new JLabel("");
        iva.setBounds(190,550,100,25);
        add(iva);

        JLabel aux2 = new JLabel("Total: ");
        aux2.setBounds(150,570,100,25);
        add(aux2);
        total = new JLabel("");
        total.setBounds(190,570,100,25);
        add(total);
    }

    private void initFields(){
        idClientFld = createFields("Ingrese el documento de la persona");
        idClientFld.setBounds(150,120,200,25);
        add(idClientFld);

        codeProductFld = createFields("Ingrese codigo del producto");
        codeProductFld.setBounds(150,200,200,25);
        add(codeProductFld);

        productQtyFld = createFields("Ingrese cantidad del producto");
        productQtyFld.setText("1");
        productQtyFld.setEditable(false);
        productQtyFld.setBounds(400,200,200,25);
        add(productQtyFld);
    }

    private JTextField createFields(String text){
        JTextField field = new JTextField(20);
        field.setText(text);
        field.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(field.getText().trim().equals(text))
                    field.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(field.getText().trim().equals(""))
                    field.setText(text);
            }
        });
        return field;
    }

    private void initButtons(){
        searchIdBt = createButtons("Buscar", "SEARCHID");
        searchIdBt.setBounds(500,120,150,30);
        add(searchIdBt);

        searchProductBt = createButtons("Buscar","SEARCHPR");
        searchProductBt.setBounds(750,200,150,30);
        add(searchProductBt);

        registerPrBt = createButtons("Registrar producto","REGISPR");
        registerPrBt.setBounds(800,350,150,30);
        add(registerPrBt);

        closeInvBt = createButtons("Cerrar factura","CLOSEIN");
        closeInvBt.setBounds(800,400,150,30);
        add(closeInvBt);
    }

    private MyButton createButtons( String text, String command){
        MyButton myButton = new MyButton(new Color(35,35,35),text);
        myButton.setRadius(20);
        myButton.setForeground(new Color(255,255,255));
        myButton.setBorderPainted(false);
        myButton.setFocusPainted(false);
        myButton.setActionCommand(command);
        myButton.addActionListener(this);
        return myButton;
    }

    private void createTable(){
        table = new JTable(0,6);
        tableHeader(table.getTableHeader());
        table.getTableHeader().setFont(new Font("SansSerif",Font.PLAIN,10));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(150,300,600,200);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setPreferredSize(table.getPreferredSize());
        add(scrollPane);
    }

    private void tableHeader(JTableHeader header) {
        header.getColumnModel().getColumn(0).setHeaderValue("Número de item") ;
        header.getColumnModel().getColumn(1).setHeaderValue("Código Producto");
        header.getColumnModel().getColumn(2).setHeaderValue("Valor unitario");
        header.getColumnModel().getColumn(3).setHeaderValue("Descripción") ;
        header.getColumnModel().getColumn(4).setHeaderValue("Cantidad") ;
        header.getColumnModel().getColumn(5).setHeaderValue("Valor x cantidad");
        header.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    private void clearTable(){
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.getDataVector().removeAllElements();
    }

    protected void loadDetails() {
        clearTable();
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        List<InvoiceDetails> auxList = myFrame.getDetails();
        System.out.println(auxList);
        for (InvoiceDetails details : auxList) {
            tableModel.addRow(new Object[]{details.getItemNumber(),details.getProductCode(), details.getDescription(),
            details.getUnitValue(),details.getQuantity(),details.getQuantityValue()});
        }
        table.setModel(tableModel);
    }

    private void clearAll(){
        idClientFld.removeAll();
        codeProductFld.removeAll();
        productQtyFld.removeAll();
        productQtyFld.setEditable(false);
        productQtyFld.setText("1");
        infoClient.removeAll();
        productSelected.removeAll();
    }

    public Invoice createInvoice(){
        Client cl = getClient();
        invoice = new Invoice(cl);
        return invoice;
    }

    public void setInvoice(){
        myFrame.setInvoiceInModel(createInvoice());
    }

    public Client getClient(){
        client = myFrame.searchClient(idClientFld.getText());
        return client;
    }

    private void setDate(){
        date.setText(invoice.getInvoiceHeader().getInvoiceDate());
    }
    private void setClientInfo(){
        setDate();
        infoClient.setText(client.getDocumentType() + " " + client.getIdNumber());
    }

    private void setProductInfo(){
        productSelected.setText(product.getCIU() + " " + product.getDescription());
    }

    private void setFooterInfo(){
        subTotal.setText(String.valueOf(myFrame.getInvoice().getInvoiceFooter().getValueProducts()));
        iva.setText(String.valueOf(myFrame.getInvoice().getInvoiceFooter().getValueIva()));
        total.setText(String.valueOf(myFrame.getInvoice().getInvoiceFooter().getTotalPay()));
    }

    private void searchProduct(){
        this.product = myFrame.searchProduct(codeProductFld.getText());
    }


    private void addDetail(){
        this.invoiceDetails = new InvoiceDetails(product.getCIU(),product.getDescription(),
                product.getUnitPrice(),Integer.parseInt(productQtyFld.getText()));
        myFrame.addInvoiceDetails(invoiceDetails);
        System.out.println("----ADD detalles-----" + invoiceDetails);
    }

    public void addInvoice(){
        myFrame.addInvoice(myFrame.getInvoice());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case "SEARCHID":
                getClient();
                setInvoice();
                setClientInfo();
                break;
            case "SEARCHPR":
                searchProduct();
                setProductInfo();
                productQtyFld.setEditable(true);
                break;
            case "REGISPR":
                addDetail();
                setFooterInfo();
                break;
            case "CLOSEIN":
                addInvoice();
                clearTable();
                clearAll();
                break;
        }
    }

}
