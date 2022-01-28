package rs.ac.uns.kts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordAdminPage {
    private WebDriver driver;

    @FindBy(id = "changePasswordButton")
    private WebElement changePasswordLink;

    @FindBy(id = "oldPassword")
    private WebElement oldPassword;

    @FindBy(id = "newPassword")
    private WebElement newPassword;

    @FindBy(id = "change-password-button")
    private WebElement changePasswordButton;

    public ChangePasswordAdminPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getOldPasswordInput() {
        return Utilities.visibilityWait(driver, this.oldPassword, 10);
    }

    public void setOldPasswordInput(String value) {
        WebElement el = getOldPasswordInput();
        el.clear();
        el.sendKeys(value);
    }

    public WebElement getNewPasswordInput() {
        return Utilities.visibilityWait(driver, this.newPassword, 10);
    }

    public void setNewPasswordInput(String value) {
        WebElement el = getNewPasswordInput();
        el.clear();
        el.sendKeys(value);
    }

    public void singInLinkClick() {
        Utilities.clickableWait(driver, this.changePasswordLink, 1000).click();
    }

    public void changePasswordBtn() {
        System.out.println(this.changePasswordButton);
        Utilities.clickableWait(driver, this.changePasswordButton, 100).click();
    }
}
