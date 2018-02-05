package com.annotationservlet.storage;

import com.annotationservlet.entity.Product;

import java.util.List;
import java.util.UUID;

public interface IProductStorage extends IGenericStorage<Product, UUID>{
    Product add(Product cat);
    void delete(Product cat);
    Product get(UUID catId);
    List<Product> listAll();
    Product update(Product cat);
}
