package rs.ac.uns.kts.Cook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import rs.ac.uns.kts.pages.AdminTestPages.Utilities;

public class OrdersPage {
    private WebDriver driver;

    @FindBy(id = "edit-item-price-button")
    private WebElement takeOrderBtn;

    @FindBy(xpath = "//a[contains(text(),'Orders')]")
    private WebElement orders;

    public OrdersPage(WebDriver driver){
        this.driver = driver;
    }

    public void ordersLinkClick() {
        Utilities.clickableWait(driver, this.orders, 1000).click();
    }

    public void takeOrderBtnClick() {
        System.out.println(this.takeOrderBtn);
        Utilities.clickableWait(driver, this.takeOrderBtn, 100).click();
    }

    public int getNumberOfOrders() {
        return Utilities.visibilityWait(driver, By.xpath("//table/tbody/tr"), 10).size();
    }
}
