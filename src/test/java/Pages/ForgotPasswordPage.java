package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {
    private WebDriver driver;

    private By submitButton = By.cssSelector("#submitBtn");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmail(String email) {
        JavascriptExecutor jse = ((JavascriptExecutor)driver);
        WebElement element = (WebElement) jse.executeScript("return document.getElementById('userName');");
        element.sendKeys(email);

    }
    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }
}

