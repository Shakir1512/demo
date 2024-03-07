import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class App {

    public static void main(String[] args) {
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        login(driver);
        performActionsAfterLogin(driver);
        logout(driver);

    }

    public static void login(WebDriver driver) {
        driver.navigate().to("https://app01.convergehub.com/");

        WebElement userName = driver.findElement(By.id("username"));
        WebElement userPassword = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginb"));

        userName.sendKeys("mdshakir151200@gmail.com");
        userPassword.sendKeys("Shakir@151200");
        loginButton.click();

        WebElement proceed = driver.findElement(By.linkText("Proceed"));
        if (proceed.isDisplayed()) {
            proceed.click();
        }
    }

    public static void performActionsAfterLogin(WebDriver driver) {
        WebElement element = driver.findElement(By.linkText("Not Now"));
        if (element.isDisplayed() && element.isEnabled()) {
            element.click();
        }
        
        WebElement imageElement = driver.findElement(By.id("admin-name-settings")).findElement(By.tagName("img"));

        Actions actions = new Actions(driver);
        actions.moveToElement(imageElement).perform();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // WebElement adElements = driver.findElements(By.className("ad-element"));

        // if (adElements.isDisplayed()) {
        // // Close the ad by clicking on the close button or another suitable action
        // WebElement closeButton =
        // adElements.findElement(By.className("close-button"));
        // closeButton.click();
        // }
        // WebElement adminSettingsButton = driver.findElement(By.linkText("Admin
        // Settings"));
    }

    public static void logout(WebDriver driver) {

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
