package co.edu.uptc.views;

import co.edu.uptc.presenter.Contract;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Board extends JFrame implements Contract.View {

    private PanelArea panelArea;
    private Contract.Presenter presenter;

    public Board() {
        setSize(400, 400);
        setLayout(new BorderLayout());
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    private void initComponents() {
        panelArea = new PanelArea(this);
        this.add(panelArea);
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


}
