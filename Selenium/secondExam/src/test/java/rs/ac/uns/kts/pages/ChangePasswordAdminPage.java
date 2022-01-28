package rs.ac.uns.kts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordAdminPage {
    private WebDriver driver;

    @FindBy(xpath = "//a[text()='Change Password']")
    private WebElement changePasswordLink;

    public ChangePasswordAdminPage(WebDriver driver){
        this.driver = driver;
    }

    public void singInLinkClick() {
        Utilities.visibilityWait(driver, this.changePasswordLink, 10).click();
    }
}
