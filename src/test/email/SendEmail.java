package test.email;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.template.Template;
public class SendEmail {
    WebDriver driver;
    WebDriverWait wait;
    Template template = new Template(driver, wait);
    public String templateName = template.getTemplateName();
    public SendEmail(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    } 
    public void sendEmail() {
        try {
        WebElement activity = driver.findElement(By.linkText("Activities"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(activity).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Emails"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'+ New')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='subject']"))).sendKeys("Sample Automation Email");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"template_dom\"]"))).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[contains(text(),'" + templateName + "')]"))).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select3_maininput\"]"))).sendKeys("mdshakir151200@mailinator.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']"))).click();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }       
    }
}
