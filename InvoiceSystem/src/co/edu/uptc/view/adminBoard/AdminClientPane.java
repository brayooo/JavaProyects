package co.edu.uptc.view.adminBoard;

import co.edu.uptc.pojo.Client;
import co.edu.uptc.view.components.MyButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;

public class AdminClientPane extends JPanel implements ActionListener {

    private JTextField textField;
    private JComboBox<Client> comboBox;
    private MyButton searchBt;
    private MyButton deleteBt;
    private MyButton editClient;
    private MyButton backBt;
    private MyButton deleteClients;
    private GridBagConstraints gbc;
    private EditClient editClientPanel;
    private AdminBoard adminBoard;
    private DialogDeleteClient dialogDeleteClient;
    private DialogDeleteAllClient dialogDeleteAllClient;
    public AdminClientPane(AdminBoard adminBoard){
        this.adminBoard = adminBoard;
        dialogDeleteClient = new DialogDeleteClient(this);
        dialogDeleteAllClient = new DialogDeleteAllClient(this);
        gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        initComponents();
        editClientPanel = new EditClient(this);
    }

    private void initComponents(){
        textField = new JTextField(20);
        textField.setText("Ingrese numero de identidad");
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(textField.getText().trim().equals("Ingrese numero de identidad"))
                    textField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(textField.getText().trim().equals(""))
                    textField.setText("Ingrese numero de identidad");
            }
        });
        comboBox = new JComboBox<>();
        comboBox.setPreferredSize(new Dimension(140,25));

        add(textField,gbc);
        addButtons(gbc);
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.insets = new Insets(0,0,0,0);
        add(comboBox,gbc);
    }

    private void addButtons(GridBagConstraints gbc){
        searchBt = new MyButton(new Color(68,65,65),"Buscar");
        deleteBt = new MyButton(new Color(68,65,65),"Borrar cliente");
        editClient = new MyButton(new Color(68,65,65),"Editar cliente");
        backBt = new MyButton(new Color(68,65,65),"Regresar");
        deleteClients = new MyButton(new Color(68,65,65),"Borrar todos los clientes");

        setInfoButtons(searchBt,"SRCH");
        setInfoButtons(deleteBt,"DEL");
        setInfoButtons(editClient, "EDIT");
        setInfoButtons(backBt,"BACK");
        setInfoButtons(deleteClients,"DELALL");
        deleteClients.setPreferredSize(new Dimension(161,40));

        gbc.gridx = 1;
        add(searchBt,gbc);
        gbc.gridy = 2;
        gbc.gridx = 1;
        gbc.insets = new Insets(10,0,0,0);
        add(deleteBt,gbc);
        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.insets = new Insets(10,0,0,0);
        add(deleteClients,gbc);
        gbc.gridy = 2;
        gbc.gridx = 2;
        gbc.insets = new Insets(10,0,0,50);
        add(editClient,gbc);
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.insets = new Insets(20,50,0,0);
        add(backBt,gbc);
    }
    private void setInfoButtons(MyButton button, String command){
        button.setRadius(20);
        button.setForeground(new Color(255,255,255));
        button.setPreferredSize(new Dimension(120,35));
        button.setBorderPainted(false);
        button.addActionListener(this);
        button.setActionCommand(command);
    }

    private void showEditClient(){
        this.setVisible(false);
        editClientPanel.setVisible(true);
        adminBoard.addClientEdit(editClientPanel);
    }

    private void showDeleteDialog(){
        dialogDeleteClient.setVisible(true);
    }

    private void showDeleteAllDialog(){
        dialogDeleteAllClient.setVisible(true);
    }

    public void hideEditClient(){
        editClientPanel.setVisible(false);
        adminBoard.showClientAdmin();
    }

    public Object getClientOfCombo(){
        if(comboBox.getSelectedItem()!=null){
            return comboBox.getSelectedItem();
        }else{
            return null;
        }
    }

    public void setClients(){
        if(textField.getText().equals("Ingrese numero de identidad")){
            for (Client cl: adminBoard.getClients()) {
                comboBox.addItem(cl);
            }
        }else {
            comboBox.addItem(adminBoard.getClient(textField.getText()));
        }
    }

    public boolean editClient(Client client){
       return adminBoard.editClient(client);
    }

    public void clearClients(){
        comboBox.removeAllItems();
    }

    public void deleteClient(){
        Client cl = (Client) getClientOfCombo();
        adminBoard.deleteClient(cl);
    }

    public List<String> getReferencedClients(){
        return adminBoard.getReferencedClients();
    }

    public void deleteSelectedClients(){
        adminBoard.deleteSelectedClients();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case "BACK":
                clearClients();
               adminBoard.hideClientPanel();
               break;
            case "SRCH":
                setClients();
                break;
            case "EDIT":
                showEditClient();
                editClientPanel.setClientField();
                break;
            case "DEL":
                showDeleteDialog();
                break;
            case "DELALL":
                showDeleteAllDialog();
                break;

        }
    }
}
