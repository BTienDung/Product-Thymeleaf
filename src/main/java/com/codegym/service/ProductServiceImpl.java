package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.persistence.ProductPersistenceImpl;

import java.util.List;

public class ProductServiceImpl implements GeneralService<Product> {
    ProductPersistenceImpl productPersistence = new ProductPersistenceImpl();

    @Override
    public List<Product> findAll() {
        return productPersistence.findAll();
    }

    @Override
    public void save(Product product) {
        productPersistence.save(product);
    }

    @Override
    public void delete(Product product) {
        productPersistence.delete(product);
    }

    @Override
    public Product edit(Product product) {
        return productPersistence.edit(product);
    }

    @Override
    public Product findById(int id) {
        return productPersistence.findById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productPersistence.findByName(name);
    }
}
