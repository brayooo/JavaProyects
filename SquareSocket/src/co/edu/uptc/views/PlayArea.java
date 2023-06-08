package co.edu.uptc.views;

import co.edu.uptc.pojos.RectangleUptc;
import co.edu.uptc.utils.UtilRec;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class PlayArea extends JPanel implements MouseListener, MouseMotionListener {

    private Board board;
    private RectangleUptc rectangleUptc;
    private boolean found;
    private Color recColor;

    public PlayArea(Board board) {
        super();
        this.board = board;
        recColor = Color.black;
        setSize(700, 700);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void paintRec() {
        Thread thread = new Thread(() -> {
            while (true) {
                repaint();
                UtilRec.getInstance().utilSleep(100);
            }
        });
        thread.start();
    }

    public void setRectangleUptc() {
        this.rectangleUptc = board.getPresenter().getRectangle();
    }

    public void setRecColor(Color color){
        this.recColor = color;
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        setRectangleUptc();
        g.setColor(recColor);
        if (rectangleUptc != null) {
            g.drawRect(rectangleUptc.getRectangle().x, rectangleUptc.getRectangle().y,
                            (int) rectangleUptc.getRectangle().getWidth(), (int) rectangleUptc.getRectangle().getHeight());
        }
    }

    public Color getRecColor() {
        return recColor;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (board.getPresenter().findRectangle(e.getPoint())) {
            found = true;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(found) {
            board.getPresenter().addPoint(e.getPoint());
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        found = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
