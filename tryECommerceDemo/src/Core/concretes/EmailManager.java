package Core.concretes;

import Core.abstarcts.EmailService;

public class EmailManager implements EmailService {

    @Override
    public boolean isTheLinkClicked() {
        return true;
    }

    @Override
    public void sendToMail() {
        System.out.println("Verification email sent");
    }

}
