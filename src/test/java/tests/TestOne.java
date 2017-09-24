package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestOne extends BaseTest {
    private String searchString = "Albert Einstein";

    @Test
    public void testOne()
    {
        homePage.getSearchBar().click();
        homePage.getSearchBar().sendKeys(searchString);
        homePage.getSearchButton().click();

        Assert.assertEquals(searchString,resultsPage.getFirstHeader().getText());
    }
}
