package co.edu.uptc.view.mainBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyMenu extends JPanel implements ActionListener {

    private JButton personBt;
    private JButton invoiceBt;
    private MyFrame myFrame;

    public MyMenu(MyFrame myFrame){
        this.myFrame = myFrame;
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(110,700));
        initComponents();
    }

    private void initComponents(){
        personBt = new JButton();
        personBt.setIcon(new ImageIcon(new ImageIcon("src/resources/personvector.png")
                .getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH)));
        personBt.setOpaque(false);
        personBt.setContentAreaFilled(false);
        personBt.setBorderPainted(false);
        personBt.setActionCommand("PER");
        personBt.addActionListener(this);
        add(Box.createVerticalStrut(35));
        add(personBt);

        invoiceBt = new JButton();
        invoiceBt.setIcon(new ImageIcon(new ImageIcon("src/resources/shopcart.png")
                .getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH)));
        invoiceBt.setOpaque(false);
        invoiceBt.setContentAreaFilled(false);
        invoiceBt.setBorderPainted(false);
        invoiceBt.setActionCommand("INV");
        invoiceBt.addActionListener(this);
        add(Box.createVerticalStrut(50));
        add(invoiceBt);
    }

    @Override
    protected void paintChildren(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#EE9CA7"), 0, getHeight(), Color.decode("#FFDDE1"));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        super.paintChildren(grphcs);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case "PER":
                myFrame.showBodyClient();
                break;
            case "INV":
                myFrame.showBodyInvoice();
        }
    }
}
