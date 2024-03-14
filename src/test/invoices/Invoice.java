package test.invoices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.login.Login;
import test.quotation.Quotation;

public class Invoice {
    WebDriver driver;
    WebDriverWait wait;
    Quotation quotation = new Quotation(driver, wait);
    public String quoteNo = quotation.getQuoteName() , invoiceNO;
    
    public Invoice(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    Login login = new Login(driver,wait);
    public void createInvoices() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Billing')]"))).click();   
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contacts\"]//li//a[contains(text(),'Invoices')]"))).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"new_button_help\"]/a"))).click();  
            Thread.sleep(1000);
            System.out.println("Quote No ="+quoteNo);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='quote_name_field']"))).sendKeys("00001");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"alls_tab_quote_name\"]/ul/li[1]"))).click();
            driver.switchTo().alert().accept();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            invoiceNO = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"header_name_change\"]/h1"))).getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getInvoiceName(){
        return invoiceNO;
    }
}
