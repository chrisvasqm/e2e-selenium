import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import project.page.DevAboutPage;
import project.page.DevHomePage;

import static org.testng.Assert.assertTrue;

public class AboutPageTests {
    private WebDriver driver;

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
    public void aboutPage_hasCorrectTitle() {
        DevHomePage homePage = new DevHomePage(driver);
        homePage.goToAboutPage();

        DevAboutPage aboutPage = new DevAboutPage(driver);
        assertTrue(aboutPage.getMainTitle().contains("About dev.to("));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
