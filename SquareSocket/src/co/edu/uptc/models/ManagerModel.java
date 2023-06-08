package co.edu.uptc.models;

import co.edu.uptc.pojos.RectangleUptc;
import co.edu.uptc.pojos.Root;
import co.edu.uptc.presenter.Contract;

import java.awt.*;

public class ManagerModel implements Contract.Model {

    private ManagerRectangle managerRectangle;
    private Contract.Presenter presenter;

    public ManagerModel(){
        managerRectangle = new ManagerRectangle();
    }

    @Override
    public void setPresenter(Contract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public RectangleUptc getRectangle() {
        return managerRectangle.getRectangleUptc();
    }

    @Override
    public boolean findRectangle(Point point) {
        return managerRectangle.findRectangle(point);
    }

    @Override
    public void setRectangle(Rectangle rectangle) {
        managerRectangle.getRectangleUptc().setRectangle(rectangle);
    }

    @Override
    public void start(String host, int port) {

    }

    @Override
    public void setRoot(Root root) {

    }

    @Override
    public Root getRoot() {
        return null;
    }

    @Override
    public void sendInfo() {

    }


    @Override
    public void addPoint(Point point) {
        managerRectangle.move(point);
    }
}
