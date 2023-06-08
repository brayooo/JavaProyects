package co.edu.uptc.view.adminBoard;

import co.edu.uptc.model.DocumentType;
import co.edu.uptc.pojo.Client;
import co.edu.uptc.view.components.MyButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditClient extends JPanel implements ActionListener {

    private JComboBox<DocumentType> typeDocuments;
    private JLabel client;
    private JTextField selectedClient;
    private JTextField documentNumber;
    private MyButton saveDocumentBt;
    private MyButton documentNumberBt;
    private MyButton bckButton;
    private AdminClientPane adminClientPane;

    public EditClient(AdminClientPane adminClientPane){
        this.adminClientPane = adminClientPane;
        setLayout(null);
        initComponents();
    }

    private void initComponents(){
        client = new JLabel("Cliente seleccionado: ");
        client.setBounds(50,40,150,50);
        add(client);
        addTextFields();
        typeDocuments = new JComboBox<>(DocumentType.values());
        typeDocuments.setBounds(150,130,100,30);
        add(typeDocuments);
        addButtons();
    }

    private void addTextFields(){
        selectedClient = new JTextField(25);
        selectedClient.setEditable(false);
        selectedClient.setBounds(200,50,200,25);
        add(selectedClient);

        documentNumber = new JTextField(15);
        documentNumber.setBounds(150,200,150,25);
        add(documentNumber);
    }

    private void addButtons(){
        saveDocumentBt = new MyButton(new Color(68,65,65),"Guardar");
        setInfoButton(saveDocumentBt,"SAVEDOC");
        saveDocumentBt.setBounds(350,130,100,30);
        add(saveDocumentBt);

        documentNumberBt = new MyButton(new Color(68,65,65),"Guardar");
        setInfoButton(documentNumberBt,"SAVEID");
        documentNumberBt.setBounds(350,200,100,30);
        add(documentNumberBt);

        bckButton = new MyButton(new Color(68,65,65),"Regresar");
        setInfoButton(bckButton,"BCK");
        bckButton.setBounds(230,280,150,30);
        add(bckButton);
    }
    private void setInfoButton(MyButton myButton, String command){
        myButton.setForeground(Color.WHITE);
        myButton.setRadius(10);
        myButton.setActionCommand(command);
        myButton.addActionListener(this);
        myButton.setOpaque(false);
    }

    public void setClientField(){
        Client cl = (Client) adminClientPane.getClientOfCombo();
        selectedClient.setText(cl.getDocumentType().getTypeDocument() + " " + cl.getIdNumber() + " " + cl.getName());
    }

    public void editClient(){
        Client cl = (Client) adminClientPane.getClientOfCombo();
        DocumentType dc = (DocumentType) typeDocuments.getSelectedItem();
        if(adminClientPane.editClient(cl)){
            cl.setDocumentType(dc);
            cl.setIdNumber(documentNumber.getText());
            adminClientPane.editClient(cl);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case "SAVEDOC":
                break;
            case "SAVEID":
                editClient();
                break;
            case "BCK":
                adminClientPane.clearClients();
                adminClientPane.hideEditClient();
                break;
        }
    }
}
