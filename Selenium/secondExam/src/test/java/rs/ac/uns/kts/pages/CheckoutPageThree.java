package rs.ac.uns.kts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPageThree {

	private WebDriver driver;

	@FindBy(id = "logout_sidebar_link")
	private WebElement resetButton;

	@FindBy(className = "bm-burger-button")
	private WebElement menuButton;


	public CheckoutPageThree(WebDriver driver) {
		this.driver = driver;
	}




	public void pressLogout(){
		Utilities.clickableWait(driver, this.resetButton, 10).click();
	}


	public void pressMenuButton(){
		Utilities.clickableWait(driver, this.menuButton, 10).click();
		
	}


}
