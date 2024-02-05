import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

// import org.openqa.selenium.firefox.FirefoxDriver;  
public class App {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/core/Desktop/Testing/demo/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Launch website
        driver.navigate().to("https://app01.convergehub.com/");

        WebElement userName = driver.findElement(By.id("username"));
        WebElement userPassword = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginb"));

        userName.sendKeys("mdshakir151200@gmail.com");
        userPassword.sendKeys("Shakir@151200");
        loginButton.click();
        // Thread.sleep(10000);
        WebElement proceed = driver.findElement(By.linkText("Proceed"));
        if(proceed.isDisplayed()){
            proceed.click();
        }

        WebElement imageElement = driver.findElement(By.id("admin-name-settings")).findElement(By.tagName("img"));

        Actions actions = new Actions(driver);
        actions.moveToElement(imageElement).perform();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement adminSettingsButton = driver.findElement(By.linkText("Admin Settings"));

        WebElement logout = driver.findElement(By.linkText("Logout"));
        logout.click();
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        driver.quit();
    }

}