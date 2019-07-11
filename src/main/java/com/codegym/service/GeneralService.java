package com.codegym.service;

import java.util.List;

public interface GeneralService<E> {
    List<E> findAll();
    void save(E e);
    void delete(E e);
    E edit(E e);
    E findById(int id);
    List<E> findByName(String name);
}
