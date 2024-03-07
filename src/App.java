import test.Login;
// import test.emailsend;
// import org.openqa.selenium.WebDriver;

// import org.openqa.selenium.chrome.ChromeDriver;
public class App {

    public static void main(String[] args) {
        Login login =new Login();
        
        // WebDriver driver = new ChromeDriver();
        // driver.manage().window().maximize(); 
        
        login.setUp();
        login.simpleLogin();
        login.hoverActivity();
        // login.hoverSale();
       
        login.scroll();
         login.terminate();
    }
}