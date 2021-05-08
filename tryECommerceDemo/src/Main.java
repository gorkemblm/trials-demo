import Business.abstarcts.AuthService;
import Business.abstarcts.UserService;
import Business.concretes.AuthManager;
import Business.concretes.UserManager;
import Core.concretes.EmailManager;
import Core.concretes.GoogleManagerAdapter;
import DataAccess.concretes.InMemoryUserDao;
import Entities.concretes.User;

public class Main {

    public static void main(String[] args) {
        String e = "gorkembilim@test.com";
        String p = "1234567";
        InMemoryUserDao inMemoryUserDao = new InMemoryUserDao();
        UserService userService = new UserManager(inMemoryUserDao);
        AuthService authService = new AuthManager(new EmailManager(),userService,new GoogleManagerAdapter(userService,e,p));
        authService.signIn();
        for (User user:inMemoryUserDao.getAllFromDatabase())
        {
            System.out.println(user.getEmail());
        }
        //authService.signUp(new User(1,"E","D","emretest.com","12347"));


    }
}
