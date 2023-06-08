package co.edu.uptc.models;

import co.edu.uptc.models.sockets.Server;
import co.edu.uptc.pojos.FigureInformation;
import co.edu.uptc.pojos.PanelInformation;
import co.edu.uptc.pojos.RectangleUptc;
import co.edu.uptc.pojos.Root;
import co.edu.uptc.presenter.Contract;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.awt.*;

public class ManagerServer implements Contract.Model {

    private Server server;
    private Contract.Presenter presenter;
    private ManagerRectangle managerRectangle;
    private Root root;

    public ManagerServer(){
        managerRectangle = new ManagerRectangle();
        root = new Root();
    }


    @Override
    public void setPresenter(Contract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public RectangleUptc getRectangle() {
        String rectangle = rectangleToJson(managerRectangle.getRectangleUptc());
        sendInfo();
        //server.sendInfo(rectangle);
        return managerRectangle.getRectangleUptc();
    }

    @Override
    public void addPoint(Point point) {
        managerRectangle.getRectangleUptc().getRectangle().setLocation(point);
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
        initServer(host,port);
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
        root.setPanelInformation(addPanelInfo(presenter.getPanelColor()));
        root.setFigureInformation(addFigureInfo(managerRectangle.getRectangleUptc().getRectangle(),
                presenter.getRecColor()));
        server.sendInfo(rootToJson(root));
    }

    private PanelInformation addPanelInfo(int color){
        PanelInformation panelInformation = new PanelInformation();
        panelInformation.setColor(color);
        return panelInformation;
    }

    private FigureInformation addFigureInfo(Rectangle rec, int color){
        FigureInformation figureInformation = new FigureInformation();
        figureInformation.setColor(color);
        figureInformation.setRectangle(rec);
        return figureInformation;
    }
    public void initServer(String host, int port){
       server = new Server(host, port);
    }

    public String rectangleToJson(RectangleUptc rectangleUptc){
        Rectangle rec  = rectangleUptc.getRectangle();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(rec);
    }

    public String rootToJson(Root root){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(root);
    }

}
