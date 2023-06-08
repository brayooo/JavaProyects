package co.edu.uptc.view.adminBoard;

import co.edu.uptc.pojo.Client;
import co.edu.uptc.view.components.MyButton;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ShowClientsDialog extends JDialog {

    private JComboBox<String> comboBox;
    private DialogDeleteAllClient dialogDeleteAllClient;

    public ShowClientsDialog(DialogDeleteAllClient dialogDeleteAllClient){
        this.dialogDeleteAllClient = dialogDeleteAllClient;
        setLayout(null);
        initComponents();
        setSize(new Dimension(500,500));
        setVisible(false);
    }

    private void initComponents(){
        comboBox = new JComboBox<>();
        comboBox.setPreferredSize(new Dimension(150,25));
        comboBox.setBounds(50,50,150,25);
        add(comboBox);
    }

    public void setComboBox() {
        List<String> list = dialogDeleteAllClient.getReferencedClients();
        for (String client: list ) {
            comboBox.addItem(client);
        }
    }
}
