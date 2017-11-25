package SeleniumTests;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class TestTwo extends BaseTest {
    private String searchString = "Isaac Newton";

    @Test
    public void TestTwoTest()
    {
        homePage.searchFor(searchString);

        Assert.assertEquals(searchString,resultsPage.getFirstHeaderText());
    }
}
