package co.edu.uptc.presenter;

import co.edu.uptc.pojos.FigureInformation;
import co.edu.uptc.pojos.RectangleUptc;
import co.edu.uptc.pojos.Root;

import java.awt.*;

public interface Contract {
    public interface Model{
        void setPresenter(Contract.Presenter presenter);
        RectangleUptc getRectangle();
        void addPoint(Point point);
        boolean findRectangle(Point point);
        void setRectangle(Rectangle rectangle);
        void start(String host, int port);
        void setRoot(Root root);
        Root getRoot();
        void sendInfo();
    }
    public interface Presenter{
        void setModel(Contract.Model model);
        void setView(Contract.View view);
        RectangleUptc getRectangle();
        void addPoint(Point point);
        boolean findRectangle(Point point);
        int getPanelColor();
        int getRecColor();
        void setPanelColor(int color);
        void setRecColor(int color);
    }

    public interface View{
        void setPanelColor(Color color);
        void setRecColor(Color color);
        int getPanelColor();
        int getRecColor();
        void setPresenter(Contract.Presenter presenter);
        void start();
        void initGame();
    }
}
