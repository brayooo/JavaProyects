package co.edu.uptc.presenter;

import co.edu.uptc.model.ModelManager;
import co.edu.uptc.view.mainBoard.MyFrame;

public class GeneralManager {

    MainContract.Model model;
    MainContract.View view;
    MainContract.Presenter presenter;

    public void createMvp(){
        view = new MyFrame();
        model = new ModelManager();
        presenter = new Presenter();
        view.setPresenter(presenter);
        model.setPresenter(presenter);
        presenter.setModel(model);
        presenter.setView(view);
    }

    public void runProject(){
        createMvp();
        view.start();
        model.loadData();
    }
}
