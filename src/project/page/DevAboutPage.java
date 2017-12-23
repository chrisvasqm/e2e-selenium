package project.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class DevAboutPage {

    @FindBy(xpath = "//h1[contains(text(), 'About dev.to')]")
    private WebElement mainTitle;

    public DevAboutPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
    }

    public String getMainTitle() {
        return mainTitle.getText();
    }

}
