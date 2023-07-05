package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class shippingAddressPage {
    private WebDriver driver;

    private By companyNameSet= By.xpath("//input[@name='company']");
    private By streetAddressSet= By.xpath("//input[@name='street[0]']");

    private By setCityName = By.xpath("//input[@name='city']");

    private By  zip = By.name("postcode");
    private By phoneNumber = By.name("telephone");
    private By nextButton = By.xpath("//button[@data-role='opc-continue']");

    public shippingAddressPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillShippingAddress(String company, String streetaddress,String city,String state,Double pincode ,Double phonenumber) throws InterruptedException {
driver.findElement(companyNameSet).sendKeys(company);
driver.findElement(streetAddressSet).sendKeys(streetaddress);
driver.findElement(setCityName).sendKeys(city);

driver.findElement(zip).sendKeys("45040");
driver.findElement(phoneNumber).sendKeys("7856647490");
//state selection
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement selectElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("region_id")));

        // Create a Select object from the <select> element
        Select select = new Select(selectElement);

        // Select the option with the label "Indiana"
        select.selectByVisibleText("Indiana");

    }

   public void  selectShippingFee()
   {
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
       // Find all <tr> elements within the <tbody>
       WebElement tbodyElement = driver.findElement(By.tagName("tbody"));
       List<WebElement> rowElements = tbodyElement.findElements(By.tagName("tr"));
       List<String> dataList = new ArrayList<>();

       // Iterate through each <tr> element
       for (WebElement rowElement : rowElements) {
           // Get the values from the child <td> elements
           WebElement methodElement = rowElement.findElement(By.className("col-method"));
           WebElement priceElement = rowElement.findElement(By.className("col-price"));
           WebElement methodTitleElement = rowElement.findElement(By.className("col-method"));
           WebElement carrierTitleElement = rowElement.findElement(By.className("col-carrier"));

           String methodTitle = methodTitleElement.getText();
           System.out.println(methodTitle);
           String carrierTitle = carrierTitleElement.getText();
           System.out.println(carrierTitle);


           /// Select the radio button within the <td> element
           WebElement radioButton = methodElement.findElement(By.tagName("input"));
           radioButton.click();
           // Add data to the ArrayList
           dataList.add(carrierTitle);

           System.out.println("dataList print "+ dataList);
           // Assert carrier title

       }
       Assert.assertTrue( dataList.contains("Flat Rate"),"Flat rate not displayed");

       driver.findElement(nextButton).click();
   }

}
