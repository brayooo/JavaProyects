package co.edu.uptc.utils;

import co.edu.uptc.models.Limits;
import co.edu.uptc.pojos.Plane;
import co.edu.uptc.pojos.PointUptc;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UtilPlane {

    private Random random;
    private static UtilPlane instance;
    private static final int CONVERSION_TIME = 60000;

    public UtilPlane() {
        random = new Random();
    }

    public static UtilPlane getInstance() {
        return instance == null ? instance = new UtilPlane() : instance;
    }

    public void utilSleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void setInitialCoordinates(Plane plane, int width, int height) {
        int margin = 35;
        int limit = (int) ((Math.random() * 4) + 1);
        if (limit == Limits.TOP.getSide()) {
            plane.setAxisX(random.nextInt(width - margin));
            plane.setAxisY(margin);
        } else if (limit == Limits.BOTTOM.getSide()) {
            plane.setAxisX(random.nextInt(width - margin) + margin);
            plane.setAxisY(height - 110);
        } else if (limit == Limits.RIGHT.getSide()) {
            plane.setAxisX(margin);
            plane.setAxisY(random.nextInt(height - margin) + margin);
        } else if (limit == Limits.LEFT.getSide()) {
            plane.setAxisX(width - margin);
            plane.setAxisY(random.nextInt(height - margin) + margin);
        }
    }

    public Point getCenterPoint(int panelWidth, int panelHeight) {
        return new Point(panelWidth / 2, panelHeight / 2);
    }


    public List<PointUptc> getPointsFromInitialToCenter(Plane plane, int panelWidth, int panelHeight) {
        Point center = getCenterPoint(panelWidth, panelHeight);
        List<PointUptc> points = new ArrayList<>();
        double m = (center.getY() - plane.getAxisY()) / (center.getX() - plane.getAxisX());
        double b = plane.getAxisY() - m * plane.getAxisX();
        if (center.getX() > plane.getAxisX()) {
            for (int x = plane.getAxisX(); x <= center.getX() * 2; x++) {
                Point point = new Point(x, calculateY(m, x, b));
                points.add(new PointUptc(point, false));
            }
        } else {
            for (int x = plane.getAxisX(); x >= center.getX() * -2; x--) {
                Point point = new Point(x, calculateY(m, x, b));
                points.add(new PointUptc(point, false));
            }
        }
        return points;
    }

    private int calculateY(double m, int x, double b) {
        return (int) (m * x + b);
    }

    public double convertMillis(double time){
        return time / CONVERSION_TIME;
    }

}
