package model;

public class Property {
    private String cadastralCode;
    private String address;
    private int area;
    private int strata;
    private Usage usage;

    private int appraisal;


    public Property(String cadastralCode, String address, int area, int strata, Usage usage, int appraisal) {
        this.cadastralCode = cadastralCode;
        this.address = address;
        this.area = area;
        this.strata = strata;
        this.usage = usage;
        this.appraisal = appraisal;
    }

    public String getCadastralNumber() {
        return cadastralCode;
    }

    public int getStrata() {
        return strata;
    }

    public Usage getUsage() {
        return usage;
    }

    public int getAppraisal(){
        return appraisal;
    }

    public int getArea() {
        return area;
    }

    public String getAddress() {
        return address;
    }

    public void setCadastralNumber(String cadastralNumber) {
        this.cadastralCode = cadastralNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public void setStrata(int strata) {
        this.strata = strata;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }

    public void setAppraisal(int appraisal){
        this.appraisal=appraisal;
    }

    @Override
    public String toString() {
        return String.valueOf(cadastralCode);
    }

}
