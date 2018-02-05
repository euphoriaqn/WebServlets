package com.annotationservlet.storage;

import com.annotationservlet.entity.Manufacturer;
import com.annotationservlet.entity.Product;

import java.util.List;
import java.util.UUID;

public interface IManufacturerStorage extends IGenericStorage<Manufacturer, UUID>{
    Manufacturer add(Manufacturer cat);
    void delete(Manufacturer cat);
    Manufacturer get(UUID catId);
    List<Manufacturer> listAll();
    Manufacturer update(Manufacturer manufacturer);
}
