package test.quotation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.product.Product;
public class Quotation {
    WebDriver driver;
    WebDriverWait wait;
    public Quotation(WebDriver driver , WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
    Product product = new Product(driver, wait);
    public String productName = product.getProductName(), quoteNo;  
    public void createQuote() {
        try {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Billing')]"))).click();   
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contacts\"]//li//a[contains(text(),'Quotes')]"))).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"new_button_help\"]/a"))).click();  
        Thread.sleep(1000); 
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='account_name_field']"))).sendKeys("New Lead Automate");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=\"alls_tab_account_name\"]/ul/li[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='valid_till']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[2]/td[3]/a[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Details')]"))).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='bean_id_1_name']"))).sendKeys(productName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='bean_id_1_name']"))).click();      
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(productName))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='quantity_1']"))).sendKeys("5");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        quoteNo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='header_name_change']"))).getText();
        System.out.println("Quote No ="+quoteNo);
    } catch (Exception e) {
        System.out.println(e.getMessage());
        e.printStackTrace();
    }
    }
    public String getQuoteName(){   
        return quoteNo;
    }
}
