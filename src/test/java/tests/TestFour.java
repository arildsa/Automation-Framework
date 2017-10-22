package tests;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class TestFour extends BaseTest {
    private String searchString = "Thomas Jefferson";

    @Test
    public void TestFourTest()
    {
        homePage.getSearchBar().click();
        homePage.getSearchBar().sendKeys(searchString);
        homePage.getSearchButton().click();

        Assert.assertEquals(searchString,resultsPage.getFirstHeader().getText());
    }
}
