package rs.ac.uns.kts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage {

	private WebDriver driver;

	@FindBy(id = "checkout")
	private WebElement checkoutButton;

    public void pressCheckout(){
        
		Utilities.clickableWait(driver, this.checkoutButton, 10).click();
		
	}

    public CartPage(WebDriver driver) {
		this.driver = driver;
	}
}
