package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePages {
    private WebDriver driver;
    private By welcomeMessage = By.xpath("//ul[@class='header links']/li/span");
    private By saleButton = By.xpath("//nav[@class='navigation']/ul/li");
    private By deals = By.xpath("//div[@class='categories-menu']/Strong");
    private By tees = By.xpath("//div[@class='categories-menu']/ul[2]/li/a");
    private By filterOptions = By.xpath("//div[@id='narrow-by-list']/div/div");
    private By filterSelection = By.xpath("//div[@id='narrow-by-list']/div/div/ol/li/a");
    private By selectTee = By.xpath("//strong[@class='product name product-item-name']/a");
    private By teeSize = By.xpath("//div[@class='swatch-option text']");
    private By colourSelect = By.xpath("//div[@aria-label='Blue']");
    private By addToCartClick = By.xpath("//button[@id='product-addtocart-button']");
    private By shoppingCarts = By.xpath("//span[@class='counter-number']");
    private By viewCart = By.xpath("//a[@class='action viewcart']");
    private By reviews = By.xpath("//a[@class='action view']");
    private By reviewComments = By.xpath("//div[@class='review-content']");
private  By proceedToCheckOut = By.xpath("//button[@id='top-cart-btn-checkout']");
    public HomePages(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> greetCustomerWithWelcomeMessage() throws InterruptedException {
        List<WebElement> welcomeTexts = driver.findElements(welcomeMessage);
        List<String> welcomeText = new ArrayList<>();
        for (WebElement element : welcomeTexts) {

            String text = element.getText();
            if (text.contains("Welcome")) {
                welcomeText.add(text);
            }
        }
        return welcomeText;
    }

    public void clickOnSaleButton() {
        List<WebElement> Menu = driver.findElements(saleButton);
        for (WebElement element : Menu) {
            String text = element.getText();
            if (text.contains("Sale")) {
                element.click();
            }
        }
    }


    public void greatDeals() throws InterruptedException {
        List<WebElement> delas = driver.findElements(deals);
        for (WebElement element : delas) {
            String text = element.getText();
            System.out.println(text);
            if (text.contains("MENS'S DEALS")) {
                List<WebElement> teeshirt = driver.findElements(tees);
                for (WebElement teesText : teeshirt) {
                    String treeset = teesText.getText();
                    if (treeset.contains("Tees")) {
                        teesText.click();
                        break;
                    }
                }
                break;
            }

        }
    }

    public void Pattrenfilter() {
        List<WebElement> delas1 = driver.findElements(filterOptions);
        for (WebElement filterOption : delas1) {
            String filters = filterOption.getText();
            if (filters.contains("PATTERN")) {
                filterOption.click();
                List<WebElement> filterSelect = driver.findElements(filterSelection);
                for (WebElement filterValues : filterSelect) {
                    String filterInsideValues = filterValues.getText();
                    System.out.println(filterInsideValues);
                    if (filterInsideValues.contains("Solid")) {
                        filterValues.click();
                        break;
                    }
                }
                break;
            }

        }
    }

    public void climateFilter() {
        List<WebElement> delas1 = driver.findElements(filterOptions);
        for (WebElement filterOption : delas1) {
            String filters = filterOption.getText();
            System.out.println(filters);
            if (filters.contains("CLIMATE")) {
                filterOption.click();
                List<WebElement> filterSelect = driver.findElements(filterSelection);
                for (WebElement filterValues : filterSelect) {
                    String filterInsideValues = filterValues.getText();
                    System.out.println(filterInsideValues);
                    if (filterInsideValues.contains("Cool")) {
                        filterValues.click();
                        break;
                    }

                }
                break;
            }
        }
    }

    public void MaterialFilter() {
        List<WebElement> delas1 = driver.findElements(filterOptions);
        for (WebElement filterOption : delas1) {
            String filters = filterOption.getText();
            System.out.println(filters);
            if (filters.contains("MATERIAL")) {
                filterOption.click();
                List<WebElement> filterSelect = driver.findElements(filterSelection);
                for (WebElement filterValues : filterSelect) {
                    String filterInsideValues = filterValues.getText();
                    System.out.println(filterInsideValues);
                    if (filterInsideValues.contains("Cotton")) {
                        filterValues.click();
                        break;
                    }

                }
                break;
            }
        }
    }

    public void selectTees() {

        List<WebElement> selectTees = driver.findElements(selectTee);
        for (WebElement selectTe : selectTees) {
            String tShirtText = selectTe.getText();
            System.out.println(tShirtText);
            if (tShirtText.contains("Strike Endurance Tee")) {
                selectTe.click();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                System.out.println("selected Tee");
                break;
            }
        }
    }

    public void tShirtSizeSelect() {

        List<WebElement> sizeTees = driver.findElements(teeSize);
        for (WebElement sizeTe : sizeTees) {
            String tShirtText = sizeTe.getText();
            if (tShirtText.contains("S")) {
                sizeTe.click();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                System.out.println("Selected small size T");
                break;
            }
        }
    }

    public void colorSizeSelect() {
        driver.findElement(colourSelect).click();
        System.out.println("Selected Blue Colour Size");

    }

    public void addToCartClicked() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(addToCartClick).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println("add to cart clicked");
    }

    public void shoppingCart() throws InterruptedException {
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Thread.sleep(5000);
        driver.findElement(shoppingCarts).click();
        System.out.println("shopping cart selected");
    }

    public void clickOnViewCart() {
        driver.findElement(viewCart).click();

    }

    public void clickOnReviewComments() {
        driver.findElement(reviews).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        List<WebElement> reviewText = driver.findElements(reviewComments);
        for (WebElement review : reviewText) {
            String reviewsText = review.getText();
            if (reviewsText.contains("expensive")) {
                Assert.assertEquals(reviewsText, "OBSESSED with this! I love that it's adjustable! A bit more expensive than I wanted, but TOTALLY worth it.");      }

        }

    }

    public void clickOnProceedCheckoutButton()
    {
        driver.findElement(proceedToCheckOut).click();
    }
}