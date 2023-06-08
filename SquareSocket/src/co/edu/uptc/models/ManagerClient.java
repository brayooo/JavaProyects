package co.edu.uptc.models;

import co.edu.uptc.models.ManagerModel;
import co.edu.uptc.models.sockets.Client;
import co.edu.uptc.pojos.FigureInformation;
import co.edu.uptc.pojos.RectangleUptc;
import co.edu.uptc.pojos.Root;
import co.edu.uptc.presenter.Contract;

import java.awt.*;

public class ManagerClient implements Contract.Model {

    private Contract.Presenter presenter;
    private Client client;
    private RectangleUptc rectangleUptc;
    private Root root;

    public ManagerClient(){
        root = new Root();
    }


    @Override
    public void setPresenter(Contract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public RectangleUptc getRectangle() {
        return rectangleUptc;
    }

    @Override
    public void addPoint(Point point) {

    }

    @Override
    public boolean findRectangle(Point point) {
        return false;
    }

    @Override
    public void setRectangle(Rectangle rectangle) {
        RectangleUptc rectangleUptc1  = new RectangleUptc();
        rectangleUptc1.setRectangle(rectangle);
        this.rectangleUptc = rectangleUptc1;

    }

    @Override
    public void start(String host, int port) {
        loadData(host, port);
    }

    @Override
    public void setRoot(Root root) {
        this.root = root;
        setRectangle(root.getFigureInformation().getRectangle());
        presenter.setPanelColor(root.getPanelInformation().getColor());
        presenter.setRecColor(root.getFigureInformation().getColor());
    }

    @Override
    public Root getRoot() {
        return this.root;
    }

    @Override
    public void sendInfo() {

    }

    public void loadData(String host, int port){
        client = new Client(host, port);
        client.setModel(this);
    }


}
