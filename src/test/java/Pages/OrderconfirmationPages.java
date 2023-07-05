package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class OrderconfirmationPages {
    private WebDriver driver;
    private By clickOnCustomerSubMenu = By.xpath("//div[@class='customer-menu']/ul/li/a");
    private By clickOnOrder = By.xpath("//div[@id='block-collapsible-nav']/ul/li/a");
    private By signOutMessage = By.xpath("//*[@id='maincontent']/div[3]/div/p");

    public OrderconfirmationPages(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnMenu() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='panel header']/ul/li/span[@role='button']")));
            element.click();
    }

    public void clickOnSubMenu() throws InterruptedException {
        List<WebElement> subMenu = driver.findElements(clickOnCustomerSubMenu);
        System.out.println("subMenu" + subMenu.size());
        for (WebElement subMenus : subMenu) {
            String subMenusTex = subMenus.getText();
            System.out.println("submenu" + subMenusTex);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            if (subMenusTex.contains("My Account")) {
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(subMenus));
                element.click();
                break;
            }


        }

    }

    public void clickOnMyOrders() throws InterruptedException {
        List<WebElement> belowMyAccount = driver.findElements(clickOnOrder);
        System.out.println("belowMyAccount" + belowMyAccount.size());
        for (WebElement belowMyAccounts : belowMyAccount) {
            String belowMyAccountTexting = belowMyAccounts.getText();
            System.out.println("pricesText" + belowMyAccountTexting);
            if (belowMyAccountTexting.contains("My Orders")) {
                belowMyAccounts.click();
                break;
            }
        }

    }

    public void viewOrders() {
        WebElement table = driver.findElement(By.id("my-orders-table"));

        // Find all rows in the table body
        WebElement tbody = table.findElement(By.tagName("tbody"));
        List<WebElement> rows = tbody.findElements(By.tagName("tr"));

        // Iterate over each row and click on the "View Order" link
        for (WebElement row : rows) {
            WebElement viewOrderLink = row.findElement(By.linkText("View Order"));
            viewOrderLink.click();

        }
    }

    public void signOut() throws InterruptedException {
        clickOnMenu();
        List<WebElement> signOut = driver.findElements(clickOnCustomerSubMenu);
        System.out.println("subMenu" + signOut.size());
        for (WebElement signOutMenus : signOut) {
            String signoutText = signOutMenus.getText();
            System.out.println("submenu" + signoutText);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            if (signoutText.contains("Sign Out")) {
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(signOutMenus));
                element.click();
                break;
            }
        }

    }

    public void signOutmessage()
    {
      String signOutText =  driver.findElement(signOutMessage).getText();
        Assert.assertEquals(signOutText,"You have signed out and will go to our homepage in 5 seconds.");

    }


}