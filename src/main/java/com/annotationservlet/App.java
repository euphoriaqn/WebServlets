package com.annotationservlet;

import com.annotationservlet.storage.HibernateProductStorage;
import com.annotationservlet.storage.IProductStorage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    private static final App INSTANCE = new App();

    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


    private App() {
    }

    public static App getInstance() {
        return INSTANCE;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
