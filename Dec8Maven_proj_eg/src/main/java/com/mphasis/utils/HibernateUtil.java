package com.mphasis.utils;  

import java.io.IOException;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory buildSessionFactory() {
        try {
            Properties props = new Properties();
            props.load(Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream("application.properties"));

            Configuration cfg = new Configuration();
            cfg.setProperties(props);
            cfg.addAnnotatedClass(com.mphasis.model.Orders.class);

            StandardServiceRegistryBuilder builder =
                    new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());

            return cfg.buildSessionFactory(builder.build());
        } catch (IOException e) {
            throw new ExceptionInInitializerError("Failed to load Hibernate configuration");
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
