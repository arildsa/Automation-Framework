package tests;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class TestTen extends BaseTest {
    private String searchString = "Colorado";

    @Test
    public void TestTenTest()
    {
        homePage.searchFor(searchString);

        Assert.assertEquals(searchString,resultsPage.getFirstHeaderText());
    }
}
