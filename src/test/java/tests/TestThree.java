package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

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
