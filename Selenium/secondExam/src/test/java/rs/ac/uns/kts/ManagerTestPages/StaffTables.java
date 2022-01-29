package rs.ac.uns.kts.ManagerTestPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import rs.ac.uns.kts.pages.AdminTestPages.Utilities;

public class StaffTables {
    private WebDriver driver;

    @FindBy(xpath = "//a[contains(text(),'Staff')]")
    private WebElement staff;

    @FindBy(xpath = "//button[@id='edit-staff-salary-button' and not(@disabled)]")
    private WebElement editSalary;

    public StaffTables(WebDriver driver){
        this.driver = driver;
    }

    public void staffLinkClick() {
        Utilities.clickableWait(driver, this.staff, 1000).click();
    }

    public void editSalaryBtnClick() {
        System.out.println(this.editSalary);
        Utilities.clickableWait(driver, this.editSalary, 100).click();
    }
}
