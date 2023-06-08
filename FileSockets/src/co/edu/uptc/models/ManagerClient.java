package co.edu.uptc.models;

import co.edu.uptc.models.sockets.Client;
import co.edu.uptc.presenter.Contract;

import java.io.File;

public class ManagerClient implements Contract.Model {

    private Contract.Presenter presenter;
    private FileManager fileManager;
    private Client client;

    public ManagerClient(){
        fileManager = new FileManager(this);
    }

    @Override
    public void setPresenter(Contract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setFile(File file) {

    }

    @Override
    public void start(String host, int port) {
        client = new Client(host, port);
        client.setModel(this);
    }

    @Override
    public void createFile() {
        fileManager.createFile("C:/Users/bryan/OneDrive/Escritorio/Test/"+fileManager.getMyFile().getFileName());
    }

    @Override
    public void addDataToMyFile(String fileName,byte[] info) {
        fileManager.addDataToMyFile(fileName,info);
    }


    @Override
    public void sendInfo(String info) {

    }
}
