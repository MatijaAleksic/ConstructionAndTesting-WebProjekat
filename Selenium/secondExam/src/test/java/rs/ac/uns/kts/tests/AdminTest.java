package rs.ac.uns.kts.tests;
import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import rs.ac.uns.kts.pages.ChangePasswordAdminPage;
import rs.ac.uns.kts.pages.SingInPage;

public class AdminTest {

    private WebDriver browser;
    private SingInPage singInPage;
    private ChangePasswordAdminPage changePasswordAdminPage;

    @Before
    public void setupSelenium() {
        // instantiate browser
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        browser = new ChromeDriver();
        // maximize window
        browser.manage().window().maximize();
        // navigate
        browser.navigate().to("http://localhost:4200/login");

        singInPage = PageFactory.initElements(browser, SingInPage.class);
    }

    @Test
    public void singInTest() throws InterruptedException {

        //valid user
        singInPage.setEmailInput("admin@gmail.com");
        singInPage.setPasswordInput("admin");
        singInPage.submitBtnClick();
        Thread.sleep(1000);
        assertEquals("http://localhost:4200/profile", browser.getCurrentUrl());

        System.out.println("nesta");
        changePasswordAdminPage.singInLinkClick();
        System.out.println("nesta");
        Thread.sleep(1000);
        assertEquals("http://localhost:4200/login", browser.getCurrentUrl());
    }

}
