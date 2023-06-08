package view.screen1;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

public class ShapedButtonUI extends BasicButtonUI {
    private Color color;
    public ShapedButtonUI(Color color){
        this.color = color;
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        Graphics2D g2d = (Graphics2D)g;
        Shape shape = new RoundRectangle2D.Double(0, 0, c.getWidth(), c.getHeight() ,10, 10);
        g2d.setPaint(color);
        g2d.fill(shape);
        super.paint(g, c);
    }
}
