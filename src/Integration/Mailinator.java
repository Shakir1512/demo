package Integration;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Mailinator {
    WebDriver driver;
    WebDriverWait wait;
    WebElement topMostMail, iframe;

    static{
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
    }

    public Mailinator(){
        driver = new ChromeDriver();
        driver.switchTo().newWindow(WindowType.TAB);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.mailinator.com/index.jsp");
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
        search.sendKeys("shakir15");
        WebElement goBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"site-header\"]/div[1]/div/div/div[1]/div/button")));  		
        goBtn.click();
        
    }

    public String getOtp(){
        String otp="";
        try{
            topMostMail = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/main/div[2]/div[3]/div/div[4]/div/div/table/tbody/tr[1]/td[2]")));
            Thread.sleep(2000);
            topMostMail.click();

            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//*[@id='html_msg_body']")));
            Thread.sleep(2000);
            iframe = driver.findElement(By.xpath("/html/body"));
            otp = iframe.getText().split(":")[1].trim();
            return otp;
        }
        catch(Exception e){
            System.out.println("Mailinator Error: " + e.getMessage());
        }
        finally{
        	
//            driver.quit();
        }
        return otp;
    }
}