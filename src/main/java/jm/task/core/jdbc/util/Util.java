package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;


public class Util {
    public static final String url = "jdbc:postgresql://localhost:5432/connection";
    public static final String username = "postgres";
    public static final String password = "Dfvgbh000!";
    public static final String driver_class = "org.postgresql.Driver";

    public static SessionFactory sessionFactory;

    public static SessionFactory sessionFactory() throws SQLException {
        if (sessionFactory == null) {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.driver_class", driver_class);
        configuration.setProperty("hibernate.connection.url", url);
        configuration.setProperty("hibernate.connection.username", username);
        configuration.setProperty("hibernate.connection.password", password);
        configuration.addAnnotatedClass(User.class);
        sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }

}
