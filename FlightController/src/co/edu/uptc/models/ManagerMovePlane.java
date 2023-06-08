package co.edu.uptc.models;

import co.edu.uptc.pojos.Plane;
import co.edu.uptc.pojos.PointUptc;
import co.edu.uptc.utils.UtilPlane;


public class ManagerMovePlane {

    private Plane plane;
    private boolean isMove;
    private Thread thread;
    private ManagerPlane managerPlane;
    private boolean paused;
    public int planesLanding = 0;

    public ManagerMovePlane(Plane plane, ManagerPlane managerPlane) {
        this.plane = plane;
        this.managerPlane = managerPlane;
        isMove = true;

    }

    public ManagerMovePlane() {

    }

    public void movement() {
        synchronized (plane) {
            if (!plane.getCoordinates().isEmpty()) {
                validateEndRoute();
                PointUptc p = plane.getCoordinates().get(plane.getPosCurrent());
                plane.setAxisX(p.getPoint().x);
                plane.setAxisY(p.getPoint().y);
                p.setStatus(false);
                plane.setPosCurrent(plane.getPosCurrent() + 1);
                validateCollision();
                validateLanding();
            }
        }
    }

    public void validateEndRoute(){
        if(plane.getPosCurrent() >= plane.getCoordinates().size()){
            plane.getCoordinates().clear();
            plane.setCoordinates(UtilPlane.getInstance().getPointsFromInitialToCenter(plane,managerPlane.getManagerModel().getViewWidth(),
                    managerPlane.getManagerModel().getViewHeight()));
            plane.setPosCurrent(0);
        }
    }
    public void validateCollision(){
        if(managerPlane.checkCollision(plane)){
            plane.setCollision(true);
            isMove = false;

        }
    }

    public void validateLanding(){
        if(isLanding()){
            plane.setLanded(true);
            isMove = false;
            planesLanding++;
            managerPlane.getLandingPlanes();
            managerPlane.deductFlightPlanes();
            managerPlane.removePlane(String.valueOf(plane.getId()));
        }
    }

    public void resumeMove(){
        paused = false;
        synchronized (thread) {
            thread.notifyAll();
        }
    }

    public boolean isLanding(){
        return plane.getRectangle().contains(managerPlane.getManagerModel().getAirstrip());
    }

    public void endGame(){
        isMove = false;
    }

    public Plane getPlane() {
        return plane;
    }

    public Thread getThread() {
        return thread;
    }

    public void setMove(boolean move) {
        isMove = move;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public void pauseMove(){
        paused = true;
    }

    public void move(String name) {
        thread = new Thread(name) {
            @Override
            public void run() {
                super.run();
                    while (isMove) {
                        if (paused){
                            synchronized (thread) {
                                try {
                                    thread.wait();
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }
                        movement();
                        UtilPlane.getInstance().utilSleep(plane.getSpeed());
                    }
            }
        };
        thread.start();
    }
}

