package co.edu.uptc.models.sockets;

import co.edu.uptc.pojos.MyFile;
import co.edu.uptc.presenter.Contract;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Client {

    private Connection con;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private Contract.Model model;

    public Client(String host, int port){
        init(host, port);
        receive();
    }
    public void init(String host, int port){
        con = new Connection("client");
        con.setHost(host);
        con.setPort(port);
        con.connection();
    }

    public void setModel(Contract.Model model){
        this.model = model;
    }

    public void receive(){
        Thread thread = new Thread(() -> {
            try {
                inputStream = new DataInputStream(con.getSocket().getInputStream());
                while (true){
                    String json = inputStream.readUTF();
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    validateCreateFile(json,gson);
                }
                //inputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        thread.start();
    }

    private void validateCreateFile(String json, Gson gson){
        MyFile myFile = transformToPojo(json,gson);
        if(myFile.getStatus() == 3){
            model.createFile();
        }else {
            model.addDataToMyFile(myFile.getFileName(),myFile.getFileInfo());
        }
    }

    private MyFile transformToPojo(String json, Gson gson){
        return gson.fromJson(json,MyFile.class);
    }
//    private Root transformToPojo(String json, Gson gson){
//        return gson.fromJson(json,Root.class);
//    }
}
