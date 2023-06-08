package co.edu.uptc.presenter;

import co.edu.uptc.pojos.Plane;

import java.awt.*;
import java.util.List;

public interface Contract {

    public interface ContractFlight{
        void setPresenter(Contract.Presenter presenter);
        List<Plane> getPlanes();
        void addPlanes();
        void addPoint(int id, int x, int y);
        Plane search(int x, int y);
        void clearRoute(int id);
        String getPlanesFlight();
        String getPlanesLanded();
        String getTimePlayed();
        void pauseGame();
        void resumeGame();
        void endGame();

    }

    public interface View{
        void setPresenter(Contract.Presenter presenter);
        void start();
        void initGame();
        void endPaint();
        Component getComponent();
        Point getAirstrip();
        void notifyError();
    }

    public interface Presenter{
        void setModel(Contract.ContractFlight contractFlight);
        void setView(Contract.View view);
        List<Plane> getPlanes();
        Component getComponent();
        void addPoint(int id, int x, int y);
        Plane search(int x, int y);
        void clearRoute(int id);
        String getPlanesFlight();
        String getPlanesLanded();
        String getTimePlayed();
        void notifyPaused();
        void notifyResume();
        Point getAirstrip();
        void endGame();
        void notifyError();
    }
}
