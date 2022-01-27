package rs.ac.uns.kts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ItemsPage {

	private WebDriver driver;

	@FindBy(id = "reset_sidebar_link")
	private WebElement resetButton;

	@FindBy(className = "bm-burger-button")
	private WebElement menuButton;

	@FindBy(id = "add-to-cart-sauce-labs-bike-light")
	private WebElement secondItem;

	@FindBy(id = "shopping_cart_container")
	private WebElement shoppingCart;

	public ItemsPage(WebDriver driver) {
		this.driver = driver;
	}



	public void addSecondItem() {
		Utilities.clickableWait(driver, this.secondItem, 10).click();
	}

	public void pressReset(){
		Utilities.clickableWait(driver, this.resetButton, 10).click();
	}


	public void pressMenuButton(){
		Utilities.clickableWait(driver, this.menuButton, 10).click();
		
	}

	public void pressShoppingCart(){
		Utilities.clickableWait(driver, this.shoppingCart, 10).click();
		
	}

	// bufix za https://stackoverflow.com/questions/62003082/elementnotinteractableexception-element-not-interactable-element-has-zero-size
		// specificno za linux i specificno za chrome 83+
	public void linuxBufix(){
		Actions actions = new Actions(driver);
		actions.moveToElement(menuButton);
		actions.perform();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
