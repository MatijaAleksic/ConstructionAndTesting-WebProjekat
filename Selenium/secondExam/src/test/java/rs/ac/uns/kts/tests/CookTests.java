package rs.ac.uns.kts.tests;

import com.paulhammant.ngwebdriver.NgWebDriver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import rs.ac.uns.kts.ChangePasswordPage;
import rs.ac.uns.kts.Cook.OrdersPage;
import rs.ac.uns.kts.SingInPage;
import rs.ac.uns.kts.pages.AdminTestPages.Utilities;


import static org.junit.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class CookTests {
    private ChromeDriver browser;
    private SingInPage singInPage;
    private ChangePasswordPage changePasswordPage;
    private OrdersPage ordersPage;
    private NgWebDriver angularWebDriver;

    @Before
    public void setupSelenium() {
        // instantiate browser
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        browser = new ChromeDriver();
        angularWebDriver = new NgWebDriver(browser);
        // maximize window
        browser.manage().window().maximize();
        // navigate
        browser.navigate().to("http://localhost:4200/login");

        singInPage = PageFactory.initElements(browser, SingInPage.class);
        changePasswordPage = PageFactory.initElements(browser, ChangePasswordPage.class);
        ordersPage = PageFactory.initElements(browser, OrdersPage.class);

        //valid user
        singInPage.setEmailInput("cook@gmail.com");
        singInPage.setPasswordInput("cook");
        singInPage.submitBtnClick();
    }

    @Test
    public void singInTest(){
        Utilities.urlWait(browser, "http://localhost:4200/profile", 100);
        assertEquals("http://localhost:4200/profile", browser.getCurrentUrl());

    }

    @Test
    public void changePasswordTest() throws InterruptedException {
        changePasswordPage.singInLinkClick();
        Utilities.urlWait(browser, "http://localhost:4200/change-password", 100);
        assertEquals("http://localhost:4200/change-password", browser.getCurrentUrl());

        changePasswordPage.setOldPasswordInput("cook");
        changePasswordPage.setNewPasswordInput("cook");
        changePasswordPage.changePasswordBtn();
        Thread.sleep(1000);
        browser.switchTo().alert().accept();
        Utilities.urlWait(browser, "http://localhost:4200/profile", 100);
        assertEquals("http://localhost:4200/profile", browser.getCurrentUrl());
    }

    @Test
    public void takeOrederTest(){
        ordersPage.ordersLinkClick();
        Utilities.urlWait(browser, "http://localhost:4200/order-table-cooks", 100);
        assertEquals("http://localhost:4200/order-table-cooks", browser.getCurrentUrl());

        int numOfOrdersBefore = ordersPage.getNumberOfOrders();
        ordersPage.takeOrderBtnClick();

        int numOfOrdersAfter = ordersPage.getNumberOfOrders();
        assertTrue(numOfOrdersAfter == numOfOrdersBefore - 1);

    }

}
