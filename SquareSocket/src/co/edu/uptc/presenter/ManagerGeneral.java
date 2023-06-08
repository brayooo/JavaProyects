package co.edu.uptc.presenter;

import co.edu.uptc.models.ManagerClient;
import co.edu.uptc.models.ManagerModel;
import co.edu.uptc.models.ManagerServer;
import co.edu.uptc.views.Board;

public class ManagerGeneral {

    private Contract.Model managerModel;
    private Contract.View view;
    private Contract.Presenter presenter;
    private static ManagerGeneral instance;

    public static ManagerGeneral getInstance(){
        return instance == null? instance = new ManagerGeneral():instance;
    }
    private void createMVP(String type, String host, int port) {
        presenter = new Presenter();
        view = new Board();
        if(type.equalsIgnoreCase("client")) {
            managerModel = new ManagerClient();
        }else {
            managerModel = new ManagerServer();
        }
        presenter.setView(view);
        presenter.setModel(managerModel);
        managerModel.setPresenter(presenter);
        view.setPresenter(presenter);
        managerModel.start(host, port);
    }

    public void run(String type, String host, int port){
        createMVP(type,host,port);
        view.start();
        view.initGame();
    }
}
