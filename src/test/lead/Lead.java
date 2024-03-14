package test.lead;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Lead {
    WebDriver driver;
    WebDriverWait wait;
    public Lead(WebDriver driver , WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
        public void hoverSale() {
        WebElement sale = driver.findElement(By.className("clr-1"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(sale).perform();
        WebElement add = driver.findElement(By.xpath("//body/div[4]/nav[1]/ul[1]/li[2]/div[1]/div[1]/ul[1]/li[1]/a[1]"));
        add.click();
        WebElement newlead = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'+ New')]")));
        newlead.click();
        WebElement fName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first_name")));
        fName.sendKeys("New Lead Automate");
        WebElement saveBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
            "//body[1]/div[4]/section[1]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/div[1]/form[1]/div[5]/ul[1]/li[1]/button[1]")));
        saveBtn.click();
    }
    public void leadToContact() {
        try {
            Thread.sleep(2000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Action')]"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"lead_convert_edit\"]/a"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='create_contact']"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='save_convert_popup']"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bodyCheckIdeal\"]/div[9]/div[3]/div/button/span"))).click();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
}
