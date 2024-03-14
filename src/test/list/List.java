package test.list;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import test.target.Target;

public class List {
    WebDriver driver ; WebDriverWait wait ;
    public List(WebDriver driver , WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
    Target target = new Target(driver, wait);
    public String targetName= target.getTargetName();
    public void createNewList(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Marketing')]"))).click();   
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contacts\"]//a[contains(text(),'Lists')]"))).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"new_button_help\"]/a"))).click();  
            Thread.sleep(1000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"name\"]"))).sendKeys("Sample List 2");
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            Thread.sleep(1000);
            addTarget();
            
            
        } catch (Exception e) {
           System.out.println("Error = "+e.getMessage());
        }
    }
    public void addTarget(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Marketing')]"))).click();   
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contacts\"]//a[contains(text(),'Lists')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='addtargetsub']//a[contains(text(),'Add')]"))).click();
        
        WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"add_new_subscriber\"]//a[contains(text(),'Targets')]")));

       Actions action = new Actions(driver);
       action.clickAndHold(ele).build().perform();
       
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"add_new_subscriber\"]//a[2]"))).click();
       
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody[@id='popup_list_targets']//input[@class='list_checkbox']"))).click();
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='button']//span[contains(text(),'Add Selected')]"))).click();
       
    }
}
