package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
        final String OPERATING_SYSTEM = System.getProperty("os.name");
        if (OPERATING_SYSTEM.contains("win"))
            driver = new ChromeDriver(new ChromeOptions().addArguments("--start-maximized"));
        else
            driver = new ChromeDriver(new ChromeOptions().addArguments("--kiosk"));

        driver.get("https://dev.to/");
    }

    @Test
    public void clickAboutLink_RedirectsToAboutPage() {
        homePage = new DevHomePage(driver);
        homePage.goToAboutPage();

        aboutPage = new DevAboutPage(driver);
        assertTrue(aboutPage.getMainTitle().contains("About dev.to("));
    }

    @Test
    public void searchBar_GetResults() {
        homePage = new DevHomePage(driver);
        homePage.searchFor("test");
        final boolean hasArticles = homePage.getArticles().size() > 0;
        assertTrue(hasArticles);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
