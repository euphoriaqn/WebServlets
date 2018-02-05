package com.annotationservlet.storage;

import com.annotationservlet.App;
import com.annotationservlet.entity.Manufacturer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class HibernateManufacturerStorage implements IManufacturerStorage {
    private static final HibernateManufacturerStorage INSTANCE = new HibernateManufacturerStorage();

    private SessionFactory sessionFactory;

    private HibernateManufacturerStorage() {
        sessionFactory = App.getInstance().getSessionFactory();
    }

    public static HibernateManufacturerStorage getInstance() {
        return INSTANCE;
    }

    public Manufacturer add(Manufacturer manufacturer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(manufacturer);
        transaction.commit();
        session.close();
        return manufacturer;
    }

    public void delete(Manufacturer manufacturer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(manufacturer);
        transaction.commit();
        session.close();
    }

    public Manufacturer get(UUID manufacturerId) {
        Manufacturer manufacturer = null;
        Session session = sessionFactory.openSession();
        manufacturer = (Manufacturer) session.get(Manufacturer.class, manufacturerId);
        session.close();
        return manufacturer;
    }

    public List<Manufacturer> listAll() {
        Session session = sessionFactory.openSession();
        List<Manufacturer> manufacturers = session.createQuery("from Manufacturer").list();
        session.close();
        return manufacturers;
    }

    public Manufacturer update(Manufacturer manufacturer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(manufacturer);
        transaction.commit();
        session.close();
        return manufacturer;
    }
}
