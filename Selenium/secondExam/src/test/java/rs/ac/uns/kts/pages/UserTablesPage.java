package rs.ac.uns.kts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserTablesPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[contains(text(),'Users ')]")
    private WebElement users;

    @FindBy(xpath = "//a[contains(text(),'Admins')]")
    private WebElement admins;

    @FindBy(xpath = "//*[contains(text(),'Managers')]")
    private WebElement managers;

    @FindBy(xpath = "//*[contains(text(),'Waiter')]")
    private WebElement waiters;

    @FindBy(xpath = "//*[contains(text(),'Cook')]")
    private WebElement cooks;

    @FindBy(xpath = "//*[contains(text(),'Main Cook')]")
    private WebElement mainCooks;

    @FindBy(xpath = "//*[contains(text(),'Barman')]")
    private WebElement barmans;

    @FindBy(xpath = "//button[@id='add-new-admin-button' and not(@disabled)]")
    private WebElement addNewAdmin;

    @FindBy(xpath = "//button[@id='delete-button' and not(@disabled)]")
    private WebElement deleteAdmin;

    public UserTablesPage(WebDriver driver){
        this.driver = driver;
    }

    public void usersLinkClick() {
        Utilities.clickableWait(driver, this.users, 1000).click();
    }

    public void adminLinkClick() {
        Utilities.clickableWait(driver, this.admins, 1000).click();
    }

    public void managerLinkClick() {
        Utilities.clickableWait(driver, this.managers, 1000).click();
    }

    public void cookLinkClick() {
        Utilities.clickableWait(driver, this.cooks, 1000).click();
    }

    public void waiterLinkClick() {
        Utilities.clickableWait(driver, this.waiters, 1000).click();
    }

    public void mainCookLinkClick() {
        Utilities.clickableWait(driver, this.mainCooks, 1000).click();
    }

    public void barmanLinkClick() {
        Utilities.clickableWait(driver, this.barmans, 1000).click();
    }
    public void addAdminBtnClick() {
        System.out.println(this.addNewAdmin);
        Utilities.clickableWait(driver, this.addNewAdmin, 100).click();
    }

    public void deleteAdminBtnClick() {
        System.out.println(this.deleteAdmin);
        Utilities.clickableWait(driver, this.deleteAdmin, 100).click();
    }

}
