package rs.ac.uns.kts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSalary {

    private WebDriver driver;

    @FindBy(id = "salary")
    private WebElement salaryInput;

    @FindBy(id = "change-salary-button")
    private WebElement submitButton;

    public EditSalary(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getSalaryInput() {
        return Utilities.visibilityWait(driver, this.salaryInput, 10);
    }

    public void setSalaryInput(String value) {
        WebElement el = getSalaryInput();
        el.clear();
        el.sendKeys(String.valueOf(value));
    }

    public void submitBtnClick() {
        System.out.println(this.submitButton);
        Utilities.clickableWait(driver, this.submitButton, 100).click();
    }
}
