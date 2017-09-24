package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.CustomCommands;

public class HomePage extends CustomCommands {

    public HomePage(RemoteWebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "searchInput")
    private WebElement searchBar = null;

    @FindBy(css = "button[type=\"submit\"]")
    private WebElement btnSearch = null;

    public WebElement getSearchBar() {
        return searchBar;
    }

    public WebElement getSearchButton()
    {
        return btnSearch;
    }
}
