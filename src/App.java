import Integration.Mailinator;
import test.Login;
public class App {
    public static void main(String[] args) {
        Login login =new Login();
        Mailinator mailinator = new Mailinator();
        login.setUp();
        login.simpleLogin();
        login.mfa(mailinator.getOtp());
        login.handlePopup();
        login.hoverActivity();
        // login.hoverSale();      
        login.scroll();
        login.terminate();
    }
}