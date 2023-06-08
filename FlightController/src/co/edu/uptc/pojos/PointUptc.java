package co.edu.uptc.pojos;

import java.awt.*;

public class PointUptc {

    private Point point;
    private boolean status;

    public PointUptc(Point point, boolean status) {
        this.point = point;
        this.status = status;
    }

    public Point getPoint() {
        return point;
    }

    public boolean isStatus() {
        return status;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Point"  + point.getLocation();
    }
}
