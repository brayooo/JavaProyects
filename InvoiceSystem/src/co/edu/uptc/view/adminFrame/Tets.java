package co.edu.uptc.view.adminFrame;

import javax.swing.*;

public class Tets extends JPanel {

    private JLabel label1 = new JLabel("aaaa");
    private JLabel label2 = new JLabel("aaaa");
    private JLabel label3 = new JLabel("aaaa");
    private JLabel label4 = new JLabel("aaaa");
    private JLabel label5 = new JLabel("aaaa");
    private JTextField textField1 = new JTextField(10);
    private JTextField textField2 = new JTextField(10);
    private JTextField textField3 = new JTextField(10);
    private JTextField textField4 = new JTextField(10);
    private JTextField textField5 = new JTextField(10);
    private JButton button = new JButton("ddasd");

    public Tets(){
        initComponents();
    }

    private void initComponents() {
        GroupLayout layout = new GroupLayout(this);
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(label1)
                .addComponent(label2)
                .addComponent(label3)
                .addComponent(label4)
                .addComponent(label5));
        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(textField1)
                .addComponent(textField2)
                .addComponent(textField3)
                .addComponent(textField4)
                .addComponent(textField5));

// Agrega el botón al grupo horizontal y lo centra
        hGroup.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED);
        hGroup.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
        hGroup.addGap(0, 0, Short.MAX_VALUE);
        hGroup.addComponent(button);
        hGroup.addGap(0, 0, Short.MAX_VALUE);

// Establece el grupo horizontal como el grupo para el eje horizontal del diseño
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(label1)
                                        .addComponent(label2)
                                        .addComponent(label3)
                                        .addComponent(label4)
                                        .addComponent(label5))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(textField1)
                                        .addComponent(textField2)
                                        .addComponent(textField3)
                                        .addComponent(textField4)
                                        .addComponent(textField5)))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(button))
        );
    }
}
