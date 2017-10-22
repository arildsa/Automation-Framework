package tests;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class TestSix extends BaseTest {
    private String searchString = "Tom Hanks";

    @Test
    public void TestSixTest()
    {
        homePage.searchFor(searchString);

        Assert.assertEquals(searchString,resultsPage.getFirstHeaderText());
    }
}
