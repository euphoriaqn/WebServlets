package com.annotationservlet.storage;

import com.annotationservlet.App;
import com.annotationservlet.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.UUID;

public class HibernateProductStorage implements IProductStorage {

    private static final HibernateProductStorage INSTANCE = new HibernateProductStorage();

    private SessionFactory sessionFactory;

    private HibernateProductStorage() {
        sessionFactory = App.getInstance().getSessionFactory();
    }

    public Product add(Product product) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(product);
        transaction.commit();
        session.close();
        return product;
    }

    public void delete(Product product) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(product);
        transaction.commit();
        session.close();
    }

    public Product get(UUID productId) {
        Product product = null;
        Session session = sessionFactory.openSession();
        product = (Product) session.get(Product.class, productId);
        session.close();
        return product;
    }

    public List<Product> listAll() {
        Session session = sessionFactory.openSession();
        List<Product> products = session.createQuery("from Product").list();
        session.close();
        return products;
    }

    public Product update(Product product) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(product);
        transaction.commit();
        session.close();
        return product;
    }
    public static HibernateProductStorage getInstance() {
        return INSTANCE;
    }
}
