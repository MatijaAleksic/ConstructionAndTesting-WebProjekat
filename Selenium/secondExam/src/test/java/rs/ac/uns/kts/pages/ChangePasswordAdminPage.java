package rs.ac.uns.kts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordAdminPage {
    private WebDriver driver;

    @FindBy(id = "changePasswordButton")
    private WebElement changePasswordLink;

    public ChangePasswordAdminPage(WebDriver driver){
        this.driver = driver;
    }

    public void singInLinkClick() {
        Utilities.clickableWait(driver, this.changePasswordLink, 1000).click();
    }
}
