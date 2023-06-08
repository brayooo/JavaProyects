package co.edu.uptc.views;

import co.edu.uptc.presenter.Contract;

import javax.swing.*;
import java.awt.*;

public class Board extends JFrame implements Contract.View {

    private PlayArea playArea;
    private ButtonPanel buttonPanel;
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
        buttonPanel = new ButtonPanel(this.getWidth(), this);
        this.add(playArea);
        this.add(buttonPanel,BorderLayout.SOUTH);
    }

    public void setPanelColor(Color color) {
        playArea.setBackground(color);
    }

    public void setRecColor(Color color) {
        playArea.setRecColor(color);
    }

    public int getPanelColor(){
        return playArea.getBackground().getRGB();
    }

    public int getRecColor(){
        return playArea.getRecColor().getRGB();
    }

    public Contract.Presenter getPresenter() {
        return presenter;
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
        playArea.paintRec();
    }
}
