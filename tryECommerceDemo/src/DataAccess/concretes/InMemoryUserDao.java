package DataAccess.concretes;

import DataAccess.abstarcts.UserDao;
import Entities.concretes.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserDao implements UserDao {
    //İçerisinde user tutması için
    private List<User> users = new ArrayList<User>();

    public InMemoryUserDao(){
        User user1 = new User(1,"Görkem","Bilim","gorkembilim@test.com","1234567");
        User user2 = new User(2,"Zafer","Çalışkan","zafercaliskan@test.com","1234567");
        User user3 = new User(3,"Sadık","Ortaoğlan","sadikortaoglan@test.com","1234567");

        users.add(user1);
        users.add(user2);
        users.add(user3);

    }

    @Override
    public void addToDatabase(User user) {
        users.add(user);
    }

    @Override
    public void deleteFromDatabase(int id) {
        User filterUser = users.stream().filter(s-> s.getId() == id).findFirst().orElse(null);
        users.remove(filterUser);

    }

    @Override
    public void updateFromDatabase(User user) {
        User filterUser = users.stream().filter(s->s.getEmail().equals(user.getEmail())).findFirst().orElse(null);
        filterUser.setId(user.getId());
        filterUser.setFirstName(user.getFirstName());
        filterUser.setLastName(user.getLastName());
        filterUser.setEmail(user.getEmail());
        filterUser.setPassword(user.getPassword());

    }

    @Override
    public User getFromDatabase(String email) {
        User filterUser = users.stream().filter(s-> s.getEmail().equals(email)).findFirst().orElse(null);
        return filterUser;
    }

    @Override
    public List<User> getAllFromDatabase() {
        return users;
    }
}
