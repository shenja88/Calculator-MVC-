package by.voluevich.calc.dao;

import by.voluevich.calc.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryUserDaoImpl implements UserDao{
    private static final List<User> USERS = new ArrayList<>();

    @Override
    public boolean save(User user) {
        if(!isExist(user)){
            USERS.add(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean isExist(User user) {
        return USERS.contains(user);
    }

    @Override
    public List<User> getAll() {
        return USERS;
    }

    @Override
    public User getByLogin(String email) {
        return USERS.stream().filter(u -> u.getEmail().equals(email)).findFirst().orElse(new User("none", "none", "none" ));
    }

    @Override
    public boolean updatePassword(User user, String newPass) {
        if(isExist(user)){
            USERS.get(USERS.indexOf(user)).setPassword(newPass);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateName(User user, String newName) {
        if(isExist(user)){
            USERS.get(USERS.indexOf(user)).setName(newName);
            return true;
        }
        return false;
    }
}
