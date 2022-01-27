package rs.ac.uns.kts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPageTwo {

	private WebDriver driver;

	@FindBy(id = "finish")
	private WebElement checkoutButton;

    public void pressCheckout(){
		Utilities.clickableWait(driver, this.checkoutButton, 10).click();
		
	}

    public CheckoutPageTwo(WebDriver driver) {
		this.driver = driver;
	}
}
