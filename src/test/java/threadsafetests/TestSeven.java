package threadsafetests;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;

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
