package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DevHomePage extends Page {
    private final WebDriver driver;

    @FindBy(xpath = "(//a[text() = 'About'])[1]")
    private WebElement linkAbout;

    @FindBy(id = "nav-search")
    private WebElement searchBox;

    @FindBy(className = "single-article")
    private List<WebElement> articles;

    DevHomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void open() {
        driver.get("https://dev.to/");
    }

    public void goToAboutPage() {
        linkAbout.click();
    }

    public void searchFor(String query) {
        searchBox.sendKeys(query, Keys.ENTER);
    }

    public boolean hasArticles() {
        return articles.size() > 0;
    }
}
