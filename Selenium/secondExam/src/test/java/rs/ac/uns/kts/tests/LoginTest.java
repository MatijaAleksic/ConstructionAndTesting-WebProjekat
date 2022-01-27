package rs.ac.uns.kts.tests;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import rs.ac.uns.kts.pages.CartPage;
import rs.ac.uns.kts.pages.CheckoutPage;
import rs.ac.uns.kts.pages.CheckoutPageThree;
import rs.ac.uns.kts.pages.CheckoutPageTwo;
import rs.ac.uns.kts.pages.ItemsPage;
import rs.ac.uns.kts.pages.SingInPage;

public class LoginTest {

	private WebDriver browser;

	private ItemsPage itemsPage;
	private SingInPage singInPage;
	private CartPage cartPage;
	private CheckoutPage checkoutPage;
	private CheckoutPageTwo checkoutPageTwo;
	private CheckoutPageThree checkoutPageThree;

	@Before
	public void setupSelenium() {
		// instantiate browser
		System.setProperty("webdriver.gecko.driver", "geckodriver");
		browser = new FirefoxDriver();
		// maximize window
		browser.manage().window().maximize();
		// navigate
		browser.navigate().to("https://www.saucedemo.com");

		itemsPage = PageFactory.initElements(browser, ItemsPage.class);
		singInPage = PageFactory.initElements(browser, SingInPage.class);
		cartPage = PageFactory.initElements(browser, CartPage.class);
		checkoutPage = PageFactory.initElements(browser, CheckoutPage.class);
		checkoutPageTwo = PageFactory.initElements(browser, CheckoutPageTwo.class);
		checkoutPageThree = PageFactory.initElements(browser, CheckoutPageThree.class);

	}

	@Test
	public void singInTest() {

		// all fields empty
		singInPage.submitBtnClick();
		assertTrue(singInPage.errorMessagePresent("Epic sadface: Username is required"));

		// password empty 
		singInPage.setEmailInput("aaa");
		singInPage.submitBtnClick();
		assertTrue(singInPage.errorMessagePresent("Epic sadface: Password is required"));

		// invalid user
		singInPage.setEmailInput("aaaaa");
		singInPage.setPasswordInput("wrong");
		singInPage.submitBtnClick();
		assertTrue(singInPage.errorMessagePresent("Epic sadface: Username and password do not match any user in this service"));

		// valid user
		singInPage.setEmailInput("performance_glitch_user");
		singInPage.setPasswordInput("secret_sauce");
		singInPage.submitBtnClick();
		assertEquals("https://www.saucedemo.com/inventory.html", browser.getCurrentUrl());
		
		// bufix za https://stackoverflow.com/questions/62003082/elementnotinteractableexception-element-not-interactable-element-has-zero-size
		// specificno za linux i specificno za chrome 83+
		// problem resen prelaskom na firefox / gecko
		//itemsPage.linuxBufix();
		
		itemsPage.pressMenuButton();
		itemsPage.pressReset();
		browser.navigate().refresh();
		itemsPage.addSecondItem();
		itemsPage.pressShoppingCart();

		cartPage.pressCheckout();
		assertEquals("https://www.saucedemo.com/checkout-step-one.html", browser.getCurrentUrl());

		


		// emtpy fields
		checkoutPage.submitBtnClick();
		assertTrue(checkoutPage.errorMessagePresent("Error: First Name is required"));

		// last Name empty 
		checkoutPage.setFirstNameInput("aaa");
		checkoutPage.submitBtnClick();
		assertTrue(checkoutPage.errorMessagePresent("Error: Last Name is required"));

		// no postal code
		checkoutPage.setFirstNameInput("aaa");
		checkoutPage.setLastNameInput("aaa");
		checkoutPage.submitBtnClick();
		assertTrue(checkoutPage.errorMessagePresent("Error: Postal Code is required"));
		
		// invalid user
		checkoutPage.setFirstNameInput("aaa");
		checkoutPage.setLastNameInput("aaa");
		checkoutPage.setPostalInput("aaa");
		checkoutPage.submitBtnClick();
		assertEquals("https://www.saucedemo.com/checkout-step-two.html", browser.getCurrentUrl());

		checkoutPageTwo.pressCheckout();
		assertEquals("https://www.saucedemo.com/checkout-complete.html", browser.getCurrentUrl());

		checkoutPageThree.pressMenuButton();
		checkoutPageThree.pressLogout();
		assertEquals("https://www.saucedemo.com/", browser.getCurrentUrl());

	}

	@After
	public void closeSelenium() {
		// Shutdown the browser
		browser.quit();
	}
}
