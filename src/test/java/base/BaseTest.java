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
import rules.ScreenShotOnFailure;
import util.CustomCommands;

import java.io.File;

public class BaseTest extends CustomCommands{

    private static RemoteWebDriver driver;
    protected HomePage homePage;
    protected ResultsPage resultsPage;
    private String baseUrl = "https://www.wikipedia.org/";
    
    @BeforeClass
    public static void beforeClass()
    {
        File file = null;
        if (System.getProperty("os.name").contains("Mac")){
            System.setProperty("webdriver.chrome.driver", "lib/chromedriverMac.exe");
            file = new File("lib/chromedriverMac.exe");
        } else if (System.getProperty("os.name").contains("Linux")) {
            System.setProperty("webdriver.chrome.driver", "lib/chromedriverLinux.exe");
            file = new File("lib/chromedriverLinux.exe");
        } else if(System.getProperty("os.name").contains("Windows")) {
            System.setProperty("webdriver.chrome.driver","lib/chromedriver.exe");
            file = new File("lib/chromedriver.exe");
        }

        file.setExecutable(true);
        file.setReadable(true);
        file.setWritable(true);

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
    public RetryOnFailure retryOnFailure = new RetryOnFailure(3);

    @Rule
    public ScreenShotOnFailure failure = new ScreenShotOnFailure(driver);


}
