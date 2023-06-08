package co.edu.uptc.view.mainBoard;

import co.edu.uptc.model.DocumentType;
import co.edu.uptc.model.ListUptc;
import co.edu.uptc.pojo.Client;
import co.edu.uptc.view.components.MyButton;

import javax.swing.*;
import java.awt.*;

public class DataClient extends JPanel{

    private GridBagConstraints gbc;
    private JComboBox<DocumentType> documentTypeJComboBox;
    private ListUptc<JTextField> textFields;
    private ListUptc<JLabel> labels;
    private ListUptc<String> texts;

    private MyButton saveBt;
    private MyFrame myFrame;

    public DataClient(MyFrame myFrame){
        this.myFrame = myFrame;
        textFields = new ListUptc<>();
        labels = new ListUptc<>();
        texts = new ListUptc<>();
        setLayout(new GridBagLayout());
        initComponents();
        setBackground(new Color(173,216,230));
    }

    private void addTexts(){
        texts.add("Tipo de documento: ");
        texts.add("Numero de documento: ");
        texts.add("Nombres: ");
        texts.add("Apellidos:");
        texts.add("Direccion de residencia: ");
        texts.add("Ciduad de residencia: ");
    }

    private void initComponents(){
        addTexts();
        gbc = new GridBagConstraints();
        documentTypeJComboBox = new JComboBox<>(DocumentType.values());
        documentTypeJComboBox.setSize(new Dimension(140,25));
        gbc.gridx = 1;
        add(documentTypeJComboBox,gbc);
        saveBt = new MyButton(new Color(0,0,0),"Añadir");
        saveBt.setForeground(new Color(255,255,255));
        saveBt.setBorderPainted(false);
        saveBt.setRadius(10);
        saveBt.addActionListener(e -> {
            addClient();
        });
        initLabels(gbc);
        initFields(gbc);
        gbc.gridy = 7;
        gbc.insets = new Insets(10,0,0,80);
        add(saveBt,gbc);
    }

    private void initLabels(GridBagConstraints gbc){
        int inX = 0;
        for (int i = 0; i < texts.size(); i++) {
            gbc.gridx = inX;
            gbc.gridy = i;
            gbc.insets = new Insets(10,0,0,0);
            JLabel label = new JLabel();
            labels.add(label);
            labels.get(i).setText(texts.get(i));
            add(labels.get(i),gbc);
        }
    }

    private void initFields(GridBagConstraints gbc){
        int inAux = 1;
        for (int i = 1; i < texts.size(); i++) {
            gbc.gridy = i;
            gbc.gridx = inAux;
            gbc.insets = new Insets(10,0,0,0);
            JTextField textField = new JTextField();
            textFields.add(textField);
            textFields.get(i-1).setColumns(20);
            add(textFields.get(i-1),gbc);
        }
    }

    public Client getClient(){
        Client client = new Client();
        client.setDocumentType((DocumentType) documentTypeJComboBox.getSelectedItem());
        client.setIdNumber(textFields.get(0).getText());
        client.setName(textFields.get(1).getText());
        client.setLastName(textFields.get(2).getText());
        client.setAddress(textFields.get(3).getText());
        client.setCity(textFields.get(4).getText());
        return client;
    }

    public void addClient(){
        Client cl = getClient();
        myFrame.addClient(cl);
    }

}
