package Business.concretes;

import Business.abstarcts.UserService;
import Core.concretes.Util;
import DataAccess.abstarcts.UserDao;
import Entities.concretes.User;

import java.util.ArrayList;
import java.util.List;

public class UserManager implements UserService {
    private UserDao userDao;

    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        if (!validate(user)) return;
        userDao.addToDatabase(user);
    }

    @Override
    public void delete(int id) {
        userDao.deleteFromDatabase(id);
    }

    @Override
    public void update(User user) {
        if (!validate(user)) return;
        userDao.updateFromDatabase(user);
    }

    @Override
    public User get(String email) {
        return userDao.getFromDatabase(email);
    }

    @Override
    public void getAll() {
        for (User user : userDao.getAllFromDatabase()) {
            System.out.println("name : " + user.getFirstName() + "\n" +
                    "surname : " + user.getLastName() + "\n" +
                    "email : " + user.getEmail());
        }
    }

    private boolean validate(User user) {
        List<String> errors = new ArrayList<>();

        if (user.getFirstName().length() < 2
                && user.getLastName().length() < 2)
            errors.add("The number of characters must be at least 2");
        if (user.getPassword().length() < 6)
            errors.add("The number of characters must be at least 6");
        if (!Util.verify(user.getEmail()))
            errors.add("Your email is incorrect");
        if (get(user.getEmail()) != null)
            errors.add("You have already account");
        if (errors.size() < 1) {
            return true;
        }
        for (String message : errors) {
            System.out.println(message);
        }
        return false;
    }

}
