package co.edu.uptc.models;

import co.edu.uptc.Global;
import co.edu.uptc.pojos.Plane;
import co.edu.uptc.utils.UtilPlane;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ManagerPlane implements Runnable {

    private List<ManagerMovePlane> thredList;
    private ManagerModel managerModel;
    public int planesFlight = 0;
    public int planesLanded;
    private boolean stop;
    private boolean paused;
    private long timeStarted;
    public double timePlayed;

    public ManagerPlane(ManagerModel managerModel) {
        this.managerModel = managerModel;
        thredList = new ArrayList<>();
        stop = true;
        timeStarted = System.currentTimeMillis();
    }

    public void addPlanes(Plane plane) {
        plane.setCoordinates(UtilPlane.getInstance().getPointsFromInitialToCenter
                (plane, managerModel.getViewWidth(), managerModel.getViewHeight()));
        planesFlight++;
        initMove(plane);
        changeTrajectory(plane);
    }

    private void initMove(Plane plane) {
        ManagerMovePlane managerMovePlane = new ManagerMovePlane(plane, this);
        thredList.add(managerMovePlane);
        managerMovePlane.move(String.valueOf(plane.getId()));
    }

    public boolean checkCollision(Plane plane) {
        Point point = new Point(plane.getAxisX(), plane.getAxisY());
        Point point1 = new Point(plane.getAxisX(), plane.getAxisY() + Global.sizeImage);
        Point point2 = new Point(plane.getAxisX() + Global.sizeImage, plane.getAxisY());
        Point point3 = new Point(plane.getAxisX() + Global.sizeImage, plane.getAxisY() + Global.sizeImage);
        for (int i = 0; i < thredList.size(); i++) {
            if (thredList.get(i).getPlane() != plane) {
                Rectangle rec = thredList.get(i).getPlane().getRectangle();
                if (rec.contains(point) || rec.contains(point1)
                        || rec.contains(point2) || rec.contains(point3)){
                    setTimePlayed();
                    managerModel.getPresenter().endGame();
                    managerModel.getPresenter().notifyError();
                    return true;
                }
            }
        }
        return false;
    }

    public void setTimePlayed(){
        timePlayed = System.currentTimeMillis() - timeStarted;
        timePlayed =  UtilPlane.getInstance().convertMillis(timePlayed);
    }

    public void getLandingPlanes(){
        for (ManagerMovePlane thread:thredList) {
            planesLanded += thread.planesLanding;
        }
    }

    public void deductFlightPlanes(){
        planesFlight--;
    }
    private void changeTrajectory(Plane plane) {
        if (!plane.getCoordinates().isEmpty()) {
            searchPlaneInThreads(plane.getId()).
                    setCoordinates(plane.getCoordinates());
        }
    }

    private Plane searchPlaneInThreads(int id) {
        for (ManagerMovePlane thread : thredList) {
            if (thread.getPlane().getId() == id) {
                return thread.getPlane();
            }
        }
        return new Plane();
    }

    public ManagerModel getManagerModel() {
        return managerModel;
    }

    private ManagerMovePlane searchThreads(String id) {
        for (ManagerMovePlane thread : thredList) {
            if (thread.getThread().getName().equals(id)) {
                return thread;
            }
        }
        return null;
    }


    public void removePlane(String id) {
        for (ManagerMovePlane thread : thredList) {
            if (thread.getThread().getName().equals(id)) {
                thredList.remove(thread);
            }
        }
    }

    public List<Plane> getPlanes() {
        List<Plane> planes = new ArrayList<>();
        for (ManagerMovePlane plane : thredList) {
            planes.add(plane.getPlane());
        }
        return planes;
    }

    public Plane searchPlane(int id) {
        for (ManagerMovePlane plane : thredList) {
            if (plane.getPlane().getId() == id) {
                return plane.getPlane();
            }
        }
        return new Plane();
    }

    public void setStop() {
        stop = true;
        resumeMove();
    }

    public void setPaused() {
        pauseMove();
        paused = true;
    }

    public void resume() {
        synchronized (this) {
            paused = false;
            notifyAll();
            resumeMove();
        }
    }

    public void pauseMove() {
        for (ManagerMovePlane thread : thredList) {
            thread.pauseMove();
        }
    }

    public void resumeMove() {
        for (ManagerMovePlane thread : thredList) {
            thread.resumeMove();
        }
    }

    public void endGame() {
        for (ManagerMovePlane thread: thredList) {
            thread.endGame();
        }
        stop = false;
        thredList.clear();
    }

    @Override
    public void run() {
        while (stop) {
            while (paused) {
                synchronized (this) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            Plane plane = new Plane();
            plane.generateId();
            plane.setColor(0);
            plane.setSpeed(70);
            UtilPlane.getInstance().setInitialCoordinates(plane, managerModel.getViewWidth(), managerModel.getViewHeight());
            addPlanes(plane);
            UtilPlane.getInstance().utilSleep(5000);
        }
    }
}
