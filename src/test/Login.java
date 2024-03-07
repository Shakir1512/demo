package test;

import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.openqa.selenium.Keys;

import java.time.Duration;

public class Login {

    public WebDriver driver;
    public WebDriverWait wait;
    public WebElement usernameInput, passwordInput, loginBtnInput;

    // private WebElement sale , add;

    public By username = By.xpath("//input[@id='username']");
    public By password = By.xpath("//input[@id='password']");
    public By loginBtn = By.xpath("//input[@id='loginb']");
    public By proceed = By.xpath("//a[contains(text(),'Proceed')]");
    public By popup = By.xpath("//body/div[@id='pop']/span[1]");
    public By profilePic = By.xpath("//header/div[1]/div[2]/div[2]/ul[1]/li[1]/ul[1]/li[2]/span[1]/img[1]");
    public By logout = By.xpath("//a[contains(text(),'Logout')]");

    public By hoversale = By.className("clr-1");
    // private By hoversale = By.id("lbl_leads");
    public By addLead = By.xpath("//body/div[4]/nav[1]/ul[1]/li[2]/div[1]/div[1]/ul[1]/li[1]/a[1]");
    public By newLead = By.xpath("//a[contains(text(),'+ New')]");
    public By fname = By.id("first_name");
    public By save = By.xpath("//body[1]/div[4]/section[1]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/div[1]/form[1]/div[5]/ul[1]/li[1]/button[1]");

    public By hoveractivity = By.linkText("Activities");
    public By clickEmail = By.linkText("Emails");
    public By newEmail = By.xpath("//a[contains(text(),'+ New')]");
    public By subjectID = By.xpath("//input[@id='subject']");
    
    By AI = By.xpath("//a[@id='ai_magic']");
//    By AI = By.id("mceu_26-open");
    
     By prompt = By.xpath("//textarea[@id='text_prompt']");
    By generateBtn = By.xpath("//button[@id='call_ai']");
    
    By useBtn = By.xpath("//button[@id='use_this']");
    
    public void setUp() {
         System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        driver = new ChromeDriver();
        
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://app01.convergehub.com");
    }

    public void simpleLogin() {
        performLogin("mdshakir151200@gmail.com", "Shakir@151200");

        handleProceed();

        handlePopup();
    }

    public void hoverSale() {

        WebElement sale = driver.findElement(this.hoversale);
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(sale).perform();
        // sale.click();
        WebElement add = driver.findElement(this.addLead);
        add.click();
        WebElement newlead = wait.until(ExpectedConditions.visibilityOfElementLocated(this.newLead));
        newlead.click();
        WebElement fName = wait.until(ExpectedConditions.visibilityOfElementLocated(this.fname));
        fName.sendKeys("New Lead Automate");

        WebElement saveBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(this.save));
        saveBtn.click();
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
    	}
    	 catch(Exception e) {
         	System.out.println(e.getMessage());
         }
    }

    private void performLogin(String username, String password) {
        usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(this.username));
        passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(this.password));
        loginBtnInput = wait.until(ExpectedConditions.elementToBeClickable(this.loginBtn));

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtnInput.click();
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

    private void handlePopup() {
        WebElement popupElement = wait.until(ExpectedConditions.visibilityOfElementLocated(popup));
        if (popupElement.isDisplayed()) {
            popupElement.click();
            System.out.println("### Popup cross clicked");
        }
    }

    public void hoverActivity() {
        WebElement activity = driver.findElement(this.hoveractivity);
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(activity).perform();
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(this.clickEmail));
        email.click();

        WebElement newemail = wait.until(ExpectedConditions.visibilityOfElementLocated(this.newEmail));
        newemail.click();

        WebElement subject = wait.until(ExpectedConditions.visibilityOfElementLocated(this.subjectID));
        subject.sendKeys("Sample Automation Test");

        WebElement clickAI = wait.until(ExpectedConditions.visibilityOfElementLocated(this.AI));
        try {
        	 Thread.sleep(2000);
//        	 actions1.moveToElement(clickAI).build().perform();
//        	 
//             actions1.click(clickAI).perform();
             
             clickAI.click();
        }
        catch(Exception e) {
        	System.out.println(e.getMessage());
        }

//        try {
//        if(clickAI.isDisplayed()){
//
//			            clickAI.click();
//        	 clickAI.sendKeys(Keys.ENTER);
//            System.out.println("ClickAi is clicked");
//        }
//        }
//        catch(Exception e){
//            System.out.println("Error : "+e.getMessage());
//        }
//
//        
//        try{
//            Actions act = new Actions(driver);
//            act.moveToElement(clickAI).click().perform();
//            System.out.println("ClickAi is clicked and hold");
//        }
//        catch(Exception e){
//            System.out.println("Error : "+e.getMessage());
//        }
       
         try {
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
         }
         catch(Exception e) {
        	 System.out.println(e.getMessage());
         }

    }
    
    public void scroll() {
    	Actions at = new Actions(driver);
        at.sendKeys(Keys.PAGE_DOWN).build().perform();
    	WebElement save = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Save as Draft')]")));
//    	at.moveToElement(save).build().perform();
//        at.click(save).perform();
        save.click();
        //This will scroll the page Horizontally till the element is found		
        handlePopup();
    }
}