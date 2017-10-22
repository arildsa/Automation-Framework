package tests;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class TestSix extends BaseTest {
    private String searchString = "Tom Hanks";

    @Test
    public void TestSixTest()
    {
        homePage.getSearchBar().click();
        homePage.getSearchBar().sendKeys(searchString);
        homePage.getSearchButton().click();

        Assert.assertEquals(searchString,resultsPage.getFirstHeader().getText());
    }
}
