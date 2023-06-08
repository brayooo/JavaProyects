package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class TaxCalculator {
    private static final double QUANTITY_OFS_TRATUM = 5;
    private static final double NUMBER_TO_GET_APRAISSAL = 1000;
    private static final String TOWN_CODE = "001";
    private ArrayList<Property> ArrayProperties;
    Properties properties;
    public static final int STRATA_ONE = 1;
    public static final int STRATA_TWO = 2;
    public static final int STRATA_THREE = 3;
    public static final int STRATA_FOUR = 4;
    public static final int STRATA_FIVE = 5;
    public static final int STRATA_SIX = 6;
    public static final int FIRST_RESIDENTIAL_RATE = 4;
    public static final double SECOND_RESIDENTIAL_RATE = 5.5;
    public static final double THIRD_RESIDENTIAL_RATE = 6.75;
    public static final double FOURTH_RESIDENTIAL_RATE = 7.75;
    public static final double FIFTH_RESIDENTIAL_RATE = 8.5;
    public static final double SIXTH_RESIDENTIAL_RATE = 10.5;
    public static final int FIRST_COMMERCIAL_RATE = 5;
    public static final double SECOND_COMMERCIAL_RATE = 7.5;
    public static final double THIRD_COMMERCIAL_RATE = 10.5;
    public static final double FOURTH_COMMERCIAL_RATE = 11.5;
    public static final int FIFTH_COMMERCIAL_RATE = 12;
    public static final int SIXTH_COMMERCIAL_RATE = 15;
    public static final int BASE_RATE = 1000;

    public TaxCalculator() {
        properties = new Properties();
        ArrayProperties = new ArrayList<Property>();
    }

    public double consultPropertyTax(String cadastralNumber, boolean exceptPayment, boolean earlyPayment)
            throws Exception {
        properties.load(new FileReader("src/Resource/discount.properties"));
        Property property = searchProperty(cadastralNumber);
        double discount = 0;
        double baseTax = calculatePropertyValue(property.getAppraisal(), property.getStrata(), property.getUsage(),
                property.getArea());
        if (exceptPayment) {
            discount += calculateExemptDiscount(baseTax);
        }
        if (earlyPayment) {
            discount += calculateEarlyDiscount(baseTax);
        }
        System.out.println(discount);
        return baseTax - discount;
    }

    public boolean convertIntToBoolean(int intOption) {
        boolean option;
        if (intOption == 1) {
            option = false;
        } else {
            option = true;
        }
        return option;
    }

    public void addProperty(Property property) {
        ArrayProperties.add(property);
    }

    public void loadProperties() throws IOException {
        FileReader source = new FileReader("src/Data/BOYACA_REG1.txt");
        BufferedReader buffer = new BufferedReader(source);
        String line = buffer.readLine();
        while ((line = buffer.readLine()) != null) {
            String[] data = line.split("\t");
            if (!data[1].equals(TOWN_CODE)) {
                return;
            }
            int area = Integer.parseInt(data[5]);//
            ArrayProperties.add(new Property(data[2], data[3], area, (int) ((Math.random() * 5) + 1), usage(data[4]),
                    area * (int) (Math.random() * NUMBER_TO_GET_APRAISSAL)));
        }
        buffer.close();
    }

    private Usage usage(String type) {
        if (type.equals("D")) {
            return Usage.COMMERCIAL;
        } else {
            return Usage.RESIDENTIAL;
        }
    }

    public Property searchProperty(String cadastralNumber) throws Exception {
        for (Property p : ArrayProperties) {
            if (p.getCadastralNumber().equals(cadastralNumber)) {
                System.out.println(p);
                return p;
            }
        }
        throw new Exception("The property doesn't found");
    }

    private double calculateEarlyDiscount(double baseTax) throws IOException {
        double discount = 0;
        properties.load(new FileReader("src/Resource/discount.properties"));
        discount = baseTax * Double.parseDouble(properties.getProperty("earlyPayment"));//
        return discount;
    }

    private double calculateExemptDiscount(double baseTax) throws IOException {
        double discount = 0;
        properties.load(new FileReader("src/Resource/discount.properties"));
        discount = baseTax * Double.parseDouble(properties.getProperty("exceptPayment"));//
        return discount;
    }

    private double calculatePropertyValue(int appraisal, int strata, Usage usage, int area) throws IOException {
        double taxValue = 0;
        if (usage.equals(Usage.RESIDENTIAL)) {
            taxValue = calculateResidentialPropertyValue(appraisal, strata, area);//
        } else {
            taxValue = calculateCommercialPropertyValue(appraisal, area);
        }
        return taxValue;
    }

    private double calculateResidentialPropertyValue(int appraisal, int strata, int area) {
        double taxValue;
        switch (strata) {
            case STRATA_ONE:
                taxValue = appraisal + ((area / FIRST_RESIDENTIAL_RATE) * BASE_RATE);
                break;
            case STRATA_TWO:
                taxValue = appraisal + ((area / SECOND_RESIDENTIAL_RATE) * BASE_RATE);
                break;
            case STRATA_THREE:
                taxValue = appraisal + ((area / THIRD_RESIDENTIAL_RATE) * BASE_RATE);
                break;
            case STRATA_FOUR:
                taxValue = appraisal + ((area / FOURTH_RESIDENTIAL_RATE) * BASE_RATE);
                break;
            case STRATA_FIVE:
                taxValue = appraisal + ((area / FIFTH_RESIDENTIAL_RATE) * BASE_RATE);
                break;
            case STRATA_SIX:
                taxValue = appraisal + ((area / SIXTH_RESIDENTIAL_RATE) * BASE_RATE);
                break;
            default:
                return 0;
        }
        return taxValue;
    }

    private double calculateCommercialPropertyValue(int appraisal, int area) throws IOException {
        properties.load(new FileReader("src/Resource/range.properties"));
        double taxValue;
        if (appraisal < Integer.parseInt(properties.getProperty("firstRate"))) {
            taxValue = appraisal + ((area / FIRST_COMMERCIAL_RATE) * BASE_RATE);
        } else if (appraisal < Integer.parseInt(properties.getProperty("secondRate"))) {
            taxValue = appraisal + ((area / SECOND_COMMERCIAL_RATE) * BASE_RATE);
        } else if (appraisal < Integer.parseInt(properties.getProperty("thirdRate"))) {
            taxValue = appraisal + ((area / THIRD_COMMERCIAL_RATE) * BASE_RATE);
        } else if (appraisal < Integer.parseInt(properties.getProperty("fourthRate"))) {
            taxValue = appraisal + ((area / FOURTH_COMMERCIAL_RATE) * BASE_RATE);
        } else if (appraisal < Integer.parseInt(properties.getProperty("fifthRate"))) {
            taxValue = appraisal + ((area / FIFTH_COMMERCIAL_RATE) * BASE_RATE);
        } else {
            taxValue = appraisal + ((area / SIXTH_COMMERCIAL_RATE) * BASE_RATE);
        }
        return taxValue;
    }

}
