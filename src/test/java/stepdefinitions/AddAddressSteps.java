package stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AddressPage;
import pages.LoginPage;
import pages.UserPage;

import java.util.concurrent.TimeUnit;

public class AddAddressSteps {
    AddressPage addressPage;
    WebDriver driver;
    UserPage userPage;

    @Given("^User logged at MyStore$")
    public void userLoggedAtMyStore() {

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("ovmgqwhyggctorygtn@miucce.com", "warsztaty");
    }


    @When("^User goes to UserAddressPage$")
    public void userGoesToUserAddressPage() {
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=addresses");
    }

    @And("^User crates new address$")
    public void userCratesNewAddress() {
        userPage = new UserPage(driver);
        userPage.setAddressButton();
    }

    @And("^User adds and saves (.*), (.*), (.*), (.*), (.*) and (.*)$")
    public void userAddsAndSavesAliasAddressCityZipPostalCodeCountryAndPhone(String alias, String address, String city, String postcode, String country, String phone) {
        addressPage = new AddressPage(driver);
        addressPage.addAddress(alias, address, city, postcode, country, phone);
    }


    @Then("^User gets \"([^\"]*)\"$")
    public void userSees(String actionMessage) {
        Assert.assertEquals(actionMessage, addressPage.getUpdateInformation());
    }

    @And("^User deletes address$")
    public void userDeletesAddress() {
        addressPage.deleteAddress();

    }

    @Then("^User deleted address and gets \"([^\"]*)\"$")
    public void addressDeleted(String confirmationMessage) {
        Assert.assertEquals(confirmationMessage, addressPage.getDeleteInformation());
        driver.quit();
    }
}