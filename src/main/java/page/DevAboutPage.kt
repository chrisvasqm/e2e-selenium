package page

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class DevAboutPage(driver: WebDriver) : Page(driver) {

    @FindBy(xpath = "//h1[contains(text(), 'About dev.to')]")
    private lateinit var mainHeader: WebElement

    val isAtAboutPage
        get() = mainHeader.text.contains("About dev.to(")
}
