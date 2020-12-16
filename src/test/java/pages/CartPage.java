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

    public void setCartButton() {

        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException ie){
        }
        addButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {
        }
        checkoutButton.click();
    }

}
