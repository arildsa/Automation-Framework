package base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.ResultsPage;
import util.CustomCommands;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseTest extends CustomCommands{

    private RemoteWebDriver driver;
    protected HomePage homePage;
    protected ResultsPage resultsPage;
    private static final Logger log = LogManager.getLogger("Log");


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

    @BeforeMethod
    public void beforeEach()
    {
        log.info("Starting a new test");
    }

    @AfterClass
    public void afterEach()
    {
        driver.quit();
    }

}
