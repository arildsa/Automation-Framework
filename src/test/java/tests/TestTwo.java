package tests;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class TestTwo extends BaseTest {
    private String searchString = "Isaac Newton";

    @Test
    public void TestTwoTest()
    {
        homePage.getSearchBar().click();
        homePage.getSearchBar().sendKeys(searchString);
        homePage.getSearchButton().click();

        Assert.assertEquals(searchString,resultsPage.getFirstHeader().getText());
    }
}
