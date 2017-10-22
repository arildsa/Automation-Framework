package tests;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class TestFour extends BaseTest {
    private String searchString = "Thomas Jefferson";

    @Test
    public void TestFourTest()
    {
        homePage.searchFor(searchString);

        Assert.assertEquals(searchString,resultsPage.getFirstHeaderText());
    }
}
