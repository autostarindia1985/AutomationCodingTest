package pom;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.How;


public class LogInPage {

    WebDriver driver;
    ExtentReports report;
    ExtentTest test;

    public LogInPage(WebDriver driver, ExtentReports report, ExtentTest test){
        this.driver = driver;
        this.report = report;
        this.test = test;
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "mobile")
    WebElement mobileTextBox;

    @FindBy(id = "password")
    WebElement passwordTextBox;
    
    @FindBy(id = "name")
    WebElement nameTextBox;
    
    @FindBy(id = "email")
    WebElement emailTextBox;
    
    @FindBy(xpath = "//form/div[2]")
    WebElement referralLink;
        
    @FindBy(linkText = "Login")
    WebElement logUserInBtn;
    
    @FindBy(linkText = "CONTINUE")
    WebElement ContinueBtn;
    
    @FindBy(how= How.CSS,using="label._1Cvlf._2tL9P.A7Y41")
    public WebElement LoginErrorMsg;

    public void typeInMobileTextBox(String mobileNumber) {
        mobileTextBox.sendKeys(mobileNumber);
        test.log(LogStatus.INFO, "Entered phone number");
    }

    public void typeInPasswordTextBox(String password) {
        passwordTextBox.sendKeys(password);
        test.log(LogStatus.INFO, "Entered Password");
    }
    
    public void typeInNameTextBox(String name) {
        nameTextBox.sendKeys(name);
        test.log(LogStatus.INFO, "Entered Name");
    }
    
    public void typeInEmailTextBox(String email) {
        emailTextBox.sendKeys(email);
        test.log(LogStatus.INFO, "Entered Email");
    }
    
    public void clickReferralLink() {
    	referralLink.click();
        test.log(LogStatus.INFO, "Clicked referral link");
    }
    
    
    public void clickOnLoginUserBtn() {
        logUserInBtn.click();
        test.log(LogStatus.INFO, "Logging In");
    }

    //Sign in with UN and PW
    public void signupuser(String mobileNumber, String name,String email,String password) {
        typeInMobileTextBox(mobileNumber);
        typeInNameTextBox(name);
        typeInEmailTextBox(email);
        typeInPasswordTextBox(password);
        clickReferralLink();
        clickContinue();
    }

	public void clickContinue() {
		ContinueBtn.click();
	     test.log(LogStatus.INFO, "Continue button clicked");
	}


}
