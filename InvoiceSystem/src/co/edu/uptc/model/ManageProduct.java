package co.edu.uptc.model;

import co.edu.uptc.pojo.Product;

import java.util.ArrayList;
import java.util.List;

public class ManageProduct {

    private List<Product> products;
    private ModelManager modelManager;

    public ManageProduct (ModelManager modelManager){
        this.modelManager = modelManager;
        products = new ListUptc<>();
        ValidateRules.getInstance().setProducts(products);
    }

    public void addProduct(Product product) {
        if(searchProduct(product.getCIU())!= null){
            modelManager.presenter.notifyError("Producto ya registrado, ingrese uno diferente");
        }else {
            products.add(product.clone());
            modelManager.presenter.notifySuccession("Producto agregado correctamente");
            System.out.println(products.get(0));
            //showProducts();
        }
    }

    public Product searchProduct(String ciu){
        for (Product pr: products) {
            if(pr.getCIU().equals(ciu)){
                return pr;
            }
        }
        return null;
    }

    public Product searchProduct(int uniqueId){
        for (Product pr: products) {
            if(pr.getUniqueId()==uniqueId){
                return pr;
            }
        }
        return null;
    }

    public void editProduct(Product product){
        boolean validation = ValidateRules.getInstance().editProduct(product);
        Product pr = searchProduct(product.getUniqueId());
        if(validation &&  pr != null){
            pr.setBarCode(product.getBarCode());
            pr.setCIU(product.getCIU());
            pr.setDescription(product.getDescription());
            pr.setUnitPrice(product.getUnitPrice());
            modelManager.presenter.notifySuccession("El producto se editó exitosamente");
        }
    }

    public void deleteProduct(Product product){
        boolean validation = ValidateRules.getInstance().deleteProduct(product);
        Product pr = searchProduct(product.getUniqueId());
        if(validation && pr != null){
            products.remove(pr);
        }else{
            modelManager.presenter.notifyError("El producto no se puede borrar, se encuentra referenciado en una factura");
        }
    }

    private void showProducts(){
        for (Product pr: products) {
            System.out.println(pr);
        }
    }

    public List<Product> getProducts() {
        ArrayList<Product> auxProducts = new ArrayList<>();
        for (Product p : products) {
            auxProducts.add(p.clone());
        }
        return auxProducts;
    }



}
