import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pom.CheckOutPage;
import pom.HomePage;
import pom.SearchPage;
import pom.RestaurantsListPage;
import pom.RestaurantsPage;
import utils.Constants;
import utils.ExtentReportUtil;
import utils.ScreenshotUtil;
import org.testng.Assert;


import java.io.IOException;
import java.util.concurrent.TimeUnit;
import utils.PropertyManager;

public class E2ETEST {

    private WebDriver driver;
    private String baseURL;
    private String browser;
    private HomePage homePage;
    private SearchPage searchPage;
    private RestaurantsListPage restaurantsListPage;
    private RestaurantsPage restaurantsPage;
    private CheckOutPage checkOutPage;
    private ExtentReports report;
    private ExtentTest test;
    
    

    
    String mobileNumber = PropertyManager.getInstance().getmobileNumber();
    String searchQuery = PropertyManager.getInstance().getsearchQuery();
    String password = PropertyManager.getInstance().getPassword();
    String exactLocation = PropertyManager.getInstance().getexactLocation();
    String name = PropertyManager.getInstance().getName();
    String email = PropertyManager.getInstance().getEmail();
    String restaurantName = PropertyManager.getInstance().restaurantName();




    
    

    @BeforeClass
    public void beforeClassMethod() throws Exception {

        baseURL = Constants.URL;
        report = ExtentReportUtil.getInstance();
    }


    @BeforeMethod
    @Parameters({"browsers"})
    public void setUp(String browsers) {

    	if (browsers.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "libs/geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            browser = browsers;
        } else if (browsers.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver" , "libs/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().fullscreen();
            browser = browsers;
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseURL);

    }

  // This test method does e2e flow starting from location search, restaurants selection,food items add and finally checkout using existing signedup user
    @Test
    public void orderFromRestaurant() throws InterruptedException {
        test = report.startTest("Order from Restaurant with Single Outlet selecting Existing Address - " + browser);

        homePage = new HomePage(driver, report, test);
        homePage.enterAddress(searchQuery , exactLocation);
        
        searchPage=new SearchPage(driver,report,test);
        searchPage.SearchRestaurant(restaurantName);
        		

        restaurantsListPage = new RestaurantsListPage(driver, report, test);
        restaurantsListPage.clickOnMySearchedRestaurant(restaurantName);

        restaurantsPage = new RestaurantsPage(driver, report, test);
        restaurantsPage.addFoodItemAndCheckout();

        checkOutPage = new CheckOutPage(driver, report, test);
        checkOutPage.RegisterNewuserWithExistingEmailId(mobileNumber,name,email,password );
        String ExpectedMessage="Email id already exists";
        checkOutPage.ModifyFoodItem();
        Assert.assertTrue(checkOutPage.getErrorMsg().contains(ExpectedMessage));

    }

    

    @AfterMethod
    public void tearDown(ITestResult testResult) throws IOException, InterruptedException {
        ScreenshotUtil.takeScreenShot(driver);

        if (testResult.getStatus() == ITestResult.FAILURE) {
            test.log(LogStatus.FAIL, testResult.getThrowable().toString());
        } else {
            test.log(LogStatus.PASS, "Verification Successful");
        }

        Thread.sleep(5000);
        driver.quit();
        report.endTest(test);
    }

    @AfterClass
    public void afterClassMethod() throws InterruptedException {

    }
}