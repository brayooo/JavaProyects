package co.edu.uptc.utils;

public class Utils {

    private static Utils instance;

    public static Utils getInstance() {
        return instance == null? instance = new Utils(): instance;
    }

    public void utilSleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
