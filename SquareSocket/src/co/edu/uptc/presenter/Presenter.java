package co.edu.uptc.presenter;

import co.edu.uptc.pojos.RectangleUptc;

import java.awt.*;

public class Presenter implements Contract.Presenter {

    private Contract.Model model;
    private Contract.View view;

    @Override
    public void setModel(Contract.Model model) {
        this.model = model;
    }

    @Override
    public void setView(Contract.View view) {
        this.view = view;
    }

    @Override
    public RectangleUptc getRectangle() {
        return model.getRectangle();
    }

    @Override
    public void addPoint(Point point) {
        model.addPoint(point);
    }

    @Override
    public boolean findRectangle(Point point) {
        return model.findRectangle(point);
    }

    @Override
    public int getPanelColor() {
        return view.getPanelColor();
    }

    @Override
    public int getRecColor() {
        return view.getRecColor();
    }

    @Override
    public void setPanelColor(int color) {
        view.setPanelColor(new Color(color));
    }

    @Override
    public void setRecColor(int color) {
        view.setRecColor(new Color(color));
    }

}
