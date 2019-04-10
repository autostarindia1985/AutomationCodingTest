package pom;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SearchPage {

    WebDriver driver;
    ExtentReports report;
    ExtentTest test;

    public SearchPage(WebDriver driver, ExtentReports report, ExtentTest test){
        this.driver = driver;
        this.report = report;
        this.test = test;
        PageFactory.initElements(driver, this);

    }
    
    @FindBy(linkText = "Search")
    WebElement Searchicon;

    @FindBy(xpath = "//input[contains(@autocomplete,'off')]")
    WebElement SearchBox;
    
    public void SearchRestaurant(String RestaurantName)
    {
    	Searchicon.click();
    	SearchBox.sendKeys(RestaurantName);
    	
    }
}