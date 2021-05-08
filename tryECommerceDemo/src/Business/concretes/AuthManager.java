package Business.concretes;

import Business.abstarcts.AuthService;
import Business.abstarcts.UserService;
import Core.abstarcts.Authenticationservice;
import Core.abstarcts.EmailService;
import Entities.concretes.User;

public class AuthManager implements AuthService {

    private UserService userService;
    private Authenticationservice authenticationservice;
    private  EmailService emailService;

    public AuthManager(EmailService emailService,UserService userService,Authenticationservice authenticationservice) {
        this.emailService = emailService;
        this.userService = userService;
        this.authenticationservice = authenticationservice;
    }

    @Override
    public void signUp(User user) {
        userService.add(user);
    }

    @Override
    public void signIn() {
        if (authenticationservice.authorize()) {
            System.out.println("Login successfully");
        }else {
            System.out.println("Login unsuccesfully");
        }

    }
}
