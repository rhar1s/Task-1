package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao bd = new UserDaoHibernateImpl();
    public void createUsersTable() {
        bd.createUsersTable();
    }

    public void dropUsersTable() {
        bd.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        bd.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        bd.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return bd.getAllUsers();
    }

    public void cleanUsersTable() {
        bd.cleanUsersTable();
    }
}
