package co.edu.uptc.models;

import java.io.*;

public class ReadFile {

    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private String file;
    private StringBuilder builder;
    private FileInputStream inputStream;
    private FileManager fileManager;


    public ReadFile(FileManager fileManager){
        this.fileManager = fileManager;
    }
    public ReadFile(String path) {
        try {
            fileReader = new FileReader(path);
            bufferedReader = new BufferedReader(fileReader);
            builder = new StringBuilder();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    public String getFile(){
        file = builder.toString();
        return file;
    }
}
