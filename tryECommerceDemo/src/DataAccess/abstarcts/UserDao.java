package DataAccess.abstarcts;

import Entities.concretes.User;

import java.util.List;

public interface UserDao {
    void addToDatabase(User user);
    void deleteFromDatabase(int id);
    void updateFromDatabase(User user);
    User getFromDatabase(String email);
    List<User> getAllFromDatabase();
}
