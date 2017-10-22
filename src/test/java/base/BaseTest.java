package base;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.HomePage;
import pages.ResultsPage;
import rules.Retry;
import util.CustomCommands;
import rules.ScreenShotOnFailure;

public class BaseTest extends CustomCommands{

    private static RemoteWebDriver driver;
    protected HomePage homePage;
    protected ResultsPage resultsPage;



    @BeforeClass
    public static void beforeClass()
    {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(CapabilityType.BROWSER_NAME,"Chrome");
        System.setProperty("webdriver.chrome.driver","lib/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Before
    public void before()
    {
        driver.navigate().to("https://www.wikipedia.org/");
        homePage = new HomePage(driver);
        resultsPage = new ResultsPage(driver);
    }

    @AfterClass
    public static void tearDown()
    {
        driver.quit();
    }

    @Rule
    public ScreenShotOnFailure failure = new ScreenShotOnFailure(driver);

    @Rule
    public Retry retry = new Retry(3);


}
