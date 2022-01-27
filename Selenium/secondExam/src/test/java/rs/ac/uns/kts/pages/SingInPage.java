package rs.ac.uns.kts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SingInPage {

	private WebDriver driver;

	@FindBy(id = "user-name")
	private WebElement emailInput;

	@FindBy(id = "password")
	private WebElement passwordInput;

	@FindBy(id = "login-button")
	private WebElement submitButton;

	@FindBy(xpath = "//*[contains(text(), 'Epic sadface')]")
	private WebElement alertDivText;

	public SingInPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getEmailInput() {
		return Utilities.visibilityWait(driver, this.emailInput, 10);
	}

	public void setEmailInput(String value) {
		WebElement el = getEmailInput();
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

	public void submitBtnClick() {
		Utilities.clickableWait(driver, this.submitButton, 10).click();
	}

	public boolean errorMessagePresent(String text) {
		return Utilities.textWait(driver, this.alertDivText, text, 10);
	}

}
