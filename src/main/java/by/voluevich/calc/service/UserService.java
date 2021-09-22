package by.voluevich.calc.service;

import by.voluevich.calc.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();

    public boolean saveUser(User user){
        if(!users.contains(user)){
            users.add(user);
            return true;
        }
        return false;
    }

    public boolean isExistUser(User user){
        for (User u: users) {
            if(u.getLogin().equals(user.getLogin()) && u.getPassword().equals(user.getPassword())){
                return true;
            }
        }
        return false;
    }

    public User getByLogin(String login){
        for (User u: users) {
            if(u.getLogin().equals(login)){
                return u;
            }
        }
        return new User();
    }

    public boolean updateName(String newName, User user){
        if(!user.getName().equals(newName)){
            users.get(users.indexOf(user)).setName(newName);
            return true;
        }
        return false;
    }

    public boolean updatePass(String oldPass, String newPass, User user){
        if(user.getPassword().equals(oldPass) && !newPass.equals(oldPass)){
            users.get(users.indexOf(user)).setPassword(newPass);
            return true;
        }
        return false;
    }
}
