package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CartPage;
import pages.ItemPage;
import pages.LoginPage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BuyItemSteps {
    WebDriver driver;
    ItemPage itemPage;
    CartPage cartPage;

    @Given("^User is logged to Mystore$")
    public void userIsLoggedMystore() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("ovmgqwhyggctorygtn@miucce.com", "warsztaty");
    }

    @When("^User goes to PrintedSweaterPage$")
    public void userGoesToPrintedSweaterPage() {
        driver.get("https://prod-kurs.coderslab.pl/index.php?id_product=2&id_product_attribute=9&rewrite=brown-bear-printed-sweater&controller=product#/size-s");
    }

    @And("^User adds and saves (.*) and (.*)$")
    public void userAddsEndSavesSizeAndQuantity(String size, String quantity) {
        itemPage = new ItemPage(driver);
        itemPage.choseItem(size, quantity);
    }

    @And("^User add item to cart and buy it$")
    public void userAddItemToCart() {
        cartPage = new CartPage(driver);
        cartPage.setCartButton();

    }

    @Then("^Make a screenshot of payment$")
    public void makeAScreenshotOfPayment() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String fileName = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss'-screenshot.png'").format(new Date());
        FileUtils.copyFile(scrFile, new File("screenshots/" + fileName));

        driver.quit();

    }


}