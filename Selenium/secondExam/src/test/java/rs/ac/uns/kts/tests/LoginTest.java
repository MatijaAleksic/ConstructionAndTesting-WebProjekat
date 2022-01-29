package rs.ac.uns.kts.tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import rs.ac.uns.kts.SingInPage;
import rs.ac.uns.kts.pages.AdminTestPages.Utilities;


public class LoginTest {

	private WebDriver browser;

	private SingInPage singInPage;

	@Before
	public void setupSelenium() {
		// instantiate browser
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		browser = new ChromeDriver();
		// maximize window
		browser.manage().window().maximize();
		// navigate
		browser.navigate().to("http://localhost:4200/login");

		singInPage = PageFactory.initElements(browser, SingInPage.class);
	}

	@Test
	public void singInTest() {

		// all fields empty
		//singInPage.submitBtnClick();
		//assertTrue(singInPage.errorMessagePresent("Epic sadface: Username is required"));

		// password empty 
		//singInPage.setEmailInput("aaa");
		//singInPage.submitBtnClick();
		//assertTrue(singInPage.errorMessagePresent("Epic sadface: Password is required"));

		// invalid user
		//singInPage.setEmailInput("aaaaa");
		//singInPage.setPasswordInput("wrong");
		//singInPage.submitBtnClick();
		//assertTrue(singInPage.errorMessagePresent("Epic sadface: Username and password do not match any user in this service"));

		// valid user
		singInPage.setEmailInput("admin@gmail.com");
		singInPage.setPasswordInput("admin");
		singInPage.submitBtnClick();
		Utilities.urlWait(browser, "http://localhost:4200/profile", 100);
		assertEquals("http://localhost:4200/profile", browser.getCurrentUrl());
		
		// bufix za https://stackoverflow.com/questions/62003082/elementnotinteractableexception-element-not-interactable-element-has-zero-size
		// specificno za linux i specificno za chrome 83+
		// problem resen prelaskom na firefox / gecko
		//itemsPage.linuxBufix();
		
		//itemsPage.pressMenuButton();
		//itemsPage.pressReset();
		//browser.navigate().refresh();
		//itemsPage.addSecondItem();
		//itemsPage.pressShoppingCart();

		//cartPage.pressCheckout();
		//assertEquals("https://www.saucedemo.com/checkout-step-one.html", browser.getCurrentUrl());

		


//		// emtpy fields
//		checkoutPage.submitBtnClick();
//		assertTrue(checkoutPage.errorMessagePresent("Error: First Name is required"));
//
//		// last Name empty
//		checkoutPage.setFirstNameInput("aaa");
//		checkoutPage.submitBtnClick();
//		assertTrue(checkoutPage.errorMessagePresent("Error: Last Name is required"));
//
//		// no postal code
//		checkoutPage.setFirstNameInput("aaa");
//		checkoutPage.setLastNameInput("aaa");
//		checkoutPage.submitBtnClick();
//		assertTrue(checkoutPage.errorMessagePresent("Error: Postal Code is required"));
//
//		// invalid user
//		checkoutPage.setFirstNameInput("aaa");
//		checkoutPage.setLastNameInput("aaa");
//		checkoutPage.setPostalInput("aaa");
//		checkoutPage.submitBtnClick();
//		assertEquals("https://www.saucedemo.com/checkout-step-two.html", browser.getCurrentUrl());
//
//		checkoutPageTwo.pressCheckout();
//		assertEquals("https://www.saucedemo.com/checkout-complete.html", browser.getCurrentUrl());
//
//		checkoutPageThree.pressMenuButton();
//		checkoutPageThree.pressLogout();
//		assertEquals("https://www.saucedemo.com/", browser.getCurrentUrl());

	}

	@After
	public void closeSelenium() {
		// Shutdown the browser
		browser.quit();
	}
}
