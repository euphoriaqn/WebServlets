package com.annotationservlet.storage;

import com.annotationservlet.entity.Product;

import java.util.List;
import java.util.UUID;

public interface IGenericStorage<T, ID> {
    T add(T t);
    void delete(T t);
    T get(ID id);
    List<T> listAll();
    T update(T t);
}