import Business.abstarcts.AuthService;
import Business.abstarcts.UserService;
import Business.concretes.AuthManager;
import Business.concretes.UserManager;
import Core.abstarcts.Authenticationservice;
import Core.abstarcts.EmailService;
import Core.concretes.DefaultAuthenticationManager;
import Core.concretes.EmailManager;
import Core.concretes.GoogleManagerAdapter;
import DataAccess.abstarcts.UserDao;
import DataAccess.concretes.InMemoryUserDao;
import Entities.concretes.User;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String actions1 = "1 - SignIn\n" +
                "2 - SignUp\n" +
                "q - Quit";
        String actions2 = "1- Others\n" +
                "2 - Google Account";

        UserDao inMemoryUserDao = new InMemoryUserDao();
        UserService userService = new UserManager(inMemoryUserDao);


        while (true) {
            System.out.println(actions1);
            System.out.print("Choose an action : ");
            String inputMain = scanner.nextLine();
            if (inputMain.equals("q")) {
                System.out.println("Logging out...");
                return;
            } else if (inputMain.equals("1")) {
                System.out.println(actions2);
                System.out.print("Choose an action : ");
                String inputUnit = scanner.nextLine();
                if (inputUnit.equals("1")) {
                    System.out.print("Email : ");
                    String email = scanner.nextLine();
                    System.out.print("Password : ");
                    String password = scanner.nextLine();
                    AuthService authService = new AuthManager(new EmailManager(), userService, new DefaultAuthenticationManager(userService, email, password));
                    authService.signIn();
                    return;
                } else if (inputUnit.equals("2")) {
                    System.out.print("Email : ");
                    String email = scanner.nextLine();
                    System.out.print("Password : ");
                    String password = scanner.nextLine();
                    AuthService authService = new AuthManager(new EmailManager(), userService, new GoogleManagerAdapter(userService, email, password));
                    authService.signIn();
                    return;
                } else {
                    System.out.println("Wrong action!");
                }
            } else if (inputMain.equals("2")) {
                while (true) {
                    System.out.println(actions2);
                    System.out.print("Choose an action : ");
                    String inputUnit2 = scanner.nextLine();
                    if (inputUnit2.equals("1")) {
                        System.out.print("First Name : ");
                        String firstName = scanner.nextLine();
                        System.out.print("Last Name : ");
                        String lastName = scanner.nextLine();
                        System.out.print("Email : ");
                        String email = scanner.nextLine();
                        System.out.print("Password : ");
                        String password = scanner.nextLine();
                        User user = new User(101, firstName, lastName, email, password);

                        AuthService authService = new AuthManager(new EmailManager(), userService, new DefaultAuthenticationManager(userService, email, password));
                        authService.signUp(user);
                        return;
                    } else if (inputUnit2.equals("2")) {
                        System.out.print("Email : ");
                        String email = scanner.nextLine();
                        System.out.print("Password : ");
                        String password = scanner.nextLine();
                        AuthService authService = new AuthManager(new EmailManager(), userService, new GoogleManagerAdapter(userService, email, password));
                        authService.signIn();
                        System.out.println("Succesfully Registered!");
                        return;
                    } else {
                        System.out.println("Wrong action!");
                        return;
                    }
                }
            } else {
                System.out.println("Wrong action!");
            }
        }

    }
}
