package co.edu.uptc.pojo;

public class InvoiceDetails {

    private int itemNumber;
    private String productCode;
    private String description;
    private double unitValue;
    private int quantity;
    private double quantityValue;

    public InvoiceDetails(int itemNumber,String productCode, String description
            , double unitValue, int quantity, double quantityValue) {
        this.itemNumber = itemNumber;
        this.productCode = productCode;
        this.description = description;
        this.unitValue = unitValue;
        this.quantity = quantity;
        this.quantityValue = quantityValue;
    }

    public InvoiceDetails(String productCode, String description, double unitValue, int quantity) {
        this.productCode = productCode;
        this.description = description;
        this.unitValue = unitValue;
        this.quantity = quantity;
    }


    public InvoiceDetails() {
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getDescription() {
        return description;
    }

    public double getQuantityValue() {
        return quantityValue;
    }

    public double getUnitValue() {
        return unitValue;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUnitValue(double unitValue) {
        this.unitValue = unitValue;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setQuantityValue(double quantityValue) {
        this.quantityValue = quantityValue;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    @Override
    public InvoiceDetails clone() {
        return new InvoiceDetails(getItemNumber(),getProductCode(),getDescription(),getUnitValue(),getQuantity(),getQuantityValue());
    }

    @Override
    public String toString() {
        return " itemNumb: " + itemNumber + " ProductCode: " + productCode + " Description: " + description + " Value: " + unitValue + " Quantity: " + quantity + " Quantity x value: " + quantityValue;
    }
}
