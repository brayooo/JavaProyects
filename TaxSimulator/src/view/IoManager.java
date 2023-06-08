package view;

import javax.swing.*;
import presenter.MenuOption;
public class IoManager {

    private static final String WELCOME_MESSAGE = "\tPROPERTY TAX SIMULATOR\n";
    private static final String MENU= "MENU:\n";
    private static final String MENU_TEXT = "Please select an option: ";
    private static final String ERROR = "Error";
    private static final String CADASTRAL_CODE_MESSAGE = "Please enter the cadastral code:";
    public static final String IS_THE_PROPERTY_EXEMPT = "Is the property exempt?";
    public static final String WAS_THE_TAX_PAID_PROMPTLY = "Was the tax paid promptly?";
    public static final String TOTAL_TAX_MESSAGE = "The total value of your property tax is:";

    public String getCadastralCode() {
        return JOptionPane.showInputDialog(null, CADASTRAL_CODE_MESSAGE);
    }

    public int getExemptionAnswer() {
        return JOptionPane.showConfirmDialog(null, IS_THE_PROPERTY_EXEMPT, null, JOptionPane.YES_NO_OPTION);
    }

    public int getPaymentAnswer() {
        return JOptionPane.showConfirmDialog(null, WAS_THE_TAX_PAID_PROMPTLY, null, JOptionPane.YES_NO_OPTION);
    }

    public MenuOption showMenu(){
        int option = JOptionPane.showOptionDialog(null, WELCOME_MESSAGE + MENU + MENU_TEXT, null,
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                MenuOption.values(), MenuOption.values()[0]);
        return MenuOption.values()[option];
    }

    public void printTotalTax(double totalTax){
        JOptionPane.showMessageDialog(null, TOTAL_TAX_MESSAGE + totalTax, null, JOptionPane.INFORMATION_MESSAGE);
    }

    public void showError(String error){
        JOptionPane.showMessageDialog(null, error, ERROR, JOptionPane.WARNING_MESSAGE);
    }
}
