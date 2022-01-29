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
import rs.ac.uns.kts.EditSalary;
import rs.ac.uns.kts.SingInPage;
import rs.ac.uns.kts.pages.AdminTestPages.AddNewUserPage;
import rs.ac.uns.kts.pages.AdminTestPages.UserTablesPage;
import rs.ac.uns.kts.pages.AdminTestPages.Utilities;


public class AdminTest {

    private ChromeDriver browser;
    private SingInPage singInPage;
    private ChangePasswordPage changePasswordPage;
    private UserTablesPage userTablePage;
    private AddNewUserPage addNewUserPage;
    private EditSalary editSalary;
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
        changePasswordPage = PageFactory.initElements(browser, ChangePasswordPage.class);
        userTablePage = PageFactory.initElements(browser, UserTablesPage.class);
        addNewUserPage = PageFactory.initElements(browser, AddNewUserPage.class);
        editSalary = PageFactory.initElements(browser,EditSalary.class);


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
        changePasswordPage.singInLinkClick();
        Utilities.urlWait(browser, "http://localhost:4200/change-password", 100);
        assertEquals("http://localhost:4200/change-password", browser.getCurrentUrl());

        changePasswordPage.setOldPasswordInput("admin");
        changePasswordPage.setNewPasswordInput("admin");
        changePasswordPage.changePasswordBtn();
        WebDriverWait wait = new WebDriverWait(browser, 100);
        wait.until(ExpectedConditions.alertIsPresent());

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


    @Test
    public void addAdminTests(){
        userTablePage.usersLinkClick();
        userTablePage.adminLinkClick();
        Utilities.urlWait(browser, "http://localhost:4200/admin-table", 100);
        assertEquals("http://localhost:4200/admin-table", browser.getCurrentUrl());

        int numOfUsersBefore = userTablePage.getNumberOfUsers();
        userTablePage.addAdminBtnClick();
        Utilities.urlWait(browser, "http://localhost:4200/add-admin", 100);
        assertEquals("http://localhost:4200/add-admin", browser.getCurrentUrl());

        addNewUserPage.setFirstNameInput("Sima");
        addNewUserPage.setLastNameInput("Sima");
        addNewUserPage.setUsernameInput("Sima");
        addNewUserPage.setPasswordInput("Sima");
        addNewUserPage.setDateInput("10022000");
        addNewUserPage.setSalaryInput("10000");
        addNewUserPage.submitBtnClick();

        Utilities.urlWait(browser, "http://localhost:4200/add-admin", 100);
        assertEquals("http://localhost:4200/add-admin", browser.getCurrentUrl());

        int numOfCategoriesAfter = userTablePage.getNumberOfUsers();

        assertTrue(numOfCategoriesAfter == numOfUsersBefore + 1);

    }

    @Test
    public void addManagerTests(){
        userTablePage.usersLinkClick();
        userTablePage.managerLinkClick();
        Utilities.urlWait(browser, "http://localhost:4200/manager-table", 100);
        assertEquals("http://localhost:4200/manager-table", browser.getCurrentUrl());

        int numOfUsersBefore = userTablePage.getNumberOfUsers();
        userTablePage.addManagerBtnClick();
        Utilities.urlWait(browser, "http://localhost:4200/add-manager", 100);
        assertEquals("http://localhost:4200/add-manager", browser.getCurrentUrl());

        addNewUserPage.setFirstNameInput("Sima");
        addNewUserPage.setLastNameInput("Sima");
        addNewUserPage.setUsernameInput("Djole");
        addNewUserPage.setPasswordInput("Djole");
        addNewUserPage.setDateInput("10022000");
        addNewUserPage.setSalaryInput("10000");
        addNewUserPage.submitBtnClick();

        Utilities.urlWait(browser, "http://localhost:4200/add-manager", 100);
        assertEquals("http://localhost:4200/add-manager", browser.getCurrentUrl());

        int numOfCategoriesAfter = userTablePage.getNumberOfUsers();

        assertTrue(numOfCategoriesAfter == numOfUsersBefore + 1);
    }

    @Test
    public void addCookTests(){
        userTablePage.usersLinkClick();
        userTablePage.cookLinkClick();
        Utilities.urlWait(browser, "http://localhost:4200/cook-table", 100);
        assertEquals("http://localhost:4200/cook-table", browser.getCurrentUrl());

        int numOfUsersBefore = userTablePage.getNumberOfUsers();
        userTablePage.addCookBtnClick();
        Utilities.urlWait(browser, "http://localhost:4200/add-cook", 100);
        assertEquals("http://localhost:4200/add-cook", browser.getCurrentUrl());

        addNewUserPage.setFirstNameInput("Sima");
        addNewUserPage.setLastNameInput("Sima");
        addNewUserPage.setUsernameInput("Uros");
        addNewUserPage.setPasswordInput("Uros");
        addNewUserPage.setDateInput("10022000");
        addNewUserPage.setSalaryInput("10000");
        addNewUserPage.submitBtnClick();

        Utilities.urlWait(browser, "http://localhost:4200/add-cook", 100);
        assertEquals("http://localhost:4200/add-cook", browser.getCurrentUrl());

        int numOfCategoriesAfter = userTablePage.getNumberOfUsers();

        assertTrue(numOfCategoriesAfter == numOfUsersBefore + 1);
    }

    @Test
    public void addWaiterTests(){
        userTablePage.usersLinkClick();
        userTablePage.waiterLinkClick();
        Utilities.urlWait(browser, "http://localhost:4200/waiter-table", 100);
        assertEquals("http://localhost:4200/waiter-table", browser.getCurrentUrl());

        int numOfUsersBefore = userTablePage.getNumberOfUsers();
        userTablePage.addWaiterBtnClick();
        Utilities.urlWait(browser, "http://localhost:4200/add-waiter", 100);
        assertEquals("http://localhost:4200/add-waiter", browser.getCurrentUrl());

        addNewUserPage.setFirstNameInput("Sima");
        addNewUserPage.setLastNameInput("Sima");
        addNewUserPage.setUsernameInput("Dragan");
        addNewUserPage.setPasswordInput("Dragan");
        addNewUserPage.setDateInput("10022000");
        addNewUserPage.setSalaryInput("10000");
        addNewUserPage.submitBtnClick();

        Utilities.urlWait(browser, "http://localhost:4200/add-waiter", 100);
        assertEquals("http://localhost:4200/add-waiter", browser.getCurrentUrl());

        int numOfCategoriesAfter = userTablePage.getNumberOfUsers();

        assertTrue(numOfCategoriesAfter == numOfUsersBefore + 1);
    }

    @Test
    public void addMainCookTests(){
        userTablePage.usersLinkClick();
        userTablePage.mainCookLinkClick();
        Utilities.urlWait(browser, "http://localhost:4200/main-cook-table", 100);
        assertEquals("http://localhost:4200/main-cook-table", browser.getCurrentUrl());

        int numOfUsersBefore = userTablePage.getNumberOfUsers();
        userTablePage.addMainCookBtnClick();
        Utilities.urlWait(browser, "http://localhost:4200/add-main-cook", 100);
        assertEquals("http://localhost:4200/add-main-cook", browser.getCurrentUrl());

        addNewUserPage.setFirstNameInput("Sima");
        addNewUserPage.setLastNameInput("Sima");
        addNewUserPage.setUsernameInput("Glavni");
        addNewUserPage.setPasswordInput("Glavni");
        addNewUserPage.setDateInput("10022000");
        addNewUserPage.setSalaryInput("10000");
        addNewUserPage.submitBtnClick();

        Utilities.urlWait(browser, "http://localhost:4200/add-main-cook", 100);
        assertEquals("http://localhost:4200/add-main-cook", browser.getCurrentUrl());

        int numOfCategoriesAfter = userTablePage.getNumberOfUsers();

        assertTrue(numOfCategoriesAfter == numOfUsersBefore + 1);
    }

    @Test
    public void addBarmanTests(){
        userTablePage.usersLinkClick();
        userTablePage.barmanLinkClick();
        Utilities.urlWait(browser, "http://localhost:4200/barman-table", 100);
        assertEquals("http://localhost:4200/barman-table", browser.getCurrentUrl());

        int numOfUsersBefore = userTablePage.getNumberOfUsers();
        userTablePage.addBarmanBtnClick();
        Utilities.urlWait(browser, "http://localhost:4200/add-barman", 100);
        assertEquals("http://localhost:4200/add-barman", browser.getCurrentUrl());

        addNewUserPage.setFirstNameInput("Sima");
        addNewUserPage.setLastNameInput("Sima");
        addNewUserPage.setUsernameInput("barmen");
        addNewUserPage.setPasswordInput("barmen");
        addNewUserPage.setDateInput("10022000");
        addNewUserPage.setSalaryInput("10000");
        addNewUserPage.submitBtnClick();

        Utilities.urlWait(browser, "http://localhost:4200/add-barman", 100);
        assertEquals("http://localhost:4200/add-barman", browser.getCurrentUrl());

        int numOfCategoriesAfter = userTablePage.getNumberOfUsers();

        assertTrue(numOfCategoriesAfter == numOfUsersBefore + 1);
    }

    @Test
    public void editManagerSalaryTest(){
        userTablePage.usersLinkClick();
        userTablePage.managerLinkClick();
        Utilities.urlWait(browser, "http://localhost:4200/manager-table", 100);
        assertEquals("http://localhost:4200/manager-table", browser.getCurrentUrl());


        userTablePage.editManagerSalaryBtnClick();

        editSalary.setSalaryInput("10000");
        editSalary.submitBtnClick();

    }

    @Test
    public void deleteAdminTest(){
        userTablePage.usersLinkClick();
        userTablePage.adminLinkClick();
        Utilities.urlWait(browser, "http://localhost:4200/admin-table", 100);
        assertEquals("http://localhost:4200/admin-table", browser.getCurrentUrl());

        int numOfUsersBefore = userTablePage.getNumberOfUsers();
        userTablePage.deleteAdminBtnClick();
        Utilities.urlWait(browser, "http://localhost:4200/admin-table", 100);
        assertEquals("http://localhost:4200/admin-table", browser.getCurrentUrl());
        int numOfCategoriesAfter = userTablePage.getNumberOfUsers();

        assertTrue(numOfCategoriesAfter == numOfUsersBefore - 1);

    }

    @Test
    public void deleteManagerTest(){
        userTablePage.usersLinkClick();
        userTablePage.managerLinkClick();
        Utilities.urlWait(browser, "http://localhost:4200/manager-table", 100);
        assertEquals("http://localhost:4200/manager-table", browser.getCurrentUrl());

        int numOfUsersBefore = userTablePage.getNumberOfUsers();
        userTablePage.deleteAdminBtnClick();
        Utilities.urlWait(browser, "http://localhost:4200/manager-table", 100);
        assertEquals("http://localhost:4200/manager-table", browser.getCurrentUrl());
        int numOfCategoriesAfter = userTablePage.getNumberOfUsers();

        assertTrue(numOfCategoriesAfter == numOfUsersBefore - 1);

    }

    @Test
    public void deleteCookTest(){
        userTablePage.usersLinkClick();
        userTablePage.cookLinkClick();
        Utilities.urlWait(browser, "http://localhost:4200/cook-table", 100);
        assertEquals("http://localhost:4200/cook-table", browser.getCurrentUrl());

        int numOfUsersBefore = userTablePage.getNumberOfUsers();
        userTablePage.deleteAdminBtnClick();
        Utilities.urlWait(browser, "http://localhost:4200/cook-table", 100);
        assertEquals("http://localhost:4200/cook-table", browser.getCurrentUrl());
        int numOfCategoriesAfter = userTablePage.getNumberOfUsers();

        assertTrue(numOfCategoriesAfter == numOfUsersBefore - 1);

    }

    @Test
    public void deleteMainCookTest(){
        userTablePage.usersLinkClick();
        userTablePage.mainCookLinkClick();
        Utilities.urlWait(browser, "http://localhost:4200/main-cook-table", 100);
        assertEquals("http://localhost:4200/main-cook-table", browser.getCurrentUrl());

        int numOfUsersBefore = userTablePage.getNumberOfUsers();
        userTablePage.deleteAdminBtnClick();
        Utilities.urlWait(browser, "http://localhost:4200/main-cook-table", 100);
        assertEquals("http://localhost:4200/main-cook-table", browser.getCurrentUrl());
        int numOfCategoriesAfter = userTablePage.getNumberOfUsers();

        assertTrue(numOfCategoriesAfter == numOfUsersBefore - 1);

    }

    @Test
    public void deleteWaiterTest(){
        userTablePage.usersLinkClick();
        userTablePage.waiterLinkClick();
        Utilities.urlWait(browser, "http://localhost:4200/waiter-table", 100);
        assertEquals("http://localhost:4200/waiter-table", browser.getCurrentUrl());

        int numOfUsersBefore = userTablePage.getNumberOfUsers();
        userTablePage.deleteAdminBtnClick();
        Utilities.urlWait(browser, "http://localhost:4200/waiter-table", 100);
        assertEquals("http://localhost:4200/waiter-table", browser.getCurrentUrl());
        int numOfCategoriesAfter = userTablePage.getNumberOfUsers();

        assertTrue(numOfCategoriesAfter == numOfUsersBefore - 1);

    }

    @Test
    public void deleteBarmanTest(){
        userTablePage.usersLinkClick();
        userTablePage.barmanLinkClick();
        Utilities.urlWait(browser, "http://localhost:4200/barman-table", 100);
        assertEquals("http://localhost:4200/barman-table", browser.getCurrentUrl());

        int numOfUsersBefore = userTablePage.getNumberOfUsers();
        userTablePage.deleteAdminBtnClick();
        Utilities.urlWait(browser, "http://localhost:4200/barman-table", 100);
        assertEquals("http://localhost:4200/barman-table", browser.getCurrentUrl());
        int numOfCategoriesAfter = userTablePage.getNumberOfUsers();

        assertTrue(numOfCategoriesAfter == numOfUsersBefore - 1);

    }

    @After
    public void closeSelenium() {
        // Shutdown the browser
        browser.quit();
    }
}
