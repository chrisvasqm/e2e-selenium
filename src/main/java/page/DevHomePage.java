package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DevHomePage extends Page {
    private final WebDriver driver;

    @FindBy(xpath = "(//a[text() = 'About'])[1]")
    private WebElement linkAbout;

    @FindBy(id = "nav-search")
    private WebElement searchBox;

    @FindBy(className = "crayons-story")
    private List<WebElement> articles;

    private WebDriverWait wait;

    DevHomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
    }

    public void open() {
        driver.get("https://dev.to/");
    }

    public void goToAboutPage() {
        linkAbout.click();
    }

    public void searchFor(String query) {
        searchBox.sendKeys(query, Keys.ENTER);
        wait.until(ExpectedConditions.urlContains("search"));
    }

    public boolean hasArticles() {
        return !articles.isEmpty();
    }
}
