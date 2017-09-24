package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

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
