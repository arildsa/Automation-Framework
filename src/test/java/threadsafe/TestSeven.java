package threadsafe;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSeven extends BaseTest {
    private String searchString = "Lionel Messi";

    @Test
    public void TestSevenTest()
    {
        homePage.getSearchBar().click();
        homePage.getSearchBar().sendKeys(searchString);
        homePage.getSearchButton().click();

        Assert.assertEquals(searchString,resultsPage.getFirstHeader().getText());
    }
}
