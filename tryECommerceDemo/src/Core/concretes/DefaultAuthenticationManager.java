package Core.concretes;

import Business.abstarcts.UserService;
import Core.abstarcts.Authenticationservice;

public class DefaultAuthenticationManager implements Authenticationservice {
    private UserService userService;
    private String email;
    private String password;

    public DefaultAuthenticationManager(UserService userService, String email, String password) {
        this.userService = userService;
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean authorize() {
        try {
            return userService.get(email).getPassword().equals(password);
        } catch (Exception e) {

        }
        return false;

    }
}
