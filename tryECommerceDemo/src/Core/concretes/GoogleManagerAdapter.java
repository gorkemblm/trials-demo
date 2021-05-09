package Core.concretes;

import Business.abstarcts.UserService;
import Core.abstarcts.Authenticationservice;
import Entities.concretes.User;

public class GoogleManagerAdapter implements Authenticationservice {
    private UserService userService;
    private String email;
    private String password;

    public GoogleManagerAdapter(UserService userService, String email, String password) {
        this.userService = userService;
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean authorize() {
        //Google dan sorgulanmış ve doğrulanmış kabul edilip user eklendi.
        userService.add(new User(1, "GoogleFirstName", "GoogleLastName", email, password));
        return true;//Yetkilendirme varsa
    }
}
