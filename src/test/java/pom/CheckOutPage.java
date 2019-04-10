package pom;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheckOutPage {

    WebDriver driver;
    ExtentReports report;
    ExtentTest test;
    WebDriverWait wait;

    public CheckOutPage(WebDriver driver, ExtentReports report, ExtentTest test) {
        this.driver = driver;
        this.report = report;
        this.test = test;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//div[text()[contains(.,'LOG IN')]]/parent::div")
    WebElement loginBtn;

    @FindBy(xpath = "//div[text()[contains(.,'SIGN UP')]]/parent::div")
    WebElement signUpBtn;

       
    @FindBy(xpath = "//div[2]/div/div/div[3]")
    WebElement modifyBtn;


    public void clickOnSignUpBtn() throws InterruptedException {
    	Thread.sleep(6000);
    	signUpBtn.click();
        test.log(LogStatus.INFO, "Clicked on signup Btn");
    }

   
   
    

    //Login, Select Existing Address, Make a payment
    public void RegisterNewuserWithExistingEmailId(String mobileNumber, String name,String email,String password) throws InterruptedException {
    	clickOnSignUpBtn();
        LogInPage logInPage = new LogInPage(driver, report, test);
        logInPage.signupuser(mobileNumber,name,email,password);
        
    }
    
    public String getText(WebElement webElement){
        return webElement.getText();
    }
    public String getErrorMsg(){
        LogInPage logInPage = new LogInPage(driver, report, test);
        return getText(logInPage.LoginErrorMsg);
    }

   
   
// This method to modify the added cup cake in checkout page
    public void ModifyFoodItem() {
	      modifyBtn.click();  	      
   	      test.log(LogStatus.INFO, "Modified Food item to Card");
        
      
}


}
