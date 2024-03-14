package test.target;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Target {
    public String targetName="Sample Target 2";
    WebDriver driver ; WebDriverWait wait ;
    public Target(WebDriver driver , WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
    public void createNewTarget(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Marketing')]"))).click();   
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contacts\"]//a[contains(text(),'Targets')]"))).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"new_button_help\"]/a"))).click();  
            Thread.sleep(1000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"first_name\"]"))).sendKeys(targetName);
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            
        } catch (Exception e) {
           System.out.println("Error = "+e.getMessage());
        }
    }
    public String getTargetName(){
        return targetName;
    }
}
