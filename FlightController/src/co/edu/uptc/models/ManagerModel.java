package co.edu.uptc.models;

import co.edu.uptc.pojos.Plane;
import co.edu.uptc.pojos.PointUptc;
import co.edu.uptc.presenter.Contract;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.List;

public class ManagerModel implements Contract.ContractFlight {

    private Contract.Presenter presenter;
    private ManagerPlane managerPlane;

    public ManagerModel() {
        managerPlane = new ManagerPlane(this);
    }

    public void addPlanes() {
        managerPlane.run();
    }

    @Override
    public void addPoint(int id, int x, int y) {
        Plane plane = managerPlane.searchPlane(id);
        plane.getCoordinates().add(new PointUptc(new Point(x, y), true));
    }
    @Override
    public Plane search(int x, int y) {
        for (Plane plane : managerPlane.getPlanes()) {
            if (plane.getRectangle().contains(new Point(x, y))) {
                return plane;
            }
        }
        return null;
    }


    @Override
    public void clearRoute(int id) {
        Plane p = managerPlane.searchPlane(id);
        p.getCoordinates().clear();
        p.setPosCurrent(0);
    }

    @Override
    public String getPlanesFlight() {
        return String.valueOf(managerPlane.planesFlight);
    }

    public String getPlanesLanded(){
        return String.valueOf(managerPlane.planesLanded);
    }

    @Override
    public String getTimePlayed() {
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(managerPlane.timePlayed);
    }

    public Contract.Presenter getPresenter(){
        return presenter;
    }

    public int getViewWidth() {
        return presenter.getComponent().getWidth();
    }

    public int getViewHeight() {
        return presenter.getComponent().getHeight();
    }

    @Override
    public void setPresenter(Contract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public List<Plane> getPlanes() {
        return managerPlane.getPlanes();
    }

    public void resumeGame() {
        managerPlane.resume();
    }

    @Override
    public void endGame() {
        managerPlane.endGame();
    }

    public Point getAirstrip() {
        return presenter.getAirstrip();
    }

    public void pauseGame() {
        managerPlane.setPaused();
    }

}
