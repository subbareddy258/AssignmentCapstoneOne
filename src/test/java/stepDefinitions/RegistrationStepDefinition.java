package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.List;
import java.util.Map;
public class RegistrationStepDefinition {
        private WebDriver driver;
        private RegistrationPage registrationPage;
        private static Logger logger = LogManager.getLogger(RegistrationStepDefinition.class);
        @Given("I am on the registration page")
        public void iAmOnTheRegistrationPage() {
            registrationPage = new RegistrationPage(driver);
            registrationPage.registerNow();
        }
        @When("I enter valid user Information {string} {string} {string}")
        public void iEnterValidUserInformationUserIdNewPasswordRepeatPassword(String userId,String password,String RepeatPasswords) {
            logger.info("Entering valid user details");
            registrationPage.enterUserId(userId);
            registrationPage.enterPasswords(password);
            registrationPage.enterRepeatedPassword(RepeatPasswords);


        }
        @And("I enter valid Account Information {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
        public void iEnterValidAccountInformationFirstNameLastNameEmailPhoneAddressAddressCityZipCountry(String firstName, String lastName,String email,String  phone,

                                                                                                         String  address1,String address2 ,String  city,String  zip,String Country,String state) {

            logger.info("Entering valid registration details");
            registrationPage.enterFirstName(firstName);
            registrationPage.enterLastName(lastName);
            registrationPage.enterEmail(email);
            registrationPage.phoneField(phone);
            registrationPage.enterAddress1(address1);
            registrationPage.enterAddress2(address2);
            registrationPage.enterCity(city);
            registrationPage.enterState(state);
            registrationPage.enterZip(zip);
            registrationPage.enterCountry(Country);
        }

        @And("Profile Information")
        public void profileInformation() {
            logger.info("Submitting the registration form");
            registrationPage.checkMyList();
            registrationPage.checkBanner();
            registrationPage.newAccount();
        }


        @Then("I should be registered successfully")
        public void iShouldBeRegisteredSuccessfully() {
            // Perform assertions to verify the registration success
            logger.info("Verifying registration success");
            // Close the browser after the scenario
            driver.quit();
        }

        @Given("User in login Page")
        public void userInLoginPage() {
            logger.info("Entering valid login page details");
            registrationPage = new RegistrationPage(driver);
            EdgeOptions options = new EdgeOptions();
            driver = new EdgeDriver(options);
            driver.get("https://petstore.octoperf.com/actions/Account.action;jsessionid=15407CE4CCE26F8E820E06FD84BDE816?signonForm=");
        }

        @When("I enter the following credentials:")
        public void iEnterTheFollowingCredentials(DataTable dataTable) {
            List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);
            registrationPage = new RegistrationPage(driver);
            String username = credentials.get(0).get("Username");
            String password = credentials.get(0).get("Password");
            registrationPage.userName(username,password);
            logger.info("Entering valid logged details");


        }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        registrationPage.signIn();
        logger.info("clicked on signInButton");
        driver.quit();
    }
}
