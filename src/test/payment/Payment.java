package test.payment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.invoices.Invoice;

public class Payment {
    WebDriver driver;
    WebDriverWait wait;
    Invoice invoice = new Invoice(driver, wait);
    public String invoiceNO = invoice.getInvoiceName();
    public Payment(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public void createPayment() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Billing')]"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contacts\"]//li//a[contains(text(),'Payments')]"))).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"new_button_help\"]/a"))).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='originator_name']"))).sendKeys("Payment Test");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='transaction_id']"))).sendKeys("TXN001123");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='payment_date']"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='ui-state-default'][contains(text(),'4')]"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='payment_amount']"))).sendKeys("2000");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='relate_module_dom']"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[contains(text(),'Invoices')]"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='checkbox'][@class='list_checkbox']"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Add Selected')]"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']"))).click();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
