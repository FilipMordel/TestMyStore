package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class AddressPage {
    private static WebDriver driver;

    public AddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "alias")
    WebElement aliasInput;

    @FindBy(name = "address1")
    WebElement addressInput;

    @FindBy(name = "city")
    WebElement cityInput;

    @FindBy(name = "postcode")
    WebElement postCodeInput;

    @FindBy(name = "id_country")
    WebElement countryList;

    @FindBy(name = "phone")
    WebElement phoneInput;

    @FindBy(css = ".btn.btn-primary")
    WebElement submitButton;

    @FindBy(css = ".alert.alert-success")
    WebElement successInformation;

    public void addAddress(String alias, String address, String city, String postcode, String country, String phone) {
        aliasInput.click();
        aliasInput.clear();
        aliasInput.sendKeys(alias);

        addressInput.click();
        addressInput.clear();
        addressInput.sendKeys(address);

        cityInput.click();
        cityInput.clear();
        cityInput.sendKeys(city);

        postCodeInput.click();
        postCodeInput.clear();
        postCodeInput.sendKeys(postcode);

        Select countryElement = new Select(countryList);
        countryElement.selectByVisibleText(country);

        phoneInput.click();
        phoneInput.clear();
        phoneInput.sendKeys(phone);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {
        }

        submitButton.click();

    }

    public String getUpdateInformation() {
        return successInformation.getText();
    }
}
