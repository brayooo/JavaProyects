package co.edu.uptc.presenter;

import java.io.File;

public interface Contract {
    public interface Model{
        void setPresenter(Contract.Presenter presenter);
        void setFile(File file);
        void start(String host, int port);
        void createFile();
        void sendInfo(String info);
        void addDataToMyFile(String fileName,byte[] info);

    }
    public interface Presenter{
        void setModel(Contract.Model model);
        void setView(Contract.View view);
        void setFile(File file);
    }

    public interface View{
        void setPresenter(Contract.Presenter presenter);
        void start();
    }
}
