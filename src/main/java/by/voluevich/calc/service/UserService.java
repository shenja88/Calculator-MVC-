package by.voluevich.calc.service;

import by.voluevich.calc.dao.UserDao;
import by.voluevich.calc.entity.User;
import by.voluevich.calc.utils.Patterns;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean saveUser(User user){
        return userDao.save(user);
    }

    public boolean signIn(User user){
        return userDao.isExist(user);
    }

    public User getByLogin(String email){
        return userDao.getByLogin(email);
    }

    public boolean updateName(String newName, User user){
        if(!user.getName().equals(newName) && userDao.isExist(user)){
            return userDao.updateName(user, newName);
        }
        return false;
    }

    public boolean updatePass(String oldPass, String newPass, User user){
        if(user.getPassword().equals(oldPass)
                && !newPass.equals(oldPass)
                && Pattern.matches(Patterns.PASSWORD, newPass)
                && userDao.isExist(user)){
            return userDao.updatePassword(user, newPass);
        }
        return false;
    }
}
