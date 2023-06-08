package view.frame;

import view.screen1.PrincipalPanel;
import view.screen2.PrincipalPanel1;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {

    private PrincipalPanel principalPanel;
    private PrincipalPanel1 principalPanel1;


    public MyFrame(ActionListener listener){
        super("App");
        setSize(300,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(600,0);
        initComponents(listener);
        setVisible(true);
    }

    private void initComponents(ActionListener listener){
        principalPanel = new PrincipalPanel(listener);
        principalPanel1 = new PrincipalPanel1(listener);
        principalPanel.setVisible(true);
        add(principalPanel);
    }

    public void changeToScreen2() {
        principalPanel.setVisible(false);
        principalPanel1.setVisible(true);
        add(principalPanel1);
    }

    public void changeToScreen1(){
        principalPanel.setVisible(true);
        principalPanel1.setVisible(false);
        add(principalPanel);
        principalPanel.revalidate();
    }
}
