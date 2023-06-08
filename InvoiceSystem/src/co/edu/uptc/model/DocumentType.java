package co.edu.uptc.model;

public enum DocumentType {
    CITIZENSHIP_CARD("CC"),FOREIGN_ID("Cedula de extranjeria"),PASSPORT("Pasaporte");

    private String typeDocument;

    DocumentType(String typeDocument){
        this.typeDocument = typeDocument;
    }
    public String getTypeDocument() {
        return this.typeDocument;
    }

    @Override
    public String toString() {
        return typeDocument;
    }
}
