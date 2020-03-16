package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ItemPage;
import pages.ListPage;
import pages.LocationPage;
import pages.WelcomePage;
import utils.MobileDriver;
import utils.MobileFactory;

import java.net.MalformedURLException;
import java.util.List;

import static utils.Util.scrollDown;
import static utils.Util.scrollNClick;

public class CompareList {

    WelcomePage welcomePage = new WelcomePage(MobileDriver.getDriver());
    LocationPage locationPage = new LocationPage(MobileDriver.getDriver());
    ListPage listPage = new ListPage(MobileDriver.getDriver());
    ItemPage itemPage = new ItemPage(MobileDriver.getDriver());

    @BeforeTest
    public void launchApp() throws MalformedURLException {
        MobileFactory.launchApp();
    }

    @Test
    public void compareList() throws InterruptedException {

        welcomePage.clickSkip();
        locationPage.clickGotItBtn();
        locationPage.clickAllowBtn();
        listPage.clickListItem();
        listPage.clickConfirmBtn();
        scrollDown();
        List<String> circleList = itemPage.getCircleList();
        scrollNClick(itemPage.getBy_homeRow(), "Test Page");
        itemPage.clickHotArtistsBtn();
        List<String> verticalList = itemPage.getVerticalList();
        Assert.assertEquals(circleList, verticalList);

    }

    @AfterTest
    public void closeApp() {
        MobileFactory.closeApp();
    }

}
