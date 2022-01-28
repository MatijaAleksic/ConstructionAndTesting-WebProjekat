package rs.ac.uns.kts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewUserPage {

    private WebDriver driver;

    @FindBy(id = "firstName")
    private WebElement firstNameInput;

    @FindBy(id = "lastName")
    private WebElement lastNameInput;

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "dateOfBirth")
    private WebElement dateInput;

    @FindBy(id = "salary")
    private WebElement salaryInput;

    @FindBy(xpath = "//button[contains(text(),'Add ')]")
    private WebElement submitButton;

    public AddNewUserPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getFirstNameInput() {
        return Utilities.visibilityWait(driver, this.firstNameInput, 10);
    }

    public void setFirstNameInput(String value) {
        WebElement el = getFirstNameInput();
        el.clear();
        el.sendKeys(value);
    }
    public WebElement getLastNameInput() {
        return Utilities.visibilityWait(driver, this.lastNameInput, 10);
    }

    public void setLastNameInput(String value) {
        WebElement el = getLastNameInput();
        el.clear();
        el.sendKeys(value);
    }
    public WebElement getUsernameInput() {
        return Utilities.visibilityWait(driver, this.usernameInput, 10);
    }

    public void setUsernameInput(String value) {
        WebElement el = getUsernameInput();
        el.clear();
        el.sendKeys(value);
    }
    public WebElement getPasswordInput() {
        return Utilities.visibilityWait(driver, this.passwordInput, 10);
    }

    public void setPasswordInput(String value) {
        WebElement el = getPasswordInput();
        el.clear();
        el.sendKeys(value);
    }
    public WebElement getDateInput() {
        return Utilities.visibilityWait(driver, this.dateInput, 10);
    }

    public void setDateInput(String value) {
        WebElement el = getDateInput();
        el.clear();
        el.sendKeys(value);
    }
    public WebElement getSalaryInput() {
        return Utilities.visibilityWait(driver, this.salaryInput, 10);
    }

    public void setSalaryInput(String value) {
        WebElement el = getSalaryInput();
        el.clear();
        el.sendKeys(value);
    }

    public void submitBtnClick() {
        System.out.println(this.submitButton);
        Utilities.clickableWait(driver, this.submitButton, 100).click();
    }

}
