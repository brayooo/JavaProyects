package view.screen2;

import javax.swing.*;
import java.awt.*;

public class MyPanel10 extends JPanel {
    private Image image;
    public MyPanel10(){
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        image = new ImageIcon( "resources/qr.png").getImage();
        g2d.drawImage(image,0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
}
