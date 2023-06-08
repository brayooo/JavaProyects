package co.edu.uptc.pojos;

import co.edu.uptc.Global;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Plane implements Cloneable{

    private static int count;
    private int id;
    private int speed;
    private int color;
    private List<PointUptc> coordinates;
    private int posCurrent = 0;
    private int AxisX;
    private int AxisY;
    private Image image;
    private boolean isCollision;
    private boolean isLanded;

    public Plane() {
        coordinates = new ArrayList<>();
    }

    public Plane(int speed, int color) {
        this.speed = speed;
        this.color = color;
    }

    public void generateId(){
        this.id = count++;
    }

    public int getSpeed() {
        return speed;
    }

    public int getColor() {
        return color;
    }

    public int getId() {
        return id;
    }

    public int getAxisX() {
        return AxisX;
    }

    public int getAxisY() {
        return AxisY;
    }

    public Image getImage() {
        return image;
    }

    public boolean isCollision() {
        return isCollision;
    }

    public List<PointUptc> getCoordinates() {
        return coordinates;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setCoordinates(List<PointUptc> coordinates) {
        this.coordinates = coordinates;
    }

    public void setLanded(boolean landed) {
        isLanded = landed;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCollision(boolean collision) {
        isCollision = collision;
    }

    public void setAxisX(int axisX) {
        AxisX = axisX;
    }

    public boolean isLanded() {
        return isLanded;
    }

    public void setAxisY(int axisY) {
        AxisY = axisY;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public Plane clone() {
        try {
            return (Plane)super.clone();
        }catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public Rectangle getRectangle(){
        return new Rectangle(getAxisX()- (Global.sizeImage / 2)
                ,getAxisY() -  (Global.sizeImage  / 2)
                ,Global.sizeImage ,Global.sizeImage );
    }


    public int getPosCurrent() {
        return posCurrent;
    }

    public void setPosCurrent(int posCurrent) {
        this.posCurrent = posCurrent;
    }
}
