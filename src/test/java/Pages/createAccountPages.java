package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class createAccountPages {
    private WebDriver driver;
    private By createAccount = By.xpath("//a[contains(text(),'Create an Account')]");
    private By firstNameInput = By.id("firstname");
    private By lastNameInput = By.id("lastname");
    private By emailInput = By.id("email_address");
    private By passwordInput = By.id("password");
    private By passwordConfirmationInput = By.id("password-confirmation");
    private By createAccountButton = By.xpath("//button[@title='Create an Account']");

    public createAccountPages(WebDriver driver) {
        this.driver = driver;
    }
    public void clickOnAccountButton()
    {
        driver.findElement(createAccountButton).click();

    }

    public void setFirstname(String firstname) {
        WebElement firstnameElement = driver.findElement(firstNameInput);
        firstnameElement.clear();
        firstnameElement.sendKeys(firstname);
    }

    public void setLastName(String lastname) {
        WebElement lastnameElement = driver.findElement(lastNameInput);
        lastnameElement.clear();
        lastnameElement.sendKeys(lastname);
    }

    public void setEmail(String email) {
        WebElement emailElement = driver.findElement(emailInput);
        emailElement.clear();
        emailElement.sendKeys(email);
    }

    public void setPassword(String password) {
        WebElement passwordElement = driver.findElement(passwordInput);
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }
    public void setConfirmationPassword(String confirmationPassword) {
        WebElement confirmationPasswordElement = driver.findElement(passwordConfirmationInput);
        confirmationPasswordElement.clear();
        confirmationPasswordElement.sendKeys(confirmationPassword);
    }

    public void clickOnAccount()
    {
        driver.findElement(createAccount).click();

    }

}
