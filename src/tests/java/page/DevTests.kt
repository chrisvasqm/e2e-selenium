package page

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.testng.Assert.assertTrue
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

class DevTests {
    private lateinit var driver: WebDriver
    private lateinit var homePage: DevHomePage
    private lateinit var aboutPage: DevAboutPage

    @BeforeMethod
    fun setUp() {
        driver = ChromeDriver()
        homePage = DevHomePage(driver)
        aboutPage = DevAboutPage(driver)

        homePage.open()
    }

    @Test
    fun goToAboutPage_ClickAboutLinkFromHomePage_RedirectsUserToAboutPage() {
        homePage.goToAboutPage()
        assertTrue(aboutPage.isAtAboutPage)
    }

    @Test
    fun searchFor_QueryingForTest_ReturnsAllPostsRelatedToTest() {
        homePage.searchFor("test")
        assertTrue(homePage.hasArticles)
    }

    @AfterMethod
    fun tearDown() {
        driver.quit()
    }
}
