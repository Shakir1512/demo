package test.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Product {
    WebDriver driver;
    WebDriverWait wait;
    public Product(WebDriver driver , WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
    public String productName = "Sample Product Test 2";
    public void createProduct() {
        driver.findElement(By.xpath("//a[contains(text(),'Billing')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"new_button_help\"]/a"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']"))).sendKeys(productName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='unit_price']"))).sendKeys("50");
        driver.findElement(By.xpath("//button[@id='productValidation']")).click();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public String getProductName(){
        return productName;
    }
}
