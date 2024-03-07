import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

// import org.openqa.selenium.firefox.FirefoxDriver;  
public class signuptest {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/core/Desktop/Testing/demo/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Launch website
        driver.navigate().to("https://www.convergehub.com/signup");

        // driver.findElement(By.name("cookie-close")).click();
        // WebElement sign = driver.findElement(By.name("cta-1 opensemi"));

        // sign.click();
        
        WebElement userName = driver.findElement(By.id("name_signup"));
        WebElement userEmail = driver.findElement(By.id("email_signup"));
        WebElement userPassword = driver.findElement(By.id("paw"));
        WebElement signupButton = driver.findElement(By.id("signup_button"));
        

        userName.sendKeys("Sample Corelynx Testing");
        userEmail.sendKeys("test12@gmail.com");
        userPassword.sendKeys("Shakir@151200");
        signupButton.click();
        Thread.sleep(5000);
        

        WebElement phone = driver.findElement(By.id("phone"));
        WebElement company = driver.findElement(By.id("company"));
        // WebElement industry = driver.findElement(By.id("paw"));
        Select industry = new Select(driver.findElement(By.name("selectbox")));
        WebElement createButton = driver.findElement(By.id("signup_stp2_button"));

        phone.sendKeys("1234567890");
        company.sendKeys("Corelyx Sample Testing");
        // industry.sendKeys("Shakir@151200");
        industry.selectByVisibleText("Banking");
        createButton.click();
        Thread.sleep(5000);
        
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // driver.quit();
    }

}