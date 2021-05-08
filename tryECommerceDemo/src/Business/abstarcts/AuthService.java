package Business.abstarcts;

import Entities.concretes.User;

public interface AuthService {
    void signUp(User user);
    void signIn();
}
