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
import rules.RetryOnFailure;
import util.CustomCommands;
import rules.ScreenShotOnFailure;

public class BaseTest extends CustomCommands{

    private static RemoteWebDriver driver;
    protected HomePage homePage;
    protected ResultsPage resultsPage;
    private String baseUrl = "https://www.wikipedia.org/";
    
    @BeforeClass
    public static void beforeClass()
    {
        if (System.getProperty("os.name").contains("Mac")){
            System.setProperty("webdriver.chrome.driver", "lib/chromedriverMac.exe");
        } else if (System.getProperty("os.name").contains("Linux")) {
            System.setProperty("webdriver.chrome.driver", "lib/chromedriverLinux.exe");
        } else if(System.getProperty("os.name").contains("Windows")) {
            System.setProperty("webdriver.chrome.driver","lib/chromedriver.exe");
        }

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(CapabilityType.BROWSER_NAME,"Chrome");

        driver = new ChromeDriver();
    }

    @Before
    public void before()
    {
        driver.navigate().to(baseUrl);
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
    public RetryOnFailure retryOnFailure = new RetryOnFailure(3);


}
