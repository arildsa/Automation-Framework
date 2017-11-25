package SeleniumTests;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class VerifyHomePageLoad extends BaseTest{

    @Test
    public void verifyHomePageLoadTest()
    {
        Assert.assertTrue(homePage.isImgCentralLogoPresent());
        Assert.assertTrue(homePage.isSearchBarPresent());
        Assert.assertTrue(homePage.isSearchButtonPresent());
        Assert.assertTrue(homePage.isLanguageListPresent());
        Assert.assertTrue(homePage.isThisLinkInTheFooter("//commons.wikimedia.org/"));
        Assert.assertTrue(homePage.isThisLinkInTheFooter("//www.wikivoyage.org/"));
        Assert.assertTrue(homePage.isThisLinkInTheFooter("//www.wiktionary.org/"));
        Assert.assertTrue(homePage.isThisLinkInTheFooter("//www.wikibooks.org/"));
        Assert.assertTrue(homePage.isThisLinkInTheFooter("//www.wikinews.org/"));
        Assert.assertTrue(homePage.isThisLinkInTheFooter("//www.wikidata.org/"));
        Assert.assertTrue(homePage.isThisLinkInTheFooter("//www.wikiversity.org/"));
        Assert.assertTrue(homePage.isThisLinkInTheFooter("//www.wikiquote.org/"));
        Assert.assertTrue(homePage.isThisLinkInTheFooter("//www.mediawiki.org/"));
        Assert.assertTrue(homePage.isThisLinkInTheFooter("//www.wikisource.org/"));
        Assert.assertTrue(homePage.isThisLinkInTheFooter("//species.wikimedia.org/"));
        Assert.assertTrue(homePage.isThisLinkInTheFooter("//meta.wikimedia.org/"));
    }
}
