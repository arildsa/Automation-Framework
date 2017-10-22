package threadsafetests;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class TestEight extends BaseTest {
    private String searchString = "Bill Gates";

    @Test
    public void TestEightTest()
    {
        homePage.getSearchBar().click();
        homePage.getSearchBar().sendKeys(searchString);
        homePage.getSearchButton().click();

        Assert.assertEquals(searchString,resultsPage.getFirstHeader().getText());
    }
}
