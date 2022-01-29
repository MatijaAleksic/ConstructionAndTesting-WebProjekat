package rs.ac.uns.kts.ManagerTestPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import rs.ac.uns.kts.pages.AdminTestPages.Utilities;

public class ChangeItemPrice {
    private WebDriver driver;

    @FindBy(id = "price")
    private WebElement priceInput;

    @FindBy(id = "change-price-button")
    private WebElement submitButton;

    public ChangeItemPrice(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getPriceInput() {
        return Utilities.visibilityWait(driver, this.priceInput, 10);
    }

    public void setPriceInput(String value) {
        WebElement el = getPriceInput();
        el.clear();
        el.sendKeys(String.valueOf(value));
    }

    public void submitBtnClick() {
        System.out.println(this.submitButton);
        Utilities.clickableWait(driver, this.submitButton, 100).click();
    }
}
