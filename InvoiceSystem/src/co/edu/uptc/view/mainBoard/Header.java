package co.edu.uptc.view.mainBoard;

import javax.swing.*;
import java.awt.*;


public class Header extends JPanel {

    private JButton adminBt;
    private MyFrame myFrame;

    public Header(MyFrame myFrame) {
        this.myFrame = myFrame;
        setLayout(new BorderLayout());
        initComponents();
    }
    private void initComponents() {
        adminBt = new JButton();
        adminBt.setIcon(new ImageIcon(new ImageIcon("src/resources/customer.png")
                .getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH)));
        adminBt.setOpaque(false);
        adminBt.setBorderPainted(false);
        adminBt.setContentAreaFilled(false);
        adminBt.setActionCommand("ADMIN");
        adminBt.addActionListener(e -> {
            String command = e.getActionCommand();
            if(command.equals("ADMIN")){
                myFrame.showAdminBoard();
            }
        });
        add(adminBt,BorderLayout.EAST);
    }


    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(0, 0, 25, getHeight());
        g2.fillRect(getWidth() - 25, getHeight() - 25, getWidth(), getHeight());
        super.paintComponent(grphcs);
    }

}
