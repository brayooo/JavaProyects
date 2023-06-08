package co.edu.uptc.views;

import co.edu.uptc.Global;
import co.edu.uptc.pojos.Plane;
import co.edu.uptc.pojos.PointUptc;
import co.edu.uptc.utils.UtilPlane;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class PlayArea extends JPanel implements MouseListener, MouseMotionListener {

    private Board board;
    private Image planeImage;
    private Image airStrip;
    private List<Plane> planes;
    private boolean found;
    private Plane plane;
    private Rectangle airStrip1;
    private boolean isStart;

    public PlayArea(Board board) {
        super();
        this.board = board;
        setSize(700, 700);
        addMouseListener(this);
        addMouseMotionListener(this);
        initUtilities();
        isStart = true;
    }

    private void initUtilities() {
        loadAirStripImage();
        airStrip1 = new Rectangle(645, 245, 30, 30);
    }

    private void setPlanes() {
        planes = board.getPlanes();
    }

    private void loadAirStripImage() {
        try {
            airStrip = ImageIO.read(new File("assets/airstrip.png"))
                    .getScaledInstance(550, 80, Image.SCALE_SMOOTH);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Plane getPlane() {
        return plane;
    }

    public List<Plane> getPlanes() {
        return planes;
    }

    public void loadPlaneImage(Plane plane) {
        switch (plane.getColor()) {
            case 0 -> {
                planeImage = getImage("assets/Plane.png");
                plane.setImage(planeImage);
            }
            case 1 -> {
                planeImage = getImage("assets/BluePlane.png");
                plane.setImage(planeImage);
            }
            case 2 -> {
                planeImage = getImage("assets/RedPlane.png");
                plane.setImage(planeImage);
            }
            case 3 -> {
                planeImage = getImage("assets/GreenPlane.png");
                plane.setImage(planeImage);
            }
        }
    }

    private Image getImage(String path) {
        try {
            Image icon = ImageIO.read(new File(path));
            return icon.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void endPaint() {
        isStart = false;
    }

    public void paintPlanes() {
        Thread thread = new Thread(() -> {
            while (isStart) {
                setPlanes();
                repaint();
                board.setCountFlights();
                board.setCountLanded();
                board.setPlaneSpeed();
                UtilPlane.getInstance().utilSleep(100);
            }
        });
        thread.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = (getWidth() - airStrip.getWidth(null)) / 2;
        int y = (getHeight() - airStrip.getHeight(null)) / 2;
        g.drawImage(airStrip, x, y, null);
        g.setColor(new Color(90, 90, 90));
        g.fillRect(airStrip1.x, airStrip1.y, airStrip1.width, airStrip1.height);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLUE);
        synchronized (planes) {
            if (planes != null) {
                for (Plane plane : planes) {
                    if (!plane.isCollision() && !plane.isLanded()) {
                        loadPlaneImage(plane);
                        int x = plane.getAxisX() - (Global.sizeImage / 2);
                        int y = plane.getAxisY() - (Global.sizeImage / 2);
                        g.drawImage(plane.getImage(), x, y, null);
                        g.setColor(Color.red);
                        g.drawRect(x, y, Global.sizeImage, Global.sizeImage);
                        List<PointUptc> coordinates = plane.getCoordinates();
                        if (coordinates.size() > 0) {
                            for (PointUptc currentPoint : coordinates) {
                                if (currentPoint.isStatus()) {
                                    g.drawOval((int) currentPoint.getPoint().getX(),
                                            (int) currentPoint.getPoint().getY(), 1, 1);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public Point getAirstrip() {
        return airStrip1.getLocation();
    }

    private boolean isPlaneClicked(MouseEvent e) {
        if (plane != null) {
            return plane.getRectangle().contains(e.getPoint());
        }
        return false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) {
            plane = board.getPresenter().search(e.getX(), e.getY());
        }
        if (SwingUtilities.isRightMouseButton(e) && isPlaneClicked(e)) {
            board.setDialog();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            plane = board.getPresenter().search(e.getX(), e.getY());
            if (plane != null) {
                found = true;
                board.getPresenter().clearRoute(plane.getId());
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (found && plane != null) {
            board.getPresenter().addPoint(plane.getId(), e.getX(), e.getY());
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        found = true;
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
