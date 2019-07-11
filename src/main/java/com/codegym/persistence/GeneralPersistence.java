package com.codegym.persistence;


import com.codegym.model.Product;

import java.util.List;

public interface GeneralPersistence<E> {
    List<E> findAll();
    void save(E e);
    void delete(E E);
    E edit(E e);
    E findById(int id);
    List<E> findByName(String name);
}
