package rs.ac.uns.kts.tests;
import static org.junit.Assert.assertEquals;

import com.paulhammant.ngwebdriver.NgWebDriver;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import rs.ac.uns.kts.pages.ChangePasswordAdminPage;
import rs.ac.uns.kts.pages.SingInPage;
import rs.ac.uns.kts.pages.Utilities;

public class AdminTest {

    private ChromeDriver browser;
    private SingInPage singInPage;
    private ChangePasswordAdminPage changePasswordAdminPage;
    private NgWebDriver angularWebDriver;

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
        changePasswordAdminPage = PageFactory.initElements(browser, ChangePasswordAdminPage.class);
    }

    @Test
    public void singInTest() throws InterruptedException {

        //valid user
        singInPage.setEmailInput("admin@gmail.com");
        singInPage.setPasswordInput("admin");
        singInPage.submitBtnClick();
        Utilities.urlWait(browser, "http://localhost:4200/profile", 100);
        assertEquals("http://localhost:4200/profile", browser.getCurrentUrl());



        changePasswordAdminPage.singInLinkClick();
        System.out.println("nesta");
        Utilities.urlWait(browser, "http://localhost:4200/change-password", 100);
        assertEquals("http://localhost:4200/change-password", browser.getCurrentUrl());
    }

}
