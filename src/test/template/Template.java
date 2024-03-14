package test.template;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Template {
    WebDriver driver;
    WebDriverWait wait;
    public String templateName = "Sample Template 3";

    public Template(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public void createTemplate() {
        try {
            driver.findElement(By.xpath("//a[contains(text(),'Marketing')][@class='clr-1']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"lbl_template_left\"]/a")).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"new_button_help\"]"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']"))).sendKeys(templateName);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='subject']"))).sendKeys("Automation Testing");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='module_name_dom']"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[contains(text(),'Leads')]"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@id='body_html_ifr']"))).sendKeys(" Dear {users.first_name}  {users.last_name},\n"+ "\n" + "An Offer status has been updated by Merchant for deal {deals.name}.\n" + "\n"+ "\n" + "Click here to check the offer status!");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']"))).click();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public String getTemplateName() {
        return templateName;
    }
}
