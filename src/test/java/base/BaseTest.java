package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.HomePage;
import pages.ResultsPage;
import util.CustomCommands;

public class BaseTest extends CustomCommands{

    private static RemoteWebDriver driver;
    protected HomePage homePage;
    protected ResultsPage resultsPage;
    private static final Logger log = LogManager.getLogger("Log");


    @Before
    public void before()
    {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(CapabilityType.BROWSER_NAME,"Chrome");
        System.setProperty("webdriver.chrome.driver","lib/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://www.wikipedia.org/");
        homePage = new HomePage(driver);
        resultsPage = new ResultsPage(driver);
    }

    @After
    public void afterEach()
    {
        driver.quit();
    }

}
