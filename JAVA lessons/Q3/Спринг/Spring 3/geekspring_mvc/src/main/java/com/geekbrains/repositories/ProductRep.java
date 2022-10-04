package com.geekbrains.repositories;

import com.geekbrains.entites.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRep {
    private List<Product> products = new ArrayList<>();

    public List<Product> showAllProducts(){
        if (products.isEmpty()){
            Product newProd = new Product();
            newProd.setId(0);
            newProd.setTitle(null);
            newProd.setCost(0);
            products.add(newProd);
//            Product newProd1 = new Product();
//            newProd1.setId("Zloi");
//            newProd1.setTitle("Rai");
//            newProd1.setCost(999);
//            products.add(newProd1);
        }
        return products;
    }

    public Product showProdById(int id){
       return products.get(id);
    }

//    @Autowired
//    public void setProducts(List<Product> products) {
//        this.products = products;
//    }

    public void addProduct(Product product){
        products.add(product);
    }

    @Override
    public String toString() {
        return "ProductRep{" +
                "products=" + products +
                '}';
    }

    public Product findOneById(int id) {
        Product product = null;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id){
                product = products.get(i);
            }
        }
        if(product == null){
            return null;
        }
        return product;
    }
}
