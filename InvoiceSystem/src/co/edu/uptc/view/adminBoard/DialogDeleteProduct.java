package co.edu.uptc.view.adminBoard;

import co.edu.uptc.view.components.MyButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogDeleteProduct extends JDialog implements ActionListener {

    private JLabel image;
    private JLabel notice;
    private MyButton accept;
    private MyButton cancel;
    private GridBagConstraints gbc;
    private AdminProductPane adminProductPane;

    public DialogDeleteProduct(AdminProductPane adminProductPane){
        this.adminProductPane = adminProductPane;
        setLayout(new GridBagLayout());
        initComponents();
        setSize(new Dimension(400,200));
        setVisible(false);
    }

    private void initComponents(){
        gbc = new GridBagConstraints();
        image = new JLabel(new ImageIcon(new ImageIcon("src/resources/interrogation.png").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH)));
        notice = new JLabel("¿Esta seguro que desea eliminar el producto");
        accept = new MyButton(new Color(122,175,255),"Aceptar");
        accept.setActionCommand("ACPT");
        accept.addActionListener(this);
        cancel = new MyButton(new Color(122,175,255),"Cancelar");
        cancel.setActionCommand("CNL");
        cancel.addActionListener(this);

        add(image,gbc);
        gbc.gridx = 1;
        add(notice,gbc);
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.insets = new Insets(10,50,0,0);
        add(accept,gbc);
        gbc.gridx = 1;
        gbc.insets = new Insets(10,0,0,0);
        add(cancel,gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("ACPT")){
            adminProductPane.deleteProduct();
            setVisible(false);
        }else if(e.getActionCommand().equals("CNL")){
            setVisible(false);
            adminProductPane.clearCombo();
        }
    }

}

