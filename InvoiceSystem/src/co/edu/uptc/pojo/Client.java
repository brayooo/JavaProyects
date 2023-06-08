package co.edu.uptc.pojo;

import co.edu.uptc.model.DocumentType;

public class Client {

    private static int counter = 0;
    private int uniqueId;
    private DocumentType documentType;
    private String idNumber;
    private String name;
    private String lastName;
    private String address;
    private String city;


    public Client(DocumentType documentType, String idNumber, String name, String lastName, String address, String city) {
        this.documentType = documentType;
        this.idNumber = idNumber;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.uniqueId = counter++;
    }


    public Client(){}

    public Client(int uniqueId, DocumentType documentType, String idNumber, String name, String lastName, String address, String city) {
        this.documentType = documentType;
        this.idNumber = idNumber;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.uniqueId = uniqueId;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public int getUniqueId() {
        return uniqueId;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public Client clone() {
        return new Client(getUniqueId(),getDocumentType(),getIdNumber(),getName(),getLastName(),getAddress(),getCity());
    }

    @Override
    public String toString() {
        return /*"UQ: " + uniqueId + "Dc type: " + documentType + */" Id: " + idNumber + " Name: " + name /*+ " LastName: " + lastName + " Address: " + address + " City: " + city*/;
    }
}
