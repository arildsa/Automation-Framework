package tests;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;


public class TestFive extends BaseTest {
    private String searchString = "Tom Cruise";

    @Test
    public void TestFiveTest()
    {
        homePage.getSearchBar().click();
        homePage.getSearchBar().sendKeys(searchString);
        homePage.getSearchButton().click();

        Assert.assertEquals(searchString,resultsPage.getFirstHeader().getText());
    }
}
