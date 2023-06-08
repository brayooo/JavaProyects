package co.edu.uptc.views;

import co.edu.uptc.pojos.Plane;
import co.edu.uptc.presenter.Contract;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Board extends JFrame implements Contract.View {

    private PlayArea playArea;
    private DialogColor dialogColor;
    private MenuBar menuBar;
    private StatusBar statusBar;
    private StatsDialog statsDialog;
    private Contract.Presenter presenter;

    public Board() {
        setSize(900, 600);
        setLayout(new BorderLayout());
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initComponents() {
        playArea = new PlayArea(this);
        menuBar = new MenuBar(this,this.getWidth());
        statusBar = new StatusBar(this);
        dialogColor = new DialogColor(playArea);
        statsDialog = new StatsDialog(this);
        this.add(statusBar, BorderLayout.SOUTH);
        this.add(playArea);
        this.setJMenuBar(menuBar);
    }

    public void setDialog(){
        dialogColor.setVisible(true);
        dialogColor.setPlaneInfo();
    }

    public void setStatsDialog(){
        statsDialog.setVisible(true);
        statsDialog.setLandedCount(presenter.getPlanesLanded());
        statsDialog.setTimeCount(presenter.getTimePlayed());
    }

    public void setPlaneSpeed(){
        if(playArea.getPlane() != null) {
            playArea.getPlane().setSpeed(dialogColor.setSliderValue());
        }
    }

    public void setCountFlights(){
        statusBar.setPlanePlayingCount(presenter.getPlanesFlight());
    }

    public  void setCountLanded(){
        statusBar.setPlanesLandedCount(presenter.getPlanesLanded());
    }

    public void endPaint (){
        playArea.endPaint();
        playArea.getPlanes().clear();
        playArea.repaint();
    }

    @Override
    public void setPresenter(Contract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        setVisible(true);
    }

    @Override
    public void initGame() {
        playArea.paintPlanes();
    }

    @Override
    public Component getComponent() {
        return this;
    }

    @Override
    public Point getAirstrip() {
        return playArea.getAirstrip();
    }

    @Override
    public void notifyError() {
        setStatsDialog();
    }

    public List<Plane> getPlanes() {
        return presenter.getPlanes();
    }

    public Contract.Presenter getPresenter() {
        return presenter;
    }
}
