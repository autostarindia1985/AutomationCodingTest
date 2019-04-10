package pom;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RestaurantsPage {

    WebDriver driver;
    ExtentReports report;
    ExtentTest test;
    WebDriverWait wait;

    public RestaurantsPage(WebDriver driver, ExtentReports report, ExtentTest test) {
        this.driver = driver;
        this.report = report;
        this.test = test;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);

    }

    
    
    @FindBy(xpath = "//*[text()[contains(.,'Red Velvet Cupcake')]]/following-sibling::*/following::div[4]")
    		
    WebElement addredCupCakeBtn;
    
    @FindBy(xpath = "//*[text()[contains(.,'Tiramisu Cupcake')]]/following-sibling::*/following::div[4]")
	
    WebElement addtiramasuCupCakeBtn;
    
    @FindBy(xpath = "//*[text()[contains(.,'Irish Coffee Cupcake')]]/following-sibling::*/following::div[4]")
	
    WebElement addirishCupCakeBtn;
    
    @FindBy(xpath = "//*[text()[contains(.,'Choco Choco Cupcake')]]/following-sibling::*/following::div[4]")
	
    WebElement addchocoCakeBtn;

    @FindBy(xpath = "//*[text()[contains(.,'Customisable')]]/parent::div") 
            List<WebElement> customizableAddBtn;
    
    @FindBy(xpath = "//*[text()[contains(.,'Red Velvet Cupcake')]]/following-sibling::*/following::div[5]") 
    WebElement addredCupCakemoreBtn;

    
    @FindBy(xpath = "//div[text()[contains(.,'Checkout')]]")
    WebElement checkOutBtn;
    
    @FindBy(xpath = "//*[contains(@id,'h-')]")
    List<WebElement> listOfItems;
    
   
    public void AddFoodItems() {
    
    	addredCupCakeBtn.click();
    	addredCupCakemoreBtn.click();
    	addtiramasuCupCakeBtn.click();
    	addirishCupCakeBtn.click();
    	addchocoCakeBtn.click();
    	
    }
                
                
                
            
            

   
    public void clickOnCheckoutBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Checkout')]")));
        checkOutBtn.click();
        test.log(LogStatus.INFO, "Clicked on Checkout");
    }

    public void addFoodItemAndCheckout() {
    	AddFoodItems();
        clickOnCheckoutBtn();
    }

   

}
