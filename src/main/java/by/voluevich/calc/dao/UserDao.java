package by.voluevich.calc.dao;

import by.voluevich.calc.entity.User;

import java.util.List;

public interface UserDao {

    boolean save(User user);

    boolean isExist(User user);

    User getByLogin(String email);

    boolean updatePassword(User user, String newPass);

    boolean updateName(User user, String newName);

    List<User> getAll();
}
