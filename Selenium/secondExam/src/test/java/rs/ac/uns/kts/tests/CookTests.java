package rs.ac.uns.kts.tests;

import static org.junit.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import com.paulhammant.ngwebdriver.NgWebDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rs.ac.uns.kts.ChangePasswordPage;
import rs.ac.uns.kts.SingInPage;
import rs.ac.uns.kts.Cook.OrdersPage;
import rs.ac.uns.kts.pages.AdminTestPages.Utilities;

public class CookTests {
    private ChromeDriver browser;
    private SingInPage singInPage;
    private ChangePasswordPage changePasswordPage;
    private OrdersPage ordersPage;
    private NgWebDriver angularWebDriver;
    private MyOrdersPage myOrdersPage;
    @Before
    public void setupSelenium() {
        // instantiate browser
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        browser = new ChromeDriver();
        angularWebDriver = new NgWebDriver(browser);
        // maximize window
        browser.manage().window().maximize();
        // navigate
        browser.navigate().to("http://localhost:4200/login");

        singInPage = PageFactory.initElements(browser, SingInPage.class);
        changePasswordPage = PageFactory.initElements(browser, ChangePasswordPage.class);
        ordersPage = PageFactory.initElements(browser, OrdersPage.class);

        myOrdersPage = PageFactory.initElements(browser, MyOrdersPage.class);


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
        WebDriverWait wait = new WebDriverWait(browser, 100);
        wait.until(ExpectedConditions.alertIsPresent());
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
        browser.navigate().refresh();
        Utilities.urlWait(browser, "http://localhost:4200/order-table-cooks", 100);

        int numOfOrdersAfter = ordersPage.getNumberOfOrders();
        assertTrue(numOfOrdersAfter == numOfOrdersBefore - 1);

    }

    @Test
    public void finishOrder(){
        myOrdersPage.ordersLinkClick();
        Utilities.urlWait(browser, "http://localhost:4200/taken-orders-table-cooks", 100);
        assertEquals("http://localhost:4200/taken-orders-table-cooks", browser.getCurrentUrl());

        int numOfOrdersBefore = myOrdersPage.getNumberOfOrders();
        myOrdersPage.takeOrderBtnClick();
        browser.navigate().refresh();
        Utilities.urlWait(browser, "http://localhost:4200/taken-orders-table-cooks", 100);

        int numOfOrdersAfter = myOrdersPage.getNumberOfOrders();
        assertTrue(numOfOrdersAfter == numOfOrdersBefore - 1);

    }

    @After
    public void closeSelenium() {
        // Shutdown the browser
        browser.quit();
    }

}
