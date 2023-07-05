package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    private By usernameInput = By.xpath("//input[@id='userName']");
    private By passwordInput = By.xpath("//input[@id='password']");
    private By loginButton = By.xpath("//input[@id='submitBtn']");
    private By SignIn = By.cssSelector("a[href='/oprs-web/login/show.do']");
    private By forgotPassword = By.cssSelector(".alinkColor[href='/oprs-web/login/forgotpw.do']");
    private By errorMessage = By.xpath("//*[@id='errorMsg']/strong");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUsername(String username) {
        WebElement usernameElement = driver.findElement(usernameInput);
        usernameElement.clear();
        usernameElement.sendKeys(username);
    }

    public void setPassword(String password) {
        WebElement passwordElement = driver.findElement(passwordInput);
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void clickSignInButton() {
        driver.findElement(SignIn).click();
    }

    public void ForgetPassword() {
        driver.findElement(forgotPassword).click();
    }

    public void checkBox() {
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("document.getElementById('TermsConditions').click()");

    }

    public String error() {
        String actualErrorMessage = driver.findElement(errorMessage).getText();
        return actualErrorMessage;
    }
}
