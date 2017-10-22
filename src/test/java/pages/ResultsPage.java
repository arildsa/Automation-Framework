package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.CustomCommands;

public class ResultsPage extends CustomCommands {

    public ResultsPage(RemoteWebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "firstHeading")
    private WebElement firstHeader = null;

    private WebElement getFirstHeader() {
        return firstHeader;
    }

    public String getFirstHeaderText()
    {
        return getFirstHeader().getText();
    }


}
