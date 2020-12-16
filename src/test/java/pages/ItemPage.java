package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ItemPage {
    private static WebDriver driver;

    public ItemPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "group_1")
    WebElement sizeList;

    @FindBy(id = "quantity_wanted")
    WebElement quantityInput;

    public void choseItem(String size, String quantity) {
        sizeList.click();
        Select sizeElement = new Select(sizeList);
        sizeElement.selectByVisibleText(size);

        quantityInput.click();
        quantityInput.clear();
        quantityInput.sendKeys(quantity);
    }
}
