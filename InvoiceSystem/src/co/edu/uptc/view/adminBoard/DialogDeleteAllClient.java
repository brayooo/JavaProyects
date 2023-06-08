package co.edu.uptc.view.adminBoard;

import co.edu.uptc.view.components.MyButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DialogDeleteAllClient extends JDialog{

    private JLabel image;
    private JLabel notice;
    private MyButton accept;
    private MyButton cancel;
    private AdminClientPane adminClientPane;
    private ShowClientsDialog showClientsDialog;

    public DialogDeleteAllClient(AdminClientPane adminClientPane){
        this.adminClientPane = adminClientPane;
        showClientsDialog = new ShowClientsDialog(this);
        setLayout(null);
        initComponents();
        setSize(new Dimension(400,200));
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(false);
    }

    private void initComponents() {
        image = new JLabel(new ImageIcon(new ImageIcon("src/resources/interrogation.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
        image.setBounds(50,50,30,30);
        add(image);

        notice = new JLabel("<html>¿Está seguro que desea eliminar<br><center>el producto?</center></html>");
        notice.setBounds(100,50,200,50);
        add(notice);
        addButtons();
    }

    private void addButtons () {
        accept = new MyButton(new Color(122, 175, 255), "Aceptar");
        accept.setBounds(100,100,85,25);
        accept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminClientPane.deleteSelectedClients();
                setVisible(false);
                showClientsDialog();
                showClientsDialog.setComboBox();
            }
        });
        add(accept);

        cancel = new MyButton(new Color(122, 175, 255), "Cancelar");
        cancel.setBounds(200,100,85,25);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                adminClientPane.clearClients();
            }
        });
        add(cancel);
    }

    public List<String> getReferencedClients(){
        return adminClientPane.getReferencedClients();
    }

    public void showClientsDialog(){
        showClientsDialog.setVisible(true);

    }
}

