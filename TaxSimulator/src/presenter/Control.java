package presenter;

import model.Property;
import model.TaxCalculator;
import model.Usage;
import view.IoManager;
import view.MyFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Control implements ActionListener {
    private IoManager io;
    private TaxCalculator taxCalculator;
    private MyFrame myFrame;

    public Control() throws IOException {
        myFrame = new MyFrame(this);
        //io = new IoManager();
        taxCalculator = new TaxCalculator();
        loadData();
        //showMenu();
    }

    /*private void showMenu(){
        MenuOption option = io.showMenu();
        switch(option){
            case CONSULT:
                consultTax();
                break;
            case EXIT:
                return;
        }
        showMenu();
    }*/

    private void consultTax(){
        try {
            io.printTotalTax(taxCalculator.consultPropertyTax(io.getCadastralCode(),
                    taxCalculator.convertIntToBoolean(io.getExemptionAnswer()),
                    taxCalculator.convertIntToBoolean(io.getPaymentAnswer())));
        } catch (Exception ioException) {
            io.showError(ioException.getMessage());
        }
    }

    private void loadData() throws IOException {
        taxCalculator.loadProperties();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String source = event.getActionCommand();
        if(source.equals("comando")){
            try {
                System.out.println(myFrame.getCadastralCode());
                Property property = taxCalculator.searchProperty(myFrame.getCadastralCode());
                myFrame.setTxtAddress(property.getAddress());
                myFrame.setTxtStratum(String.valueOf(property.getStrata()));
                myFrame.setTxtArea(String.valueOf(property.getArea()));
                myFrame.setTxtValue(String.valueOf(property.getAppraisal()));
                myFrame.setTxtUsage(property.getUsage());
                myFrame.setCadastralCode();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else if(source.equals("control")){
            try {
                myFrame.setValue(String.valueOf(taxCalculator.consultPropertyTax(myFrame.getCadastralCode(), myFrame.getStatusFirstCheckBox(), myFrame.getStatusSecondCheckBox())));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }
}
