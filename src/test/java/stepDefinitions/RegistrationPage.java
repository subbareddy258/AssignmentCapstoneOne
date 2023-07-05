package stepDefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class RegistrationPage {
    private WebDriver driver;
    private By userId = By.name("username");
    private By password = By.name("password");
    private By repeatedPassword = By.name("repeatedPassword");

    private By firstNameField = By.name("account.firstName");
    private By lastNameField = By.name("account.lastName");
    private By emailField = By.name("account.email");
    private By phoneField = By.name("account.phone");

    private By address1Field = By.name("account.address1");
    private By address2Field = By.name("account.address2");
    private By cityField = By.name("account.city");
    private By stateField = By.name("account.state");
    private By zipField = By.name("account.zip");
    private By countryField = By.name("account.country");

    private By listOptionCheckBox = By.name("account.listOption");
    private By bannerOptionCheckbox = By.name("account.bannerOption");

    private By newAccount = By.name("newAccount");

    private  By registerNow = By.xpath("//*[@id='Catalog']/a");
    private  By signon = By.name("signon");



    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }
    public void registerNow() {
        driver.findElement(registerNow).click();
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterUsername(String username) {
        driver.findElement(lastNameField).sendKeys(username);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }
    public void phoneField(String phone) {
        driver.findElement(phoneField).clear();
        driver.findElement(phoneField).sendKeys(phone);
    }
    public void enterAddress1(String address1) {
        driver.findElement(address1Field).clear();
        driver.findElement(address1Field).sendKeys(address1);
    }
    public void enterAddress2(String address2)
    {driver.findElement(address2Field).clear();
        driver.findElement(address2Field).sendKeys(address2);
    }
    public void enterZip(String zip) {
        driver.findElement(zipField).clear();
        driver.findElement(zipField).sendKeys(zip);
    }
    public void enterCity(String city)
    {
        driver.findElement(cityField).clear();
        driver.findElement(cityField).sendKeys(city);
    }
    public void enterState(String state) {

        driver.findElement(stateField).clear();
        driver.findElement(stateField).sendKeys(state);
    }
    public void enterCountry(String country) {

        driver.findElement(countryField).clear();
        driver.findElement(countryField).sendKeys(country);
    }
    public void enterUserId(String user) {

        driver.findElement(userId).clear();
        driver.findElement(userId).sendKeys(user);
    }

    public void enterPasswords(String passWord) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(passWord);
    }
    public void enterRepeatedPassword(String repeatedPasswords) {
        driver.findElement(repeatedPassword).clear();
        driver.findElement(repeatedPassword).sendKeys(repeatedPasswords);
    }

    public void checkMyList() {
        driver.findElement(listOptionCheckBox).click();
    }
    public void checkBanner() {
        driver.findElement(bannerOptionCheckbox).click();
    }
    public void newAccount() {
        driver.findElement(newAccount).submit();
    }
    public void userName(String firtsName,String passwords) {
        driver.findElement(userId).clear();
        driver.findElement(userId).sendKeys(firtsName);
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(passwords);

    }
    public void signIn()
    {
        driver.findElement(signon).click();
    }


}
