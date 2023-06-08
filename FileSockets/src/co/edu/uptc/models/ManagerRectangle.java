package co.edu.uptc.models;

import co.edu.uptc.pojos.RectangleUptc;

import java.awt.*;

public class ManagerRectangle {

    private RectangleUptc rectangleUptc;


    public ManagerRectangle() {
        rectangleUptc = new RectangleUptc();
        rectangleUptc.getRectangle().setLocation(new Point(350, 400));
        rectangleUptc.getRectangle().setSize(60, 60);
        move();
    }

    public void move(){
        Thread thread = new Thread(() -> {
            while (true) {
                Point point = new Point(rectangleUptc.getRectangle().x+5, rectangleUptc.getRectangle().y);
                rectangleUptc.getRectangle().setLocation(point);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();
    }

    public boolean findRectangle(Point point) {
        return rectangleUptc.getRectangle().contains(point);
    }

    public void move(Point point){
        rectangleUptc.getRectangle().setLocation(point);
    }

    public RectangleUptc getRectangleUptc() {
        return rectangleUptc;
    }

    public void setRectangleUptc(RectangleUptc rectangleUptc){
        this.rectangleUptc = rectangleUptc;
    }
}
