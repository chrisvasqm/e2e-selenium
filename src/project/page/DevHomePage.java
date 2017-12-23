package project.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class DevHomePage {

    @FindBy(xpath = "//*[@id=\"sidebar-wrapper-left\"]/div[2]/div[2]/div[2]/a[1]")
    private WebElement linkAbout;

    public DevHomePage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
    }

    public void goToAboutPage() {
        linkAbout.click();
    }

}
