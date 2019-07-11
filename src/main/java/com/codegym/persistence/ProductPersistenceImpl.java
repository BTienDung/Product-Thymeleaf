package com.codegym.persistence;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductPersistenceImpl implements GeneralPersistence<Product> {

    List<Product> productList = new ArrayList<>();
    {
        productList.add(new Product(1,"May giat", 300, "Con Hang"));
        productList.add(new Product(2,"Tivi", 400, "Het Hang"));
        productList.add(new Product(3,"Tu Lanh", 700, "Con Hang"));
        productList.add(new Product(4,"Dien Thoai", 300, "Con Hang"));
    }
    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public void delete(Product product) {
        for (int i=0; i<productList.size(); i++){
            if (productList.get(i).getId()==product.getId()){
                productList.remove(productList.get(i));
            }
        }
    }

    @Override
    public Product edit(Product product) {
        for (int i=0; i<productList.size(); i++){
            if (productList.get(i).getId()==product.getId()){
                productList.get(i).setName(product.getName());
                productList.get(i).setPrice(product.getPrice());
                productList.get(i).setStatus(product.getStatus());
            }
        }
        return null;
    }

    @Override
    public Product findById(int id) {
        for (int i=0;i<productList.size();i++){
            if (productList.get(i).getId()==id){
                return productList.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products = new ArrayList<>();
        for (int i=0; i<productList.size();i++){
            if (productList.get(i).getName().equals(name)){
                products.add(productList.get(i));
            }
        }
        return products;
    }
}
