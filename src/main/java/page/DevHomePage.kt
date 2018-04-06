package page

import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class DevHomePage(private val driver: WebDriver) : Page(driver) {

    @FindBy(xpath = "(//a[text() = 'About'])[1]")
    private lateinit var linkAbout: WebElement

    @FindBy(id = "nav-search")
    private lateinit var searchBox: WebElement

    @FindBy(className = "single-article")
    private lateinit var articles: List<WebElement>

    val hasArticles
        get() = articles.first().isDisplayed

    fun open() = driver.get("https://dev.to/")

    fun goToAboutPage() = linkAbout.click()

    fun searchFor(query: String) = searchBox.sendKeys(query, Keys.ENTER)

}
