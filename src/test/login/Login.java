package test.login;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
    public WebDriver driver;
    public WebDriverWait wait;
    public By username = By.xpath("//input[@id='username']");
    public By password = By.xpath("//input[@id='password']");
    public By loginBtn = By.xpath("//input[@id='loginb']");
    public By proceed = By.xpath("//a[contains(text(),'Proceed')]");
    public By popup = By.xpath("//body/div[@id='pop']/span[1]");
    public By profilePic = By.xpath("//header/div[1]/div[2]/div[2]/ul[1]/li[1]/ul[1]/li[2]/span[1]/img[1]");
    public By logout = By.xpath("//a[contains(text(),'Logout')]");

    public By hoversale = By.className("clr-1");
    public By addLead = By.xpath("//body/div[4]/nav[1]/ul[1]/li[2]/div[1]/div[1]/ul[1]/li[1]/a[1]");
    public By newLead = By.xpath("//a[contains(text(),'+ New')]");
    public By fname = By.id("first_name");
    public By save = By.xpath("//body[1]/div[4]/section[1]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/div[1]/form[1]/div[5]/ul[1]/li[1]/button[1]");
    public By hoveractivity = By.linkText("Activities");
    public By clickEmail = By.linkText("Emails");
    public By newEmail = By.xpath("//a[contains(text(),'+ New')]");
    public By subjectID = By.xpath("//input[@id='subject']");
    By AI = By.xpath("//a[@id='ai_magic']");
    By prompt = By.xpath("//textarea[@id='text_prompt']");
    By generateBtn = By.xpath("//button[@id='call_ai']");
    By useBtn = By.xpath("//button[@id='use_this']");
    By AuthInput = By.xpath("//input[@id='verificationtext']");
    By firstMail = By.xpath("/html/body/div[1]/main/div[2]/div[3]/div/div[4]/div/div/table/tbody/tr[1]/td[2]");
    By iframe = By.xpath("//*[@id='html_msg_body']");
    By iBody = By.xpath("/html/body");

    public Login(WebDriver driver , WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
    public void simpleLogin() {
        performLogin("test1234@gmail.com", "test@1234");
        handleProceed();
        handlePopup();
    }
    public void terminate() {
        try {
            Thread.sleep(4000);
            WebElement imageElement = driver.findElement(this.profilePic);
            Actions actions = new Actions(driver);
            actions.moveToElement(imageElement).perform();
            WebElement logoutBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(this.logout));
            logoutBtn.click();
            // driver.quit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void performLogin(String username, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.username)).sendKeys(username);;
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.password)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(this.loginBtn)).click();
    }
    private void handleProceed() {
        try {
            WebElement proceedElement = wait.until(ExpectedConditions.visibilityOfElementLocated(this.proceed));
            if (proceedElement.isDisplayed()) {
                proceedElement.click();
            }
        } catch (Exception e) {
            System.out.println("Login with Proceed test failed. Error: " + e.getMessage());
        }
    }

    public void handlePopup() {
        try {
            Thread.sleep(3000);
            WebElement popupElement = wait.until(ExpectedConditions.visibilityOfElementLocated(popup));
            if (popupElement.isDisplayed()) {
                popupElement.click();
                System.out.println("### Popup cross clicked");
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    public void hoverActivity() {
        WebElement activity = driver.findElement(this.hoveractivity);
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(activity).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.clickEmail)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.newEmail)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.subjectID)).sendKeys("Sample Automation Test");
        WebElement clickAI = wait.until(ExpectedConditions.visibilityOfElementLocated(this.AI));
        try {
            Thread.sleep(2000);
            clickAI.click();
            Thread.sleep(2000);
            WebElement inputPrompt = wait.until(ExpectedConditions.visibilityOfElementLocated(this.prompt));
            inputPrompt.sendKeys("Converge Hub");
            Thread.sleep(2000);
            WebElement clickGenerate = wait.until(ExpectedConditions.visibilityOfElementLocated(this.generateBtn));
            actions1.moveToElement(clickGenerate).build().perform();
            actions1.click(clickGenerate).perform();
            Thread.sleep(2000);
            WebElement clickUsethis = wait.until(ExpectedConditions.visibilityOfElementLocated(this.useBtn));
            actions1.moveToElement(clickUsethis).build().perform();
            actions1.click(clickUsethis).perform();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void mfa(String otp) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(this.AuthInput)).sendKeys(otp);
            wait.until(ExpectedConditions.elementToBeClickable(By.id("mfab"))).click();
        } catch (Exception e) {
            System.out.println("MFA: " + e.getMessage());
        }
    }
}