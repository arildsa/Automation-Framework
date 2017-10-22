package threadsafetests;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class TestSeven extends BaseTest {
    private String searchString = "Lionel Messi";

    @Test
    public void TestSevenTest()
    {
        homePage.searchFor(searchString);

        Assert.assertEquals(searchString,resultsPage.getFirstHeaderText());
    }
}
