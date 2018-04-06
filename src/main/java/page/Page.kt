package page

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory

open class Page(driver: WebDriver) {
    init {
        PageFactory.initElements(AjaxElementLocatorFactory(driver, 15), this)
    }
}
