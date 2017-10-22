package tests;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class TestThree extends BaseTest {
    private String searchString = "George Washington";

    @Test
    public void TestThreeTest()
    {
        homePage.searchFor(searchString);

        Assert.assertEquals(searchString,resultsPage.getFirstHeaderText());
    }
}
