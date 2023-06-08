package co.edu.uptc.pojos;

import java.util.Arrays;

public class MyFile {

    private String fileName;
    private byte[] fileInfo;
    private int status;

    public MyFile(){
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getFileInfo() {
        return fileInfo;
    }

    public void setFileInfo(byte[] fileInfo) {
        this.fileInfo = fileInfo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "name: "  + fileName + '\n'
                + Arrays.toString(fileInfo);
    }
}
