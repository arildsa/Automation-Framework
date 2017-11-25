package SeleniumTests;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class TestSeven extends BaseTest {
    private String searchString = "Pope";

    @Test
    public void TestSevenTest()
    {
        homePage.searchFor(searchString);

        Assert.assertEquals(searchString,resultsPage.getFirstHeaderText());
    }
}
