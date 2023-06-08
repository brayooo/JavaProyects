package co.edu.uptc.models;

import co.edu.uptc.models.sockets.Server;
import co.edu.uptc.presenter.Contract;

import java.io.File;

public class ManagerServer implements Contract.Model {

    private Contract.Presenter presenter;
    private FileManager fileManager;
    private Server server;

    public ManagerServer(){
        fileManager = new FileManager(this);
    }

    @Override
    public void setPresenter(Contract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setFile(File file) {
        //fileManager.setFile(file);
        fileManager.readFile(file);
        //server.sendInfo(myFileToString(fileManager.getMyFile()));
        //server.sendInfo(myFileToString(fileManager.getMyFile()));
    }

    @Override
    public void start(String host, int port) {
        server = new Server(host, port);
    }

    @Override
    public void createFile() {
    }

    @Override
    public void sendInfo(String info) {
        server.sendInfo(info);
    }

    @Override
    public void addDataToMyFile(String fileName,byte[] info) {
    }

}
