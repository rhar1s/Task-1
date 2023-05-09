package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {
    }


    @Override
    public void createUsersTable() {
        String query = """
                CREATE TABLE IF NOT EXISTS Users (
                id          SERIAL PRIMARY KEY,
                name        VARCHAR(255),
                lastName    VARCHAR(255),
                age         SMALLINT
                )""";
        try (Session session = Util.sessionFactory().openSession()) {
            session.beginTransaction();
            session.createSQLQuery(query).executeUpdate();
            session.getTransaction().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        String query = "DROP TABLE IF EXISTS Users";
        try (Session session = Util.sessionFactory().openSession()) {
            session.beginTransaction();
            session.createSQLQuery(query).executeUpdate();
            session.getTransaction().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Session session = Util.sessionFactory().openSession()) {
            session.beginTransaction();
            User user = new User(name, lastName, age);
            session.save(user);
            session.getTransaction().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        try (Session session = Util.sessionFactory().openSession()) {
            session.beginTransaction();
            User user = session.get(User.class, id);
            if (user != null) {
                session.delete(user);
            }
            session.getTransaction().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> list;
        try (Session session = Util.sessionFactory().openSession()) {
            session.beginTransaction();
            list = session.createQuery("FROM Users", User.class).list();
            session.getTransaction().commit();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = Util.sessionFactory().openSession()) {
            session.beginTransaction();
            session.createQuery("DELETE FROM Users").executeUpdate();
            session.getTransaction().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}