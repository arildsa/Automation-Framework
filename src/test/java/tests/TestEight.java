package tests;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class TestEight extends BaseTest {
    private String searchString = "Denver";

    @Test
    public void TestEightTest()
    {
        homePage.searchFor(searchString);

        Assert.assertEquals(searchString,resultsPage.getFirstHeaderText());
    }
}
