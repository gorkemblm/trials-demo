package Business.abstarcts;

import Entities.concretes.User;

public interface UserService {
    void add(User user);

    void delete(int id);

    void update(User user);

    User get(String email);

    void getAll();

}
