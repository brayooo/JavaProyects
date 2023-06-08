package co.edu.uptc.presenter;

import co.edu.uptc.pojos.Plane;

import java.awt.*;
import java.util.List;

public class Presenter implements Contract.Presenter {

    Contract.View view;
    Contract.ContractFlight contractFlight;

    @Override
    public void setModel(Contract.ContractFlight contractFlight) {
        this.contractFlight = contractFlight;
    }

    @Override
    public void setView(Contract.View view) {
        this.view = view;
    }

    @Override
    public List<Plane> getPlanes() {
        return contractFlight.getPlanes();
    }

    @Override
    public Component getComponent() {
        return view.getComponent();
    }

    @Override
    public void addPoint(int id, int x, int y) {
        contractFlight.addPoint(id,x,y);
    }

    @Override
    public Plane search(int x, int y) {
        return contractFlight.search(x,y);
    }

    @Override
    public void clearRoute(int id) {
        contractFlight.clearRoute(id);
    }

    @Override
    public String getPlanesFlight() {
        return contractFlight.getPlanesFlight();
    }

    @Override
    public String getPlanesLanded() {
        return contractFlight.getPlanesLanded();
    }

    @Override
    public String getTimePlayed() {
        return contractFlight.getTimePlayed();
    }

    @Override
    public void notifyPaused() {
        contractFlight.pauseGame();
    }

    @Override
    public void notifyResume() {
        contractFlight.resumeGame();
    }

    @Override
    public Point getAirstrip() {
        return view.getAirstrip();
    }

    @Override
    public void endGame() {
        contractFlight.endGame();
        view.endPaint();
    }

    @Override
    public void notifyError() {
        view.notifyError();
    }

}
