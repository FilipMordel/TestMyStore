package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

    public class UserPage {
        private WebDriver driver;

        public UserPage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        @FindBy(xpath = "//a[@data-link-action='add-address']")
        WebElement addressButton;

        public void setAddressButton() {
            addressButton.click();
        }
    }

