package tests;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class TestNine extends BaseTest {
    private String searchString = "Tom Petty";

    @Test
    public void TestNineTest()
    {
        homePage.searchFor(searchString);

        Assert.assertEquals(searchString,resultsPage.getFirstHeaderText());
    }
}
