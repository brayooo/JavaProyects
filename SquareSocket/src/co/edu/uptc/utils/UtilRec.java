package co.edu.uptc.utils;

public class UtilRec {

    private static UtilRec instance;

    public static UtilRec getInstance() {
        return instance == null? instance = new UtilRec(): instance;
    }

    public void utilSleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
