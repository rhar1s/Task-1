package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl table = new UserServiceImpl();
        table.createUsersTable();

        table.saveUser("Rustem", "Harisov", (byte) 27);
        table.saveUser("Damir", "Yafizov", (byte) 28);
        table.saveUser("Almaz", "Nurkaev", (byte) 29);
        table.saveUser("Aliya", "Sabirova", (byte) 30);

        List<User> list = table.getAllUsers();
        for (User user : list) {
            System.out.println(user);
        }

        table.removeUserById(2);
        table.cleanUsersTable();
        table.dropUsersTable();
    }
}
