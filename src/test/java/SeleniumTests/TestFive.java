package SeleniumTests;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;


public class TestFive extends BaseTest {
    private String searchString = "Tom Cruise";

    @Test
    public void TestFiveTest()
    {
        homePage.searchFor(searchString);

        Assert.assertEquals(searchString,resultsPage.getFirstHeaderText());
    }
}
