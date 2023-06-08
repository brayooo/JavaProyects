package co.edu.uptc.models;

import co.edu.uptc.pojos.MyFile;
import co.edu.uptc.presenter.Contract;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.Arrays;

public class FileManager {

    private MyFile myFile;
    private Contract.Model managerModel;
    private FileOutputStream outputStream;
    private InputStream inputStream;

    public FileManager(Contract.Model managerModel) {
        myFile = new MyFile();
        this.managerModel = managerModel;
    }

    public void setFile(File file){
//        myFile = new MyFile();
//        myFile.setFileName(file.getName());
            //myFile.setFileInfo(Files.readAllBytes(file.toPath()));
    }

    public void addDataToMyFile(String fileName, byte[] info){
        if(myFile.getFileInfo() != null){
            byte[] aux = myFile.getFileInfo();
            byte[] newArray = new byte[aux.length+info.length];
            System.arraycopy(aux,0,newArray,0,aux.length);
            System.arraycopy(info, 0, newArray, aux.length, info.length);
            myFile.setFileInfo(newArray);
        }else {
            myFile.setFileName(fileName);
            myFile.setFileInfo(info);
        }
    }

    public void readFile(File file) {
        try {
            inputStream = new FileInputStream(file);
            byte[] bytes = new byte[1000];
            myFile.setFileName(file.getName());
            int count = 0;
            int bytesRead;
            while ((bytesRead = inputStream.read(bytes)) != -1) {
                if(count == 0) {
                    myFile.setStatus(1);
                } else{
                    myFile.setStatus(2);
                }
                myFile.setFileInfo(Arrays.copyOf(bytes, bytesRead));
                managerModel.sendInfo(myFileToString(myFile));
                count++;
            }
            myFile.setStatus(3);
            managerModel.sendInfo(myFileToString(myFile));
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void createFile(String path){
        try {
            outputStream = new FileOutputStream(path);
            System.out.println(myFile.getFileName());
            System.out.println(Arrays.toString(myFile.getFileInfo()));
            outputStream.write(myFile.getFileInfo());
            outputStream.close();
            this.myFile = new MyFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String myFileToString(MyFile myFile){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(myFile);
    }

    public MyFile getMyFile() {
        return myFile;
    }

    public void setMyFile(MyFile myFile) {
        this.myFile = myFile;
    }

    public Contract.Model getManagerModel() {
        return managerModel;
    }

    public void setManagerModel(Contract.Model managerModel) {
        this.managerModel = managerModel;
    }
}
