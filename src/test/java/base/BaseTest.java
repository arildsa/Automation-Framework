package base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;
import pages.ResultsPage;
import util.CustomCommands;

public class BaseTest extends CustomCommands{

    private RemoteWebDriver driver;
    protected HomePage homePage;
    protected ResultsPage resultsPage;

    @BeforeClass
    public void before()
    {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(CapabilityType.BROWSER_NAME,"Chrome");
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://www.wikipedia.org/");
        homePage = new HomePage(driver);
        resultsPage = new ResultsPage(driver);
    }

    @AfterClass
    public void afterEach()
    {
        driver.quit();
    }

}
