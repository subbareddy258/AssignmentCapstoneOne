package Pages;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;


public class PaymentPage {
    private WebDriver driver;
    private By discountCodeInputField = By.xpath("//input[@id='discount-code']");
    private By applyDiscount = By.xpath("//button[@class='action action-apply']");
    private By errorMessage = By.xpath("//div[@data-ui-id='checkout-cart-validationmessages-message-error']");
    private By placeOrderBut = By.xpath("//button[@title='Place Order']");
    private By orderNumber = By.xpath("//div[@class='checkout-success']/p/a/strong");
    static ExtentReports report;
    static ExtentTest test;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickOnApplyDiscount()
    {
       // driver.findElement(applyDiscountCode).click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            // Wait for the loading mask to disappear
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loading-mask")));

            // Scroll to the element
            WebElement element = driver.findElement(By.className("action-toggle"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

            // Click the element using JavaScript
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

            System.out.println("Element clicked successfully.");
        } catch (Exception e) {
            System.out.println("Failed to click the element: " + e.getMessage());
        }
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(discountCodeInputField).sendKeys("TEES20");
        driver.findElement(applyDiscount).click();
            // Locate the validation message element using xpath
            WebElement validationMessage = driver.findElement(errorMessage);
            // Get the text of the validation message
            String messageText = validationMessage.getText();
            System.out.println("Validation Message: " + messageText);
            Assert.assertEquals("The coupon code isn't valid. Verify the code and try again.",messageText);
         }

    public void  clickOnPlaceOrderButton()
    {
        driver.findElement(placeOrderBut).click();
    }

    public void getOrderNumber()  {

        try {
            // Locate and extract the desired data from the UI
            WebElement dataElement = driver.findElement(orderNumber);
            String data = dataElement.getText();

            // Store the data in a text file
            String filePath = "orderId.txt";
            FileWriter writer = new FileWriter(filePath);
            writer.write(data);
            writer.close();


            System.out.println("Data successfully stored in the text file.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

}
