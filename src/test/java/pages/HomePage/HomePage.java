package pages.HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.CustomCommands;

import java.util.List;

public class HomePage extends CustomCommands {

    public HomePage(RemoteWebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "searchInput")
    private WebElement searchBar = null;

    @FindBy(css = "button[type=\"submit\"]")
    private WebElement btnSearch = null;

    @FindBy(css = "img[class='central-featured-logo']")
    private WebElement imgCentralLogo = null;

    @FindBy(css = "span[class*='lang-list-button-text']")
    private WebElement btnLangList = null;

    @FindBy(css = "div[class='footer']")
    WebElement footer = null;

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

    public boolean isImgCentralLogoPresent()
    {
        return isElementPresent(imgCentralLogo);
    }

    public boolean isSearchBarPresent()
    {
        return isElementPresent(searchBar);
    }

    public boolean isSearchButtonPresent()
    {
        return isElementPresent(btnSearch);
    }

    public boolean isLanguageListPresent()
    {
        return isElementPresent(btnLangList);
    }

    public boolean isThisLinkInTheFooter(String link)
    {
        List<WebElement> elements = footer.findElements(By.cssSelector("a[class='other-project-link']"));
        for(WebElement element : elements)
        {
            if(element.getAttribute("href").contains(link))
            {
                return true;
            }
        }
        return false;
    }
}
