package co.edu.uptc.presenter;

import co.edu.uptc.models.ManagerModel;
import co.edu.uptc.views.Board;

public class ManagerGeneral {

    private Contract.ContractFlight managerModel;
    private Contract.View view;
    private Contract.Presenter presenter;
    private static ManagerGeneral instance;

    public static ManagerGeneral getInstance(){
        return instance == null? instance = new ManagerGeneral():instance;
    }
    private void createMVP() {
        presenter = new Presenter();
        view = new Board();
        managerModel = new ManagerModel();

        presenter.setView(view);
        presenter.setModel(managerModel);
        managerModel.setPresenter(presenter);
        view.setPresenter(presenter);
    }

    public void run(){
        createMVP();
        view.start();
        view.initGame();
        managerModel.addPlanes();
    }
}
