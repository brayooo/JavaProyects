import co.edu.uptc.presenter.ManagerGeneral;

public class Main {
    public static void main(String[] args) {
        ManagerGeneral.getInstance().run(args[0],args[1], Integer.parseInt(args[2]));
    }
}