package tests;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class TestOne extends BaseTest {
    private String searchString = "Albert Einstein";

    @Test
    public void TestOneTest()
    {
        homePage.getSearchBar().click();
        homePage.getSearchBar().sendKeys(searchString);
        homePage.getSearchButton().click();

        Assert.assertEquals(searchString,resultsPage.getFirstHeader().getText());
    }
}
