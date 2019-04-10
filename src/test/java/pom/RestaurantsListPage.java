package pom;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RestaurantsListPage {

    WebDriver driver;
    ExtentReports report;
    ExtentTest test;

    public RestaurantsListPage(WebDriver driver, ExtentReports report, ExtentTest test) {
        this.driver = driver;
        this.report = report;
        this.test = test;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//div[@id='open_filter']//a[contains(@href , '#filter_')]")
    List<WebElement> filterRestaurants;

    @FindBy(xpath =  "//div[contains(@class,'la')])")
    List<WebElement> listOfRestaurants;

    @FindBy(xpath = "//*[text()[contains(.,'Bite Me')]]//ancestor::a")
    WebElement FavoutiteRestuarant;

    @FindBy(xpath = "//*[text()[contains(.,'outlets near you')]]/parent::div/following-sibling::div/a")
    List<WebElement> listOfOutlets;

    
    
    public void clickOnMySearchedRestaurant(String restaurantName) {
       
            if (FavoutiteRestuarant.getText().contains(restaurantName)){
            	FavoutiteRestuarant.click();
            	clickOnFirstOutlet();
                test.log(LogStatus.INFO, "Clicked on Restaurant");
                
            }

        }
    


    //This will click the first outlet from the given multiple outlets
    public void clickOnFirstOutlet(){
        listOfOutlets.get(0).click();
    }

    

}
