package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class DevTests {
    private WebDriver driver;
    private DevHomePage homePage;
    private DevAboutPage aboutPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        homePage = new DevHomePage(driver);
        aboutPage = new DevAboutPage(driver);

        homePage.open();
    }

    @Test
    public void clickAboutLink_RedirectsToAboutPage() {
        homePage.goToAboutPage();
        assertTrue(aboutPage.isAtAboutPage());
    }

    @Test
    public void searchBar_GetResults() {
        homePage.searchFor("test");
        assertTrue(homePage.hasArticles());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}