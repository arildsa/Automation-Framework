package tests;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class TestThree extends BaseTest {
    private String searchString = "George Washington";

    @Test
    public void TestThreeTest()
    {
        homePage.getSearchBar().click();
        homePage.getSearchBar().sendKeys(searchString);
        homePage.getSearchButton().click();

        Assert.assertEquals(searchString,resultsPage.getFirstHeader().getText());
    }
}
