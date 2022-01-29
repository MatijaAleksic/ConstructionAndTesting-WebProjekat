package rs.ac.uns.kts.tests;

import static org.junit.Assert.assertEquals;

import com.paulhammant.ngwebdriver.NgWebDriver;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import rs.ac.uns.kts.ChangePasswordPage;
import rs.ac.uns.kts.EditSalary;
import rs.ac.uns.kts.SingInPage;
import rs.ac.uns.kts.ManagerTestPages.ChangeItemPrice;
import rs.ac.uns.kts.ManagerTestPages.ItemsTable;
import rs.ac.uns.kts.ManagerTestPages.StaffTables;
import rs.ac.uns.kts.ManagerTestPages.TablesManagerPage;
import rs.ac.uns.kts.pages.AdminTestPages.Utilities;

public class ManagerTest {

    private ChromeDriver browser;
    private SingInPage singInPage;
    private ChangePasswordPage changePasswordPage;
    private StaffTables staffTables;
    private EditSalary editSalary;
    private ItemsTable itemsTable;
    private ChangeItemPrice changeItemPrice;
    private TablesManagerPage tablesManagerPage;
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
        staffTables = PageFactory.initElements(browser,StaffTables.class);
        editSalary = PageFactory.initElements(browser,EditSalary.class);
        itemsTable = PageFactory.initElements(browser,ItemsTable.class);
        changeItemPrice = PageFactory.initElements(browser,ChangeItemPrice.class);
        tablesManagerPage = PageFactory.initElements(browser,TablesManagerPage.class);

        //valid user
        singInPage.setEmailInput("manager@gmail.com");
        singInPage.setPasswordInput("manager");
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

        changePasswordPage.setOldPasswordInput("manager");
        changePasswordPage.setNewPasswordInput("manager");
        changePasswordPage.changePasswordBtn();
        Thread.sleep(1000);
        browser.switchTo().alert().accept();
        Utilities.urlWait(browser, "http://localhost:4200/profile", 100);
        assertEquals("http://localhost:4200/profile", browser.getCurrentUrl());
    }

    @Test
    public void editManagerSalaryTest(){
        staffTables.staffLinkClick();
        Utilities.urlWait(browser, "http://localhost:4200/staff-table", 100);
        assertEquals("http://localhost:4200/staff-table", browser.getCurrentUrl());

        staffTables.editSalaryBtnClick();
        Utilities.urlWait(browser, "http://localhost:4200/edit-salary-user;id=4", 100);
        assertEquals("http://localhost:4200/edit-salary-user;id=4", browser.getCurrentUrl());

        editSalary.setSalaryInput("10000");
        editSalary.submitBtnClick();
    }

    @Test
    public void editItemPriceTest(){
        itemsTable.itemsLinkClick();
        Utilities.urlWait(browser, "http://localhost:4200/items-table", 100);
        assertEquals("http://localhost:4200/items-table", browser.getCurrentUrl());

        itemsTable.editPriceBtnClick();
        Utilities.urlWait(browser, "http://localhost:4200/edit-item-price;id=1", 100);
        assertEquals("http://localhost:4200/edit-item-price;id=1", browser.getCurrentUrl());

        changeItemPrice.setPriceInput("2000");
        changeItemPrice.submitBtnClick();

    }

    @Test
    public void activateItemTest(){
        itemsTable.itemsLinkClick();
        Utilities.urlWait(browser, "http://localhost:4200/items-table", 100);
        assertEquals("http://localhost:4200/items-table", browser.getCurrentUrl());

        itemsTable.activateBtnClick();
    }

    @Test
    public void activateDeactivateItem(){
        itemsTable.setNewRecipesinkClick();
        Utilities.urlWait(browser, "http://localhost:4200/new-recipe-table", 100);
        assertEquals("http://localhost:4200/new-recipe-table", browser.getCurrentUrl());

        itemsTable.activateItemBtnClick();
        itemsTable.deactivateItemBtnClick();
    }

    @Test
    public void floorManagerTest() throws InterruptedException {
        Utilities.urlWait(browser, "http://localhost:4200/profile", 100);

        tablesManagerPage.tablesManagerLinkClick();
        Utilities.urlWait(browser, "http://localhost:4200/restourant-menu-manager", 100);
        assertEquals("http://localhost:4200/restourant-menu-manager", browser.getCurrentUrl());

        tablesManagerPage.choseFloorLinkClick();
        tablesManagerPage.addTableLinkClick();
        tablesManagerPage.choseTableLinkClick();
        tablesManagerPage.deleteTableLinkClick();
    }


}
