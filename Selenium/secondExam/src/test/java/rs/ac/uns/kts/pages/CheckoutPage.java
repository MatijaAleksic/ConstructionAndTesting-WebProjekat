package rs.ac.uns.kts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage {

	private WebDriver driver;

	@FindBy(id = "first-name")
	private WebElement firstName;

	@FindBy(id = "last-name")
	private WebElement lastName;

    @FindBy(id = "postal-code")
	private WebElement postalCode;

	@FindBy(id = "continue")
	private WebElement submitButton;

	@FindBy(xpath = "//*[contains(text(), 'Error:')]")
	private WebElement alertDivText;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getFirstNameInput() {
		return Utilities.visibilityWait(driver, this.firstName, 10);
	}

	public void setFirstNameInput(String value) {
		WebElement el = getFirstNameInput();
		el.clear();
		el.sendKeys(value);
	}

	public WebElement getLastNameInput() {
		return Utilities.visibilityWait(driver, this.lastName, 10);
	}

	public void setLastNameInput(String value) {
		WebElement el = getLastNameInput();
		el.clear();
		el.sendKeys(value);
	}


    public WebElement getPostalInput() {
		return Utilities.visibilityWait(driver, this.postalCode, 10);
	}

	public void setPostalInput(String value) {
		WebElement el = getPostalInput();
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
