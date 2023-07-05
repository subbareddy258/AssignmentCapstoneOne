package stepDefinitions;

import Pages.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

public class capStone {

    private WebDriver driver;
    private ConfigReader configReader;
    private createAccountPages createAccountPage;
   private HomePages homepage;
private shippingAddressPage shippingAddress;
private PaymentPage paymentPage;
private OrderconfirmationPages OrderconfirmationPage;
static ExtentReports report;
static ExtentTest test;
    @BeforeMethod
    public void setUp() {
        // Set the path to the chromedriver executable
       driver= DriverSetup.getWebDriver();

        configReader = new ConfigReader();
        driver.get(configReader.geMagentoURL());
        createAccountPage = new createAccountPages(driver);
        homepage = new HomePages(driver);
       shippingAddress = new shippingAddressPage(driver);
        paymentPage= new PaymentPage(driver);
        OrderconfirmationPage = new OrderconfirmationPages(driver);
        report =new ExtentReports("report/report.html",true);
        test=report.startTest("test cases execution started");
       driver.manage().window().maximize();
       test.log(LogStatus.INFO,"browser lauched and maximized");

    }



    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws IOException {
        // Read login data from Excel or any other source
        String filePath = "TestData.xlsx";
        String sheetName = "Sheet3";
        return TestDataUtils.readTestData(filePath, sheetName);

    }

    @DataProvider(name = "shippingAddress")
    public Object[][] getShippingAddress() throws IOException {
        // Read login data from Excel or any other source
        String filePath = "TestData.xlsx";
        String sheetName = "Sheet4";
        return TestDataUtils.readTestData(filePath, sheetName);

    }

    @Test(dataProvider = "loginData")
    public void createAccountPages(String firstname, String lastname,String email,String password,String confirmPassword) throws InterruptedException {
        createAccountPage.clickOnAccount();
        createAccountPage.setFirstname(firstname);
        createAccountPage.setLastName(lastname);
        createAccountPage.setEmail(email);
        createAccountPage.setPassword(password);
        createAccountPage.setConfirmationPassword(confirmPassword);
        createAccountPage.clickOnAccountButton();
        test.log(LogStatus.INFO,"account created");

        Thread.sleep(5000);
        homepage.greetCustomerWithWelcomeMessage();
        homepage.clickOnSaleButton();
        homepage.greatDeals();
        homepage.Pattrenfilter();
        homepage.climateFilter();
        homepage.MaterialFilter();
        homepage.selectTees();
        homepage.tShirtSizeSelect();
        homepage.colorSizeSelect();
        homepage.addToCartClicked();
        DriverSetup.waited();
        homepage.shoppingCart();
        DriverSetup.waited();
        homepage.clickOnViewCart();
        homepage.clickOnReviewComments();
        DriverSetup.waited();
        homepage.addToCartClicked();
        test.log(LogStatus.INFO,"products filtered and added to shopping card");

    }
    @Test(dataProvider = "shippingAddress",dependsOnMethods = "createAccountPages")
    public void shippingAddressPages(String company, String streetaddress,String city,String state,Double pincode ,Double phonenumber) throws InterruptedException {
        homepage.shoppingCart();
        homepage.clickOnProceedCheckoutButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        shippingAddress.fillShippingAddress(company,streetaddress,city,state,pincode,phonenumber);
        shippingAddress.selectShippingFee();
        paymentPage.clickOnApplyDiscount();
        paymentPage.clickOnPlaceOrderButton();
        paymentPage.getOrderNumber();



    }

    @Test(dependsOnMethods ="shippingAddressPages")
    public void orderConfirmation() throws InterruptedException {
        OrderconfirmationPage.clickOnMenu();
        OrderconfirmationPage.clickOnSubMenu();
        OrderconfirmationPage.clickOnMyOrders();
        OrderconfirmationPage.viewOrders();
        OrderconfirmationPage.signOut();
        OrderconfirmationPage.signOutmessage();
        test.log(LogStatus.INFO,"Successfully signout");

    }

    @AfterMethod
    public void takeScrenshots(ITestResult result) {
        // Close the browser
        if (result.getStatus() == ITestResult.SUCCESS) {
            // Take a screenshot
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                // Specify the destination file path
                String screenshotPath = "Screenshots/PassedScreenShots/screenshot" + screenshotFile.getName() ;
                // Copy the screenshot file to the specified location
                Files.copy(screenshotFile.toPath(), new File(screenshotPath).toPath());
                System.out.println("Screenshot captured: " + screenshotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (result.getStatus() == ITestResult.FAILURE) {
            // Take a screenshot
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                // Specify the destination file path
                String screenshotPath = "Screenshots/FailedScreenShots/screenshot" + screenshotFile.getName() + ".png";
                // Copy the screenshot file to the specified location
                Files.copy(screenshotFile.toPath(), new File(screenshotPath).toPath());
                System.out.println("Screenshot captured: " + screenshotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            test.log(LogStatus.FAIL,result.getThrowable());

        }
        report.endTest(test);
        report.flush();

    }

}
