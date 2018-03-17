package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DevAboutPage extends Page {

    @FindBy(xpath = "//h1[contains(text(), 'About dev.to')]")
    private WebElement mainTitle;

    DevAboutPage(WebDriver driver) {
        super(driver);
    }

    public String getMainTitle() {
        return mainTitle.getText();
    }

}
