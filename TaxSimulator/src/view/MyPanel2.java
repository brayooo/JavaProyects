package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MyPanel2 extends JPanel {

    private JCheckBox checkBox1;
    private JCheckBox checkBox2;

    public MyPanel2(ActionListener listener){
        initComponents(listener);
    }

    private void initComponents(ActionListener listener){
        checkBox1 = new JCheckBox("Pronto pago");
        setBounds(10,10,150,30);
        add(checkBox1);
        checkBox2 = new JCheckBox("Excento");
        setBounds(10,10,150,30);
        add(checkBox2);

    }

    public boolean getStatusFirstCheckBox(){
        return  checkBox1.isSelected();
    }

    public boolean getStatusSecondCheckBox(){
        return  checkBox1.isSelected();
    }
}
