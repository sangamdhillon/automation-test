package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.JukeBoxPage;
import pages.JukeboxListPage;
import pages.LocationPage;
import pages.WelcomePage;
import utils.MobileDriver;
import utils.MobileFactory;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static utils.Util.scrollDown;
import static utils.Util.scrollNClick;

public class CompareHotArtistList {

    @Test
    public void compareList() throws InterruptedException, MalformedURLException {

        MobileFactory.launchApp();

        WelcomePage welcomePage = new WelcomePage(MobileDriver.getDriver());
        LocationPage locationPage = new LocationPage(MobileDriver.getDriver());
        JukeboxListPage jukeboxListPage = new JukeboxListPage(MobileDriver.getDriver());
        JukeBoxPage jukeBoxPage = new JukeBoxPage(MobileDriver.getDriver());

        TimeUnit.SECONDS.sleep(2);
        welcomePage.clickSkip();
        TimeUnit.SECONDS.sleep(2);
        locationPage.clickGotItBtn();
        TimeUnit.SECONDS.sleep(2);
        locationPage.clickAllowBtn();
        TimeUnit.SECONDS.sleep(2);
        jukeboxListPage.clickJukeBoxListItem();
        TimeUnit.SECONDS.sleep(2);
        jukeboxListPage.clickConfirmBtn();
        TimeUnit.SECONDS.sleep(2);
        scrollDown();
        List<String> hotItemsCircleList = jukeBoxPage.getHotItemsCircleList();
        scrollNClick(jukeBoxPage.getBy_homeRow(), "Hot at The Sports Page");
        TimeUnit.SECONDS.sleep(2);
        jukeBoxPage.clickHotArtistsBtn();
        TimeUnit.SECONDS.sleep(2);
        List<String> hotItemsVerticalList = jukeBoxPage.getHotItemsVerticalList();
        Assert.assertEquals(hotItemsCircleList, hotItemsVerticalList);

        MobileFactory.closeApp();
    }

}
