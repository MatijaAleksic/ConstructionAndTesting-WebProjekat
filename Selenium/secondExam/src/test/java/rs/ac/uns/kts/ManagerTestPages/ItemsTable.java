package rs.ac.uns.kts.ManagerTestPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import rs.ac.uns.kts.pages.AdminTestPages.Utilities;

public class ItemsTable {
    private WebDriver driver;

    public ItemsTable(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(xpath = "//a[contains(text(),'Items')]")
    private WebElement items;

    @FindBy(xpath = "//a[contains(text(),'New Recipes')]")
    private WebElement newRecipes;

    @FindBy(xpath = "//button[contains(text(),'Edit')]")
    private WebElement editPrice;

    @FindBy(xpath = "//button[contains(text(),'Activate/Deactivate')]")
    private WebElement activate;

    @FindBy(xpath = "//button[contains(text(),'Activate')]")
    private WebElement activateItem;

    @FindBy(xpath = "//button[contains(text(),'Deactivate')]")
    private WebElement deactivateItem;

    public void itemsLinkClick() {
        Utilities.clickableWait(driver, this.items, 1000).click();
    }

    public void setNewRecipesinkClick() {
        Utilities.clickableWait(driver, this.newRecipes, 1000).click();
    }

    public void editPriceBtnClick() {
        System.out.println(this.editPrice);
        Utilities.clickableWait(driver, this.editPrice, 100).click();
    }

    public void activateBtnClick() {
        System.out.println(this.activate);
        Utilities.clickableWait(driver, this.activate, 100).click();
    }

    public void activateItemBtnClick() {
        System.out.println(this.activateItem);
        Utilities.clickableWait(driver, this.activateItem, 100).click();
    }
    public void deactivateItemBtnClick() {
        System.out.println(this.deactivateItem);
        Utilities.clickableWait(driver, this.deactivateItem, 100).click();
    }
}
