
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import test.list.List;
import test.login.Login;
// import test.target.Target;

public class App {
    static{
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
    }
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://app01.convergehub.com");
        Login login = new Login(driver, wait);
        login.simpleLogin();
        // Target target = new Target(driver, wait);
        // target.createNewTarget();
        List list = new List(driver, wait);
        list.createNewList();
        // list.addTarget();
    }

}