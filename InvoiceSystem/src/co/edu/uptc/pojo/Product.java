package co.edu.uptc.pojo;

public class Product {

    private static int counter = 0;
    private int uniqueId;
    private String barCode;
    private String CIU;
    private String description;
    private double unitPrice;

    public Product(String barCode, String CIU, String description, double unitPrice) {
        this.barCode = barCode;
        this.CIU = CIU;
        this.description = description;
        this.unitPrice = unitPrice;
        this.uniqueId = counter++;
    }

    public Product(){

    }

    public Product(int uniqueId, String barCode, String ciu, String description, double unitPrice) {
        this.barCode = barCode;
        this.CIU = ciu;
        this.description = description;
        this.unitPrice = unitPrice;
        this.uniqueId = uniqueId;
    }


    public int getUniqueId() {
        return uniqueId;
    }

    public String getBarCode() {
        return barCode;
    }

    public String getCIU() {
        return CIU;
    }

    public String getDescription() {
        return description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public void setCIU(String CIU) {
        this.CIU = CIU;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public Product clone() {
        return new Product(getUniqueId(),getBarCode(),getCIU(),getDescription(),getUnitPrice());
    }

    @Override
    public String toString() {
        return "barCode: " + barCode + "Ciu: " + CIU + "descp: " + description + "unitprice: " + unitPrice;
    }
}
