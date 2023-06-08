package co.edu.uptc.models;

import co.edu.uptc.presenter.Contract;

import java.io.File;

public class ManagerModel implements Contract.Model {

    private Contract.Presenter presenter;
    private FileManager fileManager;

    public ManagerModel(){
        fileManager = new FileManager(this);

    }
    @Override
    public void setPresenter(Contract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setFile(File file) {
        //fileManager.setFile(path);
    }

    @Override
    public void start(String host, int port) {

    }

    @Override
    public void createFile() {

    }

    @Override
    public void sendInfo(String info) {

    }

    @Override
    public void addDataToMyFile(String fileName,byte[] info) {

    }


}
