package test.campaign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Campaign {
    WebDriver driver ; WebDriverWait wait ;
    public Campaign(WebDriver driver , WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void createCampaign(){
        try {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Marketing')]"))).click();   
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contacts\"]//a[contains(text(),'Campaigns')]"))).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"new_button_help\"]"))).click();  
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"name\"]"))).sendKeys("Sample Campaign");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"budget\"]"))).sendKeys("500");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"name\"]"))).sendKeys("Sample Broadcast");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=\"broadcast_dom\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[contains(text(),'Direct Mail')]"))).click();
        driver.findElement(By.xpath("//input[@type='button']")).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='checkbox'][@class='targetlist_checkbox']"))).click();     
        driver.findElement(By.xpath("//input[@type='button'][@value='Save and Continue']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"name\"]"))).sendKeys("Sample Subject");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@id='body_html_ifr']"))).sendKeys(" Dear {users.first_name}  {users.last_name},\n"+ "\n" + "An Offer status has been updated by Merchant for deal {deals.name}.\n" + "\n"+ "\n" + "Click here to check the offer status!");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=\"module_name_dom\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"module_name_select_drp_dwn\"]//option[contains(text(),'Leads')] "))).click();
        driver.findElement(By.xpath("//input[@type='button']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='button'][@value='Save and Continue']")).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"policy\"]"))).click(); 
        driver.findElement(By.xpath("//input[@type='submit']")).click();  
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    }
}
