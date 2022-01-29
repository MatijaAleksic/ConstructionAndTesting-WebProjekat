package rs.ac.uns.kts.pages.AdminTestPages;

import org.openqa.selenium.By;
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

    @FindBy(xpath = "//button[@id='add-new-manager-button' and not(@disabled)]")
    private WebElement addNewManager;

    @FindBy(xpath = "//button[@id='add-new-cook-button' and not(@disabled)]")
    private WebElement addNewCook;

    @FindBy(xpath = "//button[@id='add-new-waiter-button' and not(@disabled)]")
    private WebElement addNewWaiter;

    @FindBy(xpath = "//button[@id='add-new-main-cook-button' and not(@disabled)]")
    private WebElement addNewMainCook;

    @FindBy(xpath = "//button[@id='add-new-barman-button' and not(@disabled)]")
    private WebElement addNewBarman;

    @FindBy(xpath = "//button[@id='edit-manager-salary-button' and not(@disabled)]")
    private WebElement editMangerSalary;

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

    public void addManagerBtnClick() {
        System.out.println(this.addNewManager);
        Utilities.clickableWait(driver, this.addNewManager, 100).click();
    }

    public void addCookBtnClick() {
        System.out.println(this.addNewCook);
        Utilities.clickableWait(driver, this.addNewCook, 100).click();
    }

    public void addWaiterBtnClick() {
        System.out.println(this.addNewWaiter);
        Utilities.clickableWait(driver, this.addNewWaiter, 100).click();
    }

    public void addMainCookBtnClick() {
        System.out.println(this.addNewMainCook);
        Utilities.clickableWait(driver, this.addNewMainCook, 100).click();
    }

    public void addBarmanBtnClick() {
        System.out.println(this.addNewBarman);
        Utilities.clickableWait(driver, this.addNewBarman, 100).click();
    }

    public void editManagerSalaryBtnClick() {
        System.out.println(this.editMangerSalary);
        Utilities.clickableWait(driver, this.editMangerSalary, 100).click();
    }

    public void deleteAdminBtnClick() {
        System.out.println(this.deleteAdmin);
        Utilities.clickableWait(driver, this.deleteAdmin, 100).click();
    }


    public int getNumberOfUsers() {
        return Utilities.visibilityWait(driver, By.xpath("//table/tbody/tr"), 10).size();
    }

}
