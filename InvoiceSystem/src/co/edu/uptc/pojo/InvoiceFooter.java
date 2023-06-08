package co.edu.uptc.pojo;

public class InvoiceFooter {

    private double valueProducts;
    private double valueIva;
    private double totalPay;

    public InvoiceFooter(double valueProducts, double valueIva, double totalPay) {
        this.valueProducts = valueProducts;
        this.valueIva = valueIva;
        this.totalPay = totalPay;
    }

    public double getValueProducts() {
        return valueProducts;
    }

    public double getValueIva() {
        return valueIva;
    }

    public double getTotalPay() {
        return totalPay;
    }

    public void setValueProducts(int valueProducts) {
        this.valueProducts = valueProducts;
    }

    public void setValueIva(int valueIva) {
        this.valueIva = valueIva;
    }

    public void setTotalPay(int totalPay) {
        this.totalPay = totalPay;
    }

    @Override
    public String toString() {
        return "Products value: " + valueProducts + " Iva value: " + valueIva + " Total: " + totalPay;
    }
}
