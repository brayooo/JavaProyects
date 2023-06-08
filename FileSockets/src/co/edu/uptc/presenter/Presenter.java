package co.edu.uptc.presenter;

import java.io.File;

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
    public void setFile(File file) {
        model.setFile(file);
    }


}
