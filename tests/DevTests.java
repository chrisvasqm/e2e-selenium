import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DevTests {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://dev.to/");
    }

    @Test
    public void goToAboutPage_checkUrl_AboutUrl() throws InterruptedException {
        WebElement aboutLink = driver.findElement(By.xpath("//*[@id=\"sidebar-wrapper-left\"]/div[2]/div[2]/div[2]/a[1]"));
        aboutLink.click();

        Thread.sleep(1000);
        String aboutPageTitle = driver.getCurrentUrl();
        Assert.assertEquals(aboutPageTitle, "https://dev.to/about");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}