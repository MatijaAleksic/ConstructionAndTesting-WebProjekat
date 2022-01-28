package rs.ac.uns.kts.tests;
import static org.junit.Assert.assertEquals;

import com.paulhammant.ngwebdriver.NgWebDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import rs.ac.uns.kts.pages.*;

public class AdminTest {

    private ChromeDriver browser;
    private SingInPage singInPage;
    private ChangePasswordAdminPage changePasswordAdminPage;
    private UserTablesPage userTablePage;
    private AddNewUserPage addNewUserPage;
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
        changePasswordAdminPage = PageFactory.initElements(browser, ChangePasswordAdminPage.class);
        userTablePage = PageFactory.initElements(browser, UserTablesPage.class);
        addNewUserPage = PageFactory.initElements(browser, AddNewUserPage.class);


        //valid user
        singInPage.setEmailInput("admin@gmail.com");
        singInPage.setPasswordInput("admin");
        singInPage.submitBtnClick();
    }

    @Test
    public void singInTest(){
        Utilities.urlWait(browser, "http://localhost:4200/profile", 100);
        assertEquals("http://localhost:4200/profile", browser.getCurrentUrl());

    }

    @Test
    public void changePasswordTest() throws InterruptedException {
        changePasswordAdminPage.singInLinkClick();
        Utilities.urlWait(browser, "http://localhost:4200/change-password", 100);
        assertEquals("http://localhost:4200/change-password", browser.getCurrentUrl());

        changePasswordAdminPage.setOldPasswordInput("admin");
        changePasswordAdminPage.setNewPasswordInput("admin");
        changePasswordAdminPage.changePasswordBtn();
        Thread.sleep(1000);
        browser.switchTo().alert().accept();
        Utilities.urlWait(browser, "http://localhost:4200/profile", 100);
        assertEquals("http://localhost:4200/profile", browser.getCurrentUrl());
    }

    @Test
    public void logoutTest(){
        singInPage.logoutLinkClick();
        Utilities.urlWait(browser, "http://localhost:4200/login", 100);
        assertEquals("http://localhost:4200/login", browser.getCurrentUrl());
    }


    //Ovde treba ispraviti samo sta se prosledjuje za date, a sta za salary
    @Test
    public void addAdminTests(){
        userTablePage.usersLinkClick();
        userTablePage.adminLinkClick();
        Utilities.urlWait(browser, "http://localhost:4200/admin-table", 100);
        assertEquals("http://localhost:4200/admin-table", browser.getCurrentUrl());

        userTablePage.addAdminBtnClick();
        Utilities.urlWait(browser, "http://localhost:4200/add-admin", 100);
        assertEquals("http://localhost:4200/add-admin", browser.getCurrentUrl());

        addNewUserPage.setFirstNameInput("Sima");
        addNewUserPage.setLastNameInput("Sima");
        addNewUserPage.setUsernameInput("Sima");
        addNewUserPage.setPasswordInput("Sima");
        addNewUserPage.setDateInput("10/02/2000");
        addNewUserPage.setSalaryInput("10000");
        addNewUserPage.submitBtnClick();

        Utilities.urlWait(browser, "http://localhost:4200/add-admin", 100);
        assertEquals("http://localhost:4200/add-admin", browser.getCurrentUrl());

    }

    @Test
    public void deleteAdminTest(){
        userTablePage.usersLinkClick();
        userTablePage.adminLinkClick();
        Utilities.urlWait(browser, "http://localhost:4200/admin-table", 100);
        assertEquals("http://localhost:4200/admin-table", browser.getCurrentUrl());

        userTablePage.deleteAdminBtnClick();
        Utilities.urlWait(browser, "http://localhost:4200/admin-table", 100);
        assertEquals("http://localhost:4200/admin-table", browser.getCurrentUrl());

        //treba samo odraditi prebrojavanje da utvrdimo brisanje

    }


}
