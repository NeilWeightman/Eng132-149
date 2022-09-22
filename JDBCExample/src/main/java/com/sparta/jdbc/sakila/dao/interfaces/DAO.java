package com.sparta.jdbc.sakila.dao.interfaces;

import java.util.List;

public interface DAO<T> {
    // CRUD Interface - create, read, update, delete
    int insert(T newRow);
    T findById(int id);
    void update(T updatedRow);
    void deleteById(int id);
    List<T> findAll();
}
