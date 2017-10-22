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

    private WebElement getSearchBar() {
        return searchBar;
    }

    private WebElement getSearchButton()
    {
        return btnSearch;
    }

    public void searchFor(String searchString)
    {
        getSearchBar().click();
        getSearchBar().sendKeys(searchString);
        getSearchButton().click();
    }
}
