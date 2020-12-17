package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".btn.btn-primary.add-to-cart")
    WebElement addButton;

    @FindBy(css = ".cart-content-btn .btn.btn-primary")
    WebElement checkoutButton;

    @FindBy(css = ".text-sm-center .btn.btn-primary")
    WebElement proceedButton;

    @FindBy(name = "confirm-addresses")
    WebElement conButton;

    @FindBy(name = "confirmDeliveryOption")
    WebElement deliveryButton;

    @FindBy(id = "payment-option-1")
    WebElement paymentButton;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    WebElement conditionsButton;

    @FindBy(css = ".btn.btn-primary.center-block")
    WebElement centerButton;


    public void setCartButton() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {
        }
        addButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {
        }
        checkoutButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {
        }
        proceedButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {
        }
        conButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {
        }
        deliveryButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {
        }
        paymentButton.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
        }
        conditionsButton.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
        }
        centerButton.click();
    }

}
